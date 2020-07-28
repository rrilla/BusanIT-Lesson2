package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductDao;
import vo.Product;

@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int code=Integer.parseInt(request.getParameter("code"));
		Product product=ProductDao.getInstance().selectOne(code);
		request.setAttribute("product", product);
		request.getRequestDispatcher("product/update.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		ServletContext context=getServletContext();
		String path=context.getRealPath("upload");
		String encType="utf-8";
		int maxSize=10*1024*1024;
		MultipartRequest multi=new MultipartRequest(
				request, 
				path,
				maxSize,
				encType,
				new DefaultFileRenamePolicy());
		int code=Integer.parseInt(multi.getParameter("code"));
		String name=multi.getParameter("name");
		int price=Integer.parseInt(multi.getParameter("price"));
		String description=multi.getParameter("description");
		String pictureurl=multi.getFilesystemName("pictureurl");
		if(pictureurl==null) {
			pictureurl=multi.getParameter("picName");
		}
		ProductDao dao=ProductDao.getInstance();
		boolean flag=dao.update(new Product(code,name,price,pictureurl,description));
		if(flag) {
			response.sendRedirect("list.do");
		}else {
			String msg=URLEncoder.encode("데이터 업데이트 실패","utf-8");
			response.sendRedirect("update.do?msg="+msg);
		}
	}

}

