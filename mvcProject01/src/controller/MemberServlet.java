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

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String command=request.getParameter("command");
		if(command.equals("list")) {
			List<Member> list=MemberDao.getInstance().selectAll();
			request.setAttribute("list",list);
			request.getRequestDispatcher("member/list.jsp")
			.forward(request,response);
			
		}else if(command.equals("joinForm")) {
			request.getRequestDispatcher("member/joinForm.jsp")
			.forward(request,response);
			
		}else if(command.equals("join")) {
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			String name=request.getParameter("name");
			Member member=new Member(id,pw,name);
			boolean flag=MemberDao.getInstance().insert(member);
			if(flag) {
				response.sendRedirect("member?command=list");
			}else {
				String msg=URLEncoder.encode("데이터 입력 실패","utf-8");
				response.sendRedirect("member?command=joinForm&msg="+msg);
			}
			
		}else if(command.equals("updateForm")) {
			String id = request.getParameter("id");
			Member member=MemberDao.getInstance().selectOne(id);
			request.setAttribute("member",member);
			request.getRequestDispatcher("member/updateForm.jsp")
			.forward(request,response);
			
		}else if(command.equals("update")) {
			int no=Integer.parseInt(request.getParameter("no"));
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			String name=request.getParameter("name");
			Member member=new Member(no,id,pw,name);
			boolean flag=MemberDao.getInstance().update(member);
	
			if(flag) {
				response.sendRedirect("member?command=list");
			}else {
				String msg=URLEncoder.encode("데이터 수정 실패","utf-8");
				response.sendRedirect("member?command=updateForm&mag="+msg);
			}
			
		}else if(command.equals("delete")) {
			String id = request.getParameter("id");
			boolean flag=MemberDao.getInstance().delete(id);
			String msg="";
			if(flag) {
				msg = URLEncoder.encode("data delete O", "utf-8");
			}else {
				msg = URLEncoder.encode("data delete O", "utf-8");
			}
			response.sendRedirect("member?command=list&msg="+msg);
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
