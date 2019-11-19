package com.skygym.recommendgym.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skygym.findgym.model.service.findGYMService;
import com.skygym.findgym.model.vo.GYM;
import com.skygym.member.model.service.MemberService;
import com.skygym.member.model.vo.Member;
import com.skygym.recommendgym.model.dao.recommendGYMService;

import common.PageBar;

/**
 * Servlet implementation class FindGYMServlet
 */
@WebServlet("/recommend/MemberRecommend")
public class MemberRecommendServlet extends HttpServlet 
{
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberRecommendServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {
   
      String userId=request.getParameter("userId");


      int numPerPage = 18;
      int cPage;
      try 
      {
         cPage=Integer.parseInt(request.getParameter("cPage"));
      }
      catch(NumberFormatException e)
      {
         cPage = 1;
      }
      Member m = new MemberService().selectOne(userId);
      
    
                  //헤더에서 가져온 userId를 통해 해당 아이디의 정보를 가져온다 
      String[] interest = m.getInterest().split(",");
                     // 가져온 회원의 관심분야를 배열로 저장한다 
      String[] addressArr = m.getAddress().split(" ");
                     // 가져온 회원의 주소를 배열로 저장한다 - > 근처지역을 우선으로 추천해주기 위함
      List<GYM> list = new ArrayList();
      
      if(interest.length==1)
      {
         list = new recommendGYMService().selectRecommendGYMList(cPage,numPerPage,addressArr[0],addressArr[1],interest[0]);
         
      }
      else if(interest.length==2)
      {
         list = new recommendGYMService().selectRecommendGYMList(cPage,numPerPage,addressArr[0],addressArr[1],interest[0],interest[1]);
      }   

      
      List<GYM> allList = new recommendGYMService().selectAll();      
      
      for(int i=0; i<allList.size(); i++)
      {
         for(int j=0; j<list.size(); j++)
         {
            if(allList.get(i).getGYMNumber()==list.get(j).getGYMNumber())
            {
               GYM g = new GYM(); 
               g.setGYMNumber(allList.get(i).getGYMNumber());
               g.setGYMCategory(allList.get(i).getGYMCategory());
               g.setGYMdistrict(allList.get(i).getGYMdistrict());
               g.setGYMbranchName(allList.get(i).getGYMbranchName());
               g.setGYMAddress(allList.get(i).getGYMAddress());
               g.setGYMtel(allList.get(i).getGYMtel());                 
                 g.setGYMInfo(allList.get(i).getGYMInfo());
                 g.setGYMHomePage(allList.get(i).getGYMHomePage());
                 g.setMainImage(allList.get(i).getMainImage());
//               System.out.println(allList.get(i).getMainImage());
//             이미지주소                    
              list.set(j, g);          
            
            }
         }
      }
      
      //전체 자료수
      int totalContent=0;
      
      if(interest.length==1)
      {
         totalContent = new recommendGYMService().selectRecommendGYMCount(interest[0],addressArr[0],addressArr[1]);
      }
      else if(interest.length==2)
      {
         totalContent = new recommendGYMService().selectRecommendGYMCount(interest[0],interest[1],addressArr[0],addressArr[1]);
      }
      
      
      int totalPage=(int)Math.ceil((double)totalContent/numPerPage);
      int barSize=5;
      String pageBar="";
      int pageNo= ((cPage-1)/barSize)*barSize+1;
      int pageEnd = pageNo+barSize-1;
      
      pageBar+="<li><a href='"+request.getContextPath()+"/recommend/MemberRecommend?userId="+userId+"&cPage="+cPage+"' title='첫 페이지' class='prevEnd'><i class='xi-angle-double-left'></i></a></li>";

      
      if(cPage==1)
      {
         pageBar+="<li><a title='전 페이지'><i class='xi-angle-left'></i></a></li>";
      }
      
      else
      {
         pageBar+="<li><a href='"+request.getContextPath()+"/recommend/MemberRecommend?userId="+userId+"&cPage="+(cPage-1)+" 'title='전 페이지' class='prevEnd'><i class='xi-angle-left'></i></a></li>";
      }

      while(!(pageNo>pageEnd || pageNo>totalPage))
      {
         if(cPage==pageNo)
         {
            pageBar+="<strong class='page_on'>"+pageNo+"</strong>";
         }
         else
         {
            pageBar+="<a href='"+request.getContextPath()+"/recommend/MemberRecommend?userId="+userId+"&cPage="+pageNo+"'>"+pageNo+"</a>";
         }
         pageNo++;
      }

      if(cPage==totalPage)
      {
         pageBar+="<li><a title='다음 페이지'><i class='xi-angle-right'></i></a></li>";
      }
      else
      {
         pageBar+="<li><a href='"+request.getContextPath()+"/recommend/MemberRecommend?userId="+userId+"&cPage="+(cPage+1)+" 'title='다음 페이지' class='nextEnd'><i class='xi-angle-right'></i></a></li>";
      }
         pageBar+="<li><a href='"+request.getContextPath()+"/recommend/MemberRecommend?userId="+userId+"&cPage="+totalPage+" 'title='끝 페이지' class='nextEnd'><i class='xi-angle-double-right'></i><span>끝 페이지</span></a></li>";

      
      request.setAttribute("list", list);
                  //자료가 들어있는 리스트
      request.setAttribute("cPage", cPage);
                  // 현재 페이지
      request.setAttribute("pageBar", pageBar);
                  //페이지 바
      request.setAttribute("numPerPage",numPerPage);
                  //페이지당 자료 갯수
      request.setAttribute("member", m);
                  // 멤버객체를 가져가서 카테고리를 별 페이지를 보여주기 위함 
      request.getRequestDispatcher("/views/recommend/MemberRecommend.jsp").forward(request, response);            

   }
   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

} 