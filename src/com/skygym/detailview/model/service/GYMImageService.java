package com.skygym.detailview.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.skygym.detailview.model.dao.GYMImageDao;
import com.skygym.detailview.model.vo.GYMImage;


public class GYMImageService {

	public GYMImage selectImageList(int GYMNumber)
	{
		Connection conn = getConnection();
		
		GYMImage imglist = new GYMImageDao().selectImageList(conn, GYMNumber);
		close(conn);
		return imglist;
		
	}
	
}
