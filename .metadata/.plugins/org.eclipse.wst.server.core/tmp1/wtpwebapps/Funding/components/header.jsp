<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
header {
	width: 100%;
	height: 72px;
	border-bottom: 1px solid #f0f0f0;
	box-sizing: border-box;
}
.header.drop {
  position: fixed;
  animation: dropHeader 0.3s;
  background-color: white;
  z-index: 999;
}

@keyframes dropHeader {
  0% {
    top: -5rem;
  }
  100% {
    top: 0;
  }
}

.header__wrap {
	width: 1080px;
	margin: 0 auto;
	display: flex;
	justify-content: space-between;
	line-height: 71px;
}
.header__wrap h1{
	font-size: 28px;
}

.header__wrap ul{
	display: flex;
	justify-content: space-around;
	width: 480px;
	font-size: 18px;
}
.header__wrap li{
	cursor: pointer;
}
.signedIn_email{
	padding-right: 12px;
	margin-top: 20px;
	margin-right:12px;
	border-right: 1px solid #eee;
	height: 30px;
	line-height: 32px;
}
.makeFunding{
	height: 30px;
	margin-top: 20px;
	margin-left: 12px;
	padding-left: 12px;
	border-left: 1px solid #eee;
	line-height: 31px !important;
	cursor: pointer;
	color: #0091ff;
	
}
#loginZone{
	width: 320px;
	display: flex;
	justify-content: right;
}
</style>
<header class="header">
	<div class="header__wrap">
		<h1 class="font-color-main" onclick="goHome()">해피펀딩</h1>
		<nav>
			<ul>
				<li><a href="/Funding/funding_list_view.do?page=1">펀딩</a></li>
				<li><a href="/Funding/notice_list.do?page=1">공지사항</a></li>
				<li><a href="/Funding/systemQuestion_list.do?page=1">Q&A</a></li>
			</ul>
		</nav>
		<div id="loginZone">
			<div class="loginButton">로그인</div>
		</div>
	</div>

</header>
<script src="/Funding/libraries/jQuery.js"></script>
<script>
let header = document.querySelector(".header");
let headerHeight = 72;

let isSeller = "<%=session.getAttribute("isSeller")%>";
if(isSeller != "null"){
	let email = "<%=session.getAttribute("id")%>";
	let txt = '<p class="signedIn_email" onclick="goSMyPage()">'+email+'</p><div class="logoutButton">로그아웃</div><div class="makeFunding">펀딩 만들기</div>';
	document.getElementById("loginZone").innerHTML = txt;
}else{
	let email = "<%=session.getAttribute("id")%>";
	if(email == "null"){
		document.getElementById("loginZone").innerHTML = '<div class="loginButton">로그인</div>';
	}else{
		document.getElementById("loginZone").innerHTML = '<p class="signedIn_email" onclick="goMyPage()">'+email+'</p><div class="logoutButton">로그아웃</div>';
	}
}
window.onscroll = function () {
  if(window.innerHeight > 1200){
	  let windowTop = window.scrollY;
	  	// 스크롤 세로값이 헤더높이보다 크거나 같으면 
		// 헤더에 클래스 'drop'을 추가한다
	  if (windowTop >= headerHeight) {
	    header.classList.add("drop");
	  } 
	  // 아니면 클래스 'drop'을 제거
	  else {
	    header.classList.remove("drop");
	  }
  }
  
};
function goHome(){
	//todo: 작성하던 내용이 사라집니다.
	location.href = "/Funding/main.do?sort=all"
}
$(document).on("click", ".loginButton", function(e){
	e.stopPropagation();
	localStorage.setItem("pastURL", location.href);
	location.href = "/Funding/pages/login.jsp";
})
$(document).on("click", ".logoutButton", function(e){
	e.stopPropagation();
	localStorage.setItem("pastURL", location.href);
	location.href = "/Funding/tempLogoutDo.jsp";
})
$(document).on("click", ".makeFunding", function(e){
	e.stopPropagation();
	location.href = "/Funding/pages/makeFunding.jsp";
})

function goMyPage(){
	location.href = "/Funding/mypage.do?tab=1&page=1"
}
function goSMyPage(){
	location.href = "/Funding/sMypage.do?tab=1&page=1"
}
</script>