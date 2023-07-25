<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<meta charset="UTF-8">
    <title>${notice.title}</title>
     <style>
     *{
     font-family: 'Noto Sans KR', sans-serif;
     }
        body {
        font-family: 'Nanum Pen Script', cursive;
            background-color: #F9F9F9;
            color: #3C3C3C;
        }
        
        h2 {
        font-family: 'Nanum Pen Script', cursive;
            font-size: 36px;
            font-weight: 700;
            margin: 20px 0;
        }
        
        p {
        	font-family: 'Nanum Pen Script', cursive;
            font-size: 16px;
            line-height: 1.5;
            margin-bottom: 10px;
        }
        
        hr {
            border: none;
            border-bottom: 1px solid #E4E4E4;
            margin: 30px 0;
        }
        
        a {
            color: #3C3C3C;
            text-decoration: none;
            font-weight: 500;
            transition: all 0.3s ease-in-out;
        }
        .button {
        font-family: 'Nanum Pen Script', cursive;
			background-color: #FF4500;
			border: none;
			border-radius: 4px;
			color: white;
			cursor: pointer;
			font-size: 16px;
			font-weight: bold;
			padding: 10px 20px;
			text-align: center;
			text-decoration: none;
			text-transform: uppercase;
			transition: background-color 0.3s ease-in-out;
			
		}
		.button:hover {
			background-color: #FFA500;
		}
		input[type="submit"],
		button[type="submit"],
		a
		 {
			background-color: #FFEB00;
			border: none;
			border-radius: 4px;
			color: #4B4F56;
			cursor: pointer;
			font-size: 16px;
			font-weight: bold;
			padding: 10px 20px;
			text-align: center;
			text-decoration: none;
			text-transform: uppercase;
			transition: background-color 0.3s ease-in-out;
		}
		#file-upload-button{
		color: red;
		}
    </style>
</head>
<body>
<h2>${notice.title}</h2>
<p>작성자: ${notice.writer}</p>
<p>작성일: ${notice.reg_date}</p>
<hr>
<p>내용: ${notice.content}</p>
<hr>
<p>조회수: ${notice.view_count}</p>
<hr>
<a href="/notice" class="button">목록으로</a>
<a href="/notice/${notice.notice_no}/edit" class="button">수정</a>
<a href="/notice/${notice.notice_no}/delete" class="button">삭제</a>
</body>
</html>


