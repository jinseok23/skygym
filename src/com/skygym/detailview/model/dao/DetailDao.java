package com.skygym.detailview.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.skygym.findgym.model.vo.GYM;
import com.skygym.detailview.model.vo.GYMReply;
import com.skygym.detailview.model.vo.Trainer;


public class DetailDao {

	private Properties prop;
	
	public DetailDao() 
	{
		prop=new Properties();
		 try {
			 String file=DetailDao.class.getResource("/sql/detail/detail-sql.properties").getPath();
			 prop.load(new FileReader(file));
		 }
		 catch(IOException e)
		 {
			 e.printStackTrace();
		 }
		 
	}
	
	
	public GYM selectOne(Connection conn, int GYMNumber)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GYM g = null;
		String sql = prop.getProperty("selectOne");
		try 
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, GYMNumber);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				g=new GYM();
				g.setGYMNumber(rs.getInt("GYMNumber"));
				g.setGYMdistrict(rs.getString("gymdistrict"));
				g.setGYMbranchName(rs.getString("gymbranchName"));
				g.setGYMAddress(rs.getString("gymaddress"));
				g.setGYMtel(rs.getString("GYMTel"));
				g.setGYMInfo(rs.getString("GYMInfo"));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return g;
		
	}
	
	public Trainer selectTrainer(Connection conn, int GYMNumber)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Trainer t = null;
		String sql = prop.getProperty("selectTrainer");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, GYMNumber);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				t = new Trainer();
				t.setGYMNumber(rs.getInt("GYMNumber"));
				t.setTrainerAImage(rs.getString("trainerAImage"));
				t.setTrainerAName(rs.getString("trainerAName"));
				t.setTrainerAPart(rs.getString("trainerAPart"));
				t.setTrainerBImage(rs.getString("trainerBImage"));
				t.setTrainerBName(rs.getString("trainerBName"));
				t.setTrainerBPart(rs.getString("trainerBPart"));
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		return t;
	}
	
	public GYMReply selectComment(Connection conn, int GYMNumber)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GYMReply gr = null;
		String sql = prop.getProperty("selectComment");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, GYMNumber);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				gr = new GYMReply();
				gr.setGYMNumber(rs.getInt("GYMNumber"));
				gr.setUserId(rs.getString("UserId"));
				gr.setGYMScore(rs.getInt("GYMScore"));
				gr.setReplyLevel(rs.getInt("replyLevel"));
				gr.setReplyNumber(rs.getInt("replyNumber"));
				gr.setReplyNumber_REF(rs.getInt("replyNumber_Ref"));
				gr.setReply_content(rs.getString("reply_content"));
				gr.setReply_date(rs.getDate("reply_date"));
				
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		
		return gr;
	}
	
	
	public int insertComment(Connection conn, GYMReply gr)
	{
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertComment");
		System.out.println(sql);
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, gr.getGYMNumber());
			pstmt.setString(2, gr.getUserId());
			pstmt.setInt(3, gr.getGYMScore());
			pstmt.setString(4, gr.getReply_content());			
			result=pstmt.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
	
	public List<GYMReply> selectCommentList(Connection conn, int GYMNumber)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectCommentList");
		ArrayList<GYMReply> list = new ArrayList<>();
		GYMReply gr = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, GYMNumber);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				gr = new GYMReply();
				gr.setGYMNumber(rs.getInt("GYMNumber"));
				gr.setGYMScore(rs.getInt("GYMScore"));
				gr.setReply_content(rs.getString("reply_content"));
				gr.setReply_date(rs.getDate("reply_date"));
				gr.setReplyLevel(rs.getInt("replyLevel"));
				gr.setReplyNumber(rs.getInt("replyNumber"));
				gr.setReplyNumber_REF(rs.getInt("replyNumber_REF"));
				gr.setUserId(rs.getString("UserId"));
				list.add(gr);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return list;
	}
	
	public int updateComment(Connection conn, GYMReply reply)
	{
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateComment");
		System.out.println(reply.getReply_content()+"필상3"+reply.getReplyNumber());
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, reply.getReply_content());
			pstmt.setInt(2, reply.getReplyNumber());
			result=pstmt.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		close(pstmt);
		return result;
		
	}
	
	public int deleteComment(Connection conn, int replyNumber)
	{
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteComment");
		int result = 0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, replyNumber);
			result=pstmt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		close(conn);
		return result;
	}
	
	
	
	
}
