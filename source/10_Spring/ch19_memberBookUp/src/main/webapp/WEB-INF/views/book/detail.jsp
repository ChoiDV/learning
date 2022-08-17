<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="${conPath }/css/style.css" rel="stylesheet">
    <style>
 		 #content {
			width: 800px; height:400px;
			margin: 50px auto;
			}
		img{width: 100px; height: 100px;}
  </style>
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
	  $(document).ready(function(){
			
  	  });
	</script>
</head>
  <body>
  	<c:if test="${modifyResult eq 1 }">
  		<script>
  			alert('책 수정 성공');
  		</script>
  	</c:if>
  	<c:if test="${modifyResult eq 0 }">
  		<script>
  			alert('책 수정 실패');
  			history.back();
  		</script>
  	</c:if>
  	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<table>
			<tr>
				<th>책 번호</th>
				<td>${bookDetail.bnum }</td>
			</tr>
			<tr>
				<th>책 제목</th>
				<td>${bookDetail.btitle }</td>
			</tr>
			<tr>
				<th>저자</th>
				<td>${bookDetail.bwriter }</td>
			</tr>
			<tr>
				<th>출판일</th>
				<td><fmt:formatDate value="${bookDetail.brdate }" dateStyle="long"/></td>
			</tr>
			<tr>
				<th>책 사진</th>
				<td>
					<img src="${conPath }/bookImgFileUpload/${bookDetail.bimg1 }" >
				</td>
			</tr>
			<tr>
				<th>책 사진</th>
				<td>
					<img src="${conPath }/bookImgFileUpload/${bookDetail.bimg2 }" >
				</td>
			</tr>
			<tr>
				<th>책 설명</th>
				<td>${bookDetail.binfo }</td>
			</tr>
			<tr>
				<td colspan="2">
					<button onclick="location='${conPath }/book.do?method=modifyForm&bnum=${bookDetail.bnum }&pageNum=${pageNum }'">수정하기</button>
					<button onclick="location='${conPath }/main.do'">메인화면</button>
					<button onclick="location='${conPath }/book.do?method=list&pageNum=${pageNum }'">목록</button>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
  </body>
</html>