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
.notice__title{
	padding: 18px 30px 19px 29px;
	border-bottom: 1px solid #eee;
}
.notice__content{
	padding: 30px 29px 34px;
}
.notice__toList{
	display: block;
    width: 160px;
    margin: 30px auto 0;
    padding: 13px 0 12px;
    background-color: #828282;
    border: 1px solid rgba(0,0,0,.1);
    font-size: 16px;
    line-height: 1.19;
    color: #fff;
    text-align: center;
    cursor:pointer;
}
</style>
</head>
<body>
	<jsp:include page="/components/header.jsp" />
	<div class="notice__wrap">
		<div class="notice__header">
			<h1 class="notice__pageTitle">공지사항</h1>
		</div>
		<div class="notice__box">
			<p class="notice__title">네이버페이 신한은행 계좌간편 및 포인트충전결제 일시 중단 안내 (3/5(토) 00:00~12:00)</p>
			<div class="notice__content">
				<p>안녕하세요 해피펀딩입니다.</p>
				<p>3월 5일 신한은행 시스템 업그레이드 작업이 있어, 아래와 같이 계좌간편 및 포인트충전결제가 일시 중단됨을 안내드립니다.</p>
			</div>
		</div>
		<a href="/Funding/pages/noticeDo.jsp" class="notice__toList">목록</a>
	</div>
</body>
</html>