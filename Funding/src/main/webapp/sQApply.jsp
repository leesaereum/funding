<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<style>	.ex-layout{ 
		height: 100%;
	 }
	.menu{
		width: 100%;
		height:70px;
		background-color: white;
	}
	.main .left-menu{
		float: left;
		width: 15%;
		height: 750px;
		border: 1px solid;
		padding: 10px
	}
	.main .content{
		float: left;
		width: 1080px;
		height: 850px;
		margin: 10px;
	}
	.main .content .article{
		height:100px;
	}
	
</style>
<header class="header">
	<div class="header__wrap">
		<h1 class="font-color-main" onclick="goHome()">해피펀딩</h1>
		<nav>
			<ul>
				<li>펀딩</li>
				<li>캠페인</li>
				<li>Q&A</li>
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
let email = "<%=session.getAttribute("seller_id")%>";
let email = "<%=session.getAttribute("email")%>";
if(email == "null"){
	document.getElementById("loginZone").innerHTML = '<div class="loginButton">로그인</div>';
}else{
	document.getElementById("loginZone").innerHTML = '<p class="signedIn_email">'+email.split("@")[0]+' 님</p><div class="logoutButton">로그아웃</div>';
}
let isSeller = "<%=session.getAttribute("isSeller")%>";
if(isSeller != "null"){
	let txt = document.getElementById("loginZone").innerHTML;
	txt += '<div class="makeFunding">펀딩 만들기</div>';
	document.getElementById("loginZone").innerHTML = txt;
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
	location.href = "/Funding/main.jsp"
}
$(document).on("click", ".loginButton", function(e){
	e.stopPropagation();
	localStorage.setItem("pastURL", location.href);
	location.href = "/Funding/slogin.jsp";
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
</script>

</head>
<body>
<div class="ex-layout">
		<div class="menu"><h2 align="right">판매자 신청페이지&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;</h2><hr></div>
		<div class="main">
			<div class="left-menu">
			
			</div>
			<div class="content">
				<form action="main.do">
				<div class="article">
				업체명 <input type = "text" name="seller_name" value="${ssignUp_view.seller_name }">
				</div> 
				
				<div class="article">
				상세설명 <textarea name="contents" rows="3" cols="50"></textarea>
				</div>
				
				<div class="article">
				사업자등록번호 <input type="text" name="seller_number" size= "30" value= "${ssignUp_view.seller_number }">
				</div>
				
				<div class="article">
				주소
				</div>
				
				<div class="article">
				신청자명 <input type="text" name="seller_person_name" value="${ssignUp_view.seller_person_name }">
				</div>
				
				<div class="article">
				신청자 전화번호 <input type="text" name="seller_person_number" value="${ssignUp_view.seller_person_number }">
				</div>
				<div class="article" align="right">
				<input type="submit" value="신청하기">
				</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>