package com.skygym.detailview.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skygym.detailview.model.service.DetailService;
import com.skygym.detailview.model.service.GYMImageService;
import com.skygym.findgym.model.vo.GYM;
import com.skygym.detailview.model.vo.GYMImage;
import com.skygym.detailview.model.vo.GYMReply;
import com.skygym.detailview.model.vo.Trainer;

/**
 * Servlet implementation class DetailViewServlet
 */
@WebServlet("/detail/detailView")
public class DetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
    	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
    	
    	GYM g = null;
		int GYMNumber = Integer.parseInt(request.getParameter("GYMNumber"));
    	
		g = new DetailService().selectOne(GYMNumber);
		
    	GYMImage imglist = new GYMImageService().selectImageList(GYMNumber);
    	Trainer t = new DetailService().selectTrainer(GYMNumber);
    	
    	
    	if(g!=null) {
			request.setAttribute("GYM", g);
			List<GYMReply> list = new DetailService().selectCommentList(GYMNumber);
			request.setAttribute("list", list);
		}
    	
    	GYMReply gr = new DetailService().selectComment(GYMNumber);
    	
    	request.setAttribute("GYMNumber", GYMNumber);
    	request.setAttribute("GYM", g);
    	request.setAttribute("imglist", imglist);
    	request.setAttribute("t", t);
    	request.setAttribute("GYMReply", gr);
    	
		request.getRequestDispatcher("/views/detail/detailView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
