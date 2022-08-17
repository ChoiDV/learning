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
 		
 	});
 </script>  
</head>
  <body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<table>
		<caption>${BoardContent.fId }번 글 상세보기</caption>
		<tr>
			<th>글번호</th>
			<td>
				${BoardContent.fId }
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>
				${BoardContent.mId }
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				${BoardContent.fTitle }
			</td>
		</tr>
		<tr>
			<th>본문</th>
			<td>
				<c:if test="${BoardContent.fFileName != null }">
				<img src="${conPath }/freeBoardUp/${BoardContent.fFileName }">
				</c:if>
				${BoardContent.fContent }
			</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>
				${BoardContent.fRdate }
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="location.href='${conPath}/boardModifyView.do?fId=${BoardContent.fId }&pageNum=${pageNum }'">수정하기</button>
				<button onclick="location.href='${conPath}/boardReplyView.do?fId=${BoardContent.fId }&pageNum=${pageNum }'">답변글 쓰기</button>
				<button onclick="location.href='${conPath}/boardDelete.do?fId=${BoardContent.fId }&pageNum=${pageNum }'">삭제</button>
				<button onclick="location.href='${conPath}/list.do?pageNum=${pageNum }'">목록</button>
			</td>
		</tr>
	</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
  </body>
</html>