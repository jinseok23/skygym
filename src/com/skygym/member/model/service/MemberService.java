package com.skygym.member.model.service;

import java.sql.Connection;

import com.skygym.member.model.dao.MemberDAO;
import com.skygym.member.model.vo.Member;

import static common.JDBCTemplate.*;

public class MemberService {

	public Member selectOne(String id) 
	{
		Connection conn=getConnection();
		Member m = new MemberDAO().selectOne(conn,id);
		close(conn);
		return m;
	}
	
	public int insertMember(Member m)
	{
		Connection conn=getConnection();
		int result=new MemberDAO().insertMember(conn,m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public boolean checkId(String userId)
	{
		Connection conn=getConnection();
		boolean isAble=new MemberDAO().checkId(conn,userId);
		close(conn);
		return isAble;
	}
	
	public int updateMember(Member m)
	{
		Connection conn=getConnection();
		int result=new MemberDAO().updateMember(conn,m);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}
	
	public int passwordUpdate(Member m)
	{
		Connection conn=getConnection();
		int result=new MemberDAO().passwordUpdate(conn,m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int memberDelete(String userId)
	{
		Connection conn=getConnection();
		int result=new MemberDAO().memberDelete(conn,userId);
		if(result>0)
			commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	

	public Member memberFindId(String name, String birth) {
		Connection conn=getConnection();
		Member m = new MemberDAO().memberFindId(conn,name,birth);
		close(conn);
		return m;
	}

	public Member memberFindId(String name, String email, String userId) {
		Connection conn = getConnection();
		Member m = new MemberDAO().memberFIndPw(conn,name,email,userId);
		close(conn);
		return m;
	}

	public int tempPw(String randomNum, String name, String email, String userId) {
		Connection conn = getConnection();
		int result = new MemberDAO().tempPw(conn,randomNum,name,email,userId);
		if(result>0)
			commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}
}
