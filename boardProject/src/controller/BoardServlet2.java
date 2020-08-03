package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;
import dao.MemberDao;
import vo.Board;

/*@WebServlet("*.do")*/
public class BoardServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String action = requestURI.substring(contextPath.length());
		if(action.equals("/list.do")) {
			List<Board> list = BoardDao.getInstance().selectAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("board/list.jsp").forward(request, response);
		}else if(action.equals("/writeForm.do")) {
			
		}else if(action.equals("/write.do")) {
			
		}else if(action.equals("/read.do")) {
			
		}else if(action.equals("updateForm.do")) {
			
		}else if(action.equals("/update.do")) {
			
		}else if(action.equals("/delete.do")) {
			
		}else if(action.equals("loginForm.do")) {
			
		}else if(action.equals("/login.do")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			int n = MemberDao.getInstance().login(id, pw);
			if(n==1) {
				HttpSession session = request.getSession();
				session.setAttribute("session_id", id);
				out.print("success");
			}else if(n==0) {
				out.print("password error");
			}else {
				out.print("id error");
			}
		}
				
	}

}







