package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.MemberDao;
import vo.Member;


@WebServlet("/servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet() 호출됨");
		
		String strJson = "";
		MemberDao memberDao = MemberDao.getInstance();
		
		memberDao = memberDao.getInstance();
		List<Member> list = memberDao.selectAll(); 
		
		Gson gson = new Gson();
		strJson = gson.toJson(list);
		System.out.println(list);
				
		// 클라이언트로 출력하기
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(strJson);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		System.out.println("doPost() 호출됨");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");

		if (id.equals("") || pw.equals("") || name.equals("")) {
			response.setStatus(500);
			return;
		}

		Member member = new Member(id, pw, name);

		MemberDao memberDao = MemberDao.getInstance();
		memberDao.insertMember(member);

		out.print("ㅊㅋ 생산성공");
		out.close();
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPut() 호출됨");
		
		String no = request.getParameter("no")== null ? "" : request.getParameter("no");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		
		System.out.println("1");
		System.out.println(no+id+name+pw);
		
		Member member = new Member();
		member.setNo(Integer.parseInt(no));
		member.setId(id);
		member.setName(name);
		member.setPw(pw);
		
		System.out.println("1");
		
		MemberDao memberDao = MemberDao.getInstance();
		memberDao.update(member);
		
		response.setContentType("text/html; charset=UTF-8"); // 응답에서 최종적 인코딩방식 설정,jsp 설정에도 있음
		PrintWriter out = response.getWriter();
		out.print("ㅊㅋ글 수정성공"); 
		out.close();
	}
	
}
