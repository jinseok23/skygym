<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.skygym.member.model.vo.Member" %>
<%
	ArrayList<Member> list=(ArrayList)request.getAttribute("list");
	String searchType="";
	String searchKeyword="";
	if(request.getAttribute("searchType")!=null)
	{
		searchType=(String)request.getAttribute("searchType");
	}
	if(request.getAttribute("searchKeyword")!=null)
	{
		searchKeyword=(String)request.getAttribute("searchKeyword");	
	}
	//페이지 처리 변수들
	String pageBar = (String)request.getAttribute("pageBar");
	int cPage=(int)request.getAttribute("cPage");
	int numPerPage=(int)request.getAttribute("numPerPage");
	String idCheck="";
	String nameCheck="";
	if(searchType.equals("userId"))
	{
		idCheck="selected";
	}
	if(searchType.equals("userName"))
	{
		nameCheck="selected";
	}
%>

<%@ include file="/views/common/header.jsp"%>
<style>
	table#view-tbl
	{
		width:1150px;
	}
	div#search-container 
	{

		width:550px;
		padding: 3px;
	}
	div#search-userName
	{
		display:none;
	}
	div#search-userId{display:inline-block;}
	div#member-all{display:inline-block;}
	div#search-container
	{
		margin:0 0 10px 0; padding:3px; float:left;
	}


	tbody tr:hover{background-color:#DDE7F4;}

	 
		/* 페이징 */
	.pagination { 
	   list-style: none;
	   padding: 0;
	   margin: 15px 0 0;
	   text-align: center;
	   display: block;
	    font-size: 0;
	    position: relative;
	    vertical-align: middle;
	}
	.pagination > li {
	   display: inline-block;
	   margin: 0;
	   padding: 0;
	}
	.pagination > li:first-child > a {
	    border-bottom-left-radius: 3px;
	    border-top-left-radius: 3px;
	    margin-left: 0;
	}
	.pagination > li:last-child > a {
	    border-bottom-right-radius: 3px;
	    border-top-right-radius: 3px;
	}
	.pagination > li + li {
	    margin-left: -1px;
	}
	.pagination img { 
	   border:0;
	}
	.pagination a,
	.pagination strong { 
	   position:relative;
	   display:inline-block;
	   text-decoration:none;
	   margin:0;
	   padding:0;
	   font-size: 12px;
	   width:30px;
	   height:30px;
	   line-height: 28px;
	   vertical-align:middle;
	   white-space: nowrap;
	   text-align:center;    
	   border: 1px solid #e1e1e1;
	}
	.pagination a { 
	   background: #fff;
	   color:#555;
	}
	.pagination .page_on {
	   font-weight:bold; 
	   background-color: #3395E8;
	   border-color: #3395E8;
	   color: #fff !important;
	}
	.pagination .page_mobile {
	   width: 100px;
	}
	.pagination .prevEnd span,
	.pagination .nextEnd span { 
	   visibility:hidden; 
	   font-size:0; 
	}
	.pagination .prevEnd,
	.pagination .nextEnd { 
	   font-size: 14px;
	}	/* 페이징 처리 끝  */
</style>
<script>
	$(function() {
		var sid = document.querySelector("#search-userId");
		var sname = document.querySelector('#search-userName');
		$('#searchType').change(function() {
			sid.style.display = 'none';
			sname.style.display = 'none';
			$('#search-' + this.value).css("display", "inline-block");
		});
		$('#numPerPage').change(function() {
			document.numPerPageFrm.submit();
		});
	});
</script>
<div class="container">
	<br><br>
	<h2>회원관리</h2>
	<hr>
	<div id="search-container">
		<select id='searchType'>
			<option value="userId" <%=idCheck%>>아이디</option>
			<option value="userName" <%=nameCheck%>>회원명</option>
		</select>
		<div id='search-userId'>
			<form action="<%=request.getContextPath()%>/memberFinder">
				<input type="hidden" name="searchType" value="userId" />
				<input type="text" name='searchKeyword' size='25' value="<%=searchKeyword%>" />
				<input type="hidden" name="cPage" value="<%=cPage=1%>" />
				<button type='submit'>검색</button>
			</form>
		</div>
		<div id='search-userName'>
			<form action="<%=request.getContextPath()%>/memberFinder">
				<input type="hidden" name="searchType" value="userName" />
				<input type="text" name='searchKeyword' size='25' value="<%=searchKeyword%>" />
				<input type="hidden" name="cPage" value="<%=cPage=1%>" />
				<button type='submit' class="btn xet_btn sky medium">검색</button>
			</form>
		</div>
		
		<div id='member-all'>
			<form action="<%=request.getContextPath()%>/admin/memberList">
				<button type='submit'>전체회원</button>
			</form>
		</div>
	</div>
	<table id='view-tbl' class="table table-sm" style="background: white;">
		<thead>
			<tr >
				<th scope="col">아이디</th>
				<th scope="col">이름</th>
				<th scope="col">생년월일</th>
				<th scope="col">이메일</th>
				<th scope="col">전화번호</th>
				<th scope="col">주소</th>
				<th scope="col">가입날짜</th>
			</tr>
		</thead>
		<tbody>
			<%if (list.size()==0) {%>
			<tr>
				<td colspan='9' style="text-align:center;">검색결과가 없습니다.</td>
			</tr>
			<%}
			else {
				for (Member m : list) {%>
			<tr>
				<td>
					<a href="<%=request.getContextPath()%>/memberFind?userId=<%=m.getUserId()%>">
						<%if (searchType.equals("userId")) {%>
							<%String markId = m.getUserId().replace(searchKeyword,"<mark style='color:white; background:#0d2240; font-weight:800;'>" + searchKeyword + "</mark>");%>
							<%=markId%>
						<%} 
						else {%>
							<%=m.getUserId()%>
						<%}%>
					</a>
				</td>
				<td>
					<%if (searchType.equals("userName")) {%>
						<%String markName = m.getUserName().replace(searchKeyword,"<mark style='color:white; background:#0d2240; font-weight:800;'>" + searchKeyword + "</mark>"); %>
						<%=markName%>
					<%} 
					else {%>
						<%=m.getUserName()%>
					<%}%>
				</td>
				<td><%=m.getResidentNum()%></td>
				<td><%=m.getEmail()%></td>
				<td><%=m.getPhone()%></td>
				<td><%=m.getAddress()%></td>
				<td><%=m.getEnrolldate()%></td>
			</tr>
			<%	} //for문 닫기
			} //else문 닫기%>
		</tbody>
	</table>
	<div class="paging">
   		<ul class="pagination">   
      		<%=pageBar %>   
   		</ul>   
	</div>	
	
</div>
<%@ include file="/views/common/footer.jsp"%>