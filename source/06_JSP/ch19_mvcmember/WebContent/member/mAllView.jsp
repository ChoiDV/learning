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
     <h2> 전체 회원 보기 </h2>
	 <table>	 	
	 		<c:if test="${list.size() eq 0 }">
	 			<tr>
	 				<td colspan="6">가입된 회원이 없습니다.</td>
	 			</tr>
	 		</c:if>
	 		<c:if test="${list.size() != 0 }">
	 				<tr>
	 					<c:forEach var="dto" items="${list }">
		 					<td><img src="${conPath }/memberPhotoUp/${dto.mphoto }" alt="사진" width="100"><br>
		 					${dto.mname }<br>
		 					(${dto.mid })</td>
	 					</c:forEach>
	 				</tr>
	 		</c:if>
	 </table>
	 <div class="paging">
	 	<c:if test="${startPage > BLOCKSIZE}">
	 		[ <a href="${conPath }/mAllView.do?pageNum=1">처음으로</a> ]
	 		[ <a href="${conPath }/mAllView.do?pageNum=${startPage-1 }">이전</a> ]
	 	</c:if>
	 	<c:forEach var="i" begin="${startPage }" end="${endPage }">
	 		<c:if test="${i eq pageNum }">
	 			[ <b> ${i } </b> ]
	 		</c:if>
	 		<c:if test="${i != pageNum }">
	 			[ <a href="${conPath }/mAllView.do?pageNum=${i }">${i }</a> ]
	 		</c:if>
	 	</c:forEach>
	 	<c:if test="${endPage < pageCnt }">
	 		[ <a href="${conPath }/mAllView.do?pageNum=${endPage+1 }">다음</a> ]
	 		[ <a href="${conPath }/mAllView.do?pageNum=${pageCnt }">맨끝으로</a> ]
	 	</c:if>
	 </div>
 </body>
</html>
