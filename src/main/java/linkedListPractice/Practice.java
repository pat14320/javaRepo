package linkedListPractice;

public class Practice {
	static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
	}

	// This adds to a linked list
	public static ListNode add(ListNode head, int val) {
		// Special case of adding to an empty list
		if (head == null) {
			return new ListNode(val);
		}
		
		ListNode curr = head;
		
		// Add to the very end of the list
		while (curr.next != null) {
			curr = curr.next;
		}
		
		// At this point, at the very last element and add the new element here
		curr.next = new ListNode(val);
		
		// Head remains unchanged, return the original head
		return head;
	}
	
	public static void printList(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	public static ListNode deleteNode(ListNode head, int val) {
		// Special case of deleting on an empty list
		if (head == null) {
			return head;
		}
		
		// Special case of deleting the first element
		if (head.val == val) {
			return head.next;
		}
		
		ListNode curr = head;
		
		while (curr.next != null) {
			if (curr.next.val == val) {
				// Delete element and return
				curr.next = curr.next.next;
				return head;
			}
			// Otherwise, keep moving curr
			curr = curr.next;
		}
		
		return head;
	}
	
	public static ListNode reverseList(ListNode head) {
		// input validation
		if (head == null) {
			return head;
		}
		
		ListNode prev = null;
		ListNode curr = head;
		
		while (curr != null) {
			ListNode next = curr.next;
			
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		// Prev will now be pointing to the head of the reversed linked list
		return prev;
	}
	
	

	public static void main(String[] args) {
		ListNode head = add(null, 10);
		
		head = add(head, 15);
		head = add(head, 30);
		
		head = deleteNode(head, 300);
		
		head = reverseList(head);
		
		printList(head);
	}

}
