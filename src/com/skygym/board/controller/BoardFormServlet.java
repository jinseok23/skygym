package com.skygym.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skygym.member.model.vo.Member;

/**
 * Servlet implementation class BoardFormServlet
 */
@WebServlet("/board/writeForm")
public class BoardFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cPage=Integer.parseInt(request.getParameter("cPage"));
		String bn = request.getParameter("bn");
				
		Member m=(Member)request.getSession().getAttribute("memberLoggedIn");
		
//		뉴스보드는 관리자만 작성가능
		if(bn.equals("newsboard")&&!m.getUserId().equals("admin"))
		{
			request.setAttribute("msg", "소식글은 운영자만 작성할 수 있습니다.");
			request.setAttribute("loc","/board/boardList?bn="+bn+"&cPage="+cPage);
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;			
		}
		
		request.setAttribute("cPage", cPage);
		request.setAttribute("bn", bn);		
		
		request.getRequestDispatcher("/views/board/writeForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
