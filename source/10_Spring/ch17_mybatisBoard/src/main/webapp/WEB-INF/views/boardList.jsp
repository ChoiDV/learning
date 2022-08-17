<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(document).ready(function() {

	});
	 function trclicked(bid){
		  location.href='${conPath }/detail.do?bid='+bid+'&pageNum=${paging.currentPage }';
	  }
</script>
</head>
<body>
	<c:if test="${writeResult eq 1 }">
		<script>
			alert('글쓰기 성공');
		</script>
	</c:if>
	<c:if test="${updateResult eq 1 }">
		<script>
			alert('글 수정 성공');
		</script>
	</c:if>
	<c:if test="${deleteResult eq 1 }">
		<script>
			alert('${param.bid}번 글 삭제 성공');
		</script>
	</c:if>
	<c:if test="${replyResult eq 1 }">
		<script>
			alert('${bid }번글에 대한 답변글 작성 성공');
		</script>
	</c:if>
	<c:set var="num" value="${paging.startRow }"/>
	<c:set var="rnum" value="${paging.totCnt - paging.startRow + 1 }"/>
	<table>
		<caption>게시판</caption>
		<tr>
			<td colspan="8"><a href="${conPath }/writeView.do">글쓰기</a></td>
		</tr>
		<tr>
			<th>순번</th>
			<th>역순</th>
			<th>글번호</th>
			<th>작성자</th>
			<th>글제목</th>
			<th>IP</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:if test="${boardList.size() eq 0 }">
			<tr>
				<td colspan="8">등록된 글이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${boardList.size() != 0 }">
			<c:forEach items="${boardList }" var="board">
				<tr onclick="trclicked(${board.bid})">
					<td>${num }</td>
					<td>${rnum }</td>
					<td>${board.bid }</td>
					<td>${board.bname }</td>
					<td class="left">
						<c:forEach var="i" begin="1" end="${board.bindent }">
							<c:if test="${i eq board.bindent }">
								└
							</c:if>
							<c:if test="${i != board.bindent }">
								&nbsp; &nbsp;
							</c:if>
						</c:forEach>
							${board.btitle }
							<c:if test="${board.bhit > 10 }">
	 						 	<b> * </b>
	 						 </c:if>
					</td>
					<td>${board.bip }</td>
					<td><fmt:formatDate value="${board.bdate }" dateStyle="long" /></td>
					<td>${board.bhit }</td>
				</tr>
				<c:set var="num" value="${num +1 }"/>
				<c:set var="rnum" value="${rnum -1 }"/>
			</c:forEach>
		</c:if>
	</table>
	<br>
	<div class="paging">
		<c:if test="${paging.startPage > paging.blockSize }">
		[ <a href="${conPath }/boardList.do?pageNum=${paging.startPage-1 }">이전으로</a>]
	</c:if>
		<c:forEach var="i" begin="${paging.startPage }"
			end="${paging.endPage }">
			<c:if test="${i eq paging.currentPage }">
			[ <b>${i }</b> ]
		</c:if>
			<c:if test="${i != paging.currentPage}">
			[ <a href="${conPath }/boardList.do?pageNum=${i }">${i }</a> ]
		</c:if>
		</c:forEach>
		<c:if test="${paging.endPage < paging.pageCnt }">
		[ <a href="${conPath }/boardList.do?pageNum=${paging.endPage+1 }">다음으로</a>]
	</c:if>
	</div>
</body>
</html>