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
 * Servlet implementation class BoardCommentInsertServlet
 */
@WebServlet("/board/boardCommentInsert")
public class BoardCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardCommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String bn=request.getParameter("bn");
		int cPage = Integer.parseInt(request.getParameter("cPage"));
				
		int boardRef=Integer.parseInt(request.getParameter("boardRef"));
		String boardCommentWriter=request.getParameter("boardCommentWriter");
		String boardCommentContent=request.getParameter("boardCommentContent");
		
		if(boardCommentContent.length()!=0 || !boardCommentContent.equals(""))
		{
			int boardCommentLevel=Integer.parseInt(request.getParameter("boardCommentLevel"));
			int boardCommentRef=Integer.parseInt(request.getParameter("boardCommentRef"));
			
			BoardComment bc = new BoardComment();
			bc.setBoardRef(boardRef);
			bc.setBoardCommentWriter(boardCommentWriter);
			bc.setBoardCommentContent(boardCommentContent);
			
			bc.setBoardCommentLevel(boardCommentLevel);
			bc.setBoardCommentRef(boardCommentRef);

			int result = new BoardService().insertBoardComment(bc,bn);
			
			
			String loc="";
			String view = "/views/common/msg.jsp";
			
			if(result>0) {
				
			}
			else {
				String msg="잘못된 접근입니다.";
				request.setAttribute("msg",msg );
			}
			
			loc="/board/contentView?no="+boardRef+"&cPage="+cPage+"&bn="+bn+"#comment";		
			request.setAttribute("loc", loc);
			request.getRequestDispatcher(view).forward(request, response);
		}
		
		else
		{
			String view = "/views/common/msg.jsp";
			String msg="내용을 입력하세요.";
			String loc="/board/contentView?no="+boardRef+"&cPage="+cPage+"&bn="+bn;		
			request.setAttribute("loc", loc);
			request.setAttribute("msg",msg );
			request.getRequestDispatcher(view).forward(request, response);
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
