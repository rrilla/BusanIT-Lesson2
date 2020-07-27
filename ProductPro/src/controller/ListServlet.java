package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import vo.Product;
import dao.ProductDao;

@WebServlet("/list.do")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao dao=ProductDao.getInstance();
		List<Product> list=dao.selectAll();
		request.setAttribute("list", list);
		RequestDispatcher ds = request.getRequestDispatcher("product/list.jsp");
		ds.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

}
