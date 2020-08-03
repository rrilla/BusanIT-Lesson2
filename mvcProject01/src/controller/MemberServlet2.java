package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.Member;

@WebServlet("*.do") //끝에 do가있는거 다받을거다
public class MemberServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String RequestURI = request.getRequestURI();
		System.out.println(RequestURI);
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		String command = RequestURI.substring(contextPath.length());
		System.out.println(command);
		//String command = null;
		//String command=request.getParameter("command");
		if(command.equals("/list.do")) {
			List<Member> list=MemberDao.getInstance().selectAll();
			request.setAttribute("list",list);
			request.getRequestDispatcher("member/list.jsp")
			.forward(request,response);
			
		}else if(command.equals("/joinForm.do")) {
			request.getRequestDispatcher("member/joinForm.jsp")
			.forward(request,response);
			
		}else if(command.equals("/join.do")) {
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			String name=request.getParameter("name");
			Member member=new Member(id,pw,name);
			boolean flag=MemberDao.getInstance().insert(member);
			if(flag) {
				response.sendRedirect("/list.do");
			}else {
				String msg=URLEncoder.encode("데이터 입력 실패","utf-8");
				response.sendRedirect("/joinForm.do?msg="+msg);
			}
			
		}else if(command.equals("/updateForm.do")) {
			int no=Integer.parseInt(request.getParameter("no"));
			Member member=MemberDao.getInstance().selectOne(no);
			request.setAttribute("member",member);
			request.getRequestDispatcher("member/updateForm.jsp")
			.forward(request,response);
			
		}else if(command.equals("/update.do")) {
			int no=Integer.parseInt(request.getParameter("no"));
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			String name=request.getParameter("name");
			Member member=new Member(no,id,pw,name);
			boolean flag=MemberDao.getInstance().update(member);
	
			if(flag) {
				response.sendRedirect("/list.do");
			}else {
				String msg=URLEncoder.encode("데이터 수정 실패","utf-8");
				response.sendRedirect("/updateForm.do?msg="+msg);
			}
			
		}else if(command.equals("/delete.do")) {
			int no=Integer.parseInt(request.getParameter("no"));
			boolean flag=MemberDao.getInstance().delete(no);
			String msg="";
			if(flag) {
				msg=URLEncoder.encode("데이터 삭제 성공","utf-8");
			}else {
				msg=URLEncoder.encode("데이터 삭제 실패","utf-8");
			}
			response.sendRedirect("/list.do?msg="+msg);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

}
