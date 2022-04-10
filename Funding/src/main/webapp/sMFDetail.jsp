<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>open 펀딩 디테일</title>
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


.sFmanage__toList {
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
.sFmanage__seller{
	width: 50px;
	text-align: center;
}
.sFmanage__banner{
	width: 170px;
}
.sFmanage__title{
	width: 120px;
}
.sFmanage__purpose{
	width: 120px;
}
.sFmanage__hits{
	width: 120px;
}
.sFmanage__state{
	width: 120px;
}
.sFmanage__fee{
	width: 120px;
}

</style>
<script src="/Funding/libraries/jQuery.js"></script>
<script src="/Funding/libraries/moment.js"></script>
<script>
	let hello = moment("${Mfunding.funding_openAt}").format("YYYY-MM-DD")
	$(document).ready(function(){
		$(".sFmanage__date").html(hello)
	})
</script>
</head>
<body>
	<jsp:include page="/components/header.jsp" />

	<div class="notice__wrap">
		<div class="notice__header">
			<h1 class="notice__pageTitle">Open펀딩상세페이지</h1>
		</div>
		<div class="sFmanage__box">
			<div class="notice__header">
			<p class="sFmanage_seller">${Mfunding.funding_seller }</p>
			<p class="sFmanage_title">${Mfunding.funding_title }</p>
			<p class="sFmanage__banner">${Mfunding.funding_banner }</p>
			<p class="sFmanage__purpose">${Mfunding.funding_purpose }</p>
			<p class="sFmanage__hits">${Mfunding.funding_hits }</p>
			<p class="sFmanage__state">${Mfunding.funding_state }</p>
			<p class="sFmanage__fee">${Mfunding.funding_fee }</p>
			<p class="sFmanage__date">${Mfunding.funding_openAt }</p>
			<p class="sFmanage__date">${Mfunding.funding_closeAt }</p>
		</div>
		</div>
		<a href="sMFManage.do" class="sFmanage__toList">목록</a>
	</div>
</body>
</html>