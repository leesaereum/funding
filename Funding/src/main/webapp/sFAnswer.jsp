<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open 문의 답변 작성페이지</title>
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

.sFADetail__box {
	list-style: none;
	margin-top: 17px;
	border: 1px solid #eee;
}

.sFADetail__liner {
	padding: 18px 29px;
	width: 100%;
	display: flex;
	justify-content: space-between;
	color: #999;
	border-bottom: 1px solid #eee;
}
.sFADetail__num{
	width: 100px;
	text-align: center;
}
.sFADetail__date{
	width: 150px;
	text-align: center;
}
.sFADetail__customer{
	width: 200px;
	text-align: center;
}
.sFADetail__content{
	width: 200px;
	text-align: center;
}
.sFADetail__state{
	width: 100px;
	text-align: center;
}
.sFADetail__title{
	width: calc(100% - 800px);
	text-align: center;
}
</style>
<body>
<jsp:include page="/components/header.jsp" />
	<div class="notice__wrap">
		<div class="notice__header">
			<h1 class="notice__pageTitle">Open펀딩 문의 답변</h1>
		</div>
		<div class="sFADetail__box">
		<c:forEach items="${FQlist }" var="FQlist">
				문의번호  <input class="sFADetail__num" type="text" maxlength="3" readonly="readonly" value="${question_num }"><br>
				고객ID   <input class="sFADetail__customer" type="text" readonly="readonly" value="${FQlist.question_customer }"><br>
				제목	    <input class="sFADetail__title" type="text" readonly="readonly" value="${FQlist.question_title }"><br>
				문의내용	<input class="sFADetail__content" type="text" readonly="readonly" value="${FQlist.question_content }"><br>
				문의일자	<input class="sFADetail__date" type="text" readonly="readonly" value="${FQlist.question_at }"><br>
		</c:forEach>
		</div>
		
		<div class="notice__header">
			<h1 class="notice__pageTitle">Open펀딩 문의 답변</h1>
		</div>
		<ul class="sFADetail__box">
			<li class="sFADetail__liner"><p class="sFADetail__num">문의번호</p>
				<p class="sFADetail__customer">고객ID</p>
				<p class="sFADetail__title">제목</p>
				<p class="sFADetail__content">문의내용</p>
				<p class="sFADetail__date">문의일자</p></li>
			<c:forEach items="${FQlist }" var="FQlist">
				<li class="sFADetail__liner"><p class="sFADetail__num">${FQlist.question_num }</p>
					<p class="sFADetail__customer">${FQlist.question_customer }</p>
					<a href="sFAnswer.do?question_num=${FQlist.question_num}"
					class="sFADetail__title">${FQlist.question_title }</a>
					<a href="sFAnswer.do?question_num=${FQlist.question_num}"
					class="sFADetail__content">${FQlist.question_content }</a>
					<p class="sFADetail__date">${FQlist.question_at }</p>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>