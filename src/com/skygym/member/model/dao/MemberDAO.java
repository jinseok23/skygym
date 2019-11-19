package com.skygym.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.skygym.member.model.vo.Member;
import static common.JDBCTemplate.*;

public class MemberDAO {

	private Properties prop;
	
	public MemberDAO()
	{
		prop=new Properties();
		try {
			String file=MemberDAO.class.getResource("/sql/member/sql-member.properties").getPath();
			prop.load(new FileReader(file));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public Member selectOne(Connection conn, String id)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		String sql=prop.getProperty("selectOne");
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next())
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
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return m;
	}
	
	public int insertMember(Connection conn, Member m)
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("insertMember");
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getResidentNum());
			pstmt.setString(5, m.getPhone());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getAddress());
			pstmt.setString(8, m.getInterest());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
	
	public boolean checkId(Connection conn, String userId)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean isAble=true;
		String sql=prop.getProperty("selectOne");
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			if(rs.next()) isAble=false;
			else isAble=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		
		return isAble;
	}
	
	public int updateMember(Connection conn, Member m)
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("memberUpdate");
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getInterest());
			pstmt.setString(6, m.getUserId());
			result=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
	
	public int passwordUpdate(Connection conn, Member m)
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("passwordUpdate");
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, m.getPassword());
			pstmt.setString(2, m.getUserId());
			result=pstmt.executeUpdate();
		}
		catch(Exception e)		
		{
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
	
	public int memberDelete(Connection conn, String userId)
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("memberDelete");
		System.out.println(sql);
		
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			result=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}

	public Member memberFindId(Connection conn, String name, String birth) {
		
		PreparedStatement pstmt =null;
		ResultSet rs= null;
		String sql = prop.getProperty("memberFindId");
		Member m = null;
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, birth);
			rs=pstmt.executeQuery();
			if(rs.next())
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
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return m;
	}

	public Member memberFIndPw(Connection conn, String name, String email, String userId) {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		String sql = prop.getProperty("memberFindPw");
		Member m = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, userId);
			rs=pstmt.executeQuery();
			if(rs.next())
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
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return m;
	}

	public int tempPw(Connection conn, String randomNum, String name, String email, String userId) {
		
		PreparedStatement pstmt = null;
		int result=0;
		String sql=prop.getProperty("tempPw");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, randomNum);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, userId);
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
