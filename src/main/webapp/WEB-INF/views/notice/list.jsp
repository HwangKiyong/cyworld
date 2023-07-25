<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<meta charset="UTF-8">
    <title>공지사항 목록</title>
    <style>
        table {
        font-family: 'Nanum Pen Script', cursive;
		  border-collapse: collapse;
		  border-spacing: 0;
		}
		section.notice {
		  padding: 80px 0;
		}
		
		.page-title {
		  margin-bottom: 60px;
		}
		
		.page-title h3 {
		font-family: 'Nanum Pen Script', cursive;
		  font-size: 40px;
		  color: #333333;
		  font-weight: 400;
		  text-align: center;
		}
		
		#board-search .search-window .search-wrap {
		    display: flex;
		    align-items: center;
		}
		
		#board-search .search-window .search-wrap select {
		    width: 15%;
		    margin-right: 30px;
		}
		
		#board-search .search-window .search-wrap input {
		    flex: 1;
		    width: auto;
		}
		
		#board-search .search-window .search-wrap .btn {
		    width: auto;
		}
		#board-search .search-window {
		
		  padding: 15px 0;
		  background-color: #f9f7f9;
		}
		
		#board-search .search-window .search-wrap {
		  position: relative;
		/*   padding-right: 124px; */
		  margin: 0 auto;
		  width: 80%;
		  max-width: 564px;
		}		
		
		#board-search .search-window .search-wrap input {
		    font-family: 'Nanum Pen Script', cursive;
		    width:100%;
		    height: 40px;
		    font-size: 14px;
		    padding: 7px 14px;
		    border: 1px solid #ccc;
		}
		
		#board-search .search-window .search-wrap select {
		font-family: 'Nanum Pen Script', cursive;
		  height: 40px;
		  width: 15%;
		  font-size: 14px;
		  padding: 7px 14px;
		  border: 1px solid #ccc;
		  margin-left: -84px;
		}
		
		#board-search .search-window .search-wrap input:focus {
		  border-color: #333;
		  outline: 0;
		  border-width: 1px;
		}
		#board-search .search-window .search-wrap .btn {
		font-family: 'Nanum Pen Script', cursive;
		  position: absolute;
		  right: 0;
		  top: 0;
		  bottom: 0;
		  width: 108px;
		  padding: 0;
		  font-size: 16px;
		}
		
		.board-table {
		  font-size: 15px;
		  width: 100%;
		  border-top: 1px solid #ccc;
		  border-bottom: 1px solid #ccc;
		}
		
		.board-table a {
		  color: #333;
		  display: inline-block;
		  line-height: 1.4;
		  word-break: break-all;
		  vertical-align: middle;
		}
		.board-table a:hover {
		  text-decoration: underline;
		}
		
		.board-table .th-num {
		  width: 100px;
		  text-align: center;
		}
		
		.board-table .th-date {
		  width: 200px;
		}
		
		.board-table th, .board-table td {
		  padding: 14px 0;
		}
		
		.board-table tbody td {
		  border-top: 1px solid #e7e7e7;
		  text-align: center;
		}
		
		.board-table tbody th {
		  padding-left: 28px;
		  padding-right: 14px;
		  border-top: 1px solid #e7e7e7;
		  text-align: left;
		}
		
		.board-table tbody th p{
		  display: none;
		}
		
		.btn {
		font-family: 'Nanum Pen Script', cursive;
		  display: inline-block;
		  padding: 0 30px;
		  font-size: 15px;
		  font-weight: 400;
		  background: transparent;
		  text-align: center;
		  white-space: nowrap;
		  vertical-align: middle;
		  -ms-touch-action: manipulation;
		  touch-action: manipulation;
		  cursor: pointer;
		  -webkit-user-select: none;
		  -moz-user-select: none;
		  -ms-user-select: none;
		  user-select: none;
		  border: 1px solid transparent;
		  text-transform: uppercase;
		  -webkit-border-radius: 0;
		  -moz-border-radius: 0;
		  border-radius: 0;
		  -webkit-transition: all 0.3s;
		  -moz-transition: all 0.3s;
		  -ms-transition: all 0.3s;
		  -o-transition: all 0.3s;
		  transition: all 0.3s;
		}
		
		.btn-dark {
		  background: #555;
		  color: #fff;
		}
		
		.btn-dark:hover, .btn-dark:focus {
		  background: #373737;
		  border-color: #373737;
		  color: #fff;
		}
		
		.btn-dark {
		  background: #FF4500;
		  color: #fff;
		}
		
		.btn-dark:hover, .btn-dark:focus {
		  background: #FFA500;
		  border-color: #373737;
		  color: #fff;
		}
		
		/* reset */
		
		* {
		  list-style: none;
		  text-decoration: none;
		  padding: 0;
		  margin: 0;
		  box-sizing: border-box;
		}
		.clearfix:after {
		  content: '';
		  display: block;
		  clear: both;
		}
		.container {
		  width: 1100px;
		  margin: 0 auto;
		}
		.blind {
		  position: absolute;
		  overflow: hidden;
		  clip: rect(0 0 0 0);
		  margin: -1px;
		  width: 1px;
		  height: 1px;
		}
		
		.write-button {
		font-family: 'Nanum Pen Script', cursive;
            position: fixed;
            bottom: 20px;
            right: 20px;
        }
        
        ul {
        font-family: 'Nanum Pen Script', cursive;
	  	text-align: center;
	  	font-size: 25px;
	  	margin-top: 25px;
		}  	
    </style>
    
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	var perPageNum = 10;
</script>
<script>
	function increaseViewCount(noticeNo) {
		$.ajax({
			type:"POST",
			url:"/notice/increaseViewCount",
			data: {notice_no: noticeNo},
			success: function(result) {
				console.log("조회수 증가 완료");
				
			},
			error: function(xhr, status, error) {
				console.log(error);
			}
		});
	}		
	function change() {
	    var searchCondition = document.getElementById("searchCondition").value;
	    var searchKeyword = document.getElementById("searchKeyword");
	    
	    // 검색 조건에 따라 입력 폼 동적 변경
	    if (searchCondition === "title") {
	        searchKeyword.placeholder = "제목을 입력해주세요";
	    } else if (searchCondition === "writer") {
	        searchKeyword.placeholder = "작성자를 입력해주세요";
	    }
	    console.log(searchCondition);
	}
