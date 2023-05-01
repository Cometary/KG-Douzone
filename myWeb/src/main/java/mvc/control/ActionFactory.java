package mvc.control;

public class ActionFactory {
	private static ActionFactory factory;

	private ActionFactory() {
	}

	public static synchronized ActionFactory getInstance() {
		if (factory == null) {
			factory = new ActionFactory();
		}
		return factory;
	}

	public Action getAction(String cmd) {
		Action action = null;
		if (cmd.equals("index")) {
			action = new IndexAction();
		}
		/*		앞으로 이 부분이 아래와 같이 확장이됩니다.
		 * 		else if(cmd.equals("insert"){
		 * 			action = new InsertAction();
		 * 		}...
		 */
		
		return action;
	}

}
