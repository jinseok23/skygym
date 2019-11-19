package com.skygym.admin.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.skygym.admin.model.dao.AdminDAO;
import com.skygym.findgym.model.vo.GYM;
import com.skygym.member.model.vo.Member;

public class AdminService {

	public List<Member> selectMemberList(int cPage, int numPerPage)
	{
		Connection conn=getConnection();
		List<Member> list=new AdminDAO().selectMemberList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	
	public int selectMemberCount()
	{
		Connection conn=getConnection();
		int result=new AdminDAO().selectMemberCount(conn);
		close(conn);
		return result;
	}
	public int selectFindCountId(String searchKeyword)
	{
		Connection conn=getConnection();
		int result=new AdminDAO().selectFindCountId(conn,searchKeyword);
		close(conn);
		return result;
	}
	public int selectFindCountName(String searchKeyword)
	{
		Connection conn=getConnection();
		int result=new AdminDAO().selectFindCountName(conn,searchKeyword);
		close(conn);
		return result;
	}
	public List<Member> selectMemberById(String key, int cPage, int numPerPage)
	{
		Connection conn=getConnection();
		List<Member> list=new AdminDAO().selectMemberById(conn,key,cPage,numPerPage);
		close(conn);
		return list;
	}

	public List<Member> selectMemberByName(String key, int cPage, int numPerPage)
	{
		Connection conn=getConnection();
		List<Member> list=new AdminDAO().selectMemberByName(conn,key,cPage,numPerPage);
		close(conn);
		return list;
	}
	
	/*제휴업체*/
	public List<GYM> selectGYMList(int cPage, int numPerPage) 
	{
		Connection conn = getConnection();
		List<GYM> list=new AdminDAO().selectGYMList(conn, cPage, numPerPage);
		close(conn);
		return list;
	}

	public int selectGYMCount() 
	{
		Connection conn=getConnection();
		int result=new AdminDAO().selectGYMCount(conn);
		close(conn);
		return result;
	}
	public List<GYM> selectGymName(String key, int cPage, int numPerPage)
	{
		Connection conn=getConnection();
		List<GYM> list=new AdminDAO().selectGymName(conn,key,cPage,numPerPage);
		close(conn);
		return list;
	}
	public int selectFindGymName(String searchKeyword)
	{
		Connection conn=getConnection();
		int result=new AdminDAO().selectFindGymName(conn,searchKeyword);
		close(conn);
		return result;
	}

	public GYM selectGym(int gymNumber) {
		Connection conn=getConnection();
		GYM g=new AdminDAO().selectGYM(conn, gymNumber);
		close(conn);
		return g;
	}

	public int updateGym(GYM g) {
		Connection conn = getConnection();
		int result = new AdminDAO().updateGym(conn, g);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int deleteGym(int gymNumber) {
		Connection conn = getConnection();
		int result = new AdminDAO().deleteGym(conn, gymNumber);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
}
