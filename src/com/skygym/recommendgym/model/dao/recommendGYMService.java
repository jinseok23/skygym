package com.skygym.recommendgym.model.dao;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.skygym.findgym.model.dao.GYMDAO;
import com.skygym.findgym.model.vo.GYM;
import com.skygym.recommendgym.model.service.recommendGYMDAO;

public class recommendGYMService 
{

   public List<GYM> selectGYMList(int cPage, int numPerPage) 
   {
      Connection conn = getConnection();
      List<GYM> list=new recommendGYMDAO().selectGYMList(conn, cPage, numPerPage);
      close(conn);
      return list;
   }

   public int selectGYMCount() 
   {
      Connection conn=getConnection();
      int result=new recommendGYMDAO().selectGYMCount(conn);
      close(conn);
      return result;

   }

   public List<GYM> selectGYMDistrictList(int cPage, int numPerPage, String findGYMDistrict) 
   {
      Connection conn = getConnection();
      List<GYM> list = new recommendGYMDAO().selectGYMDistrictList(conn, cPage, numPerPage,findGYMDistrict);
      close(conn);
      return list;
   }

   public List<GYM> selectRecommendGYMList(int cPage, int numPerPage, String addrCity, String addrDis, String interest) 
   {

      Connection conn = getConnection();
      List<GYM> list = new recommendGYMDAO().selectRecommendGYMList(conn, cPage, numPerPage, addrCity, addrDis, interest);
      close(conn);
      return list;
   }

   public List<GYM> selectRecommendGYMList(int cPage, int numPerPage, String addrCity, String addrDis, String interest1,
         String interest2) 
   {
      Connection conn = getConnection();
      List<GYM> list = new recommendGYMDAO().selectRecommendGYMList(conn, cPage, numPerPage, addrCity, addrDis, interest1, interest2);
      close(conn);
      return list;
   }

   public int selectGYMDistrictCount(String findGYMDistrict) 
   {
      Connection conn=getConnection();
      int result=new recommendGYMDAO().selectGYMDistrictCount(conn,findGYMDistrict);
      System.out.println("서비스 : "+result);
      close(conn);
      return result;
   }

      //게시물의 수를 구하는 구문
   public int selectRecommendGYMCount(String gymCategory1 , String addrCity , String addrDis) 
   {
      Connection conn=getConnection();
      int result=new recommendGYMDAO().selectRecommendGYMCount(conn,gymCategory1,addrCity,addrDis);
      close(conn);
      return result;
   }
   
       //게시물의 수를 구하는 구문
   public int selectRecommendGYMCount(String gymCategory1, String gymCategory2,String addrCity, String addrDis) 
   {
      Connection conn=getConnection();
      int result=new recommendGYMDAO().selectRecommendGYMCount(conn,gymCategory1,gymCategory2,addrCity,addrDis);
      close(conn);
      return result;
   }

   
//   이미지주소 가져오기
   public List<GYM> selectAll() {
      Connection conn=getConnection();
      List<GYM> list = new recommendGYMDAO().selectAll(conn);
      close(conn);
      return list;
   }


}