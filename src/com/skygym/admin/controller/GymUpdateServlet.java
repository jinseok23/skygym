package com.skygym.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skygym.admin.model.service.AdminService;
import com.skygym.findgym.model.vo.GYM;

/**
 * Servlet implementation class GymUpdateServlet
 */
@WebServlet("/gymUpdate")
public class GymUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GymUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int gymNumber = Integer.parseInt(request.getParameter("gymNumber"));
		String name = request.getParameter("branchName");
		String category = request.getParameter("category");
		String tel = request.getParameter("tel");
		//address
		String cityMain = request.getParameter("city-main");
		String address = request.getParameter("address");
		
		if(cityMain.equals("seoul"))
		{
			
			String citySeoul = request.getParameter("city-seoul");
			cityMain = "서울특별시";
			address = cityMain+" "+citySeoul+" "+address;
			
		}
		else if(cityMain.equals("gyeonggi"))
		{
			 
			String cityGyeonggi = request.getParameter("city-gyeonggi");
			cityMain = "경기도";
			address = cityMain+" "+cityGyeonggi+" "+address;
			
		}
		String homepage = request.getParameter("homepage");
		//hidden
		String gymInfo = request.getParameter("gymInfo");
		String district = request.getParameter("district");
		GYM g = new GYM();
		g.setGYMNumber(gymNumber);
		g.setGYMbranchName(name);
		g.setGYMCategory(category);
		g.setGYMtel(tel);
		g.setGYMAddress(address);
		g.setGYMHomePage(homepage); 
		g.setGYMdistrict(cityMain);
		g.setGYMInfo(gymInfo);
		System.out.println(" 뜨냐"+g);
		
		int result = new AdminService().updateGym(g);
		String msg="";
		String loc="";
		
		if(result>0)
		{
			msg="정보가 수정되었습니다.";
			loc="/admin/gymList";
			
		}
		else
		{
			msg="정보 수정이 되지 않았습니다.";
			loc="/admin/gymList";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
