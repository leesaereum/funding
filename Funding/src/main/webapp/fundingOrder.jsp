<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 완료 페이지</title>
<link rel="stylesheet" href="./styles/init.css">
<link rel="stylesheet" href="./styles/base.css">
</head>
<script type="text/javascript" src="/Funding/libraries/moment.js"></script>
<style>
.centering{
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	height: calc(100% - 72px);
}
</style>
<body>
	<jsp:include page="./components/header.jsp" />
	<div class="centering">
		<h1>펀딩 신청이 완료되었습니다!</h1>
		<a href="/Funding/main.do?sort=all">메인 화면으로 돌아가기</a>
	</div>
</body>
</html>