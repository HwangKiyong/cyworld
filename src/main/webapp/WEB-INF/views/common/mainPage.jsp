<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
	<meta charset="UTF-8">
	<title>로그인 성공</title>
	<style>
        body {
            background-color: #F9F9F9;
            background: url("/img/다운로드파일.jpg") center/cover no-repeat;
            font-family: 'Nanum Pen Script', cursive;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background-size: 100% 100%;
        }

        h1 {
            margin-bottom: 50px;
        }


        #welcome {
            margin-bottom: 50px;
            font-size: 24px;
            font-weight: bold;
            text-align:center;
        }

        .button {
            margin: 10px;
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
            text-decoration: none;
            display: inline-block;
        }

        .button:hover {
            background-color: #FFA500;
        }  
        /* CSS to move the table to the top-right corner */
  table {
    position: absolute;
    right: 5px;
  }

  /* Optional: Add some styling to the table for better visibility */
  table {
    border-collapse: collapse;
    border: 1px solid black;
  }

  th, td {
    padding: 25px;
    border: 1px solid black;
    background-color: white;
  }

  th {
    background-color: #f2f2f2;
  }        
  /* 원 모양의 컨테이너를 위한 클래스 정의 */
  .circular-container {
    display: inline-block; /* 이렇게 설정하면 컨테이너의 너비가 폼의 너비와 일치합니다 */
    border-radius: 100%; /* 원 모양으로 만듭니다 */
    background-color: white; /* 배경 색상을 추가합니다 */
    padding: 50px; /* 폼과 컨테이너 사이의 간격을 설정합니다 */
  }
    </style>
</head>
<body>
	<div class="circular-container">
		<h1></h1>
				<div id="welcome" >${user.user_id} 님 환영합니다.</div>
				<a href="/logOut" class="button">로그아웃</a>
				<a href="/notice" class="button">게시판바로가기</a>
				<a href="#" class="button" onclick="openMiniHomePage()">미니홈피 바로가기</a>
	</div>
	
	<table>
	  <thead>
	    <tr>
	      <th>No.</th>
	      <th>User ID</th>
	      <th>Visitor</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach var="item" items="${mini}" varStatus="loop">
	      <tr>
	        <td>${loop.index + 1}</td>
	        <td>${item.user_id}</td>
	        <td>${item.mini_today}</td>
	      </tr>
	    </c:forEach>
	  </tbody>
	</table>
	
	 <script>
        function openMiniHomePage() {
        	 window.open("/home/${user.user_no}", "_blank", "width=1500, height=1500");
        }
    </script>
</body>
</html>