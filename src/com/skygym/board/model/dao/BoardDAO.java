package com.skygym.board.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.skygym.board.model.vo.Board;
import com.skygym.board.model.vo.BoardComment;


public class BoardDAO 
{
	
	public List<Board> selectBoardList(Connection conn, int cPage, int numPerPage, String boardName)
	{
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="SELECT board_no, board_subject,board_writer,board_content,board_date,board_hits, board_invisible, case when(sysdate - board_date < 1) then 1 else 0 end as new_icon,(SELECT COUNT(*) AS cnt FROM "+boardName+"_comment WHERE board_no = board_ref) as commentTotalCnt FROM (SELECT ROWNUM AS RNUM, A.* FROM (SELECT * FROM "+boardName+" ORDER BY BOARD_DATE DESC)A)WHERE RNUM BETWEEN "+((cPage-1)*numPerPage+1)+" AND "+(cPage*numPerPage);
	
		ArrayList<Board> list=new ArrayList();
		Board b=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				b=new Board();
				b.setBoardNo(rs.getInt("board_no"));
				b.setBoardWriter(rs.getString("board_writer"));
				b.setBoardTitle(rs.getString("board_subject"));
				b.setBoardContent(rs.getString("board_content"));
				b.setBoardDate(rs.getDate("board_date"));
				b.setBoardReadCount(rs.getInt("board_hits"));
				b.setBoardInvisible(rs.getString("board_invisible"));
				b.setCommentTotalCnt(rs.getInt("commentTotalCnt"));
				b.setNewIcon(rs.getInt("new_icon"));
				list.add(b);
				
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		
		return list;
	}
	
	public int selectBoardCount(Connection conn, String boardName)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="SELECT COUNT(*) AS CNT FROM "+boardName;
		
		int result=0;
		try
		{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				result=rs.getInt("cnt");
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		
		return result;
	}

