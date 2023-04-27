package sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Destination
 */
@WebServlet("/Destination")
public class Destination extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Destination() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 try {
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<title>Destination</title>");
		 out.println("</head>");
		 out.println("<body>");
		 out.println("<h1> Destination Servlet 입니다</h1>");
		 out.println("<h2>" + request.getAttribute("myName")+ "입니다</h2>");
		 String myAge = (String)request.getAttribute("myAge");
		 out.println("<h2>" + myAge + "입니다</h2>");
		 out.println("</body>");
		 out.println("</html>");
		 } finally {
		 out.close();
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
