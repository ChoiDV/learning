package com.mega.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "exam_Ex2", urlPatterns = { "/exam_Ex2" })
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public Ex2() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if( name != null) {
			out.println("<h4> 이름은 : " + name + "</h4>");			
		} else {
			out.println("<h4>이름을 입력하지 않으셨습니다. </h4>");
		}
		if( address != null) {
			out.println("<h4> 주소는 : " + address + "</h4>");
		} else {
			out.println("<h4>주소를 입력하지 않으셨습니다.</h4>");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
