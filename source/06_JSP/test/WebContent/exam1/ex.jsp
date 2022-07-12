<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>
  	#wrap {
  		border:1px solid blue;
  		width: 300px;
  	}
  	#wrap p{
  		border-bottom: 1px solid blue;
  		height:30px;  		  		
  	}
  	#wrap button {
  		width:50px;
  		height:50px;
  		background-color: lightblue;
  		border: 1px solid blue;
  		cursor: pointer;  	
  		margin: 20px;			
  	}
  	#msg {
  		color:red;
  	}
  	

   
  </style>
</head>
 <body>
    <div id="wrap">
    	<p>동전이 있는 곳을 맞춰봐</p>
    	<button onclick="location.href='exPro.jsp?where=1'" name="where" >1번</button>
    	<button onclick="location.href='exPro.jsp?where=2'" name="where" >2번</button>    	    
    	<button onclick="location.href='exPro.jsp?where=3'" name="where" >3번</button>    	   	
    </div>
    <div id="msg">
    	<%
 		String msg = request.getParameter("msg");
 		if (msg != null){
 			out.print(msg);
 		}
 	%>
 	</div>
 </body>
</html>
