<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규 펀딩 만들기</title>
<link rel="stylesheet" href="/funding/styles/init.css">
<link rel="stylesheet" href="/funding/styles/base.css">
<link rel="stylesheet" href="./makeFunding.css">
</head>
<body>
	<jsp:include page="/components/header.jsp" />
	<div class="MF__background">
		<div class="MF__wrap">
			<div class="MF__tabs">
				<div class="MF__tab selected" id="MF__tab__1">
					<p class="MF__tab__step">STEP 1</p>
					<p class="MF__tab__description">펀딩 기본 정보 입력</p>
				</div>
				<div class="MF__tab" id="MF__tab__2">
					<p class="MF__tab__step">STEP 2</p>
					<p class="MF__tab__description">리워드 정보 입력</p>
				</div>
				<div class="MF__tab" id="MF__tab__3">
					<p class="MF__tab__step">STEP 3</p>
					<p class="MF__tab__description">펀딩 콘텐츠 입력</p>
				</div>
			</div>
			<div class="MF__tabContent selected" id="tabContent__1">
				<h3 class="MF__subtitle">STEP1 - 펀딩 기본 정보 입력</h3>
				<p class="MF__basic__title">펀딩 제목</p>
				<p class="MF__basic__description">24자 이내의 매력적인 제목을 입력해주세요</p>
				<input class="MF__basic__input large" placeholder="예) 국산 쌀과 고춧가루로 만든 말랑말랑 쌀떡볶이">
				<p class="MF__basic__warning">6~24자의 제목을 입력해주세요</p>
				<p class="MF__basic__title">펀딩 주체 이름</p>
				<p class="MF__basic__description">펀딩을 개최하시는 분의 이름 혹은 업체명을 12자 이내로 입력해주세요</p>
				<input class="MF__basic__input medium" placeholder="예) 해피펀딩">
				<p class="MF__basic__warning">2~12자의 이름을 입력해주세요</p>
				<p class="MF__basic__title">메인(썸네일) 사진</p>
				<p class="MF__basic__description">JPG, PNG 형식, 250 X 140 픽셀</p>
				<label class="MF__basic__addImage__label"><input type="file"
							class="MF__basic__addImage" accept="image/png, image/jpeg"> 이미지
							추가</label>
				<p class="MF__basic__description">썸네일 미리보기</p>
				<div class="MF__basic__imgPreview"></div>
				<p class="MF__basic__warning">썸네일 이미지는 필수입니다.</p>
				<p class="MF__basic__title">펀딩 목표금액</p>
				<p class="MF__basic__description">목표금액이 달성되지 않으면 결제, 정산되지 않고, 펀딩은 무효 처리됩니다.</p>
				<input class="MF__basic__input small" type="number">
				<p class="MF__basic__warning">10만원 ~ 10억원 이내로 입력해주세요</p>
				<p class="MF__basic__title">펀딩 오픈일</p>
				<p class="MF__basic__description">펀딩을 시작할 날짜를 선택해주세요</p>
				<input class="MF__basic__input small" type="date">
				<p class="MF__basic__warning">오픈일을 오늘 이후로 설정해주세요</p>
				<p class="MF__basic__title">펀딩 종료일</p>
				<p class="MF__basic__description">종료일까지 목표금액이 달성된 경우 종료일에 일괄 결제됩니다.</p>
				<input class="MF__basic__input small" type="date">
				<p class="MF__basic__warning">종료일은 오픈일보다 최소 5일 이후여야 합니다.</p>
				<p class="MF__basic__title">배송비</p>
				<p class="MF__basic__description">펀딩 건 당 배송비를 알려주세요</p>
				<input class="MF__basic__input small" type="number" value="2500">
				<div class="MF__moveTab">
					<p class="MF__moveTab__btn dimmed">이전</p>
					<p class="MF__moveTab__btn" onclick="moveTab(1, 2)">다음</p>
				</div>
			</div>
			
			<div class="MF__tabContent" id="tabContent__2">
				<h3 class="MF__subtitle">STEP2 - 리워드 정보 입력</h3>
				<div class="MF__rewards" id="MF_rewards">
					<div class="MF__reward">
						<img src="/funding/assets/close.svg" class="MF__reward__close">
						<div class="MF__reward__liner">
							<p>리워드 내용</p>
							<input class="MF__reward__content" placeholder="예)사과 1개 + 배 2개">
						</div>
						<div class="MF__reward__liner">
							<p>후원 금액(원)</p>
							<input type="number" value="10000">
						</div>
						<div class="MF__reward__liner">
							<p>최대 수량</p>
							<input type="number" value="99">
						</div>
						<div class="MF__reward__warningBox">
							<p class="MF__reward__warning content">리워드 내용을 5자 이상으로
								입력해주세요.</p>
							<p class="MF__reward__warning price">최소 후원 금액은 1,000원입니다.</p>
							<p class="MF__reward__warning amount">최소 수량은 1개입니다.</p>
						</div>
					</div>
				</div>
				<div class="MF__addReward" id="MF__addReward">리워드 종류 추가</div>
				<div class="MF__moveTab">
					<p class="MF__moveTab__btn" onclick="moveTab(2, 1)">이전</p>
					<p class="MF__moveTab__btn" onclick="moveTab(2, 3)">다음</p>
				</div>
			</div>
			<div class="MF__tabContent" id="tabContent__3">
				<h3 class="MF__subtitle">STEP3 - 펀딩 콘텐츠 입력</h3>
				<div class="MF__content" id="MF__content">
					<div class="MF__item">
						<img src="/funding/assets/close.svg" class="MF__close"> <input
							class="MF__input__subTitle" placeholder="소제목을 입력하세요">
					</div>
				</div>
				<div class="MF__addItem">
					<div class="MF__addItem__box">
						<p class="MF__addTitle">소제목 추가</p>
						<p class="MF__addParagraph">본문 추가</p>
						<label class="inputLabel"><input type="file"
							class="MF__addImage" accept="image/png, image/jpeg"> 이미지
							추가</label>
					</div>
				</div>
				<div class="MF__moveTab">
					<p class="MF__moveTab__btn" onclick="moveTab(3, 2)">이전</p>
					<p class="MF__moveTab__btn finish">완료</p>
				</div>
			</div>


		</div>
	</div>
	<script type="text/javascript" src="/funding/libraries/jQuery.js"></script>
	<script type="text/javascript" src="./makeFunding.js"></script>
</body>
</html>