package com.skygym.rank.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.skygym.rank.model.vo.GymRank;

import static common.JDBCTemplate.*;

public class RankDAO {
	
	private Properties prop;
	public RankDAO()
	{
		prop=new Properties();
		try {
		String file = RankDAO.class.getResource("/sql/rank/rank-sql-properties").getPath();
		//getResource에서 경로 지정할때 sql.member인데 .은 파일로 인식해서 /로 해도됨
		prop.load(new FileReader(file));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
	}

	public List<GymRank> gymRankList(Connection conn, String category) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("gymRankList");
		GymRank gr=null;
		ArrayList<GymRank> list=new ArrayList();
		
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, category);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				gr=new GymRank();
				gr.setRank(rs.getInt("rnum"));
				gr.setGymNumber(rs.getInt("gymnumber"));
				gr.setGymDistrict(rs.getString("gymdistrict"));
				gr.setGymBranchName(rs.getString("gymbranchname"));
				gr.setGymAddress(rs.getString("gymaddress"));
				gr.setGymCategory(rs.getString("gymcategory"));
				gr.setGymHomepage(rs.getString("gymhomepage"));
				gr.setMainimage(rs.getString("mainimage"));
				gr.setScore(rs.getDouble("score"));
				list.add(gr);
				
//				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return list;
	}

	public List<GymRank> seoulgymRankList(Connection conn, String category) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("seoulgymRankList");
		GymRank gr=null;
		ArrayList<GymRank> list=new ArrayList();
		
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, category);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				gr=new GymRank();
				gr.setRank(rs.getInt("rnum"));
				gr.setGymNumber(rs.getInt("gymnumber"));
				gr.setGymDistrict(rs.getString("gymdistrict"));
				gr.setGymBranchName(rs.getString("gymbranchname"));
				gr.setGymAddress(rs.getString("gymaddress"));
				gr.setGymCategory(rs.getString("gymcategory"));
				gr.setGymHomepage(rs.getString("gymhomepage"));
				gr.setMainimage(rs.getString("mainimage"));
				gr.setScore(rs.getDouble("score"));
				list.add(gr);
				
//				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return list;
	}

	public List<GymRank> gyeongigymRankList(Connection conn, String category) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("gyeongigymRankList");
		GymRank gr=null;
		ArrayList<GymRank> list=new ArrayList();
		
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, category);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				gr=new GymRank();
				gr.setRank(rs.getInt("rnum"));
				gr.setGymNumber(rs.getInt("gymnumber"));
				gr.setGymDistrict(rs.getString("gymdistrict"));
				gr.setGymBranchName(rs.getString("gymbranchname"));
				gr.setGymAddress(rs.getString("gymaddress"));
				gr.setGymCategory(rs.getString("gymcategory"));
				gr.setGymHomepage(rs.getString("gymhomepage"));
				gr.setMainimage(rs.getString("mainimage"));
				gr.setScore(rs.getDouble("score"));
				list.add(gr);
				
//				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return list;
	}

}
