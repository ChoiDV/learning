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
  	.paging {text-align: center; margin:50px 0;}
  </style>
  <link href="${conPath }/css/style.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
	  $(document).ready(function(){
			
  	  });
	</script>
</head>
  <body>
  	<c:if test="${registerResult eq 1 }">
  		<script>
  			alert('책 등록 성공');
  		</script>
  	</c:if>
  	<c:if test="${registerResult eq 0 }">
  		<script>
  			alert('책 등록 실패');
  			history.back();
  		</script>
  	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<form action="${conPath }/book.do" method="get">
			<input type="hidden" name="method" value="list">
			<div>
				<select name="schItem">
					<option value=""
						<c:if test="${param.schItem eq '' }">
							selected="selected"
						</c:if>
						>검색조건
					</option>
					<option value="all"
						<c:if test="${param.schItem eq 'all' }">
							selected="selected"
						</c:if>
						>책이름+저자</option>
					<option value="btitle"
						<c:if test="${param.schItem eq 'btitle' }">
							selected="selected"
						</c:if>
						>책 이름</option>
					<option value="bwriter"
						<c:if test="${param.schItem eq 'bwriter' }">
							selected="selected"
						</c:if>
						>저자</option>	
				</select>
				<input type="text" name="schWord" value="${param.schWord }">
				<input type="submit" value="검색">
			</div>
		</form>
		 <table>
		 	<caption>도서 LIST</caption>
		 	<tr>
		 		<c:forEach var="book" items="${bookList }">
		 			<td>
		 				<a href="${conPath }/book.do?method=detail&bnum=${book.bnum }&pageNum=${param.pageNum }">
			 				${book.btitle } <br>
			 				<img src="${conPath }/bookImgFileUpload/${book.bimg1 }"><br>
			 				${book.bwriter }<br>
			 				<fmt:formatDate value="${book.brdate }" pattern="YYYY-MM-dd" />	
		 				</a>	
		 			</td>
		 		</c:forEach>
		 	</tr>
		 </table>	
	 </div>
	 <div class="paging">
		<c:if test="${paging.startPage > paging.blockSize }">
		[ <a href="${conPath }/book.do?method=list&pageNum=${paging.startPage-1 }">이전으로</a>]
	</c:if>
		<c:forEach var="i" begin="${paging.startPage }"
			end="${paging.endPage }">
			<c:if test="${i eq paging.currentPage }">
			[ <b>${i }</b> ]
		</c:if>
			<c:if test="${i != paging.currentPage}">
			[ <a href="${conPath }/book.do?method=list&pageNum=${i }">${i }</a> ]
		</c:if>
		</c:forEach>
		<c:if test="${paging.endPage < paging.pageCnt }">
		[ <a href="${conPath }/book.do?method=list&pageNum=${paging.endPage+1 }">다음으로</a>]
	</c:if>
	</div>
	<jsp:include page="../main/footer.jsp"/>
  </body>
</html>