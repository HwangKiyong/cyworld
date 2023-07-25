<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/libs/dist/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<meta charset="UTF-8">
    <title>새 글 쓰기</title>
    <style>
    h2 {
			font-family: 'Nanum Pen Script', cursive;
		}
		label {
		font-family: 'Nanum Pen Script', cursive;
			font-weight: bold;
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

    let title = document.getElementById("title").value.trim();
    let writer = document.getElementById("writer").value.trim();
    let content = document.getElementById("txtContent").value.trim();

    if (title === '') {
        alert("제목을 입력해주세요.");
        document.getElementById("title").focus();
        return false;
    } else if (writer === '') {
        alert("작성자를 입력해주세요.");
        document.getElementById("writer").focus();
        return false;
    } else if (content === '') {
        alert("내용을 입력해주세요.");
        oEditors.getById["txtContent"].exec("FOCUS");
        return false;
    }

    console.log(content);
    return true;
}
</script>
<body>
<h2>새글작성</h2>
<form name="smartEditorForm" method="POST" action="/notice/new" onsubmit="return submitContents();">
    <div>
        <label for="title">제목:</label>
        <input type="text" id="title" name="title">
    </div>
    <div>
        <label for="writer">작성자:</label>
        <input type="text" id="writer" name="writer">
    </div>
    <textarea id="txtContent" name="content" rows="20" cols="100" style="width: 100%;"></textarea>
    <%
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateFormat.format(new Date());
    %>
    <input type="hidden" id="reg_date" name="reg_date" value="<%= currentDate %>">
    <input type="submit" value="전송" onclick="submitContents()">
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