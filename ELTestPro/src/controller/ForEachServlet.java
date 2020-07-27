package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Member;

/**
 * Servlet implementation class ForEachServlet
 */
@WebServlet("/forEach")
public class ForEachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ForEachServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Member> list=new ArrayList<Member>();
		list.add(new Member("a1","1234","kim","a1@bbb.com"));
		list.add(new Member("a2","2234","Han","a2@bbb.com"));
		list.add(new Member("a3","3234","Lee","a3@bbb.com"));
		list.add(new Member("a4","4234","Park","a4@bbb.com"));
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("test3/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
