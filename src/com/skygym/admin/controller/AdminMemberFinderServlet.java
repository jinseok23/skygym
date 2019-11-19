package com.skygym.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skygym.admin.model.service.AdminService;
import com.skygym.member.model.vo.Member;

import common.PageBar;

/**
 * Servlet implementation class AdminMemberFinderServlet
 */
@WebServlet("/memberFinder")
public class AdminMemberFinderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberFinderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//관리자가 아닌 경우
				Member m=(Member)request.getSession().getAttribute("memberLoggedIn");
				if(m==null||!m.getUserId().equals("admin"))
				{
					request.setAttribute("msg", "잘못된 경로로 접급하셨습니다.");
					request.setAttribute("loc", "/");
					request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
					return;
				}
				
				String searchType=request.getParameter("searchType");
				String searchKeyword=request.getParameter("searchKeyword");
				List<Member> list=null;

				int cPage=Integer.parseInt(request.getParameter("cPage"));
				int numPerPage=10;
				
				switch(searchType)
				{
					case "userId" : list=new AdminService().selectMemberById(searchKeyword, cPage, numPerPage);break;
					case "userName" : list=new AdminService().selectMemberByName(searchKeyword, cPage, numPerPage);break;
				}
				int totalContent=0;
				switch(searchType)
				{
					case "userId" : totalContent=new AdminService().selectFindCountId(searchKeyword);break;
					case "userName" : totalContent=new AdminService().selectFindCountName(searchKeyword);break;
				}

				int totalPage=(int)Math.ceil((double)totalContent/numPerPage);
				
				int barSize=5;
				String pageBar="";
				int pageNo= ((cPage-1)/barSize)*barSize+1;
				int pageEnd = pageNo+barSize-1;

				pageBar+="<li><a href='"+request.getContextPath()+"/memberFinder?searchType="+searchType+"&searchKeyword="+searchKeyword+"&cPage="+cPage+"' title='첫 페이지' class='prevEnd'><i class='xi-angle-double-left'></i></a></li>";
				
				if(cPage==1)
				{
					pageBar+="<li><a title='전 페이지'><i class='xi-angle-left'></i></a></li>";
				}
				else
				{
					pageBar+="<li><a href='"+request.getContextPath()+"/memberFinder?searchType="+searchType+"&searchKeyword="+searchKeyword+"&cPage="+(cPage-1)+" 'title='전 페이지' class='prevEnd'><i class='xi-angle-left'></i></a></li>";
				}

				while(!(pageNo>pageEnd || pageNo>totalPage))
				{
					if(cPage==pageNo)
					{
						pageBar+="<strong class='page_on'>"+pageNo+"</strong>";
					}
					else
					{
						pageBar+="<a href='"+request.getContextPath()+"/memberFinder?searchType="+searchType+"&searchKeyword="+searchKeyword+"&cPage="+pageNo+"'>"+pageNo+"</a>";
					}
					pageNo++;
				}

				if(cPage==totalPage)
				{
					pageBar+="<li><a title='다음 페이지'><i class='xi-angle-right'></i></a></li>";
					
				}
				else
				{
					pageBar+="<li><a href='"+request.getContextPath()+"/memberFinder?searchType="+searchType+"&searchKeyword="+searchKeyword+"&cPage="+(cPage+1)+"'title='다음 페이지' class='nextEnd'><i class='xi-angle-right'></i></a></li>";
				}
				pageBar+="<li><a href='"+request.getContextPath()+"/memberFinder?searchType="+searchType+"&searchKeyword="+searchKeyword+"&cPage="+totalPage+" 'title='끝 페이지' class='nextEnd'><i class='xi-angle-double-right'></i><span>끝 페이지</span></a></li>";

				request.setAttribute("searchType", searchType); //다시 set으로 설정해줘야되는건지??
				request.setAttribute("searchKeyword", searchKeyword);
				request.setAttribute("list", list);
				//자료가 들어있는 리스트
				request.setAttribute("cPage", cPage);
				// 현재 페이지
				request.setAttribute("pageBar", pageBar);
				//페이지 바
				request.setAttribute("numPerPage",numPerPage);
				//페이지당 자료 갯수
				request.getRequestDispatcher("/views/admin/memberFind.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
