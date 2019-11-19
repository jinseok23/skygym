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
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/board/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Member m=(Member)request.getSession().getAttribute("memberLoggedIn");
		
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String bn = request.getParameter("bn");
		int cPage = Integer.parseInt(request.getParameter("cP"));
		int boardNo = Integer.parseInt(request.getParameter("no"));
		
		Board b = new BoardService().selectOneTest(boardNo,bn);	
		if(!b.getBoardWriter().equals(m.getUserId())&&!m.getUserId().equals("admin")  )
		{
			request.setAttribute("msg", "권한이 없습니다.");
			request.setAttribute("loc","/board/contentView?no="+boardNo+"&bn="+bn+"&cPage="+cPage);
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
			
		}
		else
		{
			int result = new BoardService().deleteBoard(b,bn);
			String msg="";
			if(result>0)
			{
				msg="게시글이 삭제되었습니다.";
				request.setAttribute("msg", msg);
				request.setAttribute("loc", "/board/boardList?cPage="+cPage+"&bn="+bn);
				request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			}
			else
			{
				msg="잘못된 접근입니다.";
				request.setAttribute("msg", msg);
				request.setAttribute("loc","/board/boardView?no="+boardNo+"&bn="+bn+"&cPage="+cPage);
				request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
				return;
				
			}		
			
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
