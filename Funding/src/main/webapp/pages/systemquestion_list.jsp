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
.question__wrap {
	width: 960px;
	margin: 0 auto;
	padding: 51px 0;
}

.question__header {
	width: 100%;
	display: flex;
	justify-content: space-between;
}

.question__pageTitle {
	font-size: 21px;
}

.question__search__box {
	width: 250px;
	height: 38px;
	padding: 0 40px 0 0;
	position: relative;
}

.question__search {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 38px;
	padding-left: 10px;
}

.question__search__icon {
	position: absolute;
	right: 9px;
	top: 9px;
	height: 20px;
}

.question__box {
	list-style: none;
	margin-top: 17px;
	border: 1px solid #eee;
}

.question__liner {
	padding: 18px 29px;
	width: 100%;
	display: flex;
	justify-content: space-between;
	color: #999;
	border-bottom: 1px solid #eee;
}
.question__num{
	width: 66px;
	text-align: center;
}
.question__date{
width: 200px;
text-align: center;
}
.question__title{
	width: calc(100% - 300px);
	text-align: center;
}
.question__create {
	display: block;
	width: 160px;
	margin: 30px auto 0;
	padding: 13px 0 12px;
	background-color: #828282;
	border: 1px solid rgba(0, 0, 0, .1);
	font-size: 16px;
	line-height: 1.19;
	color: #fff;
	text-align: center;
	cursor: pointer;
}
</style>
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
	<div>
		<a href="/Funding/pages/systemquestion_create.jsp" class="question__create">질문 등록하기</a>
		</div>
		<script src="/Funding/libraries/jQuery.js"></script>
	<script type="text/javascript">
		$(document).on("click", ".question__search__icon", function() {
			location.href = "/Funding/systemQuestion_search.do?question_search="+$("#question_search").val();
		})

	</script>
</body>
</html>