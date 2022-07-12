<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="${conPath }/css/style.css" rel="stylesheet">
 <style>
 
 </style>
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 <script>
 	$(document).ready(function(){
 		$('tr').click(function(){
 			var fId = $(this).children().eq(0).text();  // tr을 클릭하면 tr의 자식들의 0번째(first)의 text를 가져와서  no에 넣는다. 즉, 글번호를 의미
 			if( !isNaN(Number(fId))){ 
 				location.href= 'boardContent.do?fId='+fId+'&pageNum=${pageNum }';
 			}
 		});
 	});
 </script>  
</head>
  <body>
  <c:if test="${writeBoardResult eq 1 }">
  	<script>
  		alert('글 작성 완료');
  	</script>
  </c:if>
  <c:if test="${writeBoardResult eq 0 }">
  	<script>
  		alert('글 작성 실패');
  		history.back();
  	</script>
  </c:if>
  <jsp:include page="../main/header.jsp"/>
  <div id="content_form">
	<table>
		<tr>
			<td>
				<a href="${conPath }/boardWriteView.do">글쓰기</a>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>글제목</th>
			<th>조회수</th>
			<th>날짜</th>
			<th>ip</th>
		</tr>
		<c:if test="${listBoard.size() eq 0 }">
			<tr>
				<td colspan="6">
					등록된 글이 없습니다.
				</td>
			</tr>			
		</c:if>
		<c:if test="${listBoard.size() != 0 }">
			<c:forEach var="list" items="${listBoard }">
				<tr>
					<td>${list.fId }</td>
					<td>${list.mId }</td>
					<td class="left">
						<c:forEach var="i" begin="1" end="${list.fIndent }">
							<!--  들여쓰기 -->
							<c:if test="${i eq list.fIndent }">
								└─
							</c:if>
							<c:if test="${i != list.fIndent }">
								&nbsp; &nbsp;
							</c:if>
						</c:forEach> <!-- 답변글 들여쓰기!!!!!!!!!!!!!! -->
						${list.fTitle }
						<c:if test="${list.fHit > 5 }">
							<b style="color=red;"> * </b>
						</c:if>
					</td>  <!--  글 제목 -->
					<td>${list.fHit }</td>
					<td>${list.fRdate }</td>
					<td>${list.fIp }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="paging">
	 	<c:if test="${startPage > BLOCKSIZE}">
	 		[ <a href="${conPath }/list.do?pageNum=${startPage-1 }">이전</a> ]
	 	</c:if>
	 	<c:forEach var="i" begin="${startPage }" end="${endPage }">
	 		<c:if test="${i eq pageNum }">
	 			[ <b> ${i } </b> ]
	 		</c:if>
	 		<c:if test="${i != pageNum }">
	 			[ <a href="${conPath }/list.do?pageNum=${i }">${i }</a> ]
	 		</c:if>
	 	</c:forEach>
	 	<c:if test="${endPage < pageCnt }">
	 		[ <a href="${conPath }/list.do?pageNum=${endPage+1 }">다음</a> ]
	 	</c:if>
	 </div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
  </body>
</html>