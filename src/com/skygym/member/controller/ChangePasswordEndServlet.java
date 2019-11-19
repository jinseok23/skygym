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
 * Servlet implementation class ChangePasswordEndServlet
 */
@WebServlet(name="ChangePasswordEndServlet",urlPatterns="/changePasswordEnd")
public class ChangePasswordEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		System.out.println(userId);
		String password=request.getParameter("password");
		String password_new=request.getParameter("password_new");
		//2개의 비지니스로직!
		//1. 비밀번호가 맞는지(logincheck)
		//2. 비밀번호 변경!
		Member m=new MemberService().selectOne(userId);
		//현재 패스워드가 일치일때
		String msg="";
		String loc="";
		String view="/views/common/msg.jsp";
		String script="self.close()";
		if(m.getPassword().equals(password))
		{
			m.setPassword(password_new);
			int result=new MemberService().passwordUpdate(m);
			if(result>0)
			{
				msg="비밀번호 수정완료";
				request.setAttribute("script", script);
			}
			else
			{
				msg="비밀번호 수정실패";
				loc="/member/updatePassword?userId="+m.getUserId();
			}
		}
		else
		{
			msg="현재비밀번호가 다릅니다.";
			loc="/member/updatePassword?userId="+m.getUserId();
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
