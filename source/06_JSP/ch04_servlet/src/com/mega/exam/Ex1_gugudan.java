package com.mega.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex1_gugudan")
public class Ex1_gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Ex1_gugudan() {
        super();    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] su = request.getParameterValues("su");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if ( su != null) {
			for(int i=0; i<su.length; i++) {
				int su2 = Integer.parseInt(su[i]);
				out.print("<h3>"+su2+"단</h3>");
				for(int idx=1; idx<=9; idx++) {
					out.println(su2 +"X" + idx + "=" + (su2*idx)+"<br>");
				}
			}
			/*  확장 for문 이용하고 
			 * for ( String s : su) { int dansu = Integer.parseInt(s); out.println("<h4>" +
			 * dansu + " 단</h4>"); for(int i=1; i <= 9; i++) {
			 * out.printf("%d * %d = %d<br>", dansu, i, dansu*i); } }
			 */
		} else {
			out.println("<h3>선택한 구구단이 없습니다.</h3>");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
