<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Funding/styles/init.css">
<link rel="stylesheet" href="/Funding/styles/base.css">
<link rel="stylesheet" href="/Funding/pages/detail.css">
<title>펀딩 상세페이자</title>
</head>
<%
String fid = request.getParameter("fid");
if (fid == null) {
	response.sendRedirect("/Funding/main.jsp");
}
%>
<script type="text/javascript" src="/Funding/libraries/jQuery.js"></script>
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript" src="/Funding/pages/detail.js"></script>

<body>
	<jsp:include page="/components/header.jsp" />
	<div class="detail__wrap">
		<div class="detail__left">
			<div class="detail__top__imgBox">
								<c:forEach items="${funding }" var="funding">
			
				<img class="detail__top__img"
					src="${funding.funding_banner}">
								</c:forEach>
			
			</div>
			<div class="detail__content__tab">
				<p class="detail__tab__tab detail__tab__selected" data-id="story">스토리</p>
				<p class="detail__tab__tab" data-id="participants">참여자</p>
				<p class="detail__tab__tab" data-id="questions">Q&A</p>
				<p class="detail__tab__tab" data-id="reviews">후기</p>
			</div>
			<div class="detail__content__tabs__box">
				<div class="detail__tab selected" id="tab-story">

					<c:forEach items="${funding }" var="funding">
						<h3>${funding.funding_title}</h3>
					
							${funding.content_content}
					</c:forEach>
				</div>
				<div class="detail__tab" id="tab-participants">
					<p class="detail__participant__title">참여내역</p>
					<div class="detail__participant__number">총 78명이 참여하였습니다.</div>
					<ul class="detail__participant__list">
						<c:forEach items="${orderList }" var="orderDtos">
					
						<li>
							<p class="detail__participant__date">2022.04.07 16:40:42</p>
							<div class="detail__participant__bottom">
								<p class="detail__participant__id">${orderDtos.order_customer}</p>
								<p class="detail__participant__amount">
									<span>100,000</span>원 참여
								</p>
							</div>
						</li>
</c:forEach>
					</ul>
				</div>
				<div class="detail__tab" id="tab-questions">
					<!-- 구매자면 질문창, 판매자면 답변창 -->
					<div class="detail__qna__new__box">
						<form action="/fundingQuestion.do" method="post">
							<input class="detail__qna__new__input" name="question_content">
							<div class="detail__qna__new__submit__box">
								<input class="detail__qna__new__submit" type="submit"
									value="새 문의 등록">
							</div>
						</form>
					</div>
					<c:forEach items="${questionList }" var="dtoQuestion">

						<div class="detail__qna__box">
							<p class="detail__qna__question">Q. ${dtoQuestion.question_content}</p>
							<p class="detail__qna__answer">A. ${dtoQuestion.question_answer}</p>
							<p class="detail__qna__date">${dtoQuestion.question_at}</p>
						</div>
						
					</c:forEach>

				</div>
				<div class="detail__tab" id="tab-reviews"></div>
			</div>

		</div>

		<div class="detail__right">
			<p class="detail__dday">D-35</p>

			<c:forEach items="${funding }" var="funding">
				<h1 class="detail__title">${funding.funding_title}</h1>
			</c:forEach>
			<p class="detail__rate__txt">
				197<span>%</span>
			</p>
			<div class="detail__rate__box">
				<div class="detail__rate__rate" style="width: 90%"></div>
			</div>
			<div class="detail__amount__box">
				<c:forEach items="${funding }" var="funding">
					<p class="detail__amount__goal">${funding.funding_purpose}</p>
				</c:forEach>
				<p class="detail__amount__funded">
					1,971,000<span>원</span>
				</p>
			</div>
			<div class="detail__seller__box">
				<div class="detail__seller__logo__box">
					<img class="detail__seller__logo"
						src='/Funding/assets/thumbs/optimize (<%=request.getParameter("fid")%>).jpeg'>
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
						<img src="/Funding/assets/arrow-down.svg">
					</div>
					<div class="detail__funding__options" id="funding__options">
						<c:forEach items="${optionList }" var="option" varStatus="status">

							<p onclick="add__option(${option.option_num}, '${option.option_name}')">${option.option_name}</p>
							<input type="hidden" readonly="readonly"
								id="optionPrice_${option.option_num}" value="${option.option_price}">
						</c:forEach>
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
				<p class="detail__funding__join" onclick="joinFunding()">펀딩 참여하기</p>
				<div class="detail__funding__share" id="funding__isLiked">
					
				</div>
			</div>

			<div class="detail__funding__rewards">
				<p class="detail__funding__rewards__title">리워드 안내</p>
				<c:forEach items="${optionList }" var="option" varStatus="status">

					<div class="detail__funding__reward">
						<div class="detail__funding__reward__top">
							<p class="detail__funding__reward__price">
								<span>${option.option_price}</span> 펀딩 참여
							</p>
							<p class="detail__funding__reward__left">
								<span>67</span>개 남음
							</p>
						</div>
						<div class="detail__funding__reward__bottom">
							<p class="detail__funding__reward__optionName">${option.option_name}</p>
							<p class="detail__funding__reward__count">현재 31명 펀딩 참여</p>
						</div>
					</div>

				</c:forEach>

			</div>
		</div>

		<div id="toast"></div>
	</div>
	<input type="hidden" value="<%=request.getParameter("fid")%>" readonly="readonly" id="fidfid">
	<div class="detail__popup__wrap"></div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		let isLike = ${isLike}
		if(isLike){
			$("#funding__isLiked").addClass("liked").html('<img src="/Funding/assets/heart_filled.png">')
		}else{
			$("#funding__isLiked").removeClass("liked").html('<img src="/Funding/assets/heart_blank.png">')

		}
	})
	$("#funding__isLiked").click(function(){
		let cid = "<%=session.getAttribute("email")%>"
		let fid = <%=request.getParameter("fid")%>
		if(cid === null){
			alert("먼저 로그인 해주세요!")
		}else{
			if($(this).hasClass("liked")){
				location.href = "/Funding/fundingUnLike.do?customer_id="+cid+"&funding_num="+fid
			}else{
				location.href = "/Funding/fundingLike.do?customer_id="+cid+"&funding_num="+fid
			}
		}
		
	})
</script>
</html>