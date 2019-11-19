package com.skygym.findgym.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.skygym.findgym.model.dao.GYMDAO;
import com.skygym.findgym.model.vo.GYM;

public class findGYMService 
{

	public List<GYM> selectGYMList(int cPage, int numPerPage) 
	{
		Connection conn = getConnection();
		List<GYM> list=new GYMDAO().selectGYMList(conn, cPage, numPerPage);
		close(conn);
		return list;
	}

	public int selectGYMCount() 
	{
		Connection conn=getConnection();
		int result=new GYMDAO().selectGYMCount(conn);
		close(conn);
		return result;

	}

	public List<GYM> selectGYMDistrictList(int cPage, int numPerPage, String findGYMDistrict) 
	{
		Connection conn = getConnection();
		List<GYM> list = new GYMDAO().selectGYMDistrictList(conn, cPage, numPerPage,findGYMDistrict);
		close(conn);
		return list;
	}

	public List<GYM> selectRecommendGYMList(int cPage, int numPerPage, String addrCity, String addrDis, String interest) {

		Connection conn = getConnection();
		List<GYM> list = new GYMDAO().selectRecommendGYMList(conn, cPage, numPerPage, addrCity, addrDis, interest);
		System.out.println("서비스에서 "+list+" 들어오나?");
		close(conn);
		return list;
	}

	public List<GYM> selectRecommendGYMList(int cPage, int numPerPage, String addrCity, String addrDis, String interest1,
			String interest2) {
		Connection conn = getConnection();
		List<GYM> list = new GYMDAO().selectRecommendGYMList(conn, cPage, numPerPage, addrCity, addrDis, interest1, interest2);
		System.out.println("서비스에서 "+list+" 들어오나?");
		
		close(conn);
		return list;
	}

	public int selectGYMDistrictCount(String findGYMDistrict) 
	{
		Connection conn=getConnection();
		int result=new GYMDAO().selectGYMDistrictCount(conn,findGYMDistrict);
		close(conn);
		return result;
	}

	/*public List<GYM> selectRecommendGYMList(int cPage, int numPerPage, String interest) 
	{
		Connection conn = getConnection();
		List<GYM> list=new GYMDAO().selectRecommendGYMList(conn, cPage, numPerPage,interest);
		close(conn);
		return list;
	}*/

	/*
	public List<GYM> selectRecommendGYMListTwo(int cPage, int numPerPage, String interest, String interestTwo) 
	{
		Connection conn = getConnection();
		List<GYM> list=new GYMDAO().selectRecommendGYMListTwo(conn, cPage, numPerPage,interest,interestTwo);
		close(conn);
		return list;	
	}

	public List<GYM> selectRecommendGYMListThree(int cPage, int numPerPage, String interest, String interestTwo,
			String interestThree) 
	{
		Connection conn = getConnection();
		List<GYM> list=new GYMDAO().selectRecommendGYMListThree(conn, cPage, numPerPage,interest,interestTwo,interestThree);
		close(conn);
		return list;
	}

	public List<GYM> selectRecommendGYMListFour(int cPage, int numPerPage, String interest, String interestTwo,
			String interestThree, String interestFour) 
	{
		Connection conn = getConnection();
		List<GYM> list=new GYMDAO().selectRecommendGYMListFour(conn, cPage, numPerPage,interest,interestTwo,interestThree,interestFour);
		close(conn);
		return list;
	}*/
	
	
	
	

}
