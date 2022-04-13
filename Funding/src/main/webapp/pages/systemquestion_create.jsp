<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A 작성</title>
<link rel="stylesheet" href="/Funding/styles/init.css">
<link rel="stylesheet" href="/Funding/styles/base.css">
<style>
.question__wrap {
	width: 960px;
	margin: 0 auto;
	padding: 51px 0;
}

.question__pageTitle {
	font-size: 21px;
	height: 50px;
	border: none;
}


.question__header {
	padding: 0 30px;
	border: 1px solid #aaa;
	width: 100%;
	box-sizing: border-box;
	height: 48px;
	margin: 24px 0;
}

.question__content {
	min-height: 300px;
	resize: none;
	padding: 30px;
	width: 100%;
	border: 1px solid #aaa;
}

.question__submit {
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

.question__num {
	width: 50px;
	systemQuestion text-align: center;
}

.question__name {
	width: 100%;
	border: none;
	padding: 8px 30px;
	box-sizing: border-box;
}

.question__date {
	width: 120px;
}
.question__form{
	border: none;
}
</style>
<script src="/Funding/libraries/jQuery.js"></script>
<script src="/Funding/libraries/moment.js"></script>
</head>
<jsp:include page="/components/header.jsp" />
<body>
	<div class="question__wrap">
		<h1 class="question__pageTitle">Q&A</h1>
		<div class="question__box">
			<p class="question__name">
				작성자 :
				<%=session.getAttribute("id")%></p>
			<form class="question__form" action="/Funding/systemQuestion.do">
				<input class="question__header" type="text" name="title"
					placeholder="제목을 입력해주세요">

				<textarea class="question__content" name="content" placeholder="내용을 입력해주세요"></textarea>

				<div>
					<input type="submit" class="question__submit">
				</div>
			</form>
		</div>
	</div>
</body>
</html>