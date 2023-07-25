<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${user.user_name} 사진첩</title>
<!-- CSS 경로 수정 -->
<link rel="stylesheet" href="/statics/font.css" />
<link rel="stylesheet" href="/statics/layout.css" />
<link rel="stylesheet" href="/statics/photo.css" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
    /* 모달 스타일 */
    .modal {
      display: none;
      position: fixed;
      z-index: 1;
      left: 0;
      top: 0;
      width: 100%;
      height: 100%;
      overflow: auto;
      background-color: rgba(0, 0, 0, 0.5);
    }
    
    .modal-content {
      background-color: #fefefe;
      margin: 15% auto;
      padding: 20px;
      border: 1px solid #888;
      width: 80%;
      max-width: 400px;
    }
  </style>
</head>
<script>
function validateForm() {
  var photoName = document.getElementById("photo_name").value;
  var photoText = document.getElementById("photo_text").value;

  if (photoName === "" || photoText === "") {
    alert("제목과 내용을 모두 입력해주세요.");
    return false;
  }

  return true;
}
</script>
<body>
  <div class="bookcover">
    <div class="bookdot">
      <div class="page">
        <div class="home">
          <div class="upside">
            <input type="hidden" id="user_id" name="user_id" value="${user.user_id}" />  
            <c:forEach var="item" items="${mini}">           
              <br><strong>&emsp;&emsp;&emsp;Today ${item.mini_today}<span style="color:coral;"></span> | Total ${item.mini_total}</strong> &emsp;&emsp; &emsp; &emsp;&emsp;&emsp;&emsp; 
            </c:forEach><span class="title">${user.user_id}의 사진첩</span>
            &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="/home/${user.user_no}">http://www.cyworld.com/${user.user_id}</a>
          </div>
          <div class="home_main">
            <div class="profile">
              <div class="profile_1">    
                <c:forEach var="item" items="${mini}">            
                  <img class="profile_image" src="/profile/${item.mini_profile}" width="200px" height="100px">
                  </c:forEach>
                </div>            
                <c:forEach var="item" items="${mini}">    
                <div class="profile_2" width="200px" height="100px">${item.mini_content}</div>
                </c:forEach>
              <div class="profile_3">
              
                <div class="profile-dropdown">
                  <div class="dropdown-btn">
                    <div class="dropdown-title">Related Link</div>
                    <div class="triangle-down"></div>
                  </div>
                  <div class="dropdown-content">
                    <a href="/notice" target="_blank">게시판</a>
                    <a href="https://github.com/joseph-106" target="_blank">Github</a>
                    <a href="https://www.instagram.com/${user.user_id}" target="_blank">Instagram</a>
                  </div>
                </div>
              </div>
            </div>
            <div class="home_contents">
              <!-- 사진 목록 영역 -->
              <div class="photo">              
                <c:forEach items="${list}" var="photo">
                  <input type="hidden" id="user_id" name="user_id" value="${user.user_id}" />
                  <div class="photo_contents">
                  <p class="no">${photo.photo_no}</p>
                  <p class="photo_name">${photo.photo_name}<span class="photo_date">(${photo.photo_date})</span> &emsp;&nbsp;&emsp;&nbsp;&emsp;&nbsp;&emsp;&nbsp; &emsp;&nbsp; &nbsp;</p>
                  <img src="/img/${photo.photo_path}" width="200px" height="100px">
                  <p class="photo_text">${photo.photo_text} </p>
                  <p class="button"><button class="custom-button" onclick="openModal(${photo.photo_no})">수정</button>
				  <button class="custom-button" onclick="deletePhoto(${photo.photo_no})"> 삭제</button></p>	
                  </div>
                </c:forEach>
              <!-- 사진 등록 폼 -->
              <form action="/photo/${user.user_no}/new" method="post" onsubmit="return validateForm()" enctype="multipart/form-data">
                <div class="photo_contents">
                <div>
                  <input type="file" id="photoFile" name="photoFile" class="custom-button" accept=".jpg, .jpeg, .png" />
                </div><br>
                <div>
                  <input type="text" id="photo_name" name="photo_name" placeholder="제목을 입력하세요." /><br><br>
                  <textarea id="photo_text" name="photo_text" placeholder="내용을 입력하세요."></textarea><br><br>
                  <button type="submit" class="custom-button" onclick="uploadAndRefresh()">등록하기</button>
                  <input type="hidden" id="user_id" name="user_id" value="${user.user_id}" />
                  </div>
                </div>
              </form>
              </div>
            </div>
          </div>
        </div>
        <div class="menu_bar">
          <a href="/home/${user.user_no}" class="menu_button1">&nbsp;&nbsp;홈</a>
          <a href="/diary/${user.user_no}" class="menu_button2">&nbsp;&nbsp;다이어리</a>
          <a href="#" class="menu_button3">&nbsp;&nbsp;사진첩</a>
          <a href="/visit/${user.user_no}" class="menu_button4">&nbsp;&nbsp;방명록</a>
        </div>
      </div>
    </div>
  </div>
  
  
  
  <form action="/photo/${user.user_no}/edit" method="post">
   <input type="hidden" id="user_id" name="user_id" value="${user.user_id}" />
   <input type="hidden" id="photo_no" name="photo_no" value="${photo.photo_no}" />
  <div id="myModal" class="modal">
    <div class="modal-content">
      <h3>사진첩 수정</h3>
      <input type="text" id="photo_name" name="photo_name" placeholder="제목을 입력하세요." /><br><br>
      <textarea id="photo_text" name="photo_text" placeholder="내용을 입력하세요."></textarea><br><br>
      <button class="custom-button"  onclick="saveChanges()">수정</button>
      <button class="custom-button" type="button" onclick="closeModal()">취소</button>
    </div>
  </div>
  </form>
  <script>
    var modal = document.getElementById("myModal");

    // 수정 버튼 클릭 시 모달 창 열기
    function openModal(photoNo) {
      modal.style.display = "block";
      document.getElementById("photo_no").value = photoNo;
    }

    // 모달 창 닫기
    function closeModal() {
      modal.style.display = "none";
    }

    // 변경 사항 저장
   // 변경 사항 저장
	function saveChanges() {
	  var photoNo = document.getElementById("photo_no").value;
	  var photoName = document.getElementById("photo_name").value;
	  var photoText = document.getElementById("photo_text").value;
	
	  // AJAX를 사용하여 데이터를 서버로 전송하는 로직을 구현하세요
	  $.ajax({
	    url: "/photo/{user_no}/edit", // 수정 API 엔드포인트
	    type: "POST",
	    data: {
	      photo_no: photoNo,
	      photo_name: photoName,
	      photo_text: photoText // 수정된 내용
	    },
	    success: function(response) {
	      // 성공적으로 처리된 후의 동작을 구현하세요
	      console.log("수정이 완료되었습니다.");
	      // 필요한 경우 모달 창을 닫거나 다른 동작을 수행하세요
	      closeModal();
	      location.reload();
	    },
	    error: function(error) {
	      // 에러 처리 로직을 구현하세요
	      console.log("수정에 실패하였습니다.");
	      // 필요한 경우 에러 메시지를 표시하거나 다른 동작을 수행하세요
	    }
	  });
	}
    
    
	function deletePhoto(photoNo) {
	    $.ajax({
	        url: "/photo/${user_no}/delete",
	        type: 'DELETE',
	        data: {
	            photo_no: photoNo
	        },
	        success: function(response) {
	            console.log('삭제가 완료되었습니다.');
	            // 필요한 경우 삭제 후의 동작을 구현하세요
	            window.location.href = window.location.href;
	        },
	        error: function(error) {
	            console.log('삭제에 실패하였습니다.');
	            // 필요한 경우 에러 처리 동작을 구현하세요
	            window.location.href = window.location.href;
	        }
	    });
	}	
  </script>
</body>
</html>