</script>
</head>
<body>
    <section class="notice">
  <div class="page-title">
        <div class="container">
            <h3>공지사항</h3>
        </div>
    </div>

    <!-- board search area -->
    <div id="board-search">
        <div class="container">
            <div class="search-window">
                <form action="/search" method="get">                             	          		
                    <div class="search-wrap">        
	                    <select id="searchCondition" name="searchCondition" onclick="change()">        
						         <option value="title">제목</option>
    							 <option value="writer">작성자</option>                
						 </select>                                              
	                     <input type="text" id="searchKeyword" name="searchKeyword" placeholder="제목을 입력해주세요" value="${searchKeyword}">
	                     <button type="submit" class="btn btn-dark">검색</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
   
  <!-- board list area -->
    <div id="board-list">
        <div class="container">
            <table class="board-table">
                <tr>
                    <th scope="col" class="th-num" style="text-align:center">번호</th>
                    <th scope="col" class="th-title" style="text-align:center">제목</th>
                    <th scope="col" class="th-reg_date" style="text-align:center">등록일</th>
                    <th scope="col" class="th-writer" style="text-align:center">작성자</th>
                    <th scope="col" class="th-view_count" style="text-align:center">조회수</th>
                </tr>
             <c:choose>
                <c:when test = "${not empty searchResults}">
                	<c:forEach items="${searchResults}" var="notice" >
                <tr>
                    <td>${notice.notice_no}</td>
                    <td><a href="/notice/${notice.notice_no}" onclick="increaseViewCount(${notice.notice_no})">${notice.title}</a></td>
                    <td>${notice.reg_date}</td>
                    <td>${notice.writer}</td>
                    <td>${notice.view_count}</td>
                </tr>
	            	</c:forEach>
	            </c:when>
	         <c:otherwise>
	           	<c:forEach items="${list}" var="notice" >
                <tr>
                    <td>${notice.notice_no}</td>
                    <td><a href="/notice/${notice.notice_no}" onclick="increaseViewCount(${notice.notice_no})" >${notice.title}</a></td>
                    <td>${notice.reg_date}</td>
                    <td>${notice.writer}</td>
                    <td>${notice.view_count}</td>
                </tr>
	             </c:forEach>
	          </c:otherwise>
	        </c:choose>
            </table>
             <ul class="paging">
		    <c:if test="${paging.prev}">
		        <span><a href="${url}?page=${paging.startPage-1}&searchCondition=${param.searchCondition}&searchKeyword=${param.searchKeyword}">이전</a></span>
		    </c:if>
		    <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
		        <c:choose>
		            <c:when test="${paging.cri.page == num}">
		                <strong>${num}</strong>
		            </c:when>
		            <c:otherwise>
		                <span><a href="${url}?page=${num}&searchCondition=${param.searchCondition}&searchKeyword=${param.searchKeyword}">${num}</a></span>
		            </c:otherwise>
		        </c:choose>
		    </c:forEach>
		    <c:if test="${paging.next && paging.endPage > 0}">
		        <span><a href="${url}?page=${paging.endPage+1}&searchCondition=${param.searchCondition}&searchKeyword=${param.searchKeyword}">다음</a></span>
		    </c:if>
		</ul>
             <a href="/write" class="write-button">
       			 <button type="submit" class="btn btn-dark">글쓰기</button>
   			 </a>
        </div>
    </div>
</section>
</body>
</html>