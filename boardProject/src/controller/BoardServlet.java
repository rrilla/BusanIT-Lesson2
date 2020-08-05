package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.BoardDao;
import dao.MemberDao;
import vo.Board;
import vo.Member;
import vo.PageMaker;

@WebServlet("*.do")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILE_REPO="C:\\Users\\admin\\Desktop\\git\\Medol-Lesson2\\boardProject\\WebContent\\images\\temp";
    
    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String action=requestURI.substring(contextPath.length());
		if(action.equals("/list.do")) {
			String strPage = request.getParameter("pageNum");
			int pageNum = 1;
			if(strPage != null) {
				pageNum = Integer.parseInt(strPage);
			}
			BoardDao boardDao = BoardDao.getInstance();
			int totalCount = boardDao.getBoardCount();
			PageMaker pageM = new PageMaker(pageNum, totalCount);
			List<Board> list = boardDao.selectAll(pageM.getStart(), pageM.getEnd());
			request.setAttribute("pageM", pageM);
			request.setAttribute("list", list);
			request.getRequestDispatcher("board/list.jsp").forward(request, response);
			
		}else if(action.equals("/writeForm.do")) {
			request.getRequestDispatcher("board/write.jsp").forward(request, response);
			
		}else if(action.equals("/write.do")) {
			Map<String, String> boardMap = upload(request, response);
			String title = boardMap.get("title");
			String content = boardMap.get("content");
			String writer=boardMap.get("writer");
			String image_name = boardMap.get("filename");
			boolean flag = BoardDao.getInstance().insertBoard(new Board(title,content,writer,image_name));
			if(flag) {
				out.print("<script>alert('새글 추가성공.');location.href='list.do';</script>");
			}else {
				out.print("<script>alert('새글 추가실패.');location.href='writeForm.do';</script>");
			}
			
		}else if(action.equals("/read.do")) {
			int bno = Integer.parseInt(request.getParameter("bno"));
			boolean flag = BoardDao.getInstance().updateReadCount(bno);
			Board board = BoardDao.getInstance().selectOne(bno);
			if(board != null && flag == true) {
				request.setAttribute("board", board);
				request.getRequestDispatcher("board/read.jsp").forward(request, response);
			}else {
				out.print("<script>alert('조회 실패.');location.href='list.do';</script>");
			}
			
		}else if(action.equals("/updateForm.do")) {
			int bno = Integer.parseInt(request.getParameter("bno"));
			Board board = BoardDao.getInstance().selectOne(bno);
			if(board != null) {
				request.setAttribute("board", board);
				request.getRequestDispatcher("board/update.jsp").forward(request, response);
			}else {
				out.print("<script>alert('게시글 읽기 실패.');location.href='read.do?bno="+bno+"';</script>");
			}
			
		}else if(action.equals("/update.do")) {
			Map<String, String> boardMap = upload(request, response);
			int bno = Integer.parseInt(boardMap.get("bno"));
			String title = boardMap.get("title");
			String content = boardMap.get("content");
			String writer = boardMap.get("writer");
			String image_name = boardMap.get("filename");
			String pageNum = boardMap.get("pageNum");
			if(image_name == null) {
				image_name = boardMap.get("ex_filename");
			}
			boolean flag = BoardDao.getInstance().insertBoard(new Board(bno, title,content,writer,image_name));
			if(flag) {
				out.print("<script>alert('글 수정성공.');location.href='list.do?pageNum="+pageNum+"';</script>");
			}else {
				out.print("<script>alert('글 수정실패.');location.href='updateForm.do?bno="+bno+"&pageNum="+pageNum+"';</script>");
			}
			
		}else if(action.equals("/delete.do")) {
			String pageNum = request.getParameter("pageNum");
			int bno = Integer.parseInt(request.getParameter("bno"));
			boolean flag = BoardDao.getInstance().deleteBoard(bno);
			if(flag) {
				out.print("<script>alert('글 삭제성공.');location.href='list.do?pageNum="+pageNum+"';</script>");
			}else {
				out.print("<script>alert('글 삭제실패.');location.href='read.do?bno="+bno+"&pageNum="+pageNum+"';</script>");
			}
			
		}else if(action.equals("/loginForm.do")) {
			
			
		}else if(action.equals("/login.do")) {
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			int n=MemberDao.getInstance().login(id,pw);
			if(n==1) {
				HttpSession session=request.getSession();	//세션을만듬
				session.setAttribute("session_id", id);
				out.print("success");
			}else if(n==0) {
				out.print("password error");
			}else {
				out.print("id error");
			}
			
		}else if(action.equals("/logout.do")) {
			HttpSession session = request.getSession();
			session.removeAttribute("session_id");
			//session.invalidate(); //페이지의 세션을 날림(무효화)
			response.sendRedirect("list.do");
			
		}else if(action.equals("/joinForm.do")) {
			request.getRequestDispatcher("member/join.jsp").forward(request, response);
			
		}else if(action.equals("/overappendId.do")) {
			String id = request.getParameter("id");
			boolean flag = MemberDao.getInstance().overappendId(id);
			if(flag) {
				out.print("not usable");
			}else {
				out.print("usable");
			}
			
		}else if(action.equals("/join.do")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			boolean flag = MemberDao.getInstance().insert(new Member(id,pw,name));
			if(flag){
				out.print("<script>alert('회원가입 성공');location.href='list.do';</script>");
			}else {
				out.print("<script>alert('회원가입 실패');location.href='list.do';</script>");
			}
		}	
	}
    
    private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Map<String, String> boardMap = new HashMap<String, String>();
    	String encoding = "utf-8";
    	File currentDirPath = new File(FILE_REPO);
    	DiskFileItemFactory factory = new DiskFileItemFactory();
    	factory.setRepository(currentDirPath);
    	factory.setSizeThreshold(5*1024*1024); 	//한번에 올릴 파일의 크기
    	factory.setDefaultCharset(encoding);	//
    	ServletFileUpload upload = new ServletFileUpload(factory);
    	
    	try {
    		List<FileItem> items = upload.parseRequest(request);
    		for(int i=0; i<items.size(); i++) {
    			FileItem item = (FileItem)items.get(i);
    			if(item.isFormField()) {
    				System.out.println(item.getFieldName() + ":" + item.getString());
    				boardMap.put(item.getFieldName(), item.getString());
    			}else {
    				System.out.println("파라미터명 : " + item.getFieldName());
    				System.out.println("파일명 : " + item.getName());
    				System.out.println("파일크기 : " + item.getSize());
    				
    				if(item.getSize()>0) {
    					int idx = item.getName().lastIndexOf("\\");
    					if(idx == -1) {
    						idx = item.getName().lastIndexOf("/");
    					}
    					String fileName = item.getName().substring(idx + 1);
    					File uploFile = new File(currentDirPath+"\\"+fileName);
    					boardMap.put(item.getFieldName(), fileName);
    					item.write(uploFile);;
    				}
    			}
    		}
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	
    	
    	return boardMap;
     	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

}
