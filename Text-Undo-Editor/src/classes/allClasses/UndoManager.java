package classes.allClasses;

public class UndoManager {
	private final Stack<String> history = new Stack<>();

	public void record(String state) {
		/*
		 * add state to stack 
		 */
		history.push(state);
	}

	public String undo() {
		/*
		 * remove state to stack 
		 */
		
		if (history.isEmpty()) {
			return null;
		}
		return history.pop();
	}
}
