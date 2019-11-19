package com.skygym.board.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.skygym.board.model.dao.BoardDAO;
import com.skygym.board.model.vo.Board;
import com.skygym.board.model.vo.BoardComment;



public class BoardService {

	
	public List<Board> selectBoardList(int cPage, int numPerPage, String boardName)
	{
		Connection conn=getConnection();
		List<Board> list=new BoardDAO().selectBoardList(conn, cPage, numPerPage,boardName);
		close(conn);
		return list;
		
	}
	
	public int selectBoardCount(String boardName)
	{
		Connection conn=getConnection();
		int result=new BoardDAO().selectBoardCount(conn,boardName);
		close(conn);
		return result;
		
	}

	public int insertBoard(Board board, String boardname) {
		
		Connection conn=getConnection();
		int result = new BoardDAO().insertBoard(conn,board,boardname);
		if(result>0) commit(conn);
		else rollback(conn);
		
		
		close(conn);
		return result;
		
	}
	
	public Board selectOne(int no, String boardName)
	{
		Connection conn = getConnection();
		Board b = new BoardDAO().selectOne(conn,no,boardName);
		close(conn);
		return b;
	}
	
	public void addBoardCount(int no, String boardName, boolean hasRead)
	{
		Connection conn=getConnection();
		int result=0;
			if(!hasRead) 
			{
				result = new BoardDAO().addBoardCount(conn,no,boardName);
				if(result>0)
				{
					commit(conn);
				}
				else
				{
					rollback(conn);
				}
			}				
		close(conn);
	}
	
	public int insertBoardComment(BoardComment bc, String boardName)
	{
		Connection conn = getConnection();
		int result = new BoardDAO().insertBoardComment(conn, bc, boardName);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		
		close(conn);
		return result;
	}

	public List<BoardComment> selectBoardCommentList(int boardNo, String boardName) {
		Connection conn = getConnection();
		List<BoardComment> list = new BoardDAO().selectBoardCommentList(conn, boardNo,boardName);

		close(conn);
		return list;
	}

	public Board selectOneTest(int no, String boardName) {
		
		Connection conn = getConnection();
		Board b = new BoardDAO().selectOne(conn,no,boardName);
		int result=0;
		if(b!=null)
		{			
				result = new BoardDAO().addBoardCount(conn,no,boardName);
				if(result>0)
				{
					commit(conn);
				}
				else
				{
					rollback(conn);
				}
			
		}
		return b;
	}

	public int updateBoard(Board board, String boardName) {
		Connection conn=getConnection();
		int result = new BoardDAO().updateBoard(conn,board,boardName);
		if(result>0) commit(conn);
		else rollback(conn);		
		
		close(conn);
		return result;		
	}

	public int deleteBoard(Board b, String boardName) {
		Connection conn=getConnection();
		int result = new BoardDAO().deleteBoard(conn,b,boardName);
		if(result>0) commit(conn);
		else rollback(conn);
		
		
		close(conn);
		return result;
	}

	public BoardComment selectComment(String boardName, int bcn) {
		Connection conn=getConnection();
		BoardComment bc = new BoardDAO().selectBoardComment(conn, boardName, bcn);
		close(conn);
		return bc;
	}

	public int deleteComment(BoardComment bc, String boardName) {
		Connection conn=getConnection();
		int result = new BoardDAO().deleteComment(conn,bc,boardName);
		if(result>0) commit(conn);
		else rollback(conn);
		
		
		close(conn);
		return result;
	}

	public int updateComment(BoardComment bc, String boardName) {
		Connection conn=getConnection();
		int result = new BoardDAO().updateComment(conn,bc,boardName);
		if(result>0) commit(conn);
		else rollback(conn);
		
		
		close(conn);
		return result;
	}
	
	
	
	
	
}












