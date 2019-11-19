package com.skygym.recommendgym.model.service;
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

public class recommendGYMDAO 
{

   private Properties prop;
   
   public recommendGYMDAO() 
   {
      prop=new Properties();
       try {
          String file=recommendGYMDAO.class.getResource("/sql/gym/gym-sql.properties").getPath();
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
         pstmt.setInt(1, (cPage-1)*numPerPage+1);
         pstmt.setInt(2, cPage*numPerPage);         
         pstmt.setString(3, "%"+findGYMDistrict+"%");
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
         
         
         pstmt.setString(1, interest);
         pstmt.setString(2, "%"+addrCity+"%");
         pstmt.setString(3, "%"+addrDis+"%");
         pstmt.setInt(4, (cPage-1)*numPerPage+1);
         pstmt.setInt(5, cPage*numPerPage);

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
         pstmt.setString(1, interest1);
         pstmt.setString(2, interest2);
         pstmt.setString(3, "%"+addrCity+"%");
         pstmt.setString(4, "%"+addrDis+"%");
         pstmt.setInt(5, (cPage-1)*numPerPage+1);
         pstmt.setInt(6, cPage*numPerPage);

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

   
   public int selectRecommendGYMCount(Connection conn, String gymCategory1 , String addrCity , String addrDis) 
   {
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      String sql=prop.getProperty("selectRecommendGYMCount1");
      int result=0;
      System.out.println(gymCategory1);
     System.out.println(addrCity);
     System.out.println(addrDis);

      try
      {
         
         pstmt=conn.prepareStatement(sql);
         pstmt.setString(1,gymCategory1);         
         pstmt.setString(2,"%"+addrCity+"%");
         pstmt.setString(3,"%"+addrDis+"%");
         rs=pstmt.executeQuery();
         
         if(rs.next())
         {
            result=rs.getInt("CNT");
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


   public int selectRecommendGYMCount(Connection conn, String addrCity, String addrDis , 
                                 String gymCategory1 , String gymCategory2) 
   {
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      String sql=prop.getProperty("selectRecommendGYMCount2");
      int result=0;
      try
      {
         pstmt=conn.prepareStatement(sql);
         pstmt.setString(1,addrCity);
         pstmt.setString(2,addrDis);
         pstmt.setString(3,"%"+gymCategory1+"%");
         pstmt.setString(4,"%"+gymCategory2+"%");
         rs=pstmt.executeQuery();
         if(rs.next())
         {
            result=rs.getInt("CNT");
         }
         
      }
      catch (SQLException e) 
      {
         e.printStackTrace();
      }
      
      close(rs);
      close(pstmt);
      System.out.println("DAO result "+result);
      return result;
   
   }


public List<GYM> selectAll(Connection conn) {
   PreparedStatement pstmt=null;
    ResultSet rs=null;
    String sql=prop.getProperty("selectAll");
    ArrayList<GYM> list=new ArrayList();
    GYM g = null;
    
    try 
    {
       pstmt=conn.prepareStatement(sql);      
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
          g.setMainImage(rs.getString("MAINIMAGE"));
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