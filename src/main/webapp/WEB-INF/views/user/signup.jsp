<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/header.jsp"/>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<title>회원가입</title>
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
    h1 {
        font-size: 3.0rem;
        font-weight: bold;
        font-family: 'Nanum Pen Script', cursive;
        position: absolute;
        top: 1px; 
        left: 20px; 
    }
     .form-label {
        font-size: 1.2rem;
    }

    .form-label::after {
        content: "*";
        color: red;
        margin-left: 4px;
    }
	.input-underline {
        border: none;
        border-bottom: 2px solid black; 
        outline: none;
        font-size: 1.2rem; 
        padding: 5px 10px; 
        width: 700px;
        background-color: transparent;
        font-family: 'Nanum Pen Script', cursive;
    }
	
	.input-underline:focus {
	  border-color: blue;
	}
	
	button {
            margin-left: 642px;
            margin-top: 20px;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            background-color: #FF4500;
            color: #FFFFFF;
            cursor: pointer;
            font-size: 16px;        		
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
         #checkUsernameBtn {
	        margin-left: 640px;
            padding: 5px 10px;
            border: none;
            border-radius: 4px;
            background-color: gray;
            color: #FFFFFF;
            cursor: pointer;
            font-size: 14px;
            font-weight: bold;
            font-family: 'Nanum Pen Script', cursive;
            transition: background-color 0.3s ease;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
            box-sizing: border-box;
	    }
	   #findAddressBtn {
	  		margin-left: 50px;
            padding: 5px 10px;
            border: none;
            border-radius: 4px;
            background-color: gray;
            color: #FFFFFF;
            cursor: pointer;
            font-size: 14px;
            font-weight: bold;
            font-family: 'Nanum Pen Script', cursive;
            transition: background-color 0.3s ease;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
            box-sizing: border-box;
	   }
	         /* 원 모양의 컨테이너를 위한 클래스 정의 */
  .circular-container {
    display: inline-block; /* 이렇게 설정하면 컨테이너의 너비가 폼의 너비와 일치합니다 */
    border-radius: 100%; /* 원 모양으로 만듭니다 */
    background-color: white; /* 배경 색상을 추가합니다 */
    padding: 50px; /* 폼과 컨테이너 사이의 간격을 설정합니다 */
  }
  
   /* 폼 컨테이너에 대한 스타일 */
  .form-container {
    max-width: auto; /* 폼의 최대 너비를 설정 */
    margin: 0 auto; /* 폼을 수평 가운데로 정렬 */
    padding: 20px; /* 폼과 테두리 간의 간격을 설정 */
    border: 2px solid #ccc; /* 테두리 스타일과 색상 설정 */
    border-radius: 10px; /* 네모 테두리를 둥글게 만듭니다 */
    background-color: #f2f2f2; /* 배경 색상 설정 */
  }

  /* 폼 내부의 요소들의 간격을 설정 */
  .form-container > * {
    margin-bottom: 10px;
  }
</style>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function() {		
		var exist = false;
		//중복확인 버튼 클릭시
		$('#checkUsernameBtn').on('click', function() {
			//입력된 아이디를 가져옴
			var id = $('#user_id').val();
			//아이디가 입력되지 않았을 경우			
			var regex = /^[A-Za-z0-9_]+$/; // 영문 대/소문자, 숫자, 특수문자 _ 만 허용하는 정규식 패턴
			

			if(!id) {
				alert('아이디를 입력해주세요.');
				return;
			}
			
			if(!regex.test(id)) {
				alert('아이디는 영문 대/소문자, 숫자, 특수문자(_)로만 이루어져야 합니다.');
				return;
			} else if(id.length < 4 || id.length > 12) {
				alert('아이디는 4글자 이상 12글자 이하여야됩니다.');
				return;
			}			
			//AJAX 요청 보내기
			$.ajax({
				type: 'POST',	//타입확인
				url: '/checkIdDuplicate',	//url확인
				data: {id: id},
				dataType: "json",
				success: function(result) {
					console.log(result);
					if (result.result === "notExist") {
			            alert('사용 가능한 아이디입니다.');
			        } else {
			        	console.log(result.reuslt);
			           alert('이미 사용중인 아이디입니다.');
			        } 
				},
				error: function() {
					alert('서버 오류가 발생했습니다.');
				}
			});
		});
	});
	//입력 없을시 알림
	function validate() {
		var userId = $('#user_id').val();
		var userName = $('#user_name').val();
		var userPwd = $('#user_pwd').val();
		var phone = $('#phone').val();
		var address = $('#address').val();
		
		/*if(!emailRegex.test(email)) {
			alert('이메일의 형태가 아닙니다.');
			return;
		} */
		
		if(!userId) {
			alert('아이디를 입력해주세요.');
			return;
		}else if(!userName) {
			alert('이름을 입력해주세요.');
			return;
		}else if(!userPwd) {
			alert('비빌번호를 입력해주세요.');
			return;
		}else if(!phone) {
			alert('전화번호를 입력해주세요.');
			return;
		}else if(!address) {
			alert('주소를 입력해주세요.');
			return;			
		}else {
			$('#registerForm').attr("action", "/signupOk");
			alert("회원가입이 성공하였습니다.");
			$('#registerForm').submit();
		}
	} 
</script>
<body>
<div class="form-container">
	<h1>회원가입</h1>
  <form id="registerForm" method="post">
    <div>
      <label class ="form-label">ID </label> 
      <button type="button" id="checkUsernameBtn">중복확인</button><br>
      <input type="text" id="user_id" name="user_id" class="input-underline">      
    </div><br>
    <div>
      <label class ="form-label">이름 </label><br>
      <input type="text" id="user_name" name="user_name" class="input-underline">
    </div><br>
    <div>
      <label class = "form-label">비밀번호 </label><br>
      <input type="password" id="user_pwd" name="user_pwd" class="input-underline">
    </div><br>
    <div>
      <label class ="form-label">휴대폰번호 </label><br>             
         <input type="text" id="phone" class="input-underline"name="phone" placeholder="-를 제외한 숫자만 입력하세요">    
    </div><br>
    <div>
      <label class = "form-label" id="taddress">주소 </label>
        <input type="button" onclick="execDaumPostcode()" value="주소찾기" id ="findAddressBtn" ><br>    
        <input type="text" id="postcode" name="postcode" placeholder="우편번호" class="input-underline" readonly><br>
		<input type="text" id="address" name="address" placeholder="주소" class="input-underline"><br>
		<input type="text" id="detailaddress" name="detailaddress" placeholder="상세주소" class="input-underline"><br>
		<input type="text" id="extraaddress" name="extraaddress" placeholder="참고항목"  class="input-underline" readonly><br>
    </div>
    <button type="button" id="register" onclick="validate()">회원가입</button>
  </form>
  </div>
</body>
</html>