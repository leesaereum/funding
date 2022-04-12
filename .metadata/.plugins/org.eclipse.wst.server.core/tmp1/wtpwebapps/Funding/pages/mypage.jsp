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
<link rel="stylesheet" href="/Funding/pages/mypage.css">
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
						<h1 class="question__pageTitle">SYSTEM Q&A</h1>
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
				<div class="question__wrap">
									<div class="question__header">
						<h1 class="question__pageTitle">FUNDING Q&A</h1>
					</div>
					<ul class="question__box">
						<li class="question__liner">
							<p class="question__title">펀딩명</p>
							<p class="question__title">질문 내용</p>
							<p class="question__date">질문 일자</p>
						</li>
						<li class="question__liner">
							<p class="question__title">답변유무</p>
							<p class="question__title">답변 내용</p>
							<p class="question__date">답변 일자</p>
						</li>
						<c:forEach items="${fundingquestion }" var="dto">
							<li class="question__liner">
								<a href="_detail.do?question_num=${dto.question_funding}"
								class="question__title">${dto.question_funding_title }</a>
								<p class="question_title">${dto.question_content }</p>
								<p class="question__date">${dto.question_at }</p>
							</li>
							<li class="question__liner">
								<p class="question_title">${dto.question_state }</p>
								<p class="question_title">${dto.question_answer }</p>
								<p class="question__date">${dto.question_answer_at }</p>
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
							<p class="my__form__subtitle">전화번호</p>
							<input class="my__form__input" type="password" id="phone" placeholder="ex)010-0000-0000"
								name="phone">
						</div>
						<div class="my__form__submit" onclick="checkMyForm()">변경하기</div>
					</div>

				</form>

			</div>
		</div>

		<script type="text/javascript" src="/Funding/libraries/jQuery.js"></script>
		<script type="text/javascript" src="/Funding/pages/mypage.js"></script>
		<script>
		function checkMyForm() {
			let form = document.form;
			console.log(form)
		}
	</script>
</body>
</html>