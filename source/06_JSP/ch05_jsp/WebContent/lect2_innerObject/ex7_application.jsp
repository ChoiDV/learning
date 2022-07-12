<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
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
 <%
 	String conPath = request.getContextPath();
 	String appPath = application.getContextPath(); // /ch05_jsp  상대경로 
 	String absolutePath = application.getRealPath(".");  // 현재 프로젝트의 절대경로 
 %>
 <h2>conPath : <%=conPath %></h2>
 <h2>appPath : <%=appPath %></h2>
 <h2>absolutePath : <%=absolutePath %></h2>
 <%
 	String filePath = application.getRealPath("WEB-INF/input.txt");
 	out.println(filePath + " 의 내용입니다.<br>");
 	// 스트림객체생성(파일 연다) - 읽는다 - 스트링객체를 닫는다(파일닫는다)
 	/* BufferedReader br = null;
 	try{
 		br = new BufferedReader(new FileReader(filePath)); // 스트림객체 생성
 		while(true){
 			String line = br.readLine(); // 파일 읽기(한줄씩). 파일의 끝이면(더이상 읽을게 없을때) null을 반환
 			if( line == null){
 				break; // 더 이상 읽을게 없을때				
 			}		
 			out.println(line+"<br>");
 		}
 	} catch(Exception e){
 		out.println("파일이 존재하지 않거나 읽을 수 없는 파일입니다");
 	} finally {
 		try{
 			if( br != null){
 	 			br.close();
 	 		}
 		} catch(Exception e){
 			
 		}		
 	}
 	 */
 	 
 	 // 위의 경우 말고 바로 파일을 열어오기 (간단하게)
 	 BufferedReader br = new BufferedReader(new FileReader(filePath)); // 스트림객체 생성 파일이 없으면 500에러 
	 	while(true){
				String line = br.readLine(); // 파일 읽기(한줄씩). 파일의 끝이면(더이상 읽을게 없을때) null을 반환
				if( line == null){
					break; // 더 이상 읽을게 없을때				
				}		
				out.println(line+"<br>");
			}
 	 br.close();
 %>
 
    
 </body>
</html>
