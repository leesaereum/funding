<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="/Funding/styles/init.css">
<link rel="stylesheet" href="/Funding/styles/base.css">
</head>
<style>
.list__wrap {
	width: 1080px;
	margin: 0 auto;
	padding: 51px 0;
}

.list__header {
	width: 100%;
	display: flex;
	justify-content: space-between;
}

.list__pageTitle {
	font-size: 21px;
}

.list__search__box {
	width: 238px;
	height: 38px;
	padding: 0 40px 0 0;
	position: relative;
}

.list__search {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 38px;
	padding-left: 10px;
}

.list__search__icon {
	position: absolute;
	right: 9px;
	top: 9px;
	height: 20px;
}

.list__box {
	list-style: none;
	margin-top: 17px;
	border: 1px solid #eee;
}

.list__liner {
	padding: 18px 29px;
	width: 100%;
	display: flex;
	justify-content: space-between;
	color: #999;
	border-bottom: 1px solid #eee;
}
.list__date{
	width: 200px;
	text-align: center;
}
.list__seller{
	width: 220px;
	text-align:center;
}
.list__title{
	width: calc(100% - 660px);
	text-align:center;
}
</style>
<body>
	<jsp:include page="/components/header.jsp" />
	<div class="list__wrap">
		<div class="list__header">
			<h1 class="list__pageTitle">펀딩 목록</h1>
			<div class="list__search__box">
				<input class="list__search" placeholder="검색어를 입력하세요"
					id="list__search" name="funding_search"> <img
					src="/Funding/assets/search.svg" class="list__search__icon">
			</div>
		</div>
		<ul class="list__box">
			<li class="list__liner"><p class="list__title">펀딩명</p><p class="list__seller">판매자</p><p class="list__date">오픈일</p><p class="list__date">마감일</p></li>
			<c:forEach items="${funding}" var="funding">
				<li class="list__liner"><a
					href="detail.jsp?fid=${funding.funding_num}"
					class="list__title">${funding.funding_title }</a>
					<p class="list__seller">${funding.funding_seller }</p>
					<p class="list__date">${funding.funding_openAt }</p>
					<p class="list__date">${funding.funding_closeAt }</p></li>
			</c:forEach>
		</ul>
	</div>
	<script src="/Funding/libraries/jQuery.js"></script>
	<script type="text/javascript">
		$(document).on("click", ".list__search__icon", function() {
			location.href = "/Funding/main.jsp";
		})
	</script>
</body>
</html>