<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <title>로그인</title>
    <style>
        body {
            background-color: #F9F9F9;
            font-family: 'Nanum Pen Script', cursive;
            background: url("/img/다운로드파일.jpg") center/cover no-repeat;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background-size: 100% 100%;
        }

        h2 {
            text-align: center;
            font-size: 1.8rem;
            font-weight: bold;
            margin-bottom: 60px;
            font-family: 'Nanum Pen Script', cursive;
        }

        input#user_id {
            width: 300px;
            margin-bottom: 10px;
            text-align: center;
            padding: 10px;
            border: none;
            border-radius: 5px;
            box-shadow: 1px 1px 3px #ccc;
            margin-left: 100px;
            font-family: 'Nanum Pen Script', cursive;
        }

        input#user_pwd {
            width: 300px;
            margin-bottom: 10px;
            text-align: center;
            padding: 10px;
            border: none;
            border-radius: 5px;
            box-shadow: 1px 1px 3px #ccc;
            margin-left: 50px;
            font-family: 'Nanum Pen Script', cursive;
        }

        button {
            margin-left: 25px;
            padding: 9px 18px;
            border: none;
            border-radius: 4px;
            background-color: #FF4500;
            color: #FFFFFF;
            cursor: pointer;
            font-size: 14px;
            font-weight: bold;
            font-family: 'Nanum Pen Script', cursive;
            transition: background-color 0.3s ease;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
            box-sizing: border-box;
        }

        button:hover {
            background-color: #FFA500;
        }

        button:focus {
            outline: none;
        }

        .login_warn {
            color: red;
            animation: blink 1s infinite;
            text-align: center;
            display: inline-block;
            margin-left: 70px;
            font-family: 'Nanum Pen Script', cursive;
        }

        @keyframes blink {
            0% { opacity: 1.0; }
            50% { opacity: 0.0; }
            100% { opacity: 1.0; }
        }

        .separator {
            margin: 0 5px;
            color: #333333;
        }

        .signup-container {
            text-align: center;
            margin-top: 35px;
        }

        .signup {
            display: inline-block;
            margin-right: 5px;
        }

        .signup:last-child {
            margin-right: 0;
        }
        /* 원 모양의 컨테이너를 위한 클래스 정의 */
  .circular-container {
    display: inline-block; /* 이렇게 설정하면 컨테이너의 너비가 폼의 너비와 일치합니다 */
    border-radius: 100%; /* 원 모양으로 만듭니다 */
    background-color: white; /* 배경 색상을 추가합니다 */
    padding: 50px; /* 폼과 컨테이너 사이의 간격을 설정합니다 */
  }
    </style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function login() {
	    var loginForm = document.loginForm;
	    var user_id = $("#user_id").val();
	    var user_pwd = $("#user_pwd").val();
	    var remember = $("#remember").prop("checked") ? "on" : "off";
	    
	    
	    
	    if (user_id == '' && user_pwd == '') {
	        alert('아이디와 비밀번호를 입력하세요');
	        console.log(remember);
	    } else if (user_id == '' && user_pwd != '') {
	        alert('아이디를 입력하세요.');
	    } else if (user_id != '' && user_pwd == '') {
	        alert('비밀번호를 입력하세요.');
	    } else if (user_id == null) {
	        alert('아이디 비밀번호를 확인하세요.');
	    } else {            
	        $("#loginForm").attr("action", "/loginCheck");
	        $("#loginForm").append('<input type="hidden" name="remember" value="' + remember + '">');
	        $("#loginForm").submit();
	        return true;
	    }        
	}	
			var login_warn = $(".login_warn");
			var login_warnVal = $(".login_warn").val();			
			
			console.log("login_warn == " + login_warn);
			console.log("login_warnVal == " + login_warnVal);			
	
</script>
</head>
<%@ page import="com.web.test.User.vo.UserVo" %>
<%@ page import="com.web.test.User.controller.UserController" %>
<% String remember = (String) session.getAttribute("remember");
UserVo user = null;
if (session.getAttribute("user") instanceof UserVo) {
    user = (UserVo) session.getAttribute("user");
} %>
<body>
<div class="circular-container">	
	<form id="loginForm" method="post">
		<h2><img src="/img/cyworldimg.jpg" style="width: 400px; heigth:400px;"></h2>
		 <p>
            <label for="user_id">ID:</label>
           <input type="text" name="user_id" id="user_id" placeholder="ID를 입력해주세요." 
	        <% String savedUserId = (String) session.getAttribute("savedUserId");
	           if (savedUserId != null && !savedUserId.isEmpty() && remember != null && remember.equals("on")) { %>
	               value="<%= savedUserId %>"
	        <% } %> />
        </p> 		
		<p>
			<label for="user_pwd">PASSWORD:</label>
			<input type="password" name="user_pwd" id="user_pwd" placeholder="비밀번호를 입력해주세요."/>
			<button type="button" onclick="login()">로그인</button>
		</p>
		<c:choose>
			<c:when test="${user == null}">
				<div class="login_warn">${msg}</div>
			</c:when>	
		</c:choose>
		<div class="signup-container">
		<div class="signup" onclick="location.href='./findId'">아이디찾기</div>
		<span class="separator">|</span>
		<div class="signup" onclick="location.href='./findPwd'">비밀번호찾기</div>
		<span class="separator">|</span>
		<div class="signup" onclick="location.href='./signup'">회원가입</div>
		</div>		
	</form>
</div>
</body>
</html>