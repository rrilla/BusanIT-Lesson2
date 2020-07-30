package ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@WebServlet("/json")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String jsonInfo = request.getParameter("jsonInfo"); //문자열 객체로 받음
		//PrintWriter out = response.getWriter();
		
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject JsonObject = (JSONObject)jsonParser.parse(jsonInfo);
			System.out.println("회원정보");
			System.out.println(JsonObject.get("name"));
			System.out.println(JsonObject.get("age"));
			System.out.println(JsonObject.get("gender"));
			System.out.println(JsonObject.get("nickname"));
			//out.print(JsonObject);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

}
