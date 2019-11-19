package com.skygym.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckNumServlet
 */
@WebServlet("/checkRandomNum")
public class CheckNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckNumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNum=Integer.parseInt(request.getParameter("userNum"));
		HttpSession session=request.getSession();
		int mailRandomNum=(int)session.getAttribute("mailRandomNum");
		String html="";
		if(userNum==mailRandomNum)
		{
			html="<span style='color:green; font-size:12px;'>인증성공</span>"
					+"<input class='checksuccess' type='hidden' value='1'/>";
		}
		else {
			html="<span style='color:red; font-size:12px;'>인증실패</span>"
				+"<input class='checksuccess' type='hidden' value='0'/>";
		}
	
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.append(html);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
