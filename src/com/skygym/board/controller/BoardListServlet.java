package com.skygym.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skygym.board.model.service.BoardService;
import com.skygym.board.model.vo.Board;


/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/board/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
			String bn = request.getParameter("bn");
			
			
			int numPerPage = 10;
			int cPage;
			try {
				cPage=Integer.parseInt(request.getParameter("cPage"));
						
			}
			catch(NumberFormatException e )
			{
				cPage = 1;
			}
			
			List<Board> list = new BoardService().selectBoardList(cPage, numPerPage,bn);
			

			int totalContent = new BoardService().selectBoardCount(bn); 
			
			

			int totalPage=(int)Math.ceil((double)totalContent/numPerPage);
			
			int barSize=5;
			String pageBar="";
			int pageNo= ((cPage-1)/barSize)*barSize+1;
			int pageEnd = pageNo+barSize-1;
			
			pageBar+="<li><a href='"+request.getContextPath()+"/board/boardList?bn="+bn+"&cPage=1' title='첫 페이지' class='prevEnd'><i class='xi-angle-double-left'></i></a></li>";
			
			if(cPage==1)
			{
				pageBar+="<li><a title='전 페이지'><i class='xi-angle-left'></i></a></li>";
			}
			else
			{
				pageBar+="<li><a href='"+request.getContextPath()+"/board/boardList?bn="+bn+"&cPage="+(cPage-1)+" 'title='전 페이지' class='prevEnd'><i class='xi-angle-left'></i></a></li>";
			}

			while(!(pageNo>pageEnd || pageNo>totalPage))
			{
				if(cPage==pageNo)
				{
					pageBar+="<strong class='page_on'>"+pageNo+"</strong>";
				}
				else
				{
					pageBar+="<a href='"+request.getContextPath()+"/board/boardList?bn="+bn+"&cPage="+pageNo+"'>"+pageNo+"</a>";
				}
				pageNo++;
			}

			if(cPage==totalPage)
			{
				pageBar+="<li><a title='다음 페이지'><i class='xi-angle-right'></i></a></li>";
				
			}
			else
			{
				pageBar+="<li><a href='"+request.getContextPath()+"/board/boardList?bn="+bn+"&cPage="+(cPage+1)+" 'title='다음 페이지' class='nextEnd'><i class='xi-angle-right'></i></a></li>";
			}
			pageBar+="<li><a href='"+request.getContextPath()+"/board/boardList?bn="+bn+"&cPage="+totalPage+" 'title='끝 페이지' class='nextEnd'><i class='xi-angle-double-right'></i><span>끝 페이지</span></a></li>";
			

			request.setAttribute("list", list);
			request.setAttribute("cPage", cPage);						
			request.setAttribute("pageBar", pageBar);		
			request.setAttribute("bn", bn);
			request.getRequestDispatcher("/views/board/boardList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
