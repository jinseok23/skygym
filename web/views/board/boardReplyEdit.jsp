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
			        <strong>댓글 수정하기</strong>
			     </h2>			
		</div>	
<button type="button" onclick="location.href='<%=request.getContextPath()%>/board/contentView?no=<%=boardNo%>&cPage=<%=cPage%>&bn=<%=bn %>#comment'"  class="btn xet_btn medium sky"><i class="xi-arrow-left"></i> 취소</button>
	<hr>
		<div class="boardWrite commentEditor r5" style="background : white;">
		<form action="<%=request.getContextPath()%>/board/bcuEnd" method="post" name='boardCommentFrm'>
			<div class="editorOption">
				<div class="write_type xet_clearfix">					
					<div class="input_form">
					<input type="text" name="writer" class="inputText userName" value="<%=bc.getBoardCommentWriter() %>" disabled/></div>
					<input type="hidden" name="boardCommentWriter" value="<%=bc.getBoardCommentWriter() %>"/>
					<input type="hidden" name="boardNo" value="<%=boardNo%>"/>
					<input type="hidden" name="cPage" value="<%=cPage%>"/>
					<input type="hidden" name="bn" value="<%=bn%>"/>
					<input type="hidden" name="boardCommentNo" value="<%=bc.getBoardCommentNo() %>"/>
				</div>	
			<div class="comment_box">				
				<div id="" class="input_area">					
					<table width=100%>
					<tr>
						<td >
							<textarea name="boardCommentContent" cols="80" rows="30" placeholder="수정할 내용을 입력하세요."><%=bc.getBoardCommentContent() %></textarea>							
						</td>						
					</tr>
					</table>	
				</div>						
			</div>
		</div>
			<div class="boardNavigation">
				<button type="submit" class="btn xet_btn large sky" style="width:100%"><i class="xi-eraser"></i> 수정 완료</button>
			</div>
		</div>
	</form>
	</div>
</div>				
			</div>

<%@ include file="/views/common/footer.jsp"%>