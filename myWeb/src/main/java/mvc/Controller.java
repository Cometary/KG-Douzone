package mvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 명령어와 명령어 처리 클래스를 쌍으로 저장
	private Map<String, Object> commandMap = new HashMap<String, Object>();

	// 명령어와 처리클래스가 매핑되어 있는 properties 파일을
	// 읽어서 Map객체인 commandMap에 저장
	// 명령어와 처리클래스가 매핑되어 있는 properties 파일은
	// Command.properties파일
	@SuppressWarnings("unchecked")
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Controller에서 init메소드 실행합니다.");
		System.out.println("매개변수의 config : "+config);
		// web.xml에서 propertyConfig에 해당하는 init-param의 값을 읽어옴
		String props = config.getInitParameter("propertyConfig");
		System.out.println("config.getInitParameter('propertyConfig') : "+props);	//Command.properties
		// 명령어와 처리클래스의 매핑정보를 저장할 Properties객체 생성
		Properties pr = new Properties();
		String path = config.getServletContext().getRealPath("/WEB-INF");
		System.out.println("config.getServletContext().getRealPath(WEB-INF) properties파일이 존재하는 경로? : "+ path);
		// D:\myProject\myJSP\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\myWeb\WEB-INF
		FileInputStream f = null;
		try {
			// Command.properties파일의 내용을 읽어옴
			f = new FileInputStream(new File(path, props));
			// Command.properties파일의 정보를 Properties객체에 저장
			pr.load(f);
		} catch (IOException e) {
			throw new ServletException(e);
		} finally {
			if (f != null)
				try {
					f.close();
				} catch (IOException ex) {
				}
		}
		// Iterator객체는 Enumeration객체를 확장시킨 개념의 객체
		Iterator<Object> keyIter = pr.keySet().iterator();
		// 객체를 하나씩 꺼내서 그 객체명으로 Properties객체에 저장된 객체에 접근
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			System.out.println("keyIter.next(); => command properties파일에 표기된 URI가 오리라 예상 : "+command);
			//	/mvc/message.do
			String className = pr.getProperty(command);
			System.out.println("pr.getProperty(command) => className 클래스 이름 예상 : "+className);
			//	mvc.MessageProcess
			try {// 해당 문자열을 클래스로 만든다.
				Class commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance();// 해당클래스의 객체를 생성
				// Map객체인 commandMap에 객체 저장
				commandMap.put(command, commandInstance);
			} catch (ClassNotFoundException e) {
				throw new ServletException(e);
			} catch (InstantiationException e) {
				throw new ServletException(e);
			} catch (IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	}

	public void doGet(// get방식의 서비스 메소드
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void doPost(// post방식의 서비스 메소드
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	// 시용자의 요청을 분석해서 해당 작업을 처리
	private void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = null;
		CommandProcess com = null;
		try {
			String command = request.getRequestURI();
			System.out.println("requestPro메서드의 command=request.getRequestURI() 요청받은 URI 예상 : "+command);
			//	/myWeb/mvc/message.do
			if (command.indexOf(request.getContextPath()) == 0) {
				command = command.substring(request.getContextPath().length());
			}
			com = (CommandProcess) commandMap.get(command);
			view = com.requestPro(request, response);
		} catch (Throwable e) {
			throw new ServletException(e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}