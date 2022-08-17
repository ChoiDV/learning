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
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
	  $(document).ready(function(){
			
  	  });
	</script>
</head>
  <body>
	<form action="${conPath }/replyWrite.do" method="post" name="frm">
		<input type="hidden" name="bid" value="${bid }">
		<table>
			<caption>${bid } 번 글 답변글 쓰기</caption>
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="bname" required="required">
				</td>
			</tr>
			<tr>
				<th>글 제목</th>
				<td>
					<input type="text" name="btitle" required="required">
				</td>
			</tr>
			<tr>
				<th>글 본문</th>
				<td>
					<input type="text" name="bcontent" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글쓰기" class="btn">
					<input type="reset" value="초기화" class="btn">
					<input type="button" value="목록" class="btn" onclick="location='${conPath }/boardList.do?pageNum=${param.pageNum }'">     
				</td>
			</tr>
		</table>
	</form>
  </body>
</html>