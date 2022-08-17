<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/bookstyle.css" rel="stylesheet">
</head>
 <body>
 	<jsp:include page="../main/header.jsp" />
    <form action="ex2_bookRegisterPro.jsp" method="post" enctype="multipart/form-data">
    	<table>
    		<caption>책등록</caption>
    		<tr>
    			<th>책제목</th>
    			<td>
    				<input type="text" name="btitle" maxlength="33" required="required">
    			</td>
    		</tr>
    		<tr>
    			<th>책가격</th>
    			<td>
    				<input type="number" name="bprice" min="0" max="9999999" required="required" >
    			</td>
    		</tr>
    		<tr>
    			<th>책이미지</th>
    			<td>
    				<input type="file" name="bimage1">
    			</td>
    		</tr>
    		<tr>
    			<th>책이미지</th>
    			<td>
    				<input type="file" name="bimage2">
    			</td>
    		</tr>
    		<tr>
    			<th>책소개</th>
    			<td>
    				<textarea rows="5" cols="5" name="bcontent"></textarea>
    			</td>
    		</tr>
    		<tr>
    			<th>할인율</th>
    			<td>
    				<input type="number" name="bdiscount" min="0" max="100" value="0" required="required">
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<input type="submit" value="책 등록" class="btn">
    				<input type="button" value="뒤로 가기" class="btn" onclick="history.back()">
    			</td>			
    		</tr>
    		
    	</table>
    </form>
    <jsp:include page="../main/footer.jsp" />
 </body>
</html>
