<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.skygym.board.model.vo.*,java.util.*" %> 
<%@ include file="/views/common/header.jsp"%>
<%@ include file="/views/common/subMenu.jsp" %>
<%
int boardNo =(int)request.getAttribute("boardNo"); 
Board board=(Board)request.getAttribute("board");
int cPage = (int)request.getAttribute("cPage");
String bn = (String)request.getAttribute("bn");

%>
<script src="http://js.nicedit.com/nicEdit-latest.js" type="text/javascript"></script>
<script type="text/javascript">bkLib.onDomLoaded(nicEditors.allTextAreas);</script>
<div class="container">
		<div class="board-header skycolor">		
				<h2 class="mt-4 mb-3">
			        <strong>글 수정하기</strong>
			     </h2>		
		</div>
		
<form action="<%=request.getContextPath()%>/board/boardEditEnd" method="post">	
 	<input type="hidden" name="bn" value="<%=bn%>">
 	<input type="hidden" name="cPage" value="<%=cPage %>"/>
 	<input type="hidden" name="boardNo" value="<%=boardNo%>"/>
 	
 	
<div id="boardwrite" style="background :white;">
	<table class="boardwrite_table">
		<colgroup>
			<col style="width:15%"/>
			<col style=""/>
		</colgroup>
			<tr>
				<th>작성자</th>
				 <td><input type="text" name="writer" class="bowrite_in" readonly value=<%=board.getBoardWriter() %> style="width:35%;"/></td> 
			</tr>			
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" value="<%=board.getBoardTitle()%>" class="bowrite_in" style="width:95%;" required />
						
				</td>
			</tr>		
		 <tr>
			<th>비밀글</th>
			<%if(bn.equals("qnaboard")||bn.equals("partnerboard")){%>
			<td>			
				<input type="radio" name="invisible" value="yes" checked class="chk" /> Yes&nbsp;&nbsp;
				<input type="radio" name="invisible" value="no" class="chk" disabled/> No
			</td>
			<%}
			else{%>
			<td>			
				<input type="radio" name="invisible" value="yes"  class="chk" /> Yes&nbsp;&nbsp;
				<input type="radio" name="invisible" value="no" checked class="chk" /> No
			</td>
		 <%} %>		 
		</tr>
		<%if(bn.equals("qnaboard")){%>
			<tr>			
 			<th>카테고리</td>
			<td>
				<select name="category">
				<option value="이용문의">이용문의</option>								
				<option value="지점문의">지점문의</option>
				<option value="결제문의">결제문의</option>
				<option value="기타문의">기타문의</option>
				</select>
			</td> 
			</tr>
			<%} %>
			<tr>
			<th>내용</th>
			<td>			
			<textarea name="content" id="board_content" style="width:100%;height:300px;">
			<%=board.getBoardContent()%>
			</textarea>			
			</td>
		</tr>
		</table>
		</div>
		<div class="boardNavigation">
	        <div class="float_left">
				<a href="<%=request.getContextPath()%>/board/boardList?bn=<%=bn%>&cPage=<%=cPage%>" class="btn xet_btn medium sky">
				<i class="xi-list-ul-l"></i> 목록으로</a>
			</div>		
			<div class="float_right">
			<button type="submit" onclick="return validate();" class="btn xet_btn medium sky"><i class="xi-eraser"></i>수정</button>
			<a href="<%=request.getContextPath()%>/board/boardList?no=<%=boardNo %>&cPage=<%=cPage%>&bn=<%=bn%>" class="btn xet_btn medium sky">
			<i class="xi-arrow-left"></i>취소</a>
			</div>
		</div>
		
		</div>
	</div>	
</div>

<script>
 	function validate()
 	{
 		var content=$("[name=board_content]").val();
 		var subject=$("[name=subject]").val();
 		if(content.trim().length==0){
 			alert("내용을 입력하세요.");
 			return false;
 		}
 		else if(subject.trim().length==0){
 			alert("제목을 입력하세요.");
 			return false; 			
 		}
 		return true;
 	}

  </script>




<%@ include file="/views/common/footer.jsp"%>