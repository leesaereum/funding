<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/funding/styles/init.css">
<link rel="stylesheet" href="/funding/styles/base.css">
<link rel="stylesheet" href="./detail.css">
<title>Insert title here</title>
</head>
<%
String fid = request.getParameter("fid");
if (fid == null) {
	response.sendRedirect("/funding/main.jsp");
}
%>
<script type="text/javascript" src="/funding/libraries/jQuery.js"></script>
<script type="text/javascript" src="./detail.js"></script>
<body>
	<jsp:include page="/components/header.jsp" />
	<div class="detail__wrap">
		<div class="detail__left">
			<div class="detail__top__imgBox">
				<img class="detail__top__img"
					src='/funding/assets/thumbs/optimize (<%=request.getParameter("fid")%>).jpeg'>
			</div>
			<div class="detail__content__tab">
				<p class="detail__tab__tab detail__tab__selected" data-id="story">스토리</p>
				<p class="detail__tab__tab" data-id="participants">참여자</p>
				<p class="detail__tab__tab" data-id="reviews">후기</p>
			</div>
			<div class="detail__content__tabs__box">
				<div class="detail__tab selected" id="tab-story">
					<h3>100% 국산 쌀로 만든 떢복이 밀키트</h3>
					<p>안녕하세요. 특허받은 쌀가루 반죽으로 돈까스를 만드는 사회적 기업인 윤푸드가 포항 마을 기업과 협업하여
						말랑말랑 국내산 떡볶이를 탄생시켰습니다. 방부제 없이 건강한 100% 국산 쌀로 만든 떡은 말랑말랑한 식감을 자랑하며
						급속 냉동으로 언제 드셔도 갓만든 떡 느낌을 받으실 수 있습니다. 또한 치즈떡은 떡안 가득찬 치즈로 고소한 맛이
						일품입니다. 이로우니 떡볶이는 마을 기업에서 만든 쌀떡을 사용하여 농가소득에도 기여를 하고 있습니다.</p>
					<img src='/funding/assets/thumbs/optimize (5).jpeg'>

					<h3>고용과 기부를 하기 위해 제품을 파는 기업</h3>
					<p>윤푸드는 경산시 인증사회적기업으로 취약계층과 청년 일자리 창출에 앞장서고 있습니다. 지난 돈까스 펀딩을 통해
						기부 및 청년일자리 창출 1명을 하였으나, 신제품도 생기고 온라인 매출도 늘면서 청년일자리 인원을 1명 더 채용할
						계획을 가지고 있습니다. 펀딩 금액이 청년일자리 창출을 위한 크나큰 도움이 될 것입니다. 제품을 팔기위해 사람을 고용
						하는 것이 아니라 고용하기 위해 제품을 파는 기업으로 좋은일을 하면서 수익을 내는 기업이 되겠습니다.</p>
					<img src='/funding/assets/thumbs/optimize (7).jpeg'>

					<h3>100% 국산 쌀로 만든 떢복이 밀키트</h3>
					<p>안녕하세요. 특허받은 쌀가루 반죽으로 돈까스를 만드는 사회적 기업인 윤푸드가 포항 마을 기업과 협업하여
						말랑말랑 국내산 떡볶이를 탄생시켰습니다. 방부제 없이 건강한 100% 국산 쌀로 만든 떡은 말랑말랑한 식감을 자랑하며
						급속 냉동으로 언제 드셔도 갓만든 떡 느낌을 받으실 수 있습니다. 또한 치즈떡은 떡안 가득찬 치즈로 고소한 맛이
						일품입니다. 이로우니 떡볶이는 마을 기업에서 만든 쌀떡을 사용하여 농가소득에도 기여를 하고 있습니다.</p>
					<img src='/funding/assets/thumbs/optimize (8).jpeg'>

					<h3>고용과 기부를 하기 위해 제품을 파는 기업</h3>
					<p>윤푸드는 경산시 인증사회적기업으로 취약계층과 청년 일자리 창출에 앞장서고 있습니다. 지난 돈까스 펀딩을 통해
						기부 및 청년일자리 창출 1명을 하였으나, 신제품도 생기고 온라인 매출도 늘면서 청년일자리 인원을 1명 더 채용할
						계획을 가지고 있습니다. 펀딩 금액이 청년일자리 창출을 위한 크나큰 도움이 될 것입니다. 제품을 팔기위해 사람을 고용
						하는 것이 아니라 고용하기 위해 제품을 파는 기업으로 좋은일을 하면서 수익을 내는 기업이 되겠습니다.</p>
					<img src='/funding/assets/thumbs/optimize (9).jpeg'>
				</div>
				<div class="detail__tab" id="tab-participants">
					<p class="detail__participant__title">참여내역</p>
					<div class="detail__participant__number">총 78명이 참여하였습니다.</div>
					<ul class="detail__participant__list">
						<li>
							<p class="detail__participant__date">2022.04.05 16:40:42</p>
							<div class="detail__participant__bottom">
								<p class="detail__participant__id">dpqhs78님</p>
								<p class="detail__participant__amount"><span>32,000</span>원 참여</p>
							</div>
						</li>
						<li>
							<p class="detail__participant__date">2022.04.05 16:40:42</p>
							<div class="detail__participant__bottom">
								<p class="detail__participant__id">dpqhs78님</p>
								<p class="detail__participant__amount"><span>32,000</span>원 참여</p>
							</div>
						</li>
						<li>
							<p class="detail__participant__date">2022.04.05 16:40:42</p>
							<div class="detail__participant__bottom">
								<p class="detail__participant__id">dpqhs78님</p>
								<p class="detail__participant__amount"><span>32,000</span>원 참여</p>
							</div>
						</li>
						<li>
							<p class="detail__participant__date">2022.04.05 16:40:42</p>
							<div class="detail__participant__bottom">
								<p class="detail__participant__id">dpqhs78님</p>
								<p class="detail__participant__amount"><span>32,000</span>원 참여</p>
							</div>
						</li>
						<li>
							<p class="detail__participant__date">2022.04.05 16:40:42</p>
							<div class="detail__participant__bottom">
								<p class="detail__participant__id">dpqhs78님</p>
								<p class="detail__participant__amount"><span>32,000</span>원 참여</p>
							</div>
						</li>
						<li>
							<p class="detail__participant__date">2022.04.05 16:40:42</p>
							<div class="detail__participant__bottom">
								<p class="detail__participant__id">dpqhs78님</p>
								<p class="detail__participant__amount"><span>32,000</span>원 참여</p>
							</div>
						</li>
					</ul>
				</div>
				<div class="detail__tab" id="tab-reviews"></div>
			</div>

		</div>

		<div class="detail__right">
			<p class="detail__dday">D-35</p>
			<h1 class="detail__title">국산 쌀과 고춧가루로 만든 말랑말랑 쌀떡볶이</h1>
			<p class="detail__rate__txt">
				197<span>%</span>
			</p>
			<div class="detail__rate__box">
				<div class="detail__rate__rate" style="width: 90%"></div>
			</div>
			<div class="detail__amount__box">
				<p class="detail__amount__goal">1,000,000원 목표</p>
				<p class="detail__amount__funded">
					1,971,000<span>원</span>
				</p>
			</div>
			<div class="detail__seller__box">
				<div class="detail__seller__logo__box">
					<img class="detail__seller__logo"
						src='/funding/assets/thumbs/optimize (<%=request.getParameter("fid")%>).jpeg'>
				</div>
				<div class="detail__seller__nameAndDetail">
					<p class="detail__seller__name">윤푸드</p>
					<p class="detail__seller__detail">모두를 이롭게 하는 먹거리</p>
				</div>
			</div>

			<div class="detail__funding__form">
				<div class="detail__funding__select">
					<div class="detail__funding__btnBox">
						<p>리워드 선택하기</p>
						<img src="/funding/assets/arrow-down.svg">
					</div>
					<div class="detail__funding__options" id="funding__options">
						<p onclick="add__option(1)">치즈떡 2팩+쌀떡2팩+어묵2팩+소스분말4팩(짜장맛2/보통맛2)</p>
						<p onclick="add__option(2)">치즈떡
							2팩+쌀떡2팩+어묵2팩+소스분말4팩(짜장맛2/보통맛2)+등심돈까스2팩</p>
						<p onclick="add__option(3)">치즈떡
							2팩+쌀떡2팩+어묵2팩+소스분말4팩(짜장맛2/보통맛2)+등심돈까스2팩+치즈돈까스2팩</p>
					</div>
				</div>
				<div class="detail__funding__selected__box" id="selected__box"></div>
				<div class="detail__funding__total__box">
					<p class="detail__funding__total__amount">총 수량 0개</p>
					<p class="detail__funding__total__totalPrice">
						총 금액<strong>0</strong><span>원</span>
					</p>
				</div>
			</div>
			<div class="detail__funding__deliveryFee">
				<p>배송비</p>
				<p>무료</p>
			</div>
			<div class="detail__funding__buttonZone">
				<p class="detail__funding__join">펀딩 참여하기</p>
				<div class="detail__funding__share"
					onclick="share(<%=request.getParameter("fid")%>)">
					<img src="/funding/assets/share.svg">
				</div>
			</div>

			<div class="detail__funding__rewards">
				<p class="detail__funding__rewards__title">리워드 안내</p>
				<div class="detail__funding__reward">
					<div class="detail__funding__reward__top">
						<p class="detail__funding__reward__price">
							<span>20,000원</span> 펀딩 참여
						</p>
						<p class="detail__funding__reward__left">
							<span>67</span>개 남음
						</p>
					</div>
					<div class="detail__funding__reward__bottom">
						<p class="detail__funding__reward__optionName">치즈떡
							2팩+쌀떡2팩+어묵2팩+소스분말4팩(짜장맛2/보통맛2)</p>
						<p class="detail__funding__reward__count">현재 31명 펀딩 참여</p>
					</div>
				</div>
				<div class="detail__funding__reward">
					<div class="detail__funding__reward__top">
						<p class="detail__funding__reward__price">
							<span>20,000원</span> 펀딩 참여
						</p>
						<p class="detail__funding__reward__left">
							<span>67</span>개 남음
						</p>
					</div>
					<div class="detail__funding__reward__bottom">
						<p class="detail__funding__reward__optionName">치즈떡
							2팩+쌀떡2팩+어묵2팩+소스분말4팩(짜장맛2/보통맛2)</p>
						<p class="detail__funding__reward__count">현재 31명 펀딩 참여</p>
					</div>
				</div>
				<div class="detail__funding__reward">
					<div class="detail__funding__reward__top">
						<p class="detail__funding__reward__price">
							<span>20,000원</span> 펀딩 참여
						</p>
						<p class="detail__funding__reward__left">
							<span>67</span>개 남음
						</p>
					</div>
					<div class="detail__funding__reward__bottom">
						<p class="detail__funding__reward__optionName">치즈떡
							2팩+쌀떡2팩+어묵2팩+소스분말4팩(짜장맛2/보통맛2)</p>
						<p class="detail__funding__reward__count">현재 31명 펀딩 참여</p>
					</div>
				</div>
			</div>
		</div>
		<div id="toast"></div>
	</div>
</body>
</html>