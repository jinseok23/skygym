<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import='java.util.*,com.skygym.findgym.model.vo.GYM'%>
<%@ include file="/views/common/header.jsp"%>
<link href="<%=request.getContextPath()%>/css/spacecss.css" rel="stylesheet"> 
<link href="https://fonts.googleapis.com/css?family=Poor+Story" rel="stylesheet">
<link rel="stylesheet" href="http://cdn.jsdelivr.net/xeicon/1.0.4/xeicon.min.css" />
 
<%
	List<GYM> list = (List)request.getAttribute("list");
	int cPage = (int)request.getAttribute("cPage");
	String pageBar = (String)request.getAttribute("pageBar");
%>
<style>
	

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


	.inner , .box , .box_space , ._space
	{
		display: inline-block;
		width : 350px; height : 350px;
		font-size: 14px;
	}
	
	background-image
	{
	  max-height: 100%;
  	  smax-width: 100%;
	}
	span:hover
	{
		transform:scale(1.1);
		font-size: 14px;
	}
	
</style>

<script>

	$(function()
	{
		$('#btnAll').click(function()
		{
					
			location.href="<%=request.getContextPath()%>/find/findGYM";
		});
		$('#btnSeoul').click(function()
		{
			
			location.href="<%=request.getContextPath()%>/find/findGYMDistrict?city=서울";
		});
		$('#btnGyeonggi').click(function(){
			location.href="<%=request.getContextPath()%>/find/findGYMDistrict?city=경기도";
		});
	});
	
</script>
<div class="carousel-item active" style="height:50%; background-image: url('<%=request.getContextPath()%>/img/recommendImg.jpg')">
   <div class="carousel-caption d-none d-md-block">
     <h2>제휴 지점찾기</h2>
     <p>find a gym</p>
  	<p style='font-size: 17px;'> 원하는 지역의 원하는  체육관을 찾을 수 있습니다</p>
   </div>
 </div>
<br><br>
<div class="container">
  <br>
  
 <form action="<%=request.getContextPath()%>/find/findGYM" name="findGym" method="post" onsubmit="return fn_submit()">
	<div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups" align="center">
	    <div class="btn-group mr-2" role="group" aria-label="First group">
			<button type="button" class="btn btn-primary" id='btnAll'> 전체보기 </button> &nbsp;
			<button type="button" class="btn btn-primary" id='btnSeoul'> 서울 </button> &nbsp;
			<button type="button" class="btn btn-primary" id='btnGyeonggi'> 경기 </button> &nbsp;
	    </div>
	</div>
</form>
<br><br>

<div align="center" id='findGYM'>
  <table class="table table-hover" style='font-size: 14px;'>
  	<tr>
			<th> 지역 </th>
			<th> 지점명 </th>
			<th> 주소 </th>
			<th> 전화번호 </th>
			<th> 상세 페이지 </th>
	</tr>
			<%for(GYM g : list) 
			  { %>
		  	<tr>
		  		<td><%= g.getGYMdistrict() %></td>
		  		<td><%=g.getGYMbranchName() %></td>
		  		<td><%=g.getGYMAddress()%></td>
		  		<td><%=g.getGYMtel()%></td>
		  		<td><input id='detailView' name='detailView' class='btn-secondary' type='button' onclick='location.href="<%=request.getContextPath() %>/detail/detailView?GYMNumber=<%= g.getGYMNumber() %>"' value='상세보기'></td>
		  	</tr>
		 <%   } %>
	
	</table>

</div>
 
	 <div class="paging">
   <ul class="pagination">   
      <%=pageBar%>   
   </ul>   
	 </div>
</div>

<%@ include file="/views/common/footer.jsp"%>