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
import vo.Member;

@WebServlet("*.do")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String action=requestURI.substring(contextPath.length());
		if(action.equals("/list.do")) {
			List<Board> list=BoardDao.getInstance().selectAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("board/list.jsp")
			.forward(request, response);
		}else if(action.equals("/writeForm.do")) {
			
		}else if(action.equals("/write.do")) {
			
		}else if(action.equals("/read.do")) {
			
		}else if(action.equals("/updateForm.do")) {
			
		}else if(action.equals("/update.do")) {
			
		}else if(action.equals("/delete.do")) {
			
		}else if(action.equals("/loginForm.do")) {
			
		}else if(action.equals("/login.do")) {
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			int n=MemberDao.getInstance().login(id,pw);
			if(n==1) {
				HttpSession session=request.getSession();	//세션을만듬
				session.setAttribute("session_id", id);
				out.print("success");
			}else if(n==0) {
				out.print("password error");
			}else {
				out.print("id error");
			}
		}else if(action.equals("/logout.do")) {
			HttpSession session = request.getSession();
			session.removeAttribute("session_id");
			//session.invalidate(); //페이지의 세션을 날림(무효화)
			response.sendRedirect("list.do");
		}else if(action.equals("/joinForm.do")) {
			request.getRequestDispatcher("member/join.jsp").forward(request, response);
		}else if(action.equals("/overappendId.do")) {
			String id = request.getParameter("id");
			boolean flag = MemberDao.getInstance().overappendId(id);
			if(flag) {
				out.print("not usable");
			}else {
				out.print("usable");
			}
		}else if(action.equals("/join.do")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			boolean flag = MemberDao.getInstance().insert(new Member(id,pw,name));
			if(flag){
				out.print("<script>alert('회원가입 성공');location.href='list.do';</script>");
			}else {
				out.print("<script>alert('회원가입 실패');location.href='list.do';</script>");
			}
		}	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

}
