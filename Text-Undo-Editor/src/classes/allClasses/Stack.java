package classes.allClasses;

public class Stack<T extends Comparable<T>> {
	
		/*
		 * Data member 
		 */
		 private DList<T> list;
		
		/*
		 * Default constructor 
		 */
		 public Stack() {
		        list = new DList<>();
		    }
		
		
		/*
		 * Add an element to the stack, by adding at the beginning of the list 
		 */
		 public void push(T item) {
		        list.addFirst(item);
		    }
		
		
		
		/*
		 * Removes an element from the stack, by removing the first element in the list 
		 */
		 public T pop() {
		        if (isEmpty()) {
		            return null;
		        }
		        return list.remove(list.head());
		    }
		
		
		/*
		 * Takes a look at the first element in the stack without removing it 
		 */
		 public T peek() {
		        if (isEmpty()) {
		            return null;
		        }
		        return list.head().getElement();
		    }
		
		
		/*
		 * Returns the size of the stack 
		 */
		 public int size() {
		        return list.size();
		    }
		
		
		/*
		 * Returns whether the stack is empty or not 
		 */
		 public boolean isEmpty() {
		        return list.isEmpty();
		    }
		
	}
