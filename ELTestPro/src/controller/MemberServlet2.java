package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Member;

@WebServlet("/member")
public class MemberServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberServlet2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		/*List<Member> list = ArrayList<Member>();*/
		HashMap<String, Member> map=new HashMap<String, Member>();
		map.put("m1",new Member(id,pw,name,email));
		map.put("m2",new Member("a1","111","한재현","naver.com"));
		map.put("m3",new Member("a2","222","한수진","naver.com"));
		
		/*list.add(new Member("a1","111","한재현","naver.com)");
		list.add(new Member("a2","222","한수진","naver.com"));
		list.add(new Member("a3","333","채옥자","naver.com"));*/
		request.setAttribute("map",map);
		
		request.setAttribute("member", new Member(id,pw,name,email));
		request.getRequestDispatcher("test2/result2.jsp").forward(request, response);
	}

}
