package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload2.do")
public class UploadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String savePath="upload";	//서버프로그램에 저장할 폴더이름,실제로 저장되지는 않음.
		int maxFileSize=5*1024*1024;	//업로드파일 최대크기
		String encType="utf-8";	//인코딩 방식
		ServletContext context=getServletContext();
		String uploadPath=context.getRealPath(savePath);	//진짜 저장된 곳 경로 
		System.out.println(uploadPath);
		
		try {
			MultipartRequest multi=new MultipartRequest(	//
					request,
					uploadPath,
					maxFileSize,
					encType,
					new DefaultFileRenamePolicy());
			
			Enumeration files=multi.getFileNames();	//업로드할 파일네임 열거형(여러개의 엘리먼트로 구성)으로 받음
			while(files.hasMoreElements()) {
				String file=(String)files.nextElement();
				String file_name=multi.getFilesystemName(file); //서버에 올라간 파일이름
				String org_file=multi.getOriginalFileName(file);	
				out.print("<br>업로드된 파일명 : " + file_name);
				out.print("<br>원본 파일명 : " + org_file);
				out.print("<hr>");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);	//get,post 둘다 동일하게 처리할시
										//doHandle 메서드 생성
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
}
