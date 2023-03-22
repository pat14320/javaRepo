package stacksAndQueues;

import java.util.Stack;

public class Practice {
	public static void sortStack(Stack<Integer> s) {
		if (s == null || s.size() == 0) {
			return;
		}
		
		Stack<Integer> sorted = new Stack<Integer>();
		
		// Insert all elements from original stack in sorted order to the "sorted" stack
		while (!s.isEmpty()) {
			// Find top element from unsorted stack
			int tmp = s.pop();
			
			// Now, insert this element in the proper position in the sorted stack
			while (!sorted.isEmpty() && sorted.peek() > tmp) {
				// Keep removing element on sorted stack if it's greater than the temp element
				s.push(sorted.pop());
			}
			
			// At the proper position now, insert tmp into the sorted stack
			sorted.push(tmp);
		}
		
		// Now sorted stack has elements in descending order with larger elements on top.
		// Reverse this and add to the empty stack and that'll be your answer with the smallest
		// elements on top.
		while (!sorted.isEmpty()) {
			s.push(sorted.pop());
		}
	}
	
	public static void printStack(Stack<Integer> s) {
		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		
		s.push(12);
		s.push(5);
		s.push(7);
		s.push(2);
		s.push(20);
		
		sortStack(s);
		printStack(s);
	}

}
