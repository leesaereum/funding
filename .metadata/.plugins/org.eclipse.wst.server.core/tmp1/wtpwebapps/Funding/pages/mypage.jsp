<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	let email = "<%=session.getAttribute("customer_id")%>";

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
			<div class="tab__content selected" id="tab__1__content"></div>
			<div class="tab__content" id="tab__2__content"></div>
			<div class="tab__content" id="tab__3__content"></div>
			<div class="tab__content" id="tab__4__content">
				<h2 class="my__title">개인정보 관리</h2>
				<form name="form" action="/myinformation_modify.do">
					<div class="my__formzone">
						<div class="my__liner">
							<p class="my__form__subtitle">변경할 비밀번호</p>
							<input class="my__form__input" type="password" id="pw1" name="customer_pw">
						</div>
						<div class="my__liner">
							<p class="my__form__subtitle">비밀번호 확인</p>
							<input class="my__form__input" type="password" id="pw2">
						</div>
						<div class="my__liner">
							<p class="my__form__subtitle">전화번호(-제외)</p>
							<input class="my__form__input" type="password" id="phone">
						</div>
						<div class="my__liner">
							<p class="my__form__subtitle">도로명 주소</p>
							<input class="my__form__button" type="button" value="주소검색" onclick="goPopup();"> 
							<input class="my__form__input long" name="address1" id="roadAddrPart1">
						</div>
						<div class="my__liner">
							<p class="my__form__subtitle">상세주소</p>
							<input class="my__form__input small" type="text" name="address2" id="addrDetail"> 
							<input class="my__form__input small" type="text" name="address3" id="roadAddrPart2">
						</div>
						<div class="my__form__submit" onclick="checkMyForm()">변경하기</div>
					</div>

				</form>

			</div>
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
		
		function checkMyForm(){
			let form = document.form;
			console.log(form)
		}
	</script>
</body>
</html>