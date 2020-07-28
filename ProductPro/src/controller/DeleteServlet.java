package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import vo.Product;

@WebServlet("/delete.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int code=Integer.parseInt(request.getParameter("code"));
		Product product=ProductDao.getInstance().selectOne(code);
		request.setAttribute("product", product);
		request.getRequestDispatcher("product/delete.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		int code=Integer.parseInt(request.getParameter("code"));
		boolean flag=ProductDao.getInstance().delete(code);
		if(flag) {
			response.sendRedirect("list.do");
		}else {
			String msg=URLEncoder.encode("삭제 실패", "utf-8");
			response.sendRedirect("delete.do?msg="+msg);
		}
	}
}
