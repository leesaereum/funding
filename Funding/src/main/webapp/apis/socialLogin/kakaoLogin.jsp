<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    	.kakaoLoginBtnBox{
    		width: 280px;
    		height: 40px;
    		margin-bottom: 8px;
    		background-color: #FDE500;
    		overflow: hidden;
    	}
    	.kakaoLoginBtnBox p{
    		text-decoration:: none;
    		margin: 0;
    		line-height: 42px;
    		float:left;
    	}
    	.kakaoLoginBtnBox img{
    		height: 100%;
    		width: auto;
    		margin-right: 24px;
    		float:left;
    	}
    </style>
</head>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
        // SDK를 초기화 합니다. 사용할 앱의 JavaScript 키를 설정해 주세요.
        Kakao.init('44993a5d29aa35a541ed1e2b03308678');

        // SDK 초기화 여부를 판단합니다.
        console.log(Kakao.isInitialized());
    </script>
<body>
<a id="custom-login-btn" href="javascript:loginWithKakao()">
<div class="kakaoLoginBtnBox">
	<img
    src="/Funding/apis/socialLogin/kakaoBtn.png"
    width="222"
    alt="카카오 로그인 버튼"
  />
  <p>카카오 로그인</p>
</div>
  
</a>
<script type="text/javascript">
  function loginWithKakao() {
	  
		  
    Kakao.Auth.login({
    	success: function(authObj) {
		      Kakao.API.request({
		        url: '/v2/user/me',
		        success: function(res) {
		          var form = document.createElement('form'); // 폼객체 생성
		          var objs;
		          objs = document.createElement('input'); // 값이 들어있는 녀석의 형식
		          objs.setAttribute('type', 'text'); // 값이 들어있는 녀석의 type
		          objs.setAttribute('name', 'email'); // 객체이름
		          objs.setAttribute('value', res.kakao_account.email); //객체값
		          form.appendChild(objs);
		          form.setAttribute('id', 'tempForm');
		          form.setAttribute('method', 'post'); //get,post 가능
		          form.setAttribute('action', "/Funding/socialLogin.do"); //보내는 url > 나중에 login.do로 보내야 함;
		          document.body.appendChild(form);
		          form.submit();
		        },
		        fail: function(error) {
		          alert(
		            'login success, but failed to request user information: ' +
		              JSON.stringify(error)
		          )
		        },
		      })
		    },
      fail: function(err) {
        alert(JSON.stringify(err))
      },
    })
  }
  
  
</script>
</body>
</html>