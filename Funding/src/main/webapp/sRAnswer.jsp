<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 답변 작성</title>
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

.sRAnswer__box {
	list-style: none;
	margin-top: 17px;
	border: 1px solid #eee;
}

.sRAnswer__liner {
	padding: 18px 29px;
	width: 100%;
	display: flex;
	justify-content: space-between;
	color: #999;
	border-bottom: 1px solid #eee;
}
.sRAnswer__num{
	width: 100px;
	text-align: center;
}
.sRAnswer__date{
	width: 150px;
	text-align: center;
}
.sRAnswer__customer{
	width: 200px;
	text-align: center;
}
.sRAnswer__content{
	width: 200px;
	text-align: center;
}
.sRAnswer__state ,.sRAnswer__rate {
	width: 100px;
	text-align: center;
}
.sRAnswer__title{
	width: calc(100% - 800px);
	text-align: center;
}
</style>
<body>
<jsp:include page="/components/header.jsp" />
	<div class="notice__wrap">
		<div class="notice__header">
			<h1 class="notice__pageTitle">Open펀딩 문의 관리</h1>
			<div class="notice__search__box">
				<input class="notice__search" placeholder="검색어를 입력하세요"
					id="notice__search" name="notice__search"> <img
					src="/Funding/assets/search.svg" class="notice__search__icon">
			</div>
		</div>
		<ul class="sRAnswer__box">
			<li class="sRAnswer__liner"><p class="sRAnswer__num">후기번호</p>
				<p class="sRAnswer__customer">고객ID</p>
				<p class="sRAnswer__funding">펀딩번호</p>
				<p class="sRAnswer__title">후기제목</p>
				<p class="sRAnswer__content">후기내용</p>
				<p class="sRAnswer__date">후기일자</p>
				<p class="sRAnswer__state">후기rate</p></li>
			<c:forEach items="${FReview }" var="FReview">
				<li class="sRAnswer__liner"><p class="sRAnswer__num">${FReview.review_num }</p>
					<p class="sRAnswer__customer">${FReview.review_customer }</p>
					<p class="sRAnswer__funding">${FReview.review_funding }</p>
					<a href="sRAnswer.do?review_num=${FReview.review_num}"
					class="sRAnswer__title">${FReview.review_title }</a>
					<a href="sRAnswer.do?review_num=${FReview.review_num}"
					class="sRAnswer__content">${FReview.review_content }</a>
					<p class="sRAnswer__date">${FReview.review_at }</p>
					<p class="sRAnswer__rate">${FReview.review_rate }</p>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>