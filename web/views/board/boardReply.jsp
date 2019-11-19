<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.skygym.board.model.vo.*,java.util.*" %>
<%@ include file="/views/common/header.jsp"%>
<%@ include file="/views/common/subMenu.jsp" %>
<%
String bn = (String)request.getAttribute("bn");
int cPage = (int)request.getAttribute("cPage");
int boardNo = (int)request.getAttribute("boardNo");
BoardComment bc = (BoardComment)request.getAttribute("bc");
%>

<div class="container">
		<div class="board-header skycolor">		
				<h2 class="mt-4 mb-3">
			        <strong>댓글 달기</strong>
			     </h2>		
		</div>	
<button type="button" onclick="location.href='<%=request.getContextPath()%>/board/contentView?no=<%=boardNo%>&cPage=<%=cPage%>&bn=<%=bn %>#comment'"  class="btn xet_btn newsky medium sky">
<i class="xi-arrow-left"></i> 취소
</button>
	
<div class="feedbackList" id="comment" style="background : white;">
	<div class="replyList">
	    <div class="item">
			<div class="itemAside">
				<img src="<%=request.getContextPath()%>/img/guest.gif" alt="profile" class="profile r50" />							</div>
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
				<div class="comment_160495_105 xe_content">
					<%=bc.getBoardCommentContent() %>
				</div>
	    </div>
	</div>
	</div>
	
	<div class="boardWrite commentEditor r5">
		<form action="<%=request.getContextPath()%>/board/boardCommentInsert" method="post" name='boardCommentFrm'>
			<div class="editorOption">
				<div class="write_type xet_clearfix">					
					<div class="input_form">
					<input type="hidden" name="boardRef" value="<%=boardNo%>"/><!-- 위에 게시판의 번호 -->
					<input type="hidden" name="boardCommentWriter" value="<%=memberLoggedIn.getUserId() %>"/>
					<input type="hidden" name="boardCommentLevel" value="2"/>
					<input type="hidden" name="boardCommentRef" value="<%=bc.getBoardCommentNo()%>"/><!-- 댓글의 번호 -->
					<input type="hidden" name="cPage" value="<%=cPage %>"/>
					<input type="hidden" name="bn" value="<%=bn %>"/>
				</div>	
			<div class="comment_box">				
				<div id="" class="input_area">					
					<table width=100%>
					<tr>
						<td >
							<textarea name="boardCommentContent" cols="80" rows="30" placeholder="댓글 내용을 입력하세요"></textarea>							
						</td>						
					</tr>
					</table>	
				</div>						
			</div>
		</div>
			<div class="boardNavigation">
				<button type="submit" class="btn xet_btn large sky" style="width:100%"><i class="xi-message"></i> 댓글의 댓글 등록</button>
			</div>
		</div>
	</form>
			
	
		</div>
	</div>
</div>	
</div>
</div>

<%@ include file="/views/common/footer.jsp"%>