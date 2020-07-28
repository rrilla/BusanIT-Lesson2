package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import dao.ProductDao;
import vo.Product;

@WebServlet("/writer2.do")
public class WriterServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("product/write.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		Map<String,String> map=upload(request,response);
		String name=map.get("name");
		int price=Integer.parseInt(map.get("price"));
		String pictureurl=map.get("pictureurl");
		String description=map.get("description");
		boolean flag=ProductDao.getInstance().insert(new Product(name,price,pictureurl,description));
		if(flag) {
			response.sendRedirect("list.do");
		}
	}
	
	private Map<String,String> upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		Map<String,String> map=new HashMap<String,String>();
		String encoding="utf-8";
		File currentDirPath=new File("e:\\file_repo");
		
		DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(10*1024*1024);
		
		ServletFileUpload upload=new ServletFileUpload(factory);
		try {
			List items=upload.parseRequest((RequestContext) request);
			for(int i=0; i<items.size();i++) {
				FileItem fileItem=(FileItem)items.get(i);
				if(fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName()+"="+fileItem.getString(encoding));
					map.put(fileItem.getFieldName(), fileItem.getString(encoding));
				}else {
					System.out.println("파라미터 명:"+fileItem.getFieldName());
					System.out.println("파일명:"+fileItem.getName());
					System.out.println("파일 크기:"+fileItem.getSize());
					if(fileItem.getSize()>0) {
						int idx=fileItem.getName().lastIndexOf("\\");
						if(idx==-1) {
							idx=fileItem.getName().lastIndexOf("/");
						}
						String fileName=fileItem.getName().substring(idx+1);
						System.out.println(fileName);
						map.put(fileItem.getFieldName(), fileName);
						
						File uploadFile=new File(currentDirPath+"\\"+fileName);
						fileItem.write(uploadFile);
					}
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}
}

