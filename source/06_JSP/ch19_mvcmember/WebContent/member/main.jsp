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
  <link href="${conPath }/css/style2.css" rel="stylesheet" type="text/css">
</head>
 <body>
 	<c:set var="SUCCESS" value="1"/>
 	<c:set var="FAIL" value="0"/>
    <c:if test="${not empty loginFail }">   <!--  로그인 실패시 메세지 뿌리기  -->
    	<script>
    		alert('${loginFail }');
    		history.back();
    	</script>
    </c:if>
    
	<c:if test="${not empty member }" >   	
    	 <h2>${member.mname }(${member.mid })님 어서오세요</h2>
    	<table>
   			<tr>
   				<td>
		   			<button onclick="location.href='${conPath}/modifyView.do'">정보수정</button>
		   			<button onclick="location.href='${conPath}/logout.do'">로그아웃</button>
		   			<button onclick="location.href='${conPath}/mAllView.do'">전체회원보기</button>  			
   				</td>
   			</tr>	
   	</table>
   	</c:if>
    
    <c:if test="${empty member }" > 
    	<h2>로그인 상태가 아닙니다.</h2>
    	<table>
   			<tr>
   				<td>
   				
		   			<button onclick="location.href='${conPath}/member/login.jsp'">로그인</button>
		   			<button onclick="location.href='${conPath}/member/join.jsp'">회원가입</button>
		   			<button onclick="location.href='${conPath}/mAllView.do'">전체회원보기</button>
   				</td>
   			</tr>	
   	</table>
   	</c:if>
   	<c:if test="${updateResult eq SUCCESS }">  <!--  정보수정 완료시 -->
   		<script>
   			alert('정보수정 완료 다시 로그인 해주세요.');
   		</script>
   	</c:if>
   	<c:if test="${updateResult eq FAIL }">  <!--  정보수정 완료시 -->
   		<script>
   			alert('정보수정 실패 ');
   			history.back();
   		</script>
   	</c:if>
   	
   	

  
   
 </body>
</html>
