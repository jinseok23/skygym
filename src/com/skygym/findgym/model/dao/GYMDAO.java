package com.skygym.findgym.model.dao;
import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.skygym.findgym.model.vo.GYM;

public class GYMDAO 
{

	private Properties prop;
	
	public GYMDAO() 
	{
		prop=new Properties();
		 try {
			 String file=GYMDAO.class.getResource("/sql/gym/gym-sql.properties").getPath();
			 prop.load(new FileReader(file));
		 }
		 catch(IOException e)
		 {
			 e.printStackTrace();
		 }

	}

	
	public List<GYM> selectGYMList(Connection conn, int cPage, int numPerPage)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectGYMList");
		ArrayList<GYM> list=new ArrayList();
		GYM g = null;
		
		try 
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);			
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				g=new GYM();
				g.setGYMNumber(rs.getInt("GYMNumber"));
				g.setGYMCategory(rs.getString("GYMCategory"));
				g.setGYMdistrict(rs.getString("GYMdistrict"));
				g.setGYMbranchName(rs.getString("GYMbranchName"));
				g.setGYMAddress(rs.getString("GYMAddress"));
				g.setGYMtel(rs.getString("GYMTel"));
				g.setGYMInfo(rs.getString("GYMInfo"));
				list.add(g);
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
	public int selectGYMCount(Connection conn)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectGYMCount");
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

	public int selectGYMDistrictCount(Connection conn, String findGYMDistrict) 
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectDistrictCount");
		int result=0;
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,findGYMDistrict);

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
	

	public List<GYM> selectGYMDistrictList(Connection conn, int cPage, int numPerPage, String findGYMDistrict) 
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectGYMDistrictList");
		GYM g=null;
		ArrayList<GYM> list=new ArrayList();
		
		try 
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+findGYMDistrict+"%");
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);			
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				g=new GYM();
				g.setGYMNumber(rs.getInt("GYMNumber"));
				g.setGYMCategory(rs.getString("GYMCategory"));
				g.setGYMdistrict(rs.getString("GYMdistrict"));
				g.setGYMbranchName(rs.getString("GYMbranchName"));
				g.setGYMAddress(rs.getString("GYMAddress"));
				g.setGYMtel(rs.getString("GYMTel"));
				g.setGYMInfo(rs.getString("GYMInfo"));
				list.add(g);
			}	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		
		return list;

	}


	public List<GYM> selectRecommendGYMList(Connection conn, int cPage, int numPerPage, String interest) 
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectRecommendGYMList");
		ArrayList<GYM> list=new ArrayList();
		GYM g = null;
		
		try 
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			pstmt.setString(3, "%"+interest+"%");
			
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				g=new GYM();
				g.setGYMNumber(rs.getInt("GYMNumber"));
				g.setGYMCategory(rs.getString("GYMCategory"));
				g.setGYMdistrict(rs.getString("GYMdistrict"));
				g.setGYMbranchName(rs.getString("GYMbranchName"));
				g.setGYMAddress(rs.getString("GYMAddress"));
				g.setGYMtel(rs.getString("GYMTel"));
				g.setGYMInfo(rs.getString("GYMInfo"));
				list.add(g);
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


	public List<GYM> selectRecommendGYMListTwo(Connection conn, int cPage, int numPerPage, String interest,
			String interestTwo) 
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectRecommendGYMListTwo");
		ArrayList<GYM> list=new ArrayList();
		GYM g = null;
		
		try 
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			pstmt.setString(3, "%"+interest+"%");
			pstmt.setString(4, "%"+interestTwo+"%");

			rs=pstmt.executeQuery();
			while(rs.next())
			{
				g=new GYM();
				g.setGYMNumber(rs.getInt("GYMNumber"));
				g.setGYMCategory(rs.getString("GYMCategory"));
				g.setGYMdistrict(rs.getString("GYMdistrict"));
				g.setGYMbranchName(rs.getString("GYMbranchName"));
				g.setGYMAddress(rs.getString("GYMAddress"));
				g.setGYMtel(rs.getString("GYMTel"));
				g.setGYMInfo(rs.getString("GYMInfo"));
				list.add(g);
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


	public List<GYM> selectRecommendGYMListThree(Connection conn, int cPage, int numPerPage, String interest,
			String interestTwo, String interestThree) 
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectRecommendGYMListThree");
		ArrayList<GYM> list=new ArrayList();
		GYM g = null;
		
		try 
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			pstmt.setString(3, "%"+interest+"%");
			pstmt.setString(4, "%"+interestTwo+"%");
			pstmt.setString(5, "%"+interestThree+"%");

			rs=pstmt.executeQuery();
			while(rs.next())
			{
				g=new GYM();
				g.setGYMNumber(rs.getInt("GYMNumber"));
				g.setGYMCategory(rs.getString("GYMCategory"));
				g.setGYMdistrict(rs.getString("GYMdistrict"));
				g.setGYMbranchName(rs.getString("GYMbranchName"));
				g.setGYMAddress(rs.getString("GYMAddress"));
				g.setGYMtel(rs.getString("GYMTel"));
				g.setGYMInfo(rs.getString("GYMInfo"));
				list.add(g);
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


	public List<GYM> selectRecommendGYMListFour(Connection conn, int cPage, int numPerPage, String interest,
			String interestTwo, String interestThree, String interestFour) 
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectRecommendGYMListFour");
		ArrayList<GYM> list=new ArrayList();
		GYM g = null;
		
		try 
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			pstmt.setString(3, "%"+interest+"%");
			pstmt.setString(4, "%"+interestTwo+"%");
			pstmt.setString(5, "%"+interestThree+"%");
			pstmt.setString(6, "%"+interestFour+"%");

			rs=pstmt.executeQuery();
			while(rs.next())
			{
				g=new GYM();
				g.setGYMNumber(rs.getInt("GYMNumber"));
				g.setGYMCategory(rs.getString("GYMCategory"));
				g.setGYMdistrict(rs.getString("GYMdistrict"));
				g.setGYMbranchName(rs.getString("GYMbranchName"));
				g.setGYMAddress(rs.getString("GYMAddress"));
				g.setGYMtel(rs.getString("GYMTel"));
				g.setGYMInfo(rs.getString("GYMInfo"));
				list.add(g);
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


	public List<GYM> selectRecommendGYMList(Connection conn, int cPage, int numPerPage, String addrCity, String addrDis,
			String interest) {
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectRecommendGYMList1");
		ArrayList<GYM> list=new ArrayList();
		GYM g = null;
		
		try 
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			pstmt.setString(3, "%"+addrCity+"%");
			pstmt.setString(4, "%"+addrDis+"%");
			pstmt.setString(5, interest);

			rs=pstmt.executeQuery();
			while(rs.next())
			{
				g=new GYM();
				g.setGYMNumber(rs.getInt("GYMNumber"));
				g.setGYMCategory(rs.getString("GYMCategory"));
				g.setGYMdistrict(rs.getString("GYMdistrict"));
				g.setGYMbranchName(rs.getString("GYMbranchName"));
				g.setGYMAddress(rs.getString("GYMAddress"));
				g.setGYMtel(rs.getString("GYMTel"));
				g.setGYMInfo(rs.getString("GYMInfo"));
				list.add(g);
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


	public List<GYM> selectRecommendGYMList(Connection conn, int cPage, int numPerPage, String addrCity, String addrDis,
			String interest1, String interest2) {

		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectRecommendGYMList2");
		ArrayList<GYM> list=new ArrayList();
		GYM g = null;
		
		try 
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			pstmt.setString(3, "%"+addrCity+"%");
			pstmt.setString(4, "%"+addrDis+"%");
			pstmt.setString(5, interest1);
			pstmt.setString(6, interest2);

			rs=pstmt.executeQuery();
			while(rs.next())
			{
				g=new GYM();
				g.setGYMNumber(rs.getInt("GYMNumber"));
				g.setGYMCategory(rs.getString("GYMCategory"));
				g.setGYMdistrict(rs.getString("GYMdistrict"));
				g.setGYMbranchName(rs.getString("GYMbranchName"));
				g.setGYMAddress(rs.getString("GYMAddress"));
				g.setGYMtel(rs.getString("GYMTel"));
				g.setGYMInfo(rs.getString("GYMInfo"));
				list.add(g);
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


	
	
}
