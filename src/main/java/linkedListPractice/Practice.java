package linkedListPractice;

import java.util.HashSet;
import java.util.Set;

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
	
	public static ListNode deleteNodeOther(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		
		// Special case of deleting the head
		if (head.val == val) {
			return head.next;
		}
		
		// Otherwise, delete node that isn't the first node in the list
		ListNode curr = head;
		ListNode prev = null;
		
		while (curr != null) {
			if (curr.val == val) {
				// Delete the node and return the original head!
				prev.next = curr.next;
				return head;
			}
			prev = curr;
			curr = curr.next;
		}
		
		// No element was deleted
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
	
	public static ListNode removeDuplicatesWithSpace(ListNode head) {
		Set<Integer> seen = new HashSet<Integer>();
		
		ListNode curr = head;
		ListNode prev = null;
		while (curr != null) {
			// Found a duplicate, remove it from the list!
			if (seen.contains(curr.val)) {
				prev.next = curr.next;
			} else {
				// Otherwise, first time encountering an element, add this to the seen set
				seen.add(curr.val);
				// Note how we only set a new prev if we don't remove the current element
				prev = curr;
			}
			curr = curr.next;
		}
		
		// Head should always be the same- never will change the head as the result of this operation
		return head;
	}
	
	public static ListNode removeDuplicatesWithoutSpace(ListNode head) {
		ListNode curr = head;
		
		// Each time, curr will definitely be pointing to a unique element
		while (curr != null) {
			// For each node, remove all duplicates in the list
			ListNode runner = curr;
			
			while (runner.next != null) {
				// Found a duplicate later in the list, remove this!
				if (runner.next.val == curr.val) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			
			// Move onto the next unique element
			curr = curr.next;
		}
		
		return head;
	}
	
	public static ListNode removeDuplicatesWithoutSpacePrevPointer(ListNode head) {
		if (head == null) {
			return head;
		}
		
		// Curr will point to each unique element in the list and remove all duplicates
		ListNode curr = head;
		while (curr != null) {
			ListNode runner = curr.next;
			ListNode prev = curr;
			
			while (runner != null) {
				if (runner.val == curr.val) {
					prev.next = runner.next;
				} else {
					prev = runner;
				}
				// Always moving the runner, but only updating prev if not a duplicate,
				// otherwise prev refers to the same value
				runner = runner.next;
			}
			
			curr = curr.next;
		}
		
		// Never will modify the head of the list
		return head;
	}
	
	// If k == 1, this is referring to the last element
	public static ListNode returnKthToLastElementBruteForce(ListNode head, int k) {
		// Obtain the size, and then iterate again to return the answer
		int size = size(head);
		
		// Invalid k passed in
		if (k <= 0 || k > size) {
			return null;
		}
		
		ListNode answer = head;
		for (int i = 0; i < size - k; i++) {
			answer = answer.next;
		}
		
		return answer;
	}
	
	public static int size(ListNode head) {
		int size = 0;
		ListNode curr = head;
		
		while (curr != null) {
			size++;
			curr = curr.next;
		}
		
		return size;
	}
	
	public static ListNode returnKthToLastOptimized(ListNode head, int k) {
		// Create two pointers, set them k length apart, and then the slow pointer should be
		// pointing to the answer
		if (head == null) {
			return null;
		}
		
		// Invalid input k
		if (k <= 0) {
			throw new IllegalArgumentException("k provided was too small");
		}
		
		ListNode slow = head;
		ListNode fast = head;
		
		// Offset slow and fast pointer by k elements
		for (int i = 0; i < k; i++) {
			if (fast != null) {
				fast = fast.next;
			} else {
				// Value of k provided was too large!
				throw new IllegalArgumentException("k provided was too large");
			}
		}
		
		// Now, keep iterating until fast is null and slow will point to the answer
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}

	public static void main(String[] args) {
		ListNode head = add(null, 10);
		head = add(head, 10);
		head = add(head, 15);
		head = add(head, 30);
		head = add(head, 30);
		head = add(head, 30);
		head = add(head, 30);
		head = add(head, 15);
		head = add(head, 15);
		
		head = removeDuplicatesWithoutSpacePrevPointer(head);
		System.out.println("Size is: " + size(head));
		printList(head);
		
		ListNode tmp = returnKthToLastOptimized(head, 2);
		System.out.println(tmp.val);
	}

}
