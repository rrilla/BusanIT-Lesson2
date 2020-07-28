package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajaxTest2")
public class AjaxTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//		String param=request.getParameter("param");
//		System.out.println("param="+param);
		String result="";
		result="<main><book>" +
		"<title><![CDATA[초보자를 위한 자바 프로그래밍]]></title"+
		"<writer><![CDATA[인포북스 | 이병승]]></writer>"+
		"<image><![CDATA[images/baby5.jpg]]></image>"+
		"</book><book>"+
		"<title><![CDATA[모두의 파이썬]]></title>"+
		"<writer><![CDATA[길벗 | 이승찬]]></writer>"+
		"<image><![CDATA[images/baby4.jpg]]></image>"+
		"</book></main>";
		PrintWriter out=response.getWriter();
		System.out.println(result);
		out.print(result);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

}
