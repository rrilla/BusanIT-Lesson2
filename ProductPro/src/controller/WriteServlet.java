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

@WebServlet("/write.do")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("product/write.jsp")
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
		
		String name=multi.getParameter("name");
		int price=Integer.parseInt(multi.getParameter("price"));
		String description=multi.getParameter("description");
		String pictureurl=multi.getFilesystemName("pictureurl");
		
		ProductDao dao=ProductDao.getInstance();
		boolean flag=dao.insert(new Product(name,price,pictureurl,description));
		if(flag) {
			response.sendRedirect("list.do");
		}else {
			String msg=URLEncoder.encode("데이터 입력 실패","UTF-8");
			response.sendRedirect("writeForm.do?msg="+msg);
		}
	}
}
