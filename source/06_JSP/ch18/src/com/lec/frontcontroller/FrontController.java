package com.lec.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.DeleteService;
import com.lec.service.InsertService;
import com.lec.service.SelectService;
import com.lec.service.Service;
import com.lec.service.UpdateService;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();    //  "/ch18/select.do"
		String conPath = request.getContextPath();  // "/ch18"
		String command = uri.substring(conPath.length());  // conPath 글자만큼 뒤에서부터 즉 /select.do 만 command 에
		System.out.println("uri = " + uri);  // "/ch18/*.do"
		System.out.println("conPath = " + conPath);
		System.out.println("들어온 요청 = "+ command);
		// 이걸로 어떤 요청이 들어왔는지 뽑아내서 그에 맞는 로직 실행
		String viewPage = null; // 뷰단의 이름을 적고  이 페이지로 가라 라고 할거임
		Service service = null;
		if(command.equals("/insert.do")) {
			// insert 로직			
			// 여기서 insert 로직을 수행하면 너무 길어지고 유지보수가 힘들어지기때문에
			// insert 로직을 수행할 객체 생성
			service = new InsertService();
			// 객체이름.메소드(request, response) = insert를 수행할 로직 
			service.execute(request, response);			
			// request.setAttribute("result", "insert 결과");   여기서 request 에 담지않고 메소드에서 담아준다. 즉 여기 서블릿에서는 어떤 요청이들어오면 그에맞는 이동만 시켜준다?			
			// viewPage = "ex2/insert.jsp"; 이렇게 하면 출력을 못함 그래서 
			viewPage = "select.do";		
		} else if(command.equals("/select.do")) {
			// select
			service = new SelectService();
			// 객체이름.메소드(request, response)
			service.execute(request, response);
			// request.setAttribute("list", "list 결과");
			viewPage = "ex2/select.jsp";
		} else if(command.equals("/delete.do")) {
			// delete
			service = new DeleteService();
			// 객체이름.메소드(request, response)
			service.execute(request, response);
			// request.setAttribute("result", "delete 결과");
			// viewPage = "ex2/delete.jsp";
			viewPage = "select.do";
		} else if(command.equals("/update.do")) {
			// update
			service = new UpdateService();
			// 객체이름.메소드(request, response)
			service.execute(request, response);
			// request.setAttribute("result", "update 결과");
			// viewPage = "ex2/update.jsp";
			viewPage = "select.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
