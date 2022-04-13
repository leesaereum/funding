<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<link rel="stylesheet" href="/Funding/styles/init.css">
<link rel="stylesheet" href="/Funding/styles/base.css">
</head>
<style>
.notice__wrap {
	width: 960px;
	margin: 0 auto;
	padding: 51px 0;
}

.notice__header {
	width: 100%;
	display: flex;
	justify-content: space-between;
}

.notice__pageTitle {
	font-size: 21px;
}

.notice__search__box {
	width: 250px;
	height: 38px;
	padding: 0 40px 0 0;
	position: relative;
}

.notice__search {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 38px;
	padding-left: 10px;
}

.notice__search__icon {
	position: absolute;
	right: 9px;
	top: 9px;
	height: 20px;
}

.notice__box {
	list-style: none;
	margin-top: 17px;
	border: 1px solid #eee;
}

.notice__liner {
	padding: 18px 29px;
	width: 100%;
	display: flex;
	justify-content: space-between;
	color: #999;
	border-bottom: 1px solid #eee;
}
.notice__num{
	width: 66px;
	text-align: center;
}
.notice__date{
width: 200px;
text-align: center;
}
.notice__title{
	width: calc(100% - 300px);
	text-align: center;
}
.pages__box{
	display: flex;
	justify-content: center;
	margin: 20px 0;
}
.pages__box > a{
	margin-right: 8px;
	width: 36px;
	height: 32px;
	border: 1px solid #999;
	border-radius: 4px;
	box-sizing: border-box;
	line-height: 32px;
	text-align: center;
}
.pages__box > .selected{
	background-color: #333;
	color: white;
}
</style>
<body>
	<jsp:include page="/components/header.jsp" />
	<div class="notice__wrap">
		<div class="notice__header">
			<h1 class="notice__pageTitle">공지사항</h1>
			<div class="notice__search__box">
				<input class="notice__search" placeholder="검색하실 제목이나 내용을 입력하세요."
					id="notice__search" name="notice__search"> <img
					src="/Funding/assets/search.svg" class="notice__search__icon">
			</div>
		</div>
		<ul class="notice__box">
			<li class="notice__liner"><p class="notice__num">공지 번호</p>
				<p class="notice__title">제목</p>
				<p class="notice__date">공지일</p></li>
			<c:forEach items="${notice}" var="notice">
				<li class="notice__liner"><p class="notice__num">${notice.notice_num }</p>
					<a href="notice_detail.do?notice_num=${notice.notice_num}"
					class="notice__title">${notice.notice_title }</a>
					<p class="notice__date">${notice.notice_At }</p></li>
			</c:forEach>
		</ul>
		<div class="pages__box" id="page__box">
		</div>
	</div>
		<script type="text/javascript">
		$(document).on("click", ".notice__search__icon", function() {
			location.href = "/Funding/notice_search.do?notice_search="+$("#notice__search").val();
		})
		
		let currentPage = <%=request.getParameter("page")%>*1;
	let count = ${countNotice}
	let pages = Math.floor((count - 1) / 10) + 1;
	let txt = "";
	for (var i = 1; i <= pages; i++) {
		if(i === currentPage){
			txt += '<a class="selected" href="/Funding/notice_list.do?page='+i+'">'+i+'</a>'

		}else{
			txt += '<a href="/Funding/notice_list.do?page='+i+'">'+i+'</a>'

		}
	}
	$("#page__box").html(txt);
	</script>
</body>
</html>