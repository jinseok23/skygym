package com.skygym.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skygym.member.model.service.MemberService;
import com.skygym.member.model.vo.Member;

import common.SendMail;

/**
 * Servlet implementation class MemberFindPwServlet
 */
@WebServlet(name="MemberFindPwServlet", urlPatterns="/memberFindPw")
/*name="ChangePasswordServlet",urlPatterns="/changePassword"*/
public class MemberFindPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindPwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("pw_name");
		String email=request.getParameter("email");
		String userId=request.getParameter("member_id");
		System.out.println(name+","+email+","+userId);
		
		Member m = new MemberService().memberFindId(name,email,userId);
		
		String msg="";
		String loc="";
		String view="";
		if(m==null)
		{
			msg="등록된 회원정보가 일치하지 않습니다.";
			loc="/views/member/idPwFind.jsp";
			view="/views/common/msg.jsp";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			request.getRequestDispatcher(view).forward(request, response);
		}
		else
		{
			int ran=new SendMail().sendMail(email); 
			String num=String.valueOf(ran);
			request.setAttribute("num",num);
			System.out.println("암호화 전."+num);
			String randomNum=(String)request.getAttribute("num");
			System.out.println("암호화 후 "+randomNum);
			
			int result = new MemberService().tempPw(randomNum,name,email,userId);

			if(result>=1)
			{
				msg="이메일로 임시비밀번호 전송 되었습니다.";
				loc="/views/member/login.jsp";
				
			}
			else
			{
				msg="정보가 맞지 않습니다. 확인 후 다시 시도 해주세요.";
				loc="/views/member/idPwFind.jsp";
			}
			request.setAttribute("msg",msg);
			request.setAttribute("loc", loc);
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
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
