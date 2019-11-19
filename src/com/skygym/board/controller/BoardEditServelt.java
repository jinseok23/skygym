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
 * Servlet implementation class BoardEditServelt
 */
@WebServlet("/board/boardEdit")
public class BoardEditServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardEditServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		세션아이디
		Member m=(Member)request.getSession().getAttribute("memberLoggedIn");
		
		
		String bn = request.getParameter("bn");
		int cPage = Integer.parseInt(request.getParameter("cP"));
		int boardNo = Integer.parseInt(request.getParameter("no"));
		
		Board board = new BoardService().selectOneTest(boardNo,bn);		
		
		if(!board.getBoardWriter().equals(m.getUserId())&&!m.getUserId().equals("admin"))
		{
			request.setAttribute("msg", "권한이 없습니다.");
			request.setAttribute("loc","/board/conetentView?no="+boardNo+"&bn="+bn+"&cPage="+cPage);
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
			
		}
		else
		{		
			request.setAttribute("boardNo", boardNo);
			request.setAttribute("board", board);
			request.setAttribute("cPage", cPage);
			request.setAttribute("bn", bn);				
			request.getRequestDispatcher("/views/board/boardEdit.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
