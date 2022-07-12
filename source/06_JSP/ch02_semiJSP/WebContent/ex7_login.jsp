<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>
  </style>
</head>
 <body>
    <form action='ex7_loginPro.jsp' method="post">
    	<table>
    		<tr>
    			<th>로그인 화면</th>   			
    		</tr>
    		<tr>
    			<td>이름<input type="text" name="name"></td>
    		</tr>	
    		<tr>
    			<td>아이디<input type="text" name="id"></td>
    		</tr>
    		<tr>
    			<td>비밀번호<input type="password" name="pw"></td>
    		</tr>
    			
    		<tr>
    		 <td colspan="2"><input type="submit" value="로그인"></td>
    		 </tr>
    	</table>
    </form>
 </body>
</html>
