package mvc.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	1. 요청을 받는다. web.xml을 통해서
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//	2. 사용자의 요청을 분석
		String cmd = request.getParameter("cmd");
		if (cmd != null) {
			ActionFactory factory = ActionFactory.getInstance();
			//	3. 해당 명령어를 수행 할 수 있는 빈을 생성
			Action action = factory.getAction(cmd);
			//	4. 명령어를 처리 - 가야 할 페이지 명을 알아냄
			ActionForward af = action.execute(request, response);
			//	5. 해당 페이지로 포워딩
			if (af.isRedirect()) {
				response.sendRedirect(af.getUrl());
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(af.getUrl());
				rd.forward(request, response);
			}
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head><title>Error</title></head>");
			out.println("<body>");
			out.println("<h4>올바른 요청이 아닙니다!</h4>");
			out.println("<h4>http://localhost:8080/mvc/test.do?cmd=요청키워드</h4>");
			out.println("</body>");
			out.println("</html>");
		}
	}

}
