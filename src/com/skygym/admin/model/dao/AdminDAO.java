package com.skygym.admin.model.dao;

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

import com.skygym.findgym.model.vo.GYM;
import com.skygym.member.model.vo.Member;


public class AdminDAO {

private Properties prop;
	
	public AdminDAO()
	{
		prop=new Properties();
		try {
			String file=AdminDAO.class.getResource("/sql/admin/sql-admin.properties").getPath();
			prop.load(new FileReader(file));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public List<Member> selectMemberList(Connection conn,int cPage,int numPerPage)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectPage");
		Member m=null;
		ArrayList<Member> list=new ArrayList<>();
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				m=new Member();
				m.setUserId(rs.getString("userid"));
				m.setPassword(rs.getString("password"));
				m.setUserName(rs.getString("username"));
				m.setResidentNum(rs.getString("residentnum"));
				m.setPhone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
				m.setAddress(rs.getString("address"));
				m.setInterest(rs.getString("interest"));
				m.setEnrolldate(rs.getDate("enrolldate"));
				
				list.add(m);
				
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
	
	public int selectMemberCount(Connection conn)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectMemberCount");
		int result=0;
		try
		{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt("cnt");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		
		return result;
	}
	public int selectFindCountId(Connection conn, String searchKeyword)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectFindCountId");
		int result=0;
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchKeyword+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt("cnt");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		
		return result;
	}
	public int selectFindCountName(Connection conn,String searchKeyword)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectFindCountName");
		int result=0;
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchKeyword+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt("cnt");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		
		return result;
	}
	public List<Member> selectMemberById(Connection conn, String key,int cPage,int numPerPage)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectMemberById");
		Member m=null;
		ArrayList<Member> list=new ArrayList<>();
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+key+"%");
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				m=new Member();
				m.setUserId(rs.getString("userid"));
				m.setPassword(rs.getString("password"));
				m.setUserName(rs.getString("username"));
				m.setResidentNum(rs.getString("residentnum"));
				m.setPhone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
				m.setAddress(rs.getString("address"));
				m.setInterest(rs.getString("interest"));
				m.setEnrolldate(rs.getDate("enrolldate"));
				list.add(m);
				
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

	public List<Member> selectMemberByName(Connection conn, String key,int cPage,int numPerPage)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectMemberByName");
		Member m=null;
		ArrayList<Member> list=new ArrayList<>();
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+key+"%");
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				m=new Member();
				m.setUserId(rs.getString("userid"));
				m.setPassword(rs.getString("password"));
				m.setUserName(rs.getString("username"));
				m.setResidentNum(rs.getString("residentnum"));
				m.setPhone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
				m.setAddress(rs.getString("address"));
				m.setInterest(rs.getString("interest"));
				m.setEnrolldate(rs.getDate("enrolldate"));
				list.add(m);
				System.out.println(list);
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
	
	/*제휴업체*/
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
	public List<GYM> selectGymName(Connection conn, String key,int cPage,int numPerPage)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectGymName");
		GYM g=null;
		ArrayList<GYM> list=new ArrayList<>();
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+key+"%");
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
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		
		return list;
	}
	public int selectFindGymName(Connection conn,String searchKeyword)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectFindGymName");
		int result=0;
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchKeyword+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt("cnt");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		
		return result;
	}
	public GYM selectGYM(Connection conn, int gymNumber) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectGYM");
		GYM g = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, gymNumber);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				g=new GYM();
				g.setGYMNumber(rs.getInt("GYMNumber"));
				g.setGYMCategory(rs.getString("GYMCategory"));
				g.setGYMdistrict(rs.getString("GYMdistrict"));
				g.setGYMbranchName(rs.getString("GYMbranchName"));
				g.setGYMAddress(rs.getString("GYMAddress"));
				g.setGYMtel(rs.getString("GYMTel"));
				g.setGYMInfo(rs.getString("GYMInfo"));
				g.setGYMHomePage(rs.getString("gymhomepage"));
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		
		return g;
	}
	public int updateGym(Connection conn, GYM g) {
		PreparedStatement pstmt = null;
		int result=0;
		String sql = prop.getProperty("updateGym");
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, g.getGYMbranchName());
			pstmt.setString(2, g.getGYMCategory());
			pstmt.setString(3, g.getGYMtel());
			pstmt.setString(4, g.getGYMAddress());
			pstmt.setString(5, g.getGYMHomePage());
			pstmt.setString(6, g.getGYMdistrict());
			pstmt.setInt(7, g.getGYMNumber());
			result=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
	public int deleteGym(Connection conn, int gymNumber) {
		PreparedStatement pstmt = null;
		int result=0;
		String sql = prop.getProperty("deleteGym");
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, gymNumber);
			result=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
	

	
}
