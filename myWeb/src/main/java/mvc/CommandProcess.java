package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//	지난번에 요청 명령어를 전달하는 방식과 비교하면 슈퍼 Action 인터페이스에 해당하는 것
//	이것을 만드는 이유는 예를 들어 ListAction, UpdateAction, DeleteAction 등 다양한
//	Action 클래스가 있다고 할때 이것들을 관리할 방법이 없다.
//	그래서 부모를 통해서 자식을 관리하는 다형성을 이용하기 위해서 슈퍼 액션을 만든것이다.
public interface CommandProcess {
	
	//	지난번에 요청 명령어를 전달하는 방식과 비교하면 execute() 메서드에 해당 것
	//	이 인터페이스를 상속받은 하위 클래스는 모주건 아래의 requestPro를 오버라이딩 해야함.
	//	그러면 우리는 다형성을 이용해서 부모를 통해서 자식의 메서드를 호출 할 수 있다.
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable;
}
