package com.skygym.detailview.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.skygym.detailview.model.dao.DetailDao;
import com.skygym.findgym.model.vo.GYM;
import com.skygym.detailview.model.vo.GYMReply;
import com.skygym.detailview.model.vo.Trainer;


public class DetailService {
	
	
	public GYM selectOne(int GYMNumber)
	{
		Connection conn = getConnection();
		GYM g = new DetailDao().selectOne(conn, GYMNumber);
		close(conn);
		return g;
	}
	
	public Trainer selectTrainer(int GYMNumber)
	{
		Connection conn = getConnection();
		Trainer t = new DetailDao().selectTrainer(conn, GYMNumber);
		close(conn);
		return t;
	}
	
	public int insertComment(GYMReply gr)
	{
		Connection conn = getConnection();
		int result = new DetailDao().insertComment(conn, gr);
		String msg = "";
		
		if(result>0) {
			msg="alert('댓글 등록에 성공하셨습니다.');";
			commit(conn);
		}else {
			msg="alert('댓글 등록에 실패하셨습니다."
					+ "다시 시도하여 주십시오.');";
			rollback(conn);
		}
		close(conn);
		System.out.println("insert : "+gr);
		return result;
	}
	
	public GYMReply selectComment(int GYMNumber)
	{
		Connection conn = getConnection();
		GYMReply gr = new DetailDao().selectComment(conn, GYMNumber);
		close(conn);
		return gr;
	}
	
	
	public List<GYMReply> selectCommentList(int GYMNumber)
	{
		Connection conn = getConnection();
		List<GYMReply> list = new DetailDao().selectCommentList(conn, GYMNumber);
		close(conn);
		return list;
	}
	
	public int updateComment(GYMReply reply)
	{
		Connection conn = getConnection();
		int result = new DetailDao().updateComment(conn, reply);
		if(result>0)
		{
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
	public int deleteComment(int replyNumber)
	{
		Connection conn = getConnection();
		int result = new DetailDao().deleteComment(conn, replyNumber);
		if(result>0)
		{
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
	
}
