<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Funding/pages/mypage.css">
<link rel="stylesheet" href="/Funding/styles/init.css">
<link rel="stylesheet" href="/Funding/styles/base.css">
</head>
<body>
	<jsp:include page="/components/header.jsp" />
<div class="list__wrap">
		<div class="list__header">
			<h1 class="list__pageTitle">참여한 펀딩 목록</h1>
			<div class="list__search__box">
				<input class="list__search" placeholder="검색할 펀딩이나 판매자를 입력하세요."
					id="list__search" name="funding_search"> <img
					src="/Funding/assets/search.svg" class="list__search__icon">
			</div>
		</div>
		
		<ul class="list__box">
			<li class="list__liner"><p class="list__title">펀딩명</p><p class="list__seller">판매자</p><p class="list__date">오픈일</p><p class="list__date">마감일</p></li>
			<c:forEach items="${funding}" var="funding">
				<li class="list__liner"><a
					href=""
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
			location.href = "/Funding/fundingSearch.do?funding_search="+$("#list__search").val();
		})
				$(document).on("click", ".tab__1", function() {
			location.href = "/myfunding_list.do";
		})
		
	</script>
</body>
</html>