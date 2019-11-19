package com.skygym.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skygym.member.model.service.MemberService;
import com.skygym.member.model.vo.Member;

/**
 * Servlet implementation class MemberFindIdServlet
 */
@WebServlet("/memberFindId")
public class MemberFindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("id_name");
		String birth=request.getParameter("birth");
		
		
		String msg="";
		String loc="";
		String view="";
		
		Member m = new MemberService().memberFindId(name, birth);
		if(m==null)
		{
			msg="등록된 회원정보가 일치하지 않습니다.";
			loc="/views/member/idPwFind.jsp";
			view="/views/member/memberFindIdMsg.jsp";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			request.getRequestDispatcher(view).forward(request, response);
			
		}
		else {
			view="/views/member/memberFindId.jsp";
			request.setAttribute("m", m);
			request.setAttribute("name", name);
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
