<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import='java.util.*,com.skygym.board.model.vo.Board'%>
<%@ include file="/views/common/header.jsp"%>
<%@ include file="/views/common/subMenu.jsp" %>

<%
	List<Board> list=(List<Board>)request.getAttribute("list");
	int cPage=(int)request.getAttribute("cPage");
	String pageBar=(String)request.getAttribute("pageBar");
	String bn = request.getParameter("bn");
	String secret="";	
%>       
<script>
function fn_event1(){
	alert("미구현... 당첨입니다!!");
}

</script>
<div class="container">
	<br>
	<div class="boardNavigation xet_clearfix mg-b15 visible-xs hidden-sm">
	<div class="float_right">
	</div></div>
	<div class="boardListForm">
	<table cellspacing="0" border="0" cellpadding="0" summary="List of Articles" class="boardList">
		<thead class="hidden-xs">
			<tr>								
				<th scope="col">번호</th>																																																
				<th scope="col">제목</th>																																												
				<th scope="col">작성자</th>																																
				<th scope="col">날짜</a></th>																																								
				<th scope="col" class="hidden-xs">조회 수</a></th>
			</tr>
		</thead>
		<tbody>			
		<%for(Board b : list) 
		  {%>
			<tr class="bg2">								
				<td class="num">
					<span><%= b.getBoardNo() %></span>				
				</td>																																																
				<td class="title">		
				
					<%if(b.getBoardInvisible().equals("yes")){out.print("<i class='xi-lock'></i>");} %>									
					<a href='<%=request.getContextPath()%>/board/contentView?no=<%= b.getBoardNo() %>&cPage=<%=cPage%>&bn=<%=bn%>' class="subject"/>
					<%=b.getBoardTitle() %>&nbsp;
					<i class="xi-comments skycolor">+<%=b.getCommentTotalCnt() %></i>
					<%if(b.getNewIcon()==1){%><i class="xi-new"></i><%} %>
				<span class="visible-xs hidden-sm">
						<i class="xi-time" title="날짜"></i><%=b.getBoardDate() %>
						<i class="xi-user" title="작성자"></i><%=b.getBoardWriter() %>		
				</span>
																										
				</td>																																												
				<td class="author hidden-xs"><%=b.getBoardWriter() %></td>
				<td class="date hidden-xs"><%=b.getBoardDate() %></td>																												
				<td class="reading hidden-xs"><%=b.getBoardReadCount() %></td>
			</tr>
			<%} %>
																																
	</table>
</div>	

<div class="paging">
	<ul class="pagination">	
		<%=pageBar %>	
		<%if(memberLoggedIn!=null){%>
			<%if(!bn.equals("newsboard")){%>
			<div class="float_right">
				<button class="btn xet_btn newsky medium sky" onclick="location.href='<%=request.getContextPath()%>/board/writeForm?bn=<%=bn%>&cPage=<%=cPage%>'">
				<i class="xi-pen"></i>쓰기</button>
			</div>	
			
			
			<!-- 운영자만 글쓰기 가능 -->
			<%}
			 if(bn.equals("newsboard")&&memberLoggedIn.getUserId().equals("admin"))
			 {%>
				<div class="float_right">
				<button class="btn xet_btn newsky medium sky" onclick="location.href='<%=request.getContextPath()%>/board/writeForm?bn=<%=bn%>&cPage=<%=cPage%>'">
				<i class="xi-pen"></i>쓰기</button>
				</div>	
				 
			 <%}
			
		}%>		
	</ul>	
</div>


<div class="boardNavigation">	
	
	<div class="boardSearch">
		 <form action="<%=request.getContextPath()%>/index.jsp" method="get" onsubmit="return procFilter(this, search)" id="fo_search" class="boardSearchForm" ><input type="hidden" name="act" value="" />
			<input type="hidden" name="vid" value="" />
			<input type="hidden" name="mid" value="simple_board_list" />
			<input type="hidden" name="category" value="" /> 
			<div class="boardSearch">
				<span class="l-r3">
					<select name="search_target">
						<option value="title">제목</option>
						<option value="content">내용</option>
						<option value="user_id">작성자</option>						
					</select>
				</span>					
				<input type="text" name="search_keyword" value="" title="검색" class="inputText" accesskey="S" placeholder="검색" />		
				<span class="search_btn_wrp r-r3">
					<button onclick="fn_event1()" class="search_btn light"><i class="xi-magnifier"></i><span class="hidden-xs"> 검색</span></button>
				</span>
			</div>
		 </form>	 
	</div>	
	
	</div>
</div> 

</div></div></div>

<%@ include file="/views/common/footer.jsp"%>