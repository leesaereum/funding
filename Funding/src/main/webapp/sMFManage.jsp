<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>open 펀딩 관리</title>
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
	width: 238px;
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

.sFmanage__box {
	list-style: none;
	margin-top: 17px;
	border: 1px solid #eee;
}

.sFmanage__liner {
	padding: 18px 29px;
	width: 100%;
	display: flex;
	justify-content: space-between;
	color: #999;
	border-bottom: 1px solid #eee;
}
.sFmanage__num{
	width: 66px;
	text-align: center;
}
.sFmanage__date{
width: 200px;
text-align: center;
}
.sFmange__banner{
width: 300px;
text-align: center;
}
.sFmanage__title{
	width: calc(100% - 600px);
	text-align: center;
}
</style>
<body>
<jsp:include page="/components/header.jsp" />
	<div class="notice__wrap">
		<div class="notice__header">
			<h1 class="notice__pageTitle">Open펀딩 관리</h1>
			<div class="notice__search__box">
				<input class="notice__search" placeholder="검색어를 입력하세요"
					id="notice__search" name="notice__search"> <img
					src="/Funding/assets/search.svg" class="notice__search__icon">
			</div>
		</div>
		<ul class="sFmanage__box">
			<li class="sFmanage__liner"><p class="sFmanage__num">공지번호</p>
				<p class="sFmanage__title">제목</p>
				<p class="sFmanage__date">펀딩오픈일</p></li>
			<c:forEach items="${Mfunding }" var="Mfunding">
				<li class="sFmanage__liner"><p class="sFmanage__num">${Mfunding.funding_num }</p>
					<a href="/Funding/pages/sMFDetail.do?funding_num=${Mfunding.funding_num}"
					class="sFmanage__title">${Mfunding.funding_title }</a>
					<p class="sFmanage__date">${Mfunding.funding_openAt }</p>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>