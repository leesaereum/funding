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
						<div class="list__search__box">
							<input class="list__search" placeholder="검색할 펀딩이나 판매자를 입력하세요."
								id="list__search" name="funding_search"> <img
								src="/Funding/assets/search.svg" class="list__search__icon">
						</div>
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

				<script type="text/javascript">
		$(document).on("click", ".list__search__icon", function() {
			location.href = "/Funding/fundingSearch.do?funding_search="+$("#list__search").val();
		})
	</script>
			</div>
			<div class="tab__content" id="tab__2__content">
				<div class="list__wrap">
					<div class="list__header">
						<h1 class="list__pageTitle">찜한 펀딩 목록</h1>
						<div class="list__search__box">
							<input class="list__search" placeholder="검색할 펀딩이나 판매자를 입력하세요."
								id="list__search" name="funding_search"> <img
								src="/Funding/assets/search.svg" class="list__search__icon">
						</div>
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
				<script type="text/javascript">
		$(document).on(
				"click",
				".list__search__icon",
				function() {
					location.href = "/Funding/fundingSearch.do?funding_search="
							+ $("#list__search").val();
				})
	</script>

			</div>
			<div class="tab__content" id="tab__3__content">
				<div class="question__wrap">
					<div class="question__header">
						<h1 class="question__pageTitle">Q&A</h1>
						<div class="question__search__box">
							<input class="question__search" placeholder="검색하실 제목이나 내용을 입력하세요"
								id="question_search" name="question_search"> <img
								src="/Funding/assets/search.svg" class="question__search__icon">
						</div>
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
		$(document).on("click", ".question__search__icon", function() {
			location.href = "/Funding/systemQuestion_search.do?question_search="+$("#question_search").val();
		})

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
		function goPopup() {
			var pop = window.open("./addressPopup.jsp", "pop",
					"width=570,height=420, scrollbars=yes, resizable=yes");

		}
		/** API 서비스 제공항목 확대 (2017.02) **/
		function jusoCallBack(roadFullAddr, roadAddrPart1, addrDetail,
				roadAddrPart2, engAddr, jibunAddr, zipNo, admCd, rnMgtSn,
				bdMgtSn, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm,
				rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo) {
			document.form.roadAddrPart1.value = roadAddrPart1;
			document.form.roadAddrPart2.value = roadAddrPart2;
			document.form.addrDetail.value = addrDetail;
		}

		function checkMyForm() {
			let form = document.form;
			console.log(form)
		}
	</script>
</body>
</html>