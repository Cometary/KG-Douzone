package mvc.control;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("IndexAction의 execute() 수행됨!");
		/*		필요에 따라서 VO, DAO 객체를 초기화 하고
		 * 		DAO에 메서드를 호출하여 데이터베이스 연동 작업을 수행함.
		 * 		그 결과로 얻은 데이터들은 아래와 같이 셋팅 합니다.
		 * 		request.setAttribute(key, value)
		 * 		최종적으로 아래와 같이 가야할 페이지와 가야할 방식을 정해서 넘겨주면 됨
		 * */
		 return new ActionForward("index.jsp", false);

	}

}
