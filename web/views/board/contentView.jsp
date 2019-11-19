<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.skygym.board.model.vo.*,java.util.*" %> 
<%@ include file="/views/common/header.jsp"%>
<%@ include file="/views/common/subMenu.jsp" %>
<%
	int boardNo =(int)request.getAttribute("boardNo"); 
	Board board=(Board)request.getAttribute("board");
	int addHits = (int)request.getAttribute("addHits");
	int cPage = Integer.parseInt(request.getParameter("cPage"));
	String bn = request.getParameter("bn");
	List<BoardComment> commentList=(List)request.getAttribute("list");
	
 /* 	String bt ="";
	switch(bn){
	case "newsboard" :
	bt="SkyGym 소식"; break;
	case "freeboard" :
	bt="자유게시판"; break;
	case "partnerboard" :
	bt="제휴문의"; break;
	case "qnaboard" :
	bt="QnA게시판"; break;
	default : 
	bt="게시판";
	} */

%>
<script>

function fn_deleteBoard()
{
	var bool = confirm("정말 삭제하시겠습니까?");
	if(bool){
		
	}
	else{
		alert("취소되었습니다.");
		event.preventDefault();
	}
}

</script>
<style>
.boardReadFooter {
	padding-bottom: 15px;
	border-bottom: 1px solid #cccdcf;
}
/* 이전,다음 게시물 보기
-------------------------------------------------------------------------------------------------------- */
.next_nav {
	list-style:none;
	margin:0;
	padding:10px 0;
	border-bottom:1px solid #cccdcf; 
	color:#555;
}
.next_nav:after {
	content:""; clear:both; display:block;
}
.next_nav li {
	float:left;
	width:50%;
	text-align:right;
	margin:0;
	padding:0;
}
.next_nav li:first-child {
	text-align:left;
}
.next_nav li a {
	display:inline-block;
	color:#555;
}

	/* colorset - board_dark */
	#xet_board.black .next_nav { 
		border-color:#333;
		color:#ccc;
	}
	#xet_board.black .next_nav li a {
		color:#ccc;
	}
	

