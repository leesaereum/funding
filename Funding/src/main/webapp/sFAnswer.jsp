<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open 문의 답변 작성페이지</title>
<link rel="stylesheet" href="/Funding/styles/init.css">
<link rel="stylesheet" href="/Funding/styles/base.css">
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

.question__box {
	list-style: none;
	margin-top: 17px;
	border: 1px solid #eee;
	min-height: 300px;
}
.question__header {
	padding: 18px 30px 19px 29px;
	border-bottom: 1px solid #eee;
	display: flex;
	justify-content: space-between;
}

.question__content {
	padding: 30px 29px 34px;
}

.question__toList {
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
.question__num{
	width: 50px;
	text-align: center;
}
.question__name{
	width: 170px;
}
.question__date{
	width: 120px;
}
.question__title{
	width: calc(100% - 400px);
	overflow: hidden;
}
.btn{
	position: absolute; 
	bottom: 220px; 
	right: 300px
}

</style>
<script src="/Funding/libraries/jQuery.js"></script>
<script src="/Funding/libraries/moment.js"></script>
<script>
	let hello = moment("${FAnswer_detail.question_at}").format("YYYY-MM-DD")
	$(document).ready(function(){
		$(".question__date").html(hello)
	})
	let hi = moment("${FAnswer_detail.question_answer_at}").format("YYYY-MM-DD")
	if(hi=="null"){ let hi = "답변 대기중"}
	$(document).ready(function(){
		$(".answer__date").html(hi)
	})

</script>
</head>
<body>
	<jsp:include page="/components/header.jsp" />

	<form>
	<div class="question__wrap">
		<div class="question__header">
			<h1 class="question__pageTitle">Open 펀딩 문의 답변 </h1>
		</div>
		<div class="question__box">
			<div class="question__header">
				<p class="question__num">${FAnswer_detail.question_num }</p>
				<p class="question__title">${FAnswer_detail.question_funding_title }</p>
				<p class="question__name">${FAnswer_detail.question_customer }</p>
				<p class="question__date"></p>
			</div>
			<div class="question__content">${FAnswer_detail.question_content }</div>
			
		</div>
			<div><a class="question__toList" href="/Funding/sFAnswer_detail.jsp?question_num=${FAnswer_detail.question_num }">답변하기</a></div>

		<a href="javascript:history.back();" class="question__toList">목록</a>
	</div>
	</form>
</body>
</html>