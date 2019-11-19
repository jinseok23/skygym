package com.skygym.detailview.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skygym.detailview.model.service.DetailService;
import com.skygym.detailview.model.vo.GYMReply;
import com.skygym.member.model.vo.Member;

/**
 * Servlet implementation class InsertCommentServlet
 */
@WebServlet("/InsertComment.do")
public class InsertCommentServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      request.setCharacterEncoding("UTF-8");
      
      
      HttpSession session = request.getSession();
      Member memberLoggedIn=(Member)session.getAttribute("memberLoggedIn");
      
      System.out.println("memberLoggedIn : "+memberLoggedIn);
      
      int GYMNumber = Integer.parseInt(request.getParameter("GYMNumber"));
      String userId = request.getParameter("userId");
      int GYMScore = Integer.parseInt(request.getParameter("chk_point"));
      String reply_content = request.getParameter("reply_content");
      
      GYMReply gr = new GYMReply();
      
      gr.setGYMNumber(GYMNumber);
      gr.setUserId(userId);
      gr.setGYMScore(GYMScore);
      gr.setReply_content(reply_content);
      
//      int result = new DetailService().insertComment(gr);
      
      System.out.println("gr : "+gr.getGYMScore());
      
      String msg = "";
      String loc = "";
      if(memberLoggedIn!=null)
      {
         
            int result = new DetailService().insertComment(gr);
         if(result>0)
         {
            msg="댓글 등록 완료!";
            loc="/detail/detailView?GYMNumber="+GYMNumber;
         }
      }else {
         
         msg="로그인 후 이용 가능합니다.";
         loc="/detail/detailView?GYMNumber="+GYMNumber;
         request.setAttribute("msg", msg);
      }
      
      
      request.setAttribute("loc", loc);
      request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
      
//      request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
//      request.setAttribute("gr", gr);
//      request.setAttribute("result", result);
      
//      }catch(Exception e)
//      {
//         e.printStackTrace();
//      }
      
      
      
      
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}