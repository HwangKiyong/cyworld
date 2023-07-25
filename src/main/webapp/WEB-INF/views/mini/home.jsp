<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/statics/font.css" />
<link rel="stylesheet" href="/statics/layout.css" />
<link rel="stylesheet" href="/statics/home.css" />
<meta charset="UTF-8">
<title>${user.user_name} 미니홈피</title>
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
    
    .mini {
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
    .updatevisit {
    	background-color: #DB4455;
    	border-radius: 5px;
    	color: white;
    }
    .updatePhoto {
    	background-color: #89B2E9;
    	border-radius: 5px;
    	color: white;
    }
  </style>
</head>
<div class="bookcover">
      <div class="bookdot">
        <div class="page">
          <div class="home">            
            <div class="upside">       
            <input type="hidden" id="user_id" name="user_id" value="${user.user_id}" />  
            <c:forEach var="item" items="${mini}">           
              <br><strong>&emsp;&emsp;&emsp;Today ${item.mini_today}<span style="color:coral;"></span> | Total ${item.mini_total}</strong> &emsp;&emsp; &emsp; &emsp;&emsp;&emsp;&emsp; <span class="title">${user.user_id}의 미니홈페이지</span> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="/home/${user.user_no}">http://www.cyworld.com/${user.user_id}</a>
            </c:forEach>
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
                <input type="hidden" id="mini_no" name="mini_no" value="${item.mini_no}"/>              
                </c:forEach>
                <div class="profile_3">
                <button class="custom-button" onclick="openModal()">수정</button>                
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
                <div class="updated_news_title"><br><strong>Updated news</strong></div>
                <div class="updated_news_contents">
                  <div class="updated_news_left" style="width:180px; height:100px; overflow: auto;"> 
                  <c:forEach var="item" items="${visit}">
				    <a href="/visit/${user.user_no}" style="text-decoration:none ;font-family: 'Nanum Pen Script', cursive; font-size: 20px;"><span class="updatevisit">방명록</span> &emsp;<c:out value="${item.register_title}" /></a>
				  </c:forEach>			  
				
				  <c:forEach var="item" items="${photo}">
				   <a href="/photo/${user.user_no}" style="text-decoration:none ;font-family: 'Nanum Pen Script', cursive; font-size: 20px;"><span class="updatePhoto">사진첩</span> &emsp;<c:out value="${item.photo_name}" /></a>
				  </c:forEach>
                  </div>
                  <div class="updated_news_right">
				    <div class="updated_news_right1">
				        <a href="/diary/${user.user_no}">다이어리</a> <span class="updated_news_right_number"> ${diaryToday}/${diaryTotal}</span> &emsp;&emsp;&emsp;&emsp;
				        <a href="/photo/${user.user_no}">사진첩</a> <span class="updated_news_right_number"> ${photoToday}/${photoTotal}</span>
				    </div>
				    <div class="updated_news_right2">
				        <a href="/visit/${user.user_no}">방명록</a> <span class="updated_news_right_number"> ${visitToday}/${visitTotal}</span> &emsp;&emsp;&emsp;&emsp;&emsp;				        
				    </div>
				    <div class="updated_news_right3"></div>
				</div>
                </div>
                <div class="miniroom_title"><br><strong>Miniroom&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</strong>
                <button class="custom-button" onclick="openMini()">수정</button></div>
                <div class="miniroom_contents">
                  <c:forEach var="item" items="${mini}">                           
                  <img class="miniroom_gif" src="/miniroom/${item.mini_room}">
                  </c:forEach>
                </div>
              </div>
            </div>
          </div>
          <div class="menu_bar">
            <a href="#" class="menu_button1">&nbsp;&nbsp;홈</a>
            <a href="/diary/${user.user_no}" class="menu_button2">&nbsp;&nbsp;다이어리</a>
            <a href="/photo/${user.user_no}" class="menu_button3">&nbsp;&nbsp;사진첩</a>
            <a href="/visit/${user.user_no}" class="menu_button4">&nbsp;&nbsp;방명록</a>
          </div>
        </div>
      </div>
    </div>
    
   <!-- 모달 창 -->
   <form action="/home/${user.user_no}/new" method="post" enctype="multipart/form-data">
   <input type="hidden" id="user_id" name="user_id" value="${user.user_id}" />
   <c:forEach var="item" items="${mini}"> 
      <input type="hidden" id="mini_no" name="mini_no" value="${item.mini_no}"/>
      </c:forEach>
  <div id="myModal" class="modal">
    <div class="modal-content">
      <h3>프로필 작성하기</h3>      
      <input type="file" id="photoFile" name="photoFile" accept=".jpg, .jpeg, .png" />
      <textarea id="mini_content" name="mini_content" placeholder="내용을 입력하세요."></textarea>
      <button class="custom-button"  onclick="saveChanges()">저장</button>
      <button class="custom-button" type="button" onclick="closeModal()">취소</button>
    </div>
  </div>
  </form>
  
  <form action="/home/${user.user_no}/mini" method="post" enctype="multipart/form-data">
  <div id="miniModal" class="mini">
  <input type="hidden" id="user_id" name="user_id" value="${user.user_id}" />
   <c:forEach var="item" items="${mini}"> 
      <input type="hidden" id="mini_no" name="mini_no" value="${item.mini_no}"/>
      </c:forEach>
    <div class="modal-content">
      <h3>프로필 작성하기</h3>      
      <input type="file" id="photoFile" name="photoFile" accept=".jpg, .jpeg, .png" />
      <button class="custom-button"  onclick="saveRooms()">저장</button>
      <button class="custom-button" type="button" onclick="closeModal()">취소</button>
    </div>
  </div>
  </form>
  
  <script>
    var modal = document.getElementById("myModal");
    var mini = document.getElementById("miniModal");

    // 수정 버튼 클릭 시 모달 창 열기
    function openModal() {
      modal.style.display = "block";
    }
    
    function openMini() {
    	mini.style.display = "block";
    }

    // 모달 창 닫기
    function closeModal() {
      modal.style.display = "none";
      mini.style.display= "none";
    }

    // 변경 사항 저장
    function saveChanges() {
      var fileInput = document.getElementById("photoFile");

      // 선택된 파일과 텍스트 내용을 사용하여 원하는 동작 수행
      // 이 예제에서는 콘솔에 로그를 출력하고 모달 창을 닫습니다.
      console.log("파일:", fileInput.files[0]);

      closeModal();

      location.reload();
    }
    
 // 변경 사항 저장
    function saveRooms() {
      var fileInput = document.getElementById("photoFile");

      // 선택된 파일과 텍스트 내용을 사용하여 원하는 동작 수행
      // 이 예제에서는 콘솔에 로그를 출력하고 모달 창을 닫습니다.
      console.log("파일:", fileInput.files[0]);

      closeModal();

      location.reload();
    }
  </script>
</body>  
</html>