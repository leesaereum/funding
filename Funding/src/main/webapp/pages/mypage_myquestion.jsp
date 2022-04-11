<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Funding/styles/init.css">
<link rel="stylesheet" href="/Funding/styles/base.css">
<link rel="stylesheet" href="/Funding/pages/mypage.css">
</head>
<body>
<jsp:include page="/components/header.jsp" />
<div class="question__wrap">
		<div class="question__header">
			<h1 class="question__pageTitle">Q&A</h1>
			<div class="question__search__box">
				<input class="question__search" placeholder="검색하실 제목이나 내용을 입력하세요"
					id="question_search" name="question_search"> <img
					src="/Funding/assets/search.svg" class="question__search__icon">
			</div>
		</div>
		<ul class="question__box">
			<li class="question__liner">
			<p class="question__num">Q&A번호</p>
				<p class="question__title">제목</p>
				<p class="question__date">질문 생성일</p>
				<p class="question__title">답변유무</p></li>
			<c:forEach items="${question }" var="dto">
				<li class="question__liner">
				<p class="question__num">${dto.question_num }</p>
					<a href="systemQuestion_detail.do?question_num=${dto.question_num}"
					class="question__title">${dto.question_title }</a>
					<p class="question__date">${dto.question_at }</p>
					<p class="question_title">${dto.question_state }</p>
					</li>
			</c:forEach>
		</ul>
		
	</div>
		<script src="/Funding/libraries/jQuery.js"></script>
	<script type="text/javascript">
		$(document).on("click", ".question__search__icon", function() {
			location.href = "/Funding/systemQuestion_search.do?question_search="+$("#question_search").val();
		})

	</script>
</body>
</html>