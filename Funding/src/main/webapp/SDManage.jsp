<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 발송 관리페이지</title>
</head>
<script type="text/javascript">
</script>
<style>
.grid {
   border: 1px solid #bcbcbc;
   display: table;
   width: 100%;
}
.rows{
	display: table-row;
}
.cells .left-menu{
		float: left;
		width: 15%;
		height: 750px;
		border: 1px solid;
		padding: 30px
}
.cells{
 	 display: table-cell;
     padding: 0px 20px;
     height: 150px;
     text-align : center;
}

</style>
<body>
	<h3>Open 펀딩 배송관리</h3>
	<div class = "grid">
		<div class = "rows">
		<div class="left-menu" align="center">
			<p>발송/배송상태</p>	
		</div>
		 	<div class = "cells">
			<p class = "delivery_state">미발송</p>
			<p>test</p>
			</div>
			<div class = "cells">
			<p class = "delivery_state">배송중</p>
			<p>test</p>
			</div>
			<div class = "cells">
			<p class = "delivery_state">배송완료</p>
			<p>test</p>
			</div>
		</div>
	</div>	
	<div class = "grid">
	<div class = "rows">
		<div class="left-menu" align="center">
			<p>펀딩 상태</p>	
		</div>
		 	<div class = "cells">
			<p class = "funding_state">신청</p>
			<p>test</p>
			</div>
			<div class = "cells">
			<p class = "funding_state">완료</p>
			<p>test</p>
			</div>
			<div class = "cells">
			<p class = "funding_state">거절</p>
			<p>test</p>
			</div>	
	</div>
	</div>
	<div class = "grid">
	<p align="right"><input type="submit" name="applyBtn" value="정산신청"></p>
	</div>
</body>
</html>