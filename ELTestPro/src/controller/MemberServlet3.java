package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Address;
import vo.Member;

@WebServlet("/member3")
public class MemberServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberServlet3() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//doGet(request, response);
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		Address address=new Address("111111", "부산시 남구");
		
		Member member=new Member(id,pw,name,email);
		member.setAddress(address);
		
		request.setAttribute("member", member);
		
		request.getRequestDispatcher("test2/result3.jsp").forward(request, response);
		
	}

}
