package sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/MyServlet") //이 이름의 Servlet을 찾아오겠다라는 기능의 오버라이딩(원래는 web.xml에 명시)
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyServlet() {
        super();
        System.out.println("MyServlet 생성자 호출됨");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); //응답정보로부터 컨텐트타입을 정해줄거야
		PrintWriter out = response.getWriter();//응답정보로부터 getWriter
		Date date = new Date();
		out.println("<html>");
		out.println("<body>");
		out.println("My First Servlet Program !");
		out.println("<br>");
		out.println(date.toString());
		out.println("</body>");
		out.println("</html>");
		
		
	}


}
