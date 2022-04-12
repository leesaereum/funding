<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
<
title>Funding detail </title>html {
	height: 100%;
}

body {
	margin: 0;
	padding: 0;
	height: 100%;
}

.signIn__wrap {
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	background-color: #DADEFD
}

.signIn__content {
	width: 280px;
	height: 400px;
	padding: 30px;
	background-color: white;
	border-radius: 16px;
}

.signIn__title {
	margin: 12px 0 16px;
}

.signIn__description {
	color: #555;
	margin: 0 0 24px;
}

.signIn__subTitle {
	font-size: 14px;
	font-weight: bold;
	margin: 4px 0;
}

.signIn__liner {
	margin-bottom: 16px;
}

.signIn__input {
	width: 280px;
	height: 40px;
	box-sizing: border-box;
	border-radius: 32px;
	border: 1px solid #aaa;
	padding: 8px 16px;
	line-height: 24px;
}

.signIn__submit {
	width: 280px;
	background-color: royalblue;
	color: white;
	height: 44px;
	margin: 24px 0;
	border-radius: 32px;
	cursor: pointer;
}

.signIn__info {
	margin: 0;
	font-size: 14px;
}
</style>
</head>
<body>
	<div class="signIn__wrap">
		<div class="signIn_content">
			<c:forEach items="${fundingdetail }" var="dto33">
				<h1 class="signIn__title">${dto33.funding_title} Funding Detail</h1>
			</c:forEach>

				<div class="signIn_liner">
					<c:forEach items="${fundingdetail }" var="dto33">

						<table border="0">
							<tr>
								<td width="10%" align="left">펀딩 아이디</td>
								<td width="10%" align="center">${dto33.funding_num}</td>
							</tr>
			
							<tr>
								<td width="10%" align="left"><a href="aFApprove.do?fundingNum=${dto33.funding_num}">승인</a> / <a href="aFreject.do?fundingNum=${dto03.funding_num}">반려</a></td>
							</tr>
							
							<tr>
								<td width="10%" align="left"><a href="aSQWList.do">목록으로 가기</a></td>
							</tr>

						</table>
					</c:forEach>
				</div>

		</div>
	</div>
</body>
</html>

