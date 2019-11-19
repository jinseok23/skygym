package com.skygym.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skygym.board.model.service.BoardService;
import com.skygym.board.model.vo.Board;

/**
 * Servlet implementation class BoardEditEndServlet
 */
@WebServlet("/board/boardEditEnd")
public class BoardEditEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardEditEndServlet() {
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
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("subject");
		String invisible = request.getParameter("invisible");			
		String content = request.getParameter("content");
		
		Board board = new Board();
		board.setBoardNo(boardNo);
		board.setBoardTitle(title);
		board.setBoardWriter(writer);
		board.setBoardContent(content);
		board.setBoardInvisible(invisible);
		
		int result = new BoardService().updateBoard(board,bn);
		String msg="";
		if(result>0)
		{
			msg="게시글이 수정되었습니다.";
		}
		else
		{
			msg="잘못된 접근입니다.";
			
		}		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", "/board/contentView?no="+boardNo+"&cPage="+cPage+"&bn="+bn);
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
