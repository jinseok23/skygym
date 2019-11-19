package com.skygym.detailview.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skygym.board.model.service.BoardService;
import com.skygym.detailview.model.service.DetailService;
import com.skygym.detailview.model.vo.GYMReply;

/**
 * Servlet implementation class UpdateCommentServlet
 */
@WebServlet("/detail/updateComment")
public class UpdateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		int replyNumber = Integer.parseInt(request.getParameter("replyNumber"));
		String replyContent = request.getParameter("replyContent");
		int GYMNumber=Integer.parseInt(request.getParameter("GYMNumber"));
		GYMReply reply = new GYMReply();
		
		reply.setReplyNumber(replyNumber);
		reply.setReply_content(replyContent);
		
		int update = new DetailService().updateComment(reply);
		
		List<GYMReply> list=new DetailService().selectCommentList(GYMNumber);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/detail/commentTable.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
