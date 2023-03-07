package practicepackage;

public class Search {
	// Returns the index of the element being looked for
	public static int binarySearch(int[] arr, int num) {
		// Input validation
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int low = 0;
		int high = arr.length - 1;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			// Element being searched for has been found
			if (arr[mid] == num) {
				return mid;
			} else if (num > arr[mid]) {
				// Search on the right hand side
				low = mid + 1;
			} else {
				// Search on the left hand side
				high = mid - 1;
			}
		}
		
		// No element has been found
		return -1;
	}
	
	public static int binarySearchRecursive(int[] arr, int num) {
		// Input validation
		if (arr == null || arr.length == 0) {
			return -1;
		}
		
		return helper(arr, num, 0, arr.length - 1);
	}
	
	public static int helper(int[] arr, int num, int start, int end) {
		// Base case/invalid case
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		
		// Found answer
		if (arr[mid] == num) {
			return mid;
		}
		// Answer is in right half of array
		if (num > arr[mid]) {
			return helper(arr, num, mid + 1, end);
		}
		// Answer is in left half of array
		return helper(arr, num, start, mid - 1);
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5};
		System.out.print(binarySearch(arr, 5));
	}

}
