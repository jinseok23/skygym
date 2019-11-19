<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import='java.util.*,com.skygym.findgym.model.vo.GYM'%>
<%@ include file="/views/common/header.jsp"%>
<link href="<%=request.getContextPath()%>/css/spacecss.css" rel="stylesheet"> 
<link href="<%=request.getContextPath()%>/vendor/jquery/paging.js" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="http://cdn.jsdelivr.net/xeicon/1.0.4/xeicon.min.css" />

<%
	List<GYM> list = (List)request.getAttribute("list");
	int cPage = (int)request.getAttribute("cPage");
	String pageBar = (String)request.getAttribute("pageBar");
	Member m = (Member)request.getAttribute("member");
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
	

	/* 기타 스타일설정 */
	.inner , .box , .box_space , ._space
	{
		display: inline-block;
		width : 350px; height : 350px;
	}
	background-image
	{
	  height: 100%;
  	  width: 100%;
	}
	span:hover
	{
		transform:scale(1.1);
	}
	
</style>
<div class="carousel-item active" style="height:50%; background-image: url('<%=request.getContextPath()%>/img/recommendImg.jpg')">
   <div class="carousel-caption d-none d-md-block">
     <h2>추천GYM</h2>
     <p>gym matching service</p>
     <%if(memberLoggedIn!=null) 
  {		%>
  <p style='font-size: 17px;'><%=memberLoggedIn.getUserName()%>님의 정보를 바탕으로 체육관을 매칭한 결과입니다.</p>
  <% }
  else
  { %>
  	<p style='font-size: 17px;'> 회원가입 후 로그인하시면 회원님께 꼭 맞는 gym을 매칭해드립니다.</p>
<% }  %>  </p>
     <%-- <h2 class="mt-4 mb-3"><strong>- <%=bt %></strong></h2>	 --%>
   </div>
 </div>
<br><br>
<div class="container">

  
  
			<%for(GYM g : list) 
		  {%>

  	<article class="box box_space _space" >
		<div class="inner" style="width :300px; height : 300px; " >
		<a href="<%=request.getContextPath() %>/detail/detailView?GYMNumber=<%= g.getGYMNumber() %>" class="_innerLink nclk" style="text-decoration: none; color:#0d2240;">
			<div class="img_box">
						<span style="background-image: url(<%=request.getContextPath()%><%=g.getMainImage() %>);" class="img lazy" title="세부정보 보기"></span>
				</div>
				<div class="info_area">
					<h5 class="tit_space"> <%=g.getGYMbranchName() %> </h5> 
					 
					<div class="tags">
						<span class='tag_area_name'> <%=g.getGYMdistrict() %></span>
						<span ><%=g.getGYMCategory() %></span>
						<span><i class="xi-tags" style='font-size: 13px;'><%=g.getGYMAddress() %></i></span>
					</div>
					<br><br>
					<div class="tel" style="color: #3395E8;">
 						<strong class='price'> <i class="xi-phone"></i> <%=g.getGYMtel()%></strong><span class='txt_unit'></span>
					</div>
				</div>
			</a>
		</div>
	</article>
			 <%} %>
	   
	   
	<div class="paging">
   <ul class="pagination">   
      <%=pageBar %>   
   </ul>   
</div>	
</div>

<br>

</div>
			
<%@ include file="/views/common/footer.jsp"%>