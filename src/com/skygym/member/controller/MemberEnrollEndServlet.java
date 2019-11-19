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
 * Servlet implementation class MemberEnrollServlet
 */
@WebServlet(name="MemberEnrollEndServlet",urlPatterns="/memberEnrollEnd")
public class MemberEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEnrollEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId_");
		String password=request.getParameter("password_");
		String userName=request.getParameter("userName");
		String residentNum=request.getParameter("residentNum");
		//휴대폰번호 합치기
		String tel1=request.getParameter("tel1");
		String tel2=request.getParameter("tel2");
		String tel3=request.getParameter("tel3");
		String phone=tel1+"-"+tel2+"-"+tel3;
		//이메일 합치기
		String email1=request.getParameter("email1");
		String email2=request.getParameter("email2");
		String email=email1+"@"+email2;
		//주소합치기
		String cityMain=request.getParameter("city-main");
		String citySeoul=null;
		String cityGyeonggi=null;
		String subAddress=request.getParameter("subaddress");
		String address="";
		if(cityMain.equals("gyeonggi")) 
		{
			cityGyeonggi=request.getParameter("city-gyeonggi");
			cityMain="경기도";
			address=cityMain+" "+cityGyeonggi+" "+subAddress;
		}
		else
		{
			citySeoul=request.getParameter("city-seoul");
			cityMain="서울특별시";
			address=cityMain+" "+citySeoul+" "+subAddress;
		}
		
		String[] interest=request.getParameterValues("interest");
		String interests=String.join(",", interest);
		
		Member m=new Member(userId,password,userName,residentNum,phone,email,address,interests,null);
		int result=new MemberService().insertMember(m);
		
		String msg="";
		String loc="/";
		String view="/views/common/msg.jsp";
		if(result>0)
		{
			msg="회원가입 되었습니다.";
		}
		else
		{
			msg="회원가입을 할 수 없습니다.";
			loc="/views/member/memberEnroll.jsp";
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
