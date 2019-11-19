package com.skygym.rank.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.skygym.rank.model.dao.RankDAO;
import com.skygym.rank.model.vo.GymRank;

public class RankService {

	
	
	
	public List<GymRank> gymRankList(String category) {

		Connection conn = getConnection();
		List<GymRank> list=new RankDAO().gymRankList(conn, category);
		close(conn);
		return list;
	}

	public List<GymRank> seoulgymRankList(String category) {
		Connection conn = getConnection();
		List<GymRank> list=new RankDAO().seoulgymRankList(conn, category);
		close(conn);
		return list;
	}

	public List<GymRank> gyeongigymRankList(String category) {
		Connection conn = getConnection();
		List<GymRank> list=new RankDAO().gyeongigymRankList(conn, category);
		close(conn);
		return list;
	}

}
