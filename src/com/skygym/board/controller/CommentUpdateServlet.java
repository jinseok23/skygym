package com.skygym.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skygym.board.model.service.BoardService;
import com.skygym.board.model.vo.BoardComment;

/**
 * Servlet implementation class CommentEditServlet
 */
@WebServlet("/board/bcu")
public class CommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String bn=request.getParameter("bn");
		int cPage = Integer.parseInt(request.getParameter("cPage"));
		int boardNo = Integer.parseInt(request.getParameter("no"));
		int bcn = Integer.parseInt(request.getParameter("bcn"));
		
		BoardComment bc = new BoardService().selectComment(bn,bcn);
		
		request.setAttribute("bn", bn);
		request.setAttribute("cPage", cPage);
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("bc", bc);
		request.getRequestDispatcher("/views/board/boardReplyEdit.jsp").forward(request, response);
			
}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
