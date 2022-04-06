<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>네이버로그인</title>
    <style type="text/css">
    	.naverLoginBtnBox{
    		width: 280px;
    		height: 40px;
    		background-color: #04C65A;
    		overflow:hidden;
    	}
    	.naverLoginBtnBox p{
    		text-decoration:: none;
    		margin: 0;
    		color: white;
    		line-height: 42px;
    		float:left;
    	}
    	.naverLoginBtnBox img{
    		height: 100%;
    		width: auto;
    		margin-right: 24px;
    		float:left;
    	}
    </style>
  </head>
  <body>
  <%
    String clientId = "iIw2A5asbDFs4SJShyZr";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http://localhost:8080/Funding/pages/naverLoginCallback.jsp", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
 %>
  <a href="<%=apiURL%>"><div class="naverLoginBtnBox"><img height="50" src="/Funding/apis/socialLogin/naverBtn.png"/><p>네이버 로그인</p></div></a>
  </body>
</html>