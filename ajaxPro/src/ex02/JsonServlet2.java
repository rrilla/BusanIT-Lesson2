package ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		JSONObject totalObject = new JSONObject();
		JSONArray membersArray = new JSONArray();
		JSONObject memberInfo = new JSONObject();
		
		memberInfo.put("name", "홍길동");
		memberInfo.put("age", 100);
		memberInfo.put("gender", "남");
		memberInfo.put("nickname", "호돌이");
		memberInfo.put("image", "images//baby2.jpg");
		membersArray.add(memberInfo);
		
		memberInfo = new JSONObject();
		memberInfo.put("name", "한재현");
		memberInfo.put("age", 27);
		memberInfo.put("gender", "남");
		memberInfo.put("nickname", "메돌이");
		memberInfo.put("image", "images//baby3.jpg");
		membersArray.add(memberInfo);
		
		memberInfo = new JSONObject();
		memberInfo.put("name", "김연아");
		memberInfo.put("age", 18);
		memberInfo.put("gender", "여자");
		memberInfo.put("nickname", "칼치");
		memberInfo.put("image", "images//baby4.jpg");
		membersArray.add(memberInfo);
		
		totalObject.put("members", membersArray);
		String jsonInfo = totalObject.toString();
		System.out.println(jsonInfo);
		out.print(jsonInfo);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

}
