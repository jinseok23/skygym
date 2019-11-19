package common;

import javax.servlet.http.HttpServletRequest;

import com.skygym.admin.model.service.AdminService;

public class PageBar {

	public static String getPageBar(HttpServletRequest request, int cPage, int numPerPage)
	{
		//페이지바를 구성
				int totalContent=new AdminService().selectMemberCount();
				
				int totalPage=(int)Math.ceil((double)totalContent/numPerPage);
				
				int pageBarSize=5;
				String pageBar="";
				
				int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
				int pageEnd=pageNo+pageBarSize-1;
				
				//[이전]문자 넣기
				if(pageNo==1)
				{
					pageBar+="<span>[이전]</span>";
				}
				else
				{
					pageBar+="<a href='"+request.getContextPath()+"/admin/memberList?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"'>[이전]</a>";
				}
				//section 숫자 넣기
				while(!(pageNo>pageEnd||pageNo>totalPage))
				{
					if(cPage==pageNo)
					{
						pageBar+="<span class='cPage'>"+pageNo+"</span>";
					}
					else
					{
						pageBar+="<a href='"+request.getContextPath()+"/admin/memberList?cPage="+pageNo+"&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
					}
					pageNo++;
				}
				//[다음] section
				if(pageNo>totalPage)
				{
					pageBar+="<span class='cPage'>"+"[다음]"+"</span>";
				}
				else
				{
					pageBar+="<a href='"+request.getContextPath()+"/admin/memberList?cPage="+pageNo+"&numPerPage="+numPerPage+"'>[다음]</a>";
				}
				
				return pageBar;
	}
}
