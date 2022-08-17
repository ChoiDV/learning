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
  <link href="${conPath }/css/login.css" rel="stylesheet" type="text/css">
</head>
 <body>
 <jsp:include page="../main/header.jsp"/>
	<!--  ${requestScope.joinResult } -->
	<!--  ${requestScope.joinErrorMsg } --> <!--  들이 있을수도 있고 없을수도 있고 -->
	<!--  ${sessionScope.mid } 가 있을수도 있고 없을수도 있고-->
	<c:if test="${not empty joinResult }">    <!--  != null 하고 같은 뜻 -->
		<script>
			alert('${joinResult }');
		</script>
	</c:if>	
	<c:if test="${not empty joinErrorMsg  }">   <!--  != null 하고 같은 뜻 -->
		<script>
			alert('${joinErrorMsg }');
			history.back();
		</script>
	</c:if>
	<div id=loginForm_wrap>
	<form action="${conPath }/login.do" method="post">
		<table>
			<tr>
				<th>ID</th>
				<td>
					<input type="text" name="mid" value="${mid }" required="required">
					<!--  value=에 ${mid }를 넣으면 mid가 있으면 mid가 나오고 없으면 그냥 "" 빈스트링 나옴  -->
				</td>
			</tr>
			<tr>
				<th>PW</th>
				<td>
					<input type="password" name="mpw" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="location='${conPath }/joinView.do'">
				</td>
			</tr>
		</table>
	</form>
	</div>
	 <jsp:include page="../main/footer.jsp"/>
	
	
 </body>
</html>
