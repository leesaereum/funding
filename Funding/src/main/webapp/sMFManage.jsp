<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>open 펀딩 관리</title>
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

.notice__search__box {
	width: 238px;
	height: 38px;
	padding: 0 40px 0 0;
	position: relative;
}

.notice__search {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 38px;
	padding-left: 10px;
}

.notice__search__icon {
	position: absolute;
	right: 9px;
	top: 9px;
	height: 20px;
}


</style>
<script type="text/javascript">
	//function del() {
		
	//}
</script>
<body>
<jsp:include page="/components/header.jsp" />
	<div class="notice__wrap">
		<div class="notice__header">
			<h1 class="notice__pageTitle">Open펀딩 관리</h1>
		</div>
		<ul class="sFmanage__box">
			<li class="sFmanage__liner"><p class="sFmanage__num">펀딩 번호</p>
				<p class="sFmanage__title">제목</p>
				<p class="sFmanage__date">펀딩오픈일</p></li>
			<c:forEach items="${Mfunding }" var="Mfunding">
				<li class="sFmanage__liner"><p class="sFmanage__num">${Mfunding.funding_num }</p>
					<a href="/Funding/sMFDetail.do?funding_num=${Mfunding.funding_num}"
					class="sFmanage__title">${Mfunding.funding_title }</a>
					<p class="sFmanage__date">${Mfunding.funding_openAt }</p>
					<!--<p><input type="button" value="삭제" onclick="del()"></p>-->
					<a href = "sMFDDelete.do?funding_num=${Mfunding.funding_num }">X</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>