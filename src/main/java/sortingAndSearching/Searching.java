package sortingAndSearching;

public class Searching {
	public static int binarySearch(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		
		int low = 0;
		int high = nums.length - 1;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			
			if (nums[mid] == target) {
				return mid;
			} else if (target < nums[mid]) {
				// Answer is in the LHS
				high = mid - 1;
			} else {
				// Answer is in the RHS
				low = mid + 1;
			}
		}
		
		return -1; // Answer not found
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 3, 4, 5};
		System.out.println(binarySearch(nums, 3));
	}

}
