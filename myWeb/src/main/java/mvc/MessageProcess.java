package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	앞에서 명령어를 전달하는 방식과 비교하면 XXXAction에 해당하는 클래스이다.
//	그리고 controller로 부터 작업의 처리를 지시받아서 실제적인 작업을 처리하는 클래스이다.


//	Controller로 부터 작업의 처리를 지시받아서 작업을 처리
public class MessageProcess implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//	여기에서 필요에 따라서 VO DAO를 초기화 하고 DAO의 메서드를 호출하여
		//	데이터베이스 연동작업을 처리한다.
		//	여기서 얻은 데이터를 아래와 같이 request 내장객체에 셋팅해서
		//	포워딩으로 화면까지 전달하면 된다
		request.setAttribute("message", "요청 파라미터로 명령어를 전달");
		System.out.println("MessageProcess.java 지나갑니다.");
		 return "/mvc/process.jsp";
	}

}
