package com.skygym.detailview.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.skygym.detailview.model.vo.GYMImage;

public class GYMImageDao {

private Properties prop;
	
	public GYMImageDao() 
	{
		prop=new Properties();
		 try {
			 String file=DetailDao.class.getResource("/sql/detail/GYMImage-sql.properties").getPath();
			 prop.load(new FileReader(file));
		 }
		 catch(IOException e)
		 {
			 e.printStackTrace();
		 }
	}
	
	public GYMImage selectImageList(Connection conn, int GYMNumber)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectImageList");
		GYMImage img = null;
		try 
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, GYMNumber);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				img=new GYMImage();
				img.setGYMNumber(rs.getInt("GYMNumber"));
				img.setMainImage(rs.getString("MainImage"));
				img.setSubImagea(rs.getString("subImagea"));
				img.setSubImageb(rs.getString("subImageb"));
				img.setSubImagec(rs.getString("subImagec"));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		return img;
	}
	
	
}
