<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<title>비밀번호 찾기</title>
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
//휴대폰번호 유효성 검사 함수
function isValidPhoneNumber(phoneNumber) {
    // 숫자만으로 이루어져야 하며, 12자 이하인 경우 유효한 번호로 간주
    var regex = /^\d{1,12}$/;
    return regex.test(phoneNumber);
}
	
	//입력 없을시 알림
	function validate() {
		var userId = $('#user_id').val();
		var userName = $('#user_name').val();
		var phone = $('#phone').val();
		var userPwd = "${userPwd}";
		if(!userId) {
			alert('아이디를 입력해주세요.');
			return;
		}else if(!userName) {
			alert('이름을 입력해주세요.');
			return;		
		}else if(!phone) {
			alert('전화번호를 입력해주세요.');
			return;				
		}else if (!isValidPhoneNumber(phone)) {
	        alert('유효한 휴대폰번호를 입력해주세요.');
	        return;
	    } else {
			$.ajax({
			    type: 'POST',
			    url: '/findPwdOk',
			    data: { user_id: userId, user_name: userName, phone: phone },
			    success: function(result) {
			    	console.log(result);
			        if (result !== "") {
			            alert('비빌번호는 ' + result + '입니다.');
			        } else {
			            alert('비빌번호를 찾을 수 없습니다.');
			        }
			    },
			    error: function() {
			        alert('서버 오류가 발생했습니다.');
			    }
			});
		}
	} 	
</script>
<body>
<div class="form-container">
	<h1>비밀번호 찾기</h1>
  <form id="registerForm" method="post">
  <div>
      <label class ="form-label">ID </label> <br>
      <input type="text" id="user_id" name="user_id" class="input-underline">      
    </div><br>
    <div>    
      <label class ="form-label">이름 </label><br>
      <input type="text" id="user_name" name="user_name" class="input-underline">
    </div><br>
    <div>
      <label class ="form-label">휴대폰번호 </label><br>             
         <input type="text" id="phone" class="input-underline"name="phone" placeholder="-를 제외한 숫자만 입력하세요">    
    </div><br>
    <button type="button" id="register" onclick="validate()">비빌번호 찾기</button>
  </form>
</div>
</body>
</body>
</html>