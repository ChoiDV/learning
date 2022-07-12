<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
 <body>
	<%--
		String id = request.getParameter("id");
		String[] pets = request.getParameterValues("pet");
		out.println("<h3>ID : " + id + "</h3>");
		out.println("<h3>키우는 동물은 : ");
		if(pets != null){
			for(String pet : pets){
				out.println(pet + " , ");
			}
			
		} else {
			out.println("없습니다.");
		}
		out.println("</h3>");
	--%>
	<h3>ID : ${ param.id } </h3>
	<h3>
		키우는 동물은 : ${ paramValues.pet[0] }  <!--  pets가 null 이면 그냥 빈스트링으로 나오지 에러 안남  -->
					${ paramValues.pet[1] }  <!--  checkbox에서 선택한것이 1개면 0번방에만 2개면   0,1번방에만  -->
					${ paramValues.pet[2] }	
					${ paramValues.pet[3] }
					${ paramValues.pet[4] }	
		${ empty paramValues.pet ? "키우는 동물은 없습니다" : "" }			
	</h3>
	<h2>contextID : ${ initParam.contextID }</h2>
    <h2>contextPW : ${ initParam.contextPW }</h2>
	
 </body>
</html>
