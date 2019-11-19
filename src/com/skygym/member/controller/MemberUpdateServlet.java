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
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/memberUpdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId_");
		String userName=request.getParameter("userName");
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
		
		Member m=new Member();
		m.setUserId(userId);
		m.setUserName(userName);
		m.setPhone(phone);
		m.setEmail(email);
		m.setAddress(address);
		m.setInterest(String.join(",", interest));
		System.out.println(m.getInterest());
		
		int result=new MemberService().updateMember(m);

		String msg="";
		String loc="";
		String view="/views/common/msg.jsp";
		
		if(result>0)
		{
			msg="회원정보가 수정되었습니다.";
		}
		else
		{
			msg="회원정보 수정을 실패하였습니다.";
			loc="/memberView?userid="+m.getUserId();
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
