<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="/Funding/styles/init.css">
<link rel="stylesheet" href="/Funding/styles/base.css">
<link rel="stylesheet" href="/Funding/styles/fundingCards.css">
<link rel="stylesheet" href="/Funding/pages/Smypage.css">
</head>
<script>
document.addEventListener('DOMContentLoaded', function() {
	let email = "<%=session.getAttribute("id")%>
	";

		if (email == "null") {
			location.href = "/Funding/main.jsp"
		}
	});
</script>
<body>
	<jsp:include page="/components/header.jsp" />
	<div class="my__wrap__wrap">
		<div class="my__wrap">
			<div class="my__tab">
				<p class="my__tab__btn selected" id="tab__1">참여한 펀딩</p>
				<p class="my__tab__btn" id="tab__2">찜한 펀딩</p>
				<p class="my__tab__btn" id="tab__3">Q&A</p>
				<p class="my__tab__btn" id="tab__4">개인정보 관리</p>
				<p class="my__tab__btn" id="tab__5">주최한 펀딩 관리</p>
				<p class="my__tab__btn" id="tab__6">펀딩 정산</p>
			</div>
			<div class="tab__content selected" id="tab__1__content">
				<div class="list__wrap">
					<div class="list__header">
						<h1 class="list__pageTitle">참여한 펀딩 목록</h1>
					</div>

					<ul class="list__box">
						<li class="list__liner"><p class="list__title">펀딩명</p>
							<p class="list__seller">판매자</p>
							<p class="list__date">오픈일</p>
							<p class="list__date">마감일</p></li>
						<c:forEach items="${funding}" var="funding">
							<li class="list__liner">
								<p class="list__title">${funding.funding_title }</p>
								<p class="list__seller">${funding.funding_seller }</p>
								<p class="list__date">${funding.funding_openAt }</p>
								<p class="list__date">${funding.funding_closeAt }</p>
								<p class="list_seller">
									<a
										href="/Funding/myorder_detail.do?funding_num=${funding.funding_num }">상세보기</a>
								</p>
							</li>
						</c:forEach>
					</ul>
				</div>
				<script src="/Funding/libraries/jQuery.js"></script>
			</div>
			<div class="tab__content" id="tab__2__content">
				<div class="list__wrap">
					<div class="list__header">
						<h1 class="list__pageTitle">찜한 펀딩 목록</h1>
					</div>

					<ul class="list__box">
						<li class="list__liner"><p class="list__title">펀딩명</p>
							<p class="list__seller">판매자</p>
							<p class="list__date">오픈일</p>
							<p class="list__date">마감일</p></li>
						<c:forEach items="${like}" var="like">
							<li class="list__liner"><a
								href="/Funding/fundingContent_view.do?fid=${like.funding_num}"
								class="list__title">${like.funding_title }</a>
								<p class="list__seller">${like.funding_seller }</p>
								<p class="list__date">${like.funding_openAt }</p>
								<p class="list__date">${like.funding_closeAt }</p></li>
						</c:forEach>
					</ul>
				</div>
				<script src="/Funding/libraries/jQuery.js"></script>
			</div>
			<div class="tab__content" id="tab__3__content">
				<div class="question__wrap">
					<div class="question__header">
						<h1 class="question__pageTitle">Q&A</h1>
					</div>
					<ul class="question__box">
						<li class="question__liner">
							<p class="question__num">Q&A번호</p>
							<p class="question__title">제목</p>
							<p class="question__date">질문 생성일</p>
							<p class="question__title">답변유무</p>
						</li>
						<c:forEach items="${question }" var="dto">
							<li class="question__liner">
								<p class="question__num">${dto.question_num }</p> <a
								href="systemQuestion_detail.do?question_num=${dto.question_num}"
								class="question__title">${dto.question_title }</a>
								<p class="question__date">${dto.question_at }</p>
								<p class="question_title">${dto.question_state }</p>
							</li>
						</c:forEach>
					</ul>

				</div>
				<script src="/Funding/libraries/jQuery.js"></script>
				<script type="text/javascript">

	</script>
			</div>
			<div class="tab__content" id="tab__4__content">
				<h2 class="my__title">개인정보 관리</h2>
				<form name="form" action="/myinformation_modify.do">
					<div class="my__formzone">
						<div class="my__liner">
							<p class="my__form__subtitle">변경할 비밀번호</p>
							<input class="my__form__input" type="password" id="pw1"
								name="customer_pw">
						</div>
						<div class="my__liner">
							<p class="my__form__subtitle">비밀번호 확인</p>
							<input class="my__form__input" type="password" id="pw2">
						</div>
						<div class="my__liner">
							<p class="my__form__subtitle">전화번호(-제외)</p>
							<input class="my__form__input" type="password" id="phone"
								name="phone">
						</div>
					</div>
					<div class="my__form__submit" onclick="checkMyForm()">변경하기</div>
			</div>

			</form>

		</div>
		<div class="tab__content" id="tab__5__content">
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
							<a
							href="/Funding/sMFDetail.do?funding_num=${Mfunding.funding_num}"
							class="sFmanage__title">${Mfunding.funding_title }</a>
							<p class="sFmanage__date">${Mfunding.funding_openAt }</p></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="tab__content" id="tab__6__content"></div>
	</div>

	<script type="text/javascript" src="/Funding/libraries/jQuery.js"></script>
	<script type="text/javascript" src="/Funding/pages/Smypage.js"></script>
</body>
</html>