package com.skygym.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skygym.board.model.service.BoardService;
import com.skygym.board.model.vo.Board;
import com.skygym.board.model.vo.BoardComment;
import com.skygym.member.model.vo.Member;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/board/contentView")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNo=Integer.parseInt(request.getParameter("no"));
		String bn=request.getParameter("bn");
		int cPage = Integer.parseInt(request.getParameter("cPage"));		
		
		int addHits=0;
		
		Cookie[] cookie=request.getCookies();
		String boardCookieVal="";
		boolean hasRead=false;
		
		
		String view="";
		
		Member m=(Member)request.getSession().getAttribute("memberLoggedIn");
		
		Board board=new BoardService().selectOne(boardNo, bn);
		
//		게시글이 삭제됐을 때 
		if(board==null)
		{		
			request.setAttribute("msg", "게시글이 존재하지 않습니다.");
			request.setAttribute("loc","/board/boardList?bn="+bn+"&cPage="+cPage);
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}		
//		비로그인이고 비밀글일 때
		if(m==null&&board.getBoardInvisible().equals("yes"))
		{
			request.setAttribute("msg", "로그인하시기 바랍니다.");
			request.setAttribute("loc","/views/member/login.jsp");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}

		if(cookie!=null)
		{
			outer:
				for(Cookie c:cookie)
				{
					String name=c.getName();
					String value=c.getValue();
					if("boardCookie".equals(name))
					{
						boardCookieVal=value;
						if(value.contains("|"+boardNo+"|"))
						{
							hasRead=true;
							break outer;
						}
					}
				}
		}
		
		if(!hasRead)
		{
			Cookie boardCookie=new Cookie("boardCookie",boardCookieVal+"|"+boardNo+"|");
			boardCookie.setMaxAge(-1);
			response.addCookie(boardCookie);
			addHits = 1;
		}
		
//		로그인 되었을 때
		if(m!=null);
		{		
//			비밀글 일때
			if(board.getBoardInvisible().equals("yes"))
			{
//				비밀글을 볼 수 있는 유저
				if(board.getBoardWriter().equals(m.getUserId()) || m.getUserId().equals("admin"))
				{
					new BoardService().addBoardCount(boardNo ,bn,hasRead);
					List<BoardComment> list=new BoardService().selectBoardCommentList(boardNo,bn);
					request.setAttribute("addHits", addHits);
					request.setAttribute("boardNo", boardNo);
					request.setAttribute("board", board);
					request.setAttribute("list", list);
					request.setAttribute("cPage", cPage);
					view="/views/board/contentView.jsp";	
					request.getRequestDispatcher(view).forward(request, response);
				}
				else
				{
					request.setAttribute("msg", "비밀글은 작성자만 볼 수 있습니다.");
					request.setAttribute("loc","/board/boardList?bn="+bn+"&cPage="+cPage);
					request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
					return;
				}
			}
//			비밀글이 아닐 때
			else
			{
				new BoardService().addBoardCount(boardNo ,bn,hasRead);
				List<BoardComment> list=new BoardService().selectBoardCommentList(boardNo,bn);
				request.setAttribute("addHits", addHits);
				request.setAttribute("boardNo", boardNo);
				request.setAttribute("board", board);
				request.setAttribute("list", list);
				request.setAttribute("cPage", cPage);
				view="/views/board/contentView.jsp";
				request.getRequestDispatcher(view).forward(request, response);				
			}				
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
