package com.skygym.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skygym.board.model.service.BoardService;
import com.skygym.board.model.vo.Board;
import com.skygym.member.model.vo.Member;



/**
 * Servlet implementation class BoardFormEndServlet
 */
@WebServlet("/board/writeFormEnd")
public class BoardFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFormEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String bn = request.getParameter("bn");
		int cPage = Integer.parseInt(request.getParameter("cPage"));
		
		String invisible = request.getParameter("invisible");		
		String title = request.getParameter("subject");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
			
		Board board = new Board();
		board.setBoardTitle(title);
		board.setBoardWriter(writer);
		board.setBoardContent(content);
		board.setBoardInvisible(invisible);
			
		int result = new BoardService().insertBoard(board,bn);
		
		if(result>0)
		{
			
		}
		else
		{
			String msg="잘못된 접근입니다.";
			request.setAttribute("msg", msg);
		}		
		request.setAttribute("loc", "/board/boardList?bn="+bn+"&cPage="+cPage);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
