<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@
	page import="com.skygym.findgym.model.vo.GYM, java.util.*,
				com.skygym.detailview.model.vo.GYMImage,
				com.skygym.detailview.model.vo.Trainer,
				com.skygym.detailview.model.vo.GYMReply,
				com.skygym.member.model.vo.Member"
 %>	
<%
	List<GYMReply> commentList=(List)request.getAttribute("list");

	Member memberLoggedIn=(Member)session.getAttribute("memberLoggedIn");
%>

<%if(commentList!=null) 
		{
			%>
		<%
			for(GYMReply gr:commentList)
			{
				if(gr.getReplyLevel()==1)
				{
			%>
			<tr class="level1">
				<td style="height:150px;">
					<sub class="userId"><%=gr.getUserId() %></sub>
					<sub class="reply_date"><%=gr.getReply_date() %></sub>
					<sub class="GYMScore">
					<%String temp1 = "";
					switch(gr.getGYMScore()){
					case 1 : temp1 = "/img/star1.png"; break;
					case 2 : temp1 = "/img/star2.png"; break;
					case 3 : temp1 = "/img/star3.png"; break;
					case 4 : temp1 = "/img/star4.png"; break;
					case 5 : temp1 = "/img/star5.png"; break;
				} %>
						<img src="<%=request.getContextPath()%><%=temp1 %>" style="width:80px;"/>
					</sub>
					<br/><br/><br>
						<p id='re-comment'><%=gr.getReply_content() %></p>
				<%
				if(memberLoggedIn!=null)
				{
					if(gr.getUserId().equals(memberLoggedIn.getUserId())||"admin".equals(memberLoggedIn.getUserId()))
					{ %>	
					<div class='alterbtn'>
						
						<form name='deleteComment' action='<%=request.getContextPath() %>/detail/deleteComment' accept-charset="UTF-8" method="post">
								<input type='hidden' id='replyNumber' name='replyNumber' value='<%=gr.getReplyNumber() %>'>
								<input type='hidden' name='GYMNumber' value=<%=gr.getGYMNumber() %>>
						   		<input type='hidden' name='userId' value='<%=gr.getUserId() %>'>
						   		<input type='hidden' name='replyLevel' value='<%=gr.getReplyLevel() %>'>
						   		<input type='hidden' id='re-content1' name='re-content1' value='<%=gr.getReply_content() %>'>
								<button id='btn-delete' onclick='fn_delete()' name='deleteComment'>삭제</button>
						</form>								
								<button class='btn-cancel' type='button' style='display:none;'>취소</button>
								<button class='btn-updatecon' type='button' style='display:none;' value='<%=gr.getReplyNumber() %>'>수정완료</button>
								<button class='btn-update' type='button' name='updateComment'>수정</button>
					</div>
					<%}
					}%>
				</td>
			</tr>
				<%}
			} // for문 닫기 // if문 닫기
		}%>