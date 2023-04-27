package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 String id = request.getParameter("id");
		 String pwd = request.getParameter("pwd");
		 //db에서 사용자 정보 조회.... 이부분의 코딩을 수정해서 만들어 볼것 //db에서 조회한 사용자의 아이디 비번이 일치하는 경우
		 //클라이언트의 정보를 HttpSession객체에 유지 시킨다.
		 String dbID = "";
		 String dbPWD = "";
		 
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 StringBuffer sb = new StringBuffer();
		 sb.append("select id, pass from login ");
		 sb.append("where id=?");
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "douzone", "1234");
			 ps = con.prepareStatement(sb.toString());
			 ps.setString(1, id);
			 rs = ps.executeQuery();
				if(rs.next()) {
					dbID = rs.getString("id");
					dbPWD = rs.getString("pass");
				}
		 } catch (Exception e) {
			 e.printStackTrace();
		 }finally {
			 try {if(con!=null) {con.close();}} catch (Exception e2) {}
			 try {if(ps!=null) {ps.close();}} catch (Exception e2) {}
			 try {if(rs!=null) {rs.close();}} catch (Exception e2) {}
		 }
		 
		 if(dbID.equals(id) && dbPWD.equals(pwd)){
		 //HttpSession객체 얻기
		 HttpSession session = request.getSession();
		 //클라이언트의 정보를 HttpSession객체에 저장
		 session.setAttribute("user", id);
		 }
		 response.sendRedirect("Login");
		 
	}

}
