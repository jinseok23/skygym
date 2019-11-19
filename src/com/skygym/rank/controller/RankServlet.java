package com.skygym.rank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skygym.rank.model.service.RankService;
import com.skygym.rank.model.vo.GymRank;

/**
 * Servlet implementation class RankServlet
 */
@WebServlet("/rank/rankList")
public class RankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String category = request.getParameter("category");
		if(category==null||category.equals("health"))
		{
			category="헬스";
		}
		System.out.println(category);
		List<GymRank> allList=null;
		List<GymRank> seoulList=null;
		List<GymRank> gyeongiList=null;
		if(category.equals("militaryArts"))
		{
			category = "무술";
			allList = new RankService().gymRankList(category);
			seoulList = new RankService().seoulgymRankList(category);
			gyeongiList = new RankService().gyeongigymRankList(category);
		}
		else if(category.equals("physical"))
		{
			category = "체형교정";
			allList = new RankService().gymRankList(category);
			seoulList = new RankService().seoulgymRankList(category);
			gyeongiList = new RankService().gyeongigymRankList(category);
		}
		else if(category.equals("martialArts"))
		{
			category = "종합격투기";
			allList = new RankService().gymRankList(category);
			seoulList = new RankService().seoulgymRankList(category);
			gyeongiList = new RankService().gyeongigymRankList(category);
		}
		allList = new RankService().gymRankList(category);
		seoulList = new RankService().seoulgymRankList(category);
		gyeongiList = new RankService().gyeongigymRankList(category);
		request.setAttribute("allList", allList);
		request.setAttribute("list", allList);
		request.setAttribute("seoulList", seoulList);
		request.setAttribute("gyeongiList", gyeongiList);		
		request.getRequestDispatcher("/views/rank/rank.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}




