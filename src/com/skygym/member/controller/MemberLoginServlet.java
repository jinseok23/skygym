package com.skygym.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skygym.member.model.service.MemberService;
import com.skygym.member.model.vo.Member;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet(name="MemberLoginServlet",urlPatterns="/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=(String)request.getParameter("userId");
		String password=(String)request.getParameter("password");
		System.out.println("암호화 :"+password);
		Member m=new MemberService().selectOne(userId);
		
		String msg="";//client한테 메세지 보내는 역할
		String loc="";//페이지를 이동하는 역할
		String view="views/common/msg.jsp";//이동할 페이지!
		
		//로그인처리
		if(m!=null)
		{
			if(m.getPassword().equals(password))
			{
				//로그인성공
				msg=null;
				loc="/";
				HttpSession session=request.getSession();
				
				session.setAttribute("memberLoggedIn", m);
				
				//쿠키설정내용
				//저장여부를 확인
				String saveId=request.getParameter("saveId");
				//쿠키를 저장하는 로직
				if(saveId!=null)//checkbox에 체크여부
				{
					Cookie c=new Cookie("saveId", userId);
					c.setMaxAge(365*24*60*60);
					c.setPath("/");
					response.addCookie(c);
				}
				//쿠키를 삭제하는 로직
				else
				{
					//Cookie값 삭제
					Cookie c=new Cookie("saveId", userId);
					c.setMaxAge(0);
					c.setPath("/");
					response.addCookie(c);
				}
			}
			else
			{
				//비밀번호가 다릅니다.
				msg="비밀번호가 다릅니다";
				loc="/views/member/login.jsp";
			}
		}
		else
		{
			//id가 없습니다.
			msg="아이디가 없습니다.";
			loc="/";
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