</style>
<div class="container">
<%-- 		<div class="board-header skycolor">		
				<h2 class="mt-4 mb-3">
			        <strong><%=bt %></strong>
			     </h2>	
		</div>	 --%>
				
	<div id="boardview">
	<table class="boardview_table"  style="background : white;">
		<tr>
			<th class="bv_top bv_header">				
					<div class="titleArea">
					<strong><%=board.getBoardTitle() %></strong>						
					</div>
					<div class="title_info">
						<div class="float_left">
							<span>
								<i class="xi-user" title="작성자"></i>
									<strong><%=board.getBoardWriter() %></strong>	
							</span>
							<span>
								<i class="xi-time" title="등록일"></i>
									<strong><%=board.getBoardTime() %></strong>
							</span>
						</div>
						<div class="float_right">
							<span>
								<i class="xi-comments" title="댓글"></i>
									<strong><%=board.getCommentTotalCnt() %></strong>
							</span>
							<span>
								<i class="xi-eye" title="조회 수"></i> 
									<strong><%=board.getBoardReadCount()+addHits %></strong>
							</span>
						</div>
				</div>				
			</th>
		</tr>
		<tr>
			<td class="bv_view">
			<%=board.getBoardContent() %>			
			</td>
		</tr>
	</table>
	
	<!-- 보드 네비 세션처리 -->			
		<div class="boardNavigation">
	        <div class="float_left">
				<a href="<%=request.getContextPath()%>/board/boardList?bn=<%=bn%>&cPage=<%=cPage%>" class="btn xet_btn medium sky">
				<i class="xi-list-ul-l"></i> 목록으로</a>
			</div>	
			<%
				if(memberLoggedIn!=null)
				{
					if(board.getBoardWriter().equals(memberLoggedIn.getUserId())||"admin".equals(memberLoggedIn.getUserId()))
					{ %>	
			<div class="float_right">
			<a href="<%=request.getContextPath()%>/board/boardEdit?bn=<%=bn%>&no=<%=boardNo%>&cP=<%=cPage%>" class="btn xet_btn medium sky">
				<span><i class="xi-eraser"></i>수정</span></a>
			<a href="<%=request.getContextPath()%>/board/boardDelete?bn=<%=bn%>&no=<%=boardNo%>&cP=<%=cPage%>" onclick="fn_deleteBoard()" class="btn xet_btn medium sky">
				<span><i class="xi-trash"></i>삭제</span></a>
			</div>
			<%}
				}%>
		</div>			
		
	</div> 
    <div>	
	<div class="feedbackList" id="comment"  style="background : white;">

	<h3 class="feedbackHeader">
		<i class="xi-comments" title="댓글"></i> 댓글이 <em>'<%=board.getCommentTotalCnt()%>'</em>개 달렸습니다.
	</h3>	
	<%if(commentList!=null){
				for(BoardComment bc:commentList) 
				{
					if(bc.getBoardCommentLevel()==1)
					{
				%>	
	<div class="replyList">
			<div class="item " id="comment_160495">
			<div class="indent">			
				<div class="itemAside">
				<%if(bc.getBoardCommentWriter().equals("admin")){%>
				<img src="<%=request.getContextPath()%>/img/admin.png" alt="profile" class="profile r50" />   
				<%}else{ %>
					<img src="<%=request.getContextPath()%>/img/guest.gif" alt="profile" class="profile r50" />									
				<%}%>
				</div>
				<div class="itemContent">
							<p class="meta">
							<span>
								<i class="xi-user" title="작성자"></i> 
								<%=bc.getBoardCommentWriter() %>							
							</span>
							<span>
								<i class="xi-time" title="등록일"></i>
								 <%=bc.getBoardCommentTime() %>
							</span>														
							</p>
						<!-- // 댓글 출력 -->						
						<div class="comment_160495_105 xe_content">
						 <%= bc.getBoardCommentContent()%>
						</div>															
						<ul class="option">
							<% if(memberLoggedIn!=null)
							{ %>
							<li>
								<a href="<%=request.getContextPath()%>/board/brp?bn=<%=bn%>&bcn=<%=bc.getBoardCommentNo()%>&no=<%=boardNo%>&cPage=<%=cPage%>#comment" class="xet_btn small">
									<span>
										<i class="xi-reply"></i>댓글
									</span>
								</a>
							</li>
							<!-- 세션처리 -->
							<% if(bc.getBoardCommentWriter().equals(memberLoggedIn.getUserId())||"admin".equals(memberLoggedIn.getUserId()))
							{ %>							
							<li><a href="<%=request.getContextPath()%>/board/bcu?bn=<%=bn%>&bcn=<%=bc.getBoardCommentNo()%>&no=<%=boardNo%>&cPage=<%=cPage%>#content" class="xet_btn small"><span><i class="xi-eraser"></i> 수정</span></a></li>
							<li><a href="<%=request.getContextPath()%>/board/bcd?bn=<%=bn%>&bcn=<%=bc.getBoardCommentNo()%>&no=<%=boardNo%>&cPage=<%=cPage%>" class="xet_btn small" onclick="fn_deleteBoard()"><span><i class="xi-trash"></i> 삭제</span></a></li>
						 	<%
						 	}
						}%>								
							</ul>		
					</div>
			</div>
		</div>
		<% }	
			else if(bc.getBoardCommentLevel()==2)
			{ %>
			<div class="item itemReply" id="comment_160522">
			<div class="indent" style="margin-left:5px">			
				<div class="itemAside">
				<%if(bc.getBoardCommentWriter().equals("admin")){%>
				<img src="<%=request.getContextPath()%>/img/admin.png" alt="profile" class="profile r50" />   
				<%}else{ %>
					<img src="<%=request.getContextPath()%>/img/guest.gif" alt="profile" class="profile r50" />									
				<%}%>
				</div>
				<div class="itemContent">
							<p class="meta">
							<span>
								<i class="xi-user" title="작성자"></i> 
								<%=bc.getBoardCommentWriter()%>
							</span>
							<span>
								<i class="xi-time" title="등록일"></i>
								<%=bc.getBoardCommentTime()%>
							</span>
							</p>
						<div class="comment_160522_160278 xe_content">
						<%= bc.getBoardCommentContent()%>
						</div>
						<ul class="option">
						<% if(memberLoggedIn!=null)
						{%>
							<li>
								<a href="<%=request.getContextPath()%>/board/boardReply?bn=<%=bn%>&bcn=<%=bc.getBoardCommentNo()%>&no=<%=boardNo%>&cPage=<%=cPage%>#comment" class="xet_btn small">
									<span>
										<i class="xi-reply"></i> 댓글
									</span>
								</a>
							</li>
							<!-- 세션처리 -->
							<%if(bc.getBoardCommentWriter().equals(memberLoggedIn.getUserId())||"admin".equals(memberLoggedIn.getUserId()))
									{ %>							
							<li><a href="<%=request.getContextPath()%>/board/bcu?bn=<%=bn%>&bcn=<%=bc.getBoardCommentNo()%>&no=<%=boardNo%>&cPage=<%=cPage%>" class="xet_btn small"><span><i class="xi-eraser"></i> 수정</span></a></li>
							<li><a href="<%=request.getContextPath()%>/board/bcd?bn=<%=bn%>&bcn=<%=bc.getBoardCommentNo()%>&no=<%=boardNo%>&cPage=<%=cPage%>" class="xet_btn small" onclick="fn_deleteBoard()"><span><i class="xi-trash"></i> 삭제</span></a></li>
						 	<%	}
								}%>	
						</ul>	
				</div>
			</div>
		</div>			
			<%
			}
	}
}
	%>	
	</div>
	</div>
	<% if(memberLoggedIn!=null)
	{ %>
	<div class="boardWrite commentEditor r5" style="background : white;">
		<form action="<%=request.getContextPath()%>/board/boardCommentInsert" method="post" name='boardCommentFrm'>
			<div class="editorOption">
				<div class="write_type xet_clearfix">					
					<div class="input_form">
					<input type="text" name="writer" class="inputText userName" value="<%=memberLoggedIn.getUserId() %>" disabled/></div>
					<input type="hidden" name="boardRef" value="<%=board.getBoardNo()%>"/><!-- 게시판번호 -->
					<input type="hidden" name="boardCommentWriter" value="<%=memberLoggedIn.getUserId() %>"/><!-- 세션아이디 -->
					<input type="hidden" name="boardCommentLevel" value="1"/>
					<input type="hidden" name="boardCommentRef" value="0"/><!-- 참조 번호 -->
					<input type="hidden" name="cPage" value="<%=cPage %>"/>
					<input type="hidden" name="bn" value="<%=bn %>"/>
				</div>	
			<div class="comment_box">				
				<div id="" class="input_area">					
					<table width=100%>
					<tr>
						<td >
							<textarea name="boardCommentContent"  class="resizenone" cols="80" rows="30" placeholder="내용을 입력하세요."></textarea>							
						</td>						
					</tr>
					</table>	
				</div>						
			</div>
		</div>
			<div class="boardNavigation">
				<button type="submit" class="btn xet_btn large sky" style="width:100%"><i class="xi-message"></i> 댓글 등록</button>
			</div>
		</div>
	</form>
	<%
	}
	%>
	
		</div>
	</div>
	</div>
	</div>
	</div></div></div></div></div></div>

<%@ include file="/views/common/footer.jsp"%>