	public int insertBoard(Connection conn, Board b, String boardName) 
	{
		
		PreparedStatement pstmt=null;
		String sql="INSERT INTO "+boardName+" VALUES(SEQ_"+boardName+"_NO.NEXTVAL,"+"'"+b.getBoardTitle()+"'"+","+"'"+b.getBoardWriter()+"'"+","+"'"+b.getBoardContent()+"'"+",DEFAULT,DEFAULT,"+"'"+b.getBoardInvisible()+"'"+")";
		
		int result=0;

		try
		{
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}

	public Board selectOne(Connection conn, int no, String boardName) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="SELECT board_no,board_subject,board_writer,board_content,board_date,board_hits,board_invisible,TO_CHAR(board_date, 'YYYY-MM-DD HH24:MI:SS') as board_time, (SELECT COUNT(*) AS cnt FROM "+boardName+"_comment WHERE board_no = board_ref) as commentTotalCnt FROM "+boardName+" WHERE BOARD_NO="+no;
			
		Board b = null;
		try
		{
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				b= new Board();
				b.setBoardNo(rs.getInt("board_no"));
				b.setBoardWriter(rs.getString("board_writer"));
				b.setBoardTitle(rs.getString("board_subject"));
				b.setBoardContent(rs.getString("board_content"));
				b.setBoardDate(rs.getDate("board_date"));
				b.setBoardReadCount(rs.getInt("board_hits"));
				b.setBoardInvisible(rs.getString("board_invisible"));
				b.setBoardTime(rs.getString("board_time"));
				b.setCommentTotalCnt(rs.getInt("commentTotalCnt"));

				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(pstmt);
		close(rs);
		
		return b;
	}

	public int addBoardCount(Connection conn, int no, String boardName) 
	{
		PreparedStatement pstmt=null;
		int result = 0;
		String sql = "UPDATE "+boardName+" SET BOARD_HITS = BOARD_HITS+1 WHERE BOARD_NO="+no;
		try
		{
			pstmt=conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(pstmt);
		return result;
		
	}

	public int insertBoardComment(Connection conn,BoardComment bc, String boardName) {

			PreparedStatement pstmt= null;
			int result =0;
			String sql="INSERT INTO "+boardName+"_COMMENT VALUES(SEQ_"+boardName+"_COMMENT_NO.NEXTVAL,"+bc.getBoardCommentLevel()+","+"'"+bc.getBoardCommentWriter()+"'"+","+"'"+bc.getBoardCommentContent()+"'"+","+bc.getBoardRef()+","+(bc.getBoardCommentRef()==0?null:String.valueOf(bc.getBoardCommentRef()))+",DEFAULT)";
					
			try
			{
				pstmt=conn.prepareStatement(sql);
				result = pstmt.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			close(pstmt);		
			
			return result;
	}

	public List<BoardComment> selectBoardCommentList(Connection conn, int boardNo, String boardName) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select lpad(' ',(level-1)*5)||board_comment_content,A. board_comment_no,board_comment_level,board_comment_writer,board_comment_content,board_ref,board_comment_ref,TO_CHAR(BOARD_COMMENT_DATE, 'YYYY-MM-DD HH24:MI:SS') AS COMMENT_TIME from "+boardName+"_comment A where board_ref="+boardNo+" start with board_comment_level=1 connect by prior board_comment_no=board_comment_ref order siblings by board_comment_date asc";
		
		ArrayList<BoardComment> list = new ArrayList<>();
		BoardComment bc =null;
		try
		{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				bc = new BoardComment();
				bc.setBoardCommentNo(rs.getInt("board_comment_no"));
				bc.setBoardCommentLevel(rs.getInt("board_comment_level"));
				bc.setBoardCommentWriter(rs.getString("board_comment_writer"));
				bc.setBoardCommentContent(rs.getString("board_comment_content"));
				bc.setBoardRef(rs.getInt("board_ref"));
				bc.setBoardCommentRef(rs.getInt("board_comment_ref")); 
				bc.setBoardCommentTime(rs.getString("comment_time"));
				list.add(bc);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		close(pstmt);
		close(rs);
		
		return list;
	}

	public int updateBoard(Connection conn, Board b, String boardName) {
		PreparedStatement pstmt=null;
		String sql="UPDATE "+boardName+" set board_subject="+"'"+b.getBoardTitle()+"'"+","+"board_content="+"'"+b.getBoardContent()+"'"+","+"board_invisible="+"'"+b.getBoardInvisible()+"'" +" where board_no="+b.getBoardNo();
		
		int result=0;

		try
		{
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}

	public int deleteBoard(Connection conn, Board b, String boardName) {
		PreparedStatement pstmt=null;
		
		String sql="delete from "+boardName+" where board_no="+b.getBoardNo();		
		System.out.println(sql);
		
		int result=0;

		try
		{
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}

	public BoardComment selectBoardComment(Connection conn, String boardName, int bcn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="SELECT BOARD_COMMENT_CONTENT, BOARD_COMMENT_LEVEL, BOARD_COMMENT_NO,BOARD_COMMENT_WRITER, TO_CHAR(BOARD_COMMENT_DATE, 'YYYY-MM-DD HH24:MI:SS') AS COMMENT_TIME FROM "+boardName+"_comment"+" WHERE BOARD_COMMENT_NO="+bcn;
		BoardComment bc = null;
		try
		{
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				bc= new BoardComment();
				bc.setBoardCommentContent(rs.getString("BOARD_COMMENT_CONTENT"));
				bc.setBoardCommentTime(rs.getString("COMMENT_TIME"));
				bc.setBoardCommentLevel(rs.getInt("BOARD_COMMENT_LEVEL"));
				bc.setBoardCommentNo(rs.getInt("BOARD_COMMENT_NO"));
				bc.setBoardCommentWriter(rs.getString("BOARD_COMMENT_WRITER"));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(pstmt);
		close(rs);
		
		return bc;
	}

	public int deleteComment(Connection conn, BoardComment bc, String boardName) {
		PreparedStatement pstmt=null;
		
		String sql="delete from "+boardName+"_comment where board_comment_no="+bc.getBoardCommentNo();		
		
		int result=0;

		try
		{
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}

	public int updateComment(Connection conn, BoardComment bc, String boardName) {
		PreparedStatement pstmt=null;
		
		String sql="UPDATE "+boardName+"_comment set BOARD_COMMENT_CONTENT="+"'"+bc.getBoardCommentContent()+"'"+" where board_comment_no="+bc.getBoardCommentNo();
	
		int result=0;

		try
		{
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(pstmt);
		return result;		
	}
	
}