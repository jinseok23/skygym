package com.skygym.findgym.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skygym.findgym.model.service.findGYMService;
import com.skygym.findgym.model.vo.GYM;

import common.PageBar;


/**
 * Servlet implementation class FindSeoulGYMServlet
 */
@WebServlet("/find/findGYMDistrict")
public class FindGYMDistrictServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindGYMDistrictServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String district = request.getParameter("city");
		//페이징 처리
		
		int numPerPage = 10;
		int cPage;
		try 
		{
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}
		catch(NumberFormatException e)
		{
			cPage = 1;
		}
		
		List<GYM> list = new findGYMService().selectGYMDistrictList(cPage, numPerPage, district);
						 	 //보드에 있는 자료를 가져와서 List에 담는다
		
		//전체 자료수
		int totalContent=new findGYMService().selectGYMDistrictCount(district);
		
		int totalPage=(int)Math.ceil((double)totalContent/numPerPage);
		
		int barSize=5;
		String pageBar="";
		int pageNo= ((cPage-1)/barSize)*barSize+1;
		int pageEnd = pageNo+barSize-1;

	
		pageBar+="<li><a href='"+request.getContextPath()+"/find/findGYMDistrict?city="+district+"&cPage="+cPage+"' title='첫 페이지' class='prevEnd'><i class='xi-angle-double-left'></i></a></li>";
		
		if(cPage==1)
		{
			pageBar+="<li><a title='전 페이지'><i class='xi-angle-left'></i></a></li>";
		}
		else
		{
			pageBar+="<li><a href='"+request.getContextPath()+"/find/findGYMDistrict?city="+district+"&cPage="+(cPage-1)+" 'title='전 페이지' class='prevEnd'><i class='xi-angle-left'></i></a></li>";
		}

		while(!(pageNo>pageEnd || pageNo>totalPage))
		{
			if(cPage==pageNo)
			{
				pageBar+="<strong class='page_on'>"+pageNo+"</strong>";
			}
			else
			{
				pageBar+="<a href='"+request.getContextPath()+"/find/findGYMDistrict?city="+district+"&cPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}

		if(cPage==totalPage)
		{
			pageBar+="<li><a title='다음 페이지'><i class='xi-angle-right'></i></a></li>";
			
		}
		else
		{
			pageBar+="<li><a href='"+request.getContextPath()+"/find/findGYMDistrict?city="+district+"&cPage="+(cPage+1)+" 'title='다음 페이지' class='nextEnd'><i class='xi-angle-right'></i></a></li>";
		}
			pageBar+="<li><a href='"+request.getContextPath()+"/find/findGYMDistrict?city="+district+"&cPage="+totalPage+"'title='끝 페이지' class='nextEnd'><i class='xi-angle-double-right'></i><span>끝 페이지</span></a></li>";
		
		request.setAttribute("list", list);
						//자료가 들어있는 리스트
		request.setAttribute("cPage", cPage);
						// 현재 페이지
		request.setAttribute("pageBar", pageBar);
						//페이지 바
		request.setAttribute("numPerPage",numPerPage);
						//페이지당 자료 갯수
		
		request.getRequestDispatcher("/views/find/findGYMDistrict.jsp").forward(request, response);				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
