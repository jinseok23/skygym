package com.skygym.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skygym.board.model.service.BoardService;
import com.skygym.board.model.vo.BoardComment;
import com.skygym.member.model.vo.Member;

/**
 * Servlet implementation class BoardCommentDelete
 */
@WebServlet("/board/bcd")
public class BoardCommentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardCommentDelete() {
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
		
		String bn=request.getParameter("bn");
		int cPage = Integer.parseInt(request.getParameter("cPage"));
		int boardNo = Integer.parseInt(request.getParameter("no"));
		int bcn = Integer.parseInt(request.getParameter("bcn"));
		
		BoardComment bc = new BoardService().selectComment(bn,bcn);
			
		if(!bc.getBoardCommentWriter().equals(m.getUserId())&&!m.getUserId().equals("admin"))
		{
			request.setAttribute("msg", "권한이 없습니다.");
			request.setAttribute("loc","/board/contentView?no="+boardNo+"&bn="+bn+"&cPage="+cPage);
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
			
		}
		else
		{
			int result = new BoardService().deleteComment(bc,bn);
			String msg="";
			if(result>0)
			{
				msg="댓글이 삭제되었습니다.";
				request.setAttribute("msg", msg);
				request.setAttribute("loc", "/board/contentView?no="+boardNo+"&bn="+bn+"&cPage="+cPage);
				request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			}
			else
			{
				msg="잘못된 접근입니다.";
				request.setAttribute("msg", msg);
				request.setAttribute("loc","/board/contentView?no="+boardNo+"&bn="+bn+"&cPage="+cPage);
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
