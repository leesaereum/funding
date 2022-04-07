<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
.notice__header{
	width:  100%;
	display: flex;
	justify-content: space-between;
}
.notice__pageTitle{
	font-size: 21px;
}
.notice__search__box{
	width: 238px;
	height: 38px;
	padding: 0 40px 0 0;
	position: relative;
}
.notice__search{
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 38px;
	padding-left: 10px;
}
.notice__search__icon{
	position: absolute;
	right: 9px;
	top: 9px;
	height: 20px;
}
.notice__box{
   list-style:none;
   margin-top: 17px;
   border: 1px solid #eee;
}
.notice__liner{
	padding: 18px 29px;
	width: 100%;
	display: flex;
	justify-content: space-between;
	color: #999;
	border-bottom: 1px solid #eee;
}

</style>
<body>
	<jsp:include page="/components/header.jsp" />
	<div class="notice__wrap">
		<div class="notice__header">
			<h1 class="notice__pageTitle">공지사항</h1>
			<div class="notice__search__box">
				<input class="notice__search" placeholder="검색어를 입력하세요" id="notice__search" name="notice__search">
				<img src="/Funding/assets/search.svg" class="notice__search__icon">
			</div>
		</div>
		<ul class="notice__box">
			<% for(int i=0; i<10; i++){ %>
			<li class="notice__liner">
				<a href="/Funding/pages/notice__detail.jsp?nid=<%= i %>" class="notice__title">네이버페이 신한은행 계좌간편 및 포인트충전결제 일시 중단 안내 (3/5(토) 00:00~12:00)</a>
				<p class="notice__date">2022-04-01</p>
			</li>
			<% } %>
		</ul>
	</div>
</body>
</html>