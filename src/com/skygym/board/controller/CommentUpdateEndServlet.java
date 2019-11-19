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
 * Servlet implementation class CommentUpdateEndServlet
 */
@WebServlet("/board/bcuEnd")
public class CommentUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		Member m=(Member)request.getSession().getAttribute("memberLoggedIn");
		
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int cPage = Integer.parseInt(request.getParameter("cPage"));
		String bn = request.getParameter("bn");
		String writer = request.getParameter("boardCommentWriter");
		String bcc = request.getParameter("boardCommentContent");
		int bcn = Integer.parseInt(request.getParameter("boardCommentNo"));
		
		
		BoardComment bc = new BoardComment();
		bc.setBoardCommentWriter(writer);
		bc.setBoardCommentContent(bcc);
		bc.setBoardCommentNo(bcn);
	
		if(!bc.getBoardCommentWriter().equals(m.getUserId())&&!m.getUserId().equals("admin"))
		{
			request.setAttribute("msg", "잘못된 접근입니다.");
			request.setAttribute("loc","/board/contentView?no="+boardNo+"&bn="+bn+"&cPage="+cPage);
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
			
		}
		else
		{
			int result = new BoardService().updateComment(bc,bn);
			String msg="";
			if(result>0)
			{
				msg="댓글이 수정되었습니다.";
				request.setAttribute("msg", msg);
				request.setAttribute("loc", "/board/contentView?no="+boardNo+"&bn="+bn+"&cPage="+cPage);
				request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			}
			else
			{
				msg="잘못된 접근입니다.";
				request.setAttribute("msg", msg);
				request.setAttribute("loc","/board/conetentView?no="+boardNo+"&bn="+bn+"&cPage="+cPage);
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
