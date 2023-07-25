<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/libs/dist/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
	<meta charset="UTF-8">
	<title>게시글 수정</title>
	<style>
		h2 {
			font-family: 'Nanum Pen Script', cursive;
		}
		label {
		font-family: 'Nanum Pen Script', cursive;
			font-weight: bold;
		}
		textarea {
		font-family: 'Nanum Pen Script', cursive;
			width: 100%;
			height: 200px;
		}
		 input[type="submit"] {
		 font-family: 'Nanum Pen Script', cursive;
            background-color: #FF4500;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 20px;
        }
        input[type="submit"]:hover {
        font-family: 'Nanum Pen Script', cursive;
            background-color: #FFA500;
        }
	</style>
</head>
<script>
function submitContents() {
	oEditors.getById["txtContent"].exec("UPDATE_CONTENTS_FIELD", [])
    let content = document.getElementById("txtContent").value.trim();
    
    if(content == '') { //비어있어도 기본 P태그가 붙더라.
        alert("내용을 입력해주세요.");
        oEditors.getById["txtContent"].exec("FOCUS")
        return
    } else {
        console.log(content);
    }
}
</script>
<body>
	<h2>게시글 수정</h2>
	<form action="${pageContext.request.contextPath}/notice/${notice_no}/edit" method="post">
		<p>
			<label>제목 : </label>
			<input type="text" name="title" value="${notice.title}">
		</p>
		<p>
		<textarea id="txtContent" name="content" rows="20" cols="100" style="width: 100%;">${notice.content}</textarea>
		</p>
		<input type="hidden" name="notice_no" value="${notice.notice_no}">
		<p>
			<input type="submit" value="수정" onclick="submitContents()">
		</p>
	</form>
<script id="smartEditor" type="text/javascript"> 
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
	    oAppRef: oEditors,
	    elPlaceHolder: "txtContent",  //textarea ID 입력
	    sSkinURI: "/libs/dist/SmartEditor2Skin.html",  //martEditor2Skin.html 경로 입력
	    fCreator: "createSEditor2",
	    htParams : { 
	    	// 툴바 사용 여부 (true:사용/ false:사용하지 않음) 
	        bUseToolbar : true, 
		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음) 
		bUseVerticalResizer : true, 
		// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음) 
		bUseModeChanger : true 
	    }
	});
</script>
</body>
</html>