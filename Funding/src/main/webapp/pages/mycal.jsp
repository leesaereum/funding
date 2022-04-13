<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펀딩 정산 내역</title>
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

.notice__num {
	width: 50px;
	text-align: center;
}

.notice__name {
	width: 170px;
}

.ordering__price {
	width: 170px;
}

.ordering__date {
	width: 120px;
}

.notice__title {
	width: calc(100% - 400px);
	overflow: hidden;
}
</style>
<script src="/Funding/libraries/jQuery.js"></script>
<script src="/Funding/libraries/moment.js"></script>

</head>

<body>
	<jsp:include page="/components/header.jsp" />

	<div class="notice__wrap">
		<div class="notice__header">
			<h1 class="notice__pageTitle">펀딩 정산 내역</h1>
		</div>
		<div class="notice__box">
			<div class="notice__content">
				<div class="notice__header">
					<p class="notice__title">펀딩명</p>
					<p class="ordering__price">펀딩 총 합계 금액</p>
					<p class="notice__name">정산 상태</p>
				</div>

				<div class="notice__header">
					<p class="notice__title">${funding.funding_title}</p>
					<p class="ordering__price">${funding.total }</p>
					<p class="notice__name">${cal}</p>
				</div>
			</div>
			<a href="" class="notice__toList">정산 신청</a> <a
				href="javascript:history.back();" class="notice__toList">목록</a>
		</div>
</body>
</html>