<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 신청페이지</title>

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
</head>

</head>
<body>
	<%
		String address=request.getParameter("address_state") + " " +request.getParameter("address_city")
							+ " " +request.getParameter("address_line");
	%>
	<div class="ex-layout">
		<div class="menu"><h2 align="right">판매자 신청페이지&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;</h2><hr></div>
		<div class="main">
			<div class="left-menu">
			
			</div>
			<div class="content">
				<form action="sQApply.jsp" method="post">
				<div class="article">
				업체명 <input type = "text" name="seller_name" value="<%=request.getParameter("seller_name") %>">
				</div> 
				
				<div class="article">
				사업자등록번호 <input type="text" name="seller_number" size= "30" value= "<%=request.getParameter("seller_number") %>">
				</div>
				
				<div class="article">
				주소 <input type="text" name="address" size="30" value="<%=address %>">
				</div>
				
				<div class="article">
				신청자명 <input type="text" name="seller_person_name" value="<%=request.getParameter("seller_person_name") %>">
				</div>
				
				<div class="article">
				신청자 전화번호 <input type="text" name="seller_person_number" value="<%=request.getParameter("seller_person_number") %>">
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