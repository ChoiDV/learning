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
	  function delete_fun(bid){
	  	var answer = confirm('정말 삭제하시겠습니까?');
	  	if(answer){
	  		location.href='${conPath }/delete.do?bid='+bid;
	  	} else {
	  		alert('취소되었습니다.');
	  	}
	  }
	</script>
</head>
  <body>
	<table>
		<caption>${detail.bid } 번 글 상세보기</caption>
		<tr>
			<th>작성자</th>
			<td>
				${detail.bname }
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${detail.btitle }</td>
		</tr>
		<tr>
			<th>본문</th>
			<td>${detail.bcontent }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>
				<fmt:formatDate value="${detail.bdate }" dateStyle="long" />
			</td>
		</tr>
		<tr>
			<th>IP</th>
			<td>
				${detail.bip }
			</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>
				${detail.bhit }
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="location='${conPath }/replyView.do?bid=${detail.bid }&pageNum=${param.pageNum }'">답변글</button>
				<button onclick="location='${conPath }/boardList.do?pageNum=${param.pageNum }'">목록</button>
				<button onclick="location='${conPath }/updateView.do?bid=${detail.bid }&pageNum=${param.pageNum }'">수정</button>
				<button onclick="delete_fun(${detail.bid })">삭제</button>
			</td>
		</tr>
	</table>
  </body>
</html>