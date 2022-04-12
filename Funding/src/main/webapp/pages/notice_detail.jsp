<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<link rel="stylesheet" href="/Funding/styles/init.css">
<link rel="stylesheet" href="/Funding/styles/base.css">
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

.notice__box {
	list-style: none;
	margin-top: 17px;
	border: 1px solid #eee;
	min-height: 300px;
}
.notice__header {
	padding: 18px 30px 19px 29px;
	border-bottom: 1px solid #eee;
	display: flex;
	justify-content: space-between;
}

.notice__content {
	padding: 30px 29px 34px;
}

.notice__toList {
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
.notice__num{
	width: 50px;
	text-align: center;
}
.notice__name{
	width: 170px;
}
.notice__date{
	width: 120px;
}
.notice__title{
	width: calc(100% - 400px);
	overflow: hidden;
}
</style>
<script src="/Funding/libraries/jQuery.js"></script>
<script src="/Funding/libraries/moment.js"></script>
<script>
	let hello = moment("${notice.notice_At}").format("YYYY-MM-DD")
	$(document).ready(function(){
		$(".notice__date").html(hello)
	})
</script>
</head>
<body>
	<jsp:include page="/components/header.jsp" />

	<div class="notice__wrap">
		<div class="notice__header">
			<h1 class="notice__pageTitle">공지사항</h1>
		</div>
		<div class="notice__box">
			<div class="notice__header">
				<p class="notice__num">${notice.notice_num }</p>
				<p class="notice__title">${notice.notice_title }</p>
				<p class="notice__name">${notice.notice_admin }</p>
				<p class="notice__date"></p>
			</div>
			<div class="notice__content">${notice.notice_content }</div>
		</div>
			<a href="javascript:history.back();" class="notice__toList">목록</a>
		
	</div>
</body>
</html>