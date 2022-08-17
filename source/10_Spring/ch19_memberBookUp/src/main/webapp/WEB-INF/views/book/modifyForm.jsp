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
   <style>
 	 #content {
		width: 800px; height:350px;
		margin: 50px auto;
	 }
	</style>
  <link href="${conPath }/css/style.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
	  $(document).ready(function(){
			
  	  });
	</script>
</head>
  <body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<form action="book.do?method=modify" method="post" enctype="multipart/form-data">
			<input type="hidden" name="bnum" value="${modifyBook.bnum }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<table>
				<caption>${modifyBook.bnum } 번 책 수정하기</caption>
				<tr>
					<th>책 제목</th>
					<td>
						<input type="text" name="btitle" required="required" value="${modifyBook.btitle }">
					</td>
				</tr>
				<tr>
					<th>저자</th>
					<td>
						<input type="text" name="bwriter" required="required" value="${modifyBook.bwriter }">
					</td>
				</tr>
				<tr>
					<th>출판일</th>
					<td>
						<input type="date" name="brdate" required="required" value="${modifyBook.brdate }">
					</td>
				</tr>
				<tr>
					<th>책 사진1</th>
					<td>
						<input type="file" name="tempbimg1">
					</td>
				</tr>
				<tr>
					<th>책 사진2</th>
					<td>
						<input type="file" name="tempbimg2">
					</td>
				</tr>
				<tr>
					<th>책 설명</th>
					<td>
						<input type="text" name="binfo" required="required" value="${modifyBook.binfo }">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정">
						<input type="reset" value="취소">
						<input type="button" value="뒤로가기" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
  </body>
</html>