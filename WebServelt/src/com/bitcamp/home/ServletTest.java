package com.bitcamp.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test.do")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServletTest() {
    	super();
    }
    
    // doGet() , doPost()메소드가 호출되기 전에 실행되는 메소드
	public void init(ServletTest config) throws ServletException {
		System.out.println("init()메소드 실행됨");
	}
	
	//접속을 get방식으로 했을때 호출되는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()메소드 실행됨");
		System.out.println("num= " + request.getParameter("num"));
		
		//세션의 아이디와 이름을 얻어오기
		HttpSession ses = request.getSession();
		String userid = (String)ses.getAttribute("logId");
		String username = (String)ses.getAttribute("logName");
		
		//접속자에게 정보보내기
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		pw.println("<html>");
		pw.println("<head><title>서블릿을 이용한 홈페이지</title>");
		
		pw.println("<script>");
		pw.println("document.write('자바스크립트에 출력');");
		pw.println("</script>");
		pw.println("</head>");
		
		pw.println("<body>");
		pw.println("<h1>서블릿 홈페이지 테스트(아이디 "+userid + "이름 : " + username +"</h1>");
		pw.println("</body>");
		pw.println("</html>");
	}
	
	//접속을 post방식으로 했을떄 호출되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost()메소드 실행됨");
	}

}
