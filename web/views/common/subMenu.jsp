<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="<%=request.getContextPath()%>/css/board.css" rel="stylesheet"> 
<%
/* String bn = request.getParameter("bn"); */
String bnis = request.getParameter("bn");



String bt ="";
switch(bnis){
case "newsboard" :
bt="SkyGym 소식"; break;
case "freeboard" :
bt="자유게시판"; break;
case "partnerboard" :
bt="제휴문의 게시판"; break;
case "qnaboard" :
bt="Q&A 게시판"; break;
default : 
bt="게시판";
}
%>
<style>
/* 게시판 */ 
.boardlist_table {
	width:100%; 
	border-collapse:collapse; 
	border-top:3px solid #cccdcf;
	border-bottom: 1px solid #cccdcf;
	
}
.boardlist_table tr th {
	background:#f9f9f9;
	font-size:12px;
	font-weight:normal;
	color:#555454;
	padding:9px 0;
	border-bottom:1px solid #dedede;
	text-align:center;
	height:14px;
}


.boardlist_table tr td a{color:black; text-decoration:none;}
.boardlist_table tr td a:hover { color : #3395E8;}

.boardlist_table tr td {font-size:12px;color:#666;padding:10px 5px;border-bottom:1px solid #dedede;text-align:center;height:14px;}
.boardlist_table tr .bo2 {text-align:left;}
.boardlist_table .bo1, .boardlist_table .bo4, .boardlist_table .bo5 {
	font-size:11px;
	font-weight:normal;
	color:#969696;
}
.boardlist_table .noti .bo1 {
	font-size:11px;
	font-weight:bold;
	color:#ff8600;
}
.boardlist_table .noti .bo2 {font-weight:bold;}
.boardlist_table .noti .bo2 a {color:#333;}


header, footer, nav, aside, section, article {display:block;}
table {padding:0;border-spacing:0px;border:0;border-collapse:collapse;}


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
.pagination > li a,
.pagination > li strong { 
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
}

/* Board Navigation
-------------------------------------------------------------------------------------------------------- */
.boardNavigation { 
	margin-top: 20px;
	text-align:center;
	*zoom:1;
}
.boardNavigation:after { 
	content:"";
	display:block;
	clear:both;
}


/* Search 
-------------------------------------------------------------------------------------------------------- */
.boardSearch {
	text-align: center;
}
.boardSearchForm {
	margin: 0 0 15px;
	padding:0;
}
.boardSearchForm .boardSearch * {
	vertical-align: middle;
}
.boardSearchForm .boardSearch { 
	position:relative;
	line-height: 30px;
	font-size: 0;
}
.boardSearchForm .boardSearch span.l-r3 {
	display:inline-block;
	height: 32px;
	padding:0;
	border:1px solid #cccdcf; 
	border-right: 0;
	background:#fff; 
	color:#555;
}
.boardSearchForm .boardSearch span select {
	margin:4px;
	padding:0;
	border:0;
	font-size: 12px;
	background:none;
	color:#555;
}
.boardSearchForm .boardSearch .inputText { 	
	width: 160px;
	height: 32px; 
	font-size: 12px;
	padding:0 5px; 
	margin:0;
	color:#777;
	background: #fff;
	border: 1px solid #cccdcf;
	-webkit-border-radius: 0;
	-webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
}
.boardSearchForm .boardSearch .inputText:focus { 
	color: #333;
	background: #fff;
}
.boardSearchForm .boardSearch .search_btn_wrp {
	display: inline-block;
	border: 1px solid #cccdcf;
	border-left: 0;
	overflow: hidden;
}
.boardSearchForm .boardSearch .search_btn { 
	display:inline-block;
	width: 100%;
	font-size: 12px;
	height: 30px; 
	margin:0; 
	padding:0 15px; 
	cursor:pointer; 
	border: 0;
	color:#555;
}
.boardSearchForm .boardSearch .search_btn i {
	vertical-align: middle;
}

/*  */
#boardview {width:100%; }
#boardview .boardview_table {width:100%; border-bottom : 1px solid #cccdcf; border-top:3px solid #cccdcf;}
#boardview .boardview_table .bv_top {font-size:13px;text-align:left;padding:10px;background:#f9f9f9;border:0;border-bottom:1px solid #dedede; }
#boardview .boardview_table .bv_top p {font-weight:normal;color:#969696;font-size:11px;margin-top:3px;}
#boardview .boardview_table th {font-weight:bold;font-size:12px;text-align:center;background:#f9f9f9;border-top:1px solid #dedede;border-bottom:1px solid #dedede;padding:9px 5px 12px 5px;}
#boardview .boardview_table .view-sort {font-size:12px;text-align:left;border-top:1px solid #dedede;padding:9px 5px 9px 5px;min-height:200px;}
#boardview .boardview_table .bv_view {padding:10px;height:325px;vertical-align:top;letter-spacing: -0.5px;line-height: 20px;}

#boardview .boardview_comm {width:100%;margin-top:10px;border-top:2px solid #333;}
#boardview .boardview_comm th {text-align:left;font-size:12px;font-weight:normal;line-height:18px;border-bottom:1px solid #dedede;padding:9px 5px;}
#boardview .boardview_comm th strong {color:#ff8600;font-size:12px;}
#boardview .boardview_comm td {text-align:right;font-size:10px;border-bottom:1px solid #dedede;padding:9px 5px;font-family:tahoma;color:#939393;}
#boardview .boardview_comm td p {margin-top:3px;}
#boardview .boardview_comm td p a {text-transform:uppercase;}
#boardview .boardview_comm .boardview_comm_top {text-align:left;font-weight:bold;font-size:14px;padding:10px;color:#333;border:0 !important;}
#boardview .boardview_comm .boardview_comm_guest {
	text-align:left;
	font-size:12px;
	padding:0 0 5px 0;
	letter-spacing:-1px;
	color:#666;
	border:0 !important;
	/* font-family:; */
}
#boardview .boardview_comm .boardview_comm_write {width:85%;border:0 !important;padding:0 !important;}
#boardview .boardview_comm .boardview_comm_write textarea{width:100%;height:60px;border:1px solid #ddd;border-bottom:1px solid #aaa;}
#boardview .boardview_comm .boardview_comm_btn {width:15%;border:0 !important;padding:0 !important;}
#boardview .boardview_comm .boardview_comm_btn .boardview_comm_input {
	width:100%;
	font-weight:bold;
	font-size:14px;
	letter-spacing:-1px;
	display:block;
	padding:3px 10px 6px 10px;
	border:1px solid #ddd;
	border-right:1px solid #aaa;
	border-bottom:1px solid #aaa;
	height:62px;
	background: #ffffff; /* Old browsers */
	background: -moz-linear-gradient(top, #ffffff 0%, #e5e5e5 100%); /* FF3.6+ */
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#ffffff), color-stop(100%,#e5e5e5)); /* Chrome,Safari4+ */
	background: -webkit-linear-gradient(top, #ffffff 0%,#e5e5e5 100%); /* Chrome10+,Safari5.1+ */
	background: -o-linear-gradient(top, #ffffff 0%,#e5e5e5 100%); /* Opera 11.10+ */
	background: -ms-linear-gradient(top, #ffffff 0%,#e5e5e5 100%); /* IE10+ */
	background: linear-gradient(to bottom, #ffffff 0%,#e5e5e5 100%); /* W3C */
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffffff', endColorstr='#e5e5e5',GradientType=0 ); /* IE6-9 */
}
#boardview .boardview_comm .bo_reply {
	background:#333; padding:0 2px; font:9px tahoma; color:#fff;
}
/*  */
.bv_header .titleArea { 
	margin-bottom: 10px; 
	word-break:break-all; 
	text-align:left; 	
}

.bv_header .title_info {
	margin-bottom: 10px; 
	*zoom:1; 
	color: #777;
}
.bv_header .title_info:after { 
	content:""; display:block; clear:both; 
}
.bv_header .title_info span { 
	display: inline-block;
	margin: 0 5px 0 0;
}
.bv_header .title_info strong
{
	display:inline-block;
	font-weight: normal;
	color: #777;
}

.comment_box {border:1px solid #ddd;}
.CommentWriteTitle {border-top:1px solid #acacac; border-bottom:1px solid #acacac; padding:5px;   margin:0px; margin:8px 0px; font-size:12px; font-family:Tahoma,gulim;}
.CommentWriteTitle .ComentTitle1{font-weight:bold; color:red; font-size:11px;}
.CommentWriteTitle .ComentTitle2{color:#acacac; font-size:12px; font-weight:normal;}
.CommentWriteTitle img{vertical-align:middle;}
.input_area{padding:10px;border:1px solid #fff;background:#fafafa;zoom:1; }	
.input_area textarea{height:100px;padding:4px 0 0 6px;border:1px solid #d1d1d1;border-right:1px solid #e9e9e9;border-bottom:1px solid #e9e9e9;background:#fff;color:#666;font-size:12px;line-height:20px;vertical-align:top; width:99%; resize:none;}

/* comment
-------------------------------------------------------------------------------------------------------- */
.feedbackList { 
	position:relative;
	overflow:hidden;
	padding: 10px; 
	margin: 15px 0; 
	width : 100%;
	border-radius: 5px;
	border: 1px solid #cccdcf;
}

	/* 엮인글 수, 댓글 수 */
.feedbackList .feedbackHeader {
	font-size: 14px;
	padding: 10px;
	/* background: #f1f1f1; */
	color: #333;
	border-bottom: 1px solid #cccdcf;
}
.feedbackList .feedbackHeader a { 
	color:#555;
}
.feedbackList .feedbackHeader em { 
	font-weight:bold; 
	color:#3395E8;
	/* color:#ff6600; */
}

	/* 댓글 목록 */
.feedbackList .replyList { 
	clear:both; 
	margin:0; 
	padding:0px;
}
.feedbackList .item { 
	position:relative; 
	margin: 0 0 10px;
	padding: 10px 0;
	border-bottom: 1px dotted #cccdcf;
	*zoom:1; 
} 
.feedbackList .item:after {
	content:""; 
	display:block; 
	clear:both; 
}
.feedbackList .item .indent { 
	position:relative; 
	margin:0; 
	padding:0; 
	*zoom:1;
}
.feedbackList .item .indent:after { 
	content:""; 
	display:block; 
	clear:both;
}
.feedbackList .item.itemReply .indent { 
	background:url(../img/iconReply.png) no-repeat 0 0; 
	padding-left:15px; 
}
	



/* 댓글 작성자 정보 */
.feedbackList .item .itemAside {
	position:relative; 
	float:left;
	overflow:hidden; 
	margin:0 15px 0 0; 
	padding:0; 
	*zoom:1; 
	text-align:center;
	z-index:2;

}
.feedbackList .item .itemAside img.profile { 
	width: 50px;
	vertical-align:top; 
	border:1px solid #cccdcf;
}

	
/* 댓글 내용 부분 */
.feedbackList .item .itemContent { 
	position:relative; 
	overflow:hidden;  
	margin:0; 
	padding:0; 
}
.feedbackList .item .itemContent .meta { 
	margin:0 0 10px; 
	white-space: normal;
	vertical-align: middle;
	font-size: 12px;
	color:#777;
}
.feedbackList .item .itemContent .meta a {
	color:#777;
}
.feedbackList .item .itemContent .meta span {
	margin-right: 10px;
}


/* 댓글 옵션 버튼 부분 */
.feedbackList .item .option { 
	float: right;
	margin: 10px 10px 0; 
	padding: 0;
	list-style: none; 
	white-space: nowrap; 
	*zoom:1;
}
.feedbackList .item:hover .option { 
	display: block;
}
.feedbackList .item .option li { 
	position:relative;
	display:inline; 
	padding:0;
	margin: 0;
	font-size: 12px;
}
.feedbackList .item .option li.wouldYou a { 
	font-size:11px;
	padding:0;
	color:#555;
}
.feedbackList .item .option li a { 
	text-decoration:none;
	color:#555;
}


/* Editor */
.commentEditor { 
	position:relative; 
	margin-bottom:15px !important;
	padding:15px !important; 
	border:1px solid #cccdcf; 
}

	/* Editor Option */
.editorOption {
	margin: 0; 
}
.editorOption * { 
	vertical-align:middle;
}
.editorOption select { 
	margin-right:10px; 
}

/* write form 
--------------------------------------------------------------------------------------------------------*/
.boardWrite { 
	margin:0 0 10px; 
	padding: 0;
}

.boardWrite em { 
	color:#2980b9; 
}
.boardWrite .write_type {
	margin-bottom: 10px;
	padding-bottom: 10px;
	border-bottom: 1px dotted #e1e1e1;
}
.boardWrite .write_type * {
	vertical-align:middle;
}
.boardWrite .write_type .input_title {
	float: left;
	width: 20%;
	position: relative;
	margin: 0;
	padding: 0;
	color: #111;
}
.boardWrite .write_type .input_form {
	float: left;
	width: 100%;
}

	/* 제목 입력 */
.boardWrite .write_type .inputText {
	width:  100%;
}
.boardWrite .write_type input[type=text]
{ 
	display:inline-block;
	height: 32px;
	line-height: 32px;
	padding:0 1%;
	color:#777;
	background: #fbfbfb;
	border: 1px solid #cccdcf;
	box-shadow: inset 0 1px 2px rgba(0,0,0,.1);
	border-radius:3px;
}
.boardWrite .write_type textarea { 
	display:inline-block;
	padding: 1%;
	color:#777;
	background: #fbfbfb;
	border: 1px solid #cccdcf;
	box-shadow: inset 0 1px 2px rgba(0,0,0,.1);
	border-radius:3px;
}

.boardHeader {
  height: 50%;
  min-height: 300px;
  background: url('<%=request.getContextPath()%>/img/test4.jpg') center center no-repeat scroll;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  background-size: cover;
  -o-background-size: cover;
}

.list-color{
color : #0d2240
}
</style>   
<div class="carousel-item active" style="height:50%; background-image: url('<%=request.getContextPath()%>/img/test4.jpg')">
   <div class="carousel-caption d-none d-md-block">
     <h1>고객센터</h1>
     <p>customer service</p>
     <h2 class="mt-4 mb-3"><strong>- <%=bt %></strong></h2>	
   </div>
 </div>
<!-- Page Content -->
    <div class="container">
      <div class="row">
        <div class="col-lg-3">
          <h2 class="my-4"></h2>          
          <div class="list-group" style="font-weight: 700;">
            <span class="list-group-item" style="background: #3295e6; color:white;">고객센터</span>
            <a href="<%=request.getContextPath()%>/board/boardList?bn=newsboard" class="list-group-item list-color">SkyGym 소식</a>
            <a href="<%=request.getContextPath()%>/board/boardList?bn=freeboard" class="list-group-item list-color">자유게시판</a>
            <a href="<%=request.getContextPath()%>/board/boardList?bn=partnerboard" class="list-group-item list-color">제휴문의</a>
            <a href="<%=request.getContextPath()%>/board/boardList?bn=qnaboard" class="list-group-item list-color">Q & A</a>
          </div>
        </div>
        
        <!-- /.col-lg-3 -->
		<div class="col-lg-9">

