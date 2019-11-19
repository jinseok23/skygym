package com.skygym.detailview.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skygym.detailview.model.service.DetailService;
import com.skygym.detailview.model.vo.GYMReply;

/**
 * Servlet implementation class DeleteCommentServlet
 */
@WebServlet("/detail/deleteComment")
public class DeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		int GYMNumber = Integer.parseInt(request.getParameter("GYMNumber"));
		int replyNumber = Integer.parseInt(request.getParameter("replyNumber"));
		String replyContent = request.getParameter("re-content");
		String userId = request.getParameter("userId");
		int replyLevel = Integer.parseInt(request.getParameter("replyLevel"));
		
		
		System.out.println("디테일 코멘트 인서트");
		System.out.println(GYMNumber);
		System.out.println(replyNumber);
		System.out.println(replyContent);
		System.out.println(replyLevel);
		
		
		
		GYMReply reply = new GYMReply();
		
		reply.setGYMNumber(GYMNumber);
		reply.setReplyNumber(replyNumber);
		reply.setReply_content(replyContent);
		reply.setUserId(userId);
		reply.setReplyLevel(replyLevel);
		
		
		int del = new DetailService().deleteComment(replyNumber);
		
		request.setAttribute("GYMNumber", GYMNumber);
		request.setAttribute("replyNumber", replyNumber);
		request.setAttribute("re-content", replyContent);
		request.setAttribute("userId", userId);
		request.setAttribute("replyLevel", replyLevel);
		request.setAttribute("del", del);
		
		
		request.getRequestDispatcher("/detail/detailView?GYMNumber="+GYMNumber).forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
