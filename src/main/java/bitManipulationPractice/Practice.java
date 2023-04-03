package bitManipulationPractice;

public class Practice {
	
	// Updating bits in N by inserting M from position i to j. Note that i is always smaller
	public static int updateBits(int n, int m, int i, int j) {
		// 1. Clear the bits in N from i to j by forming a mask of all 1's except for
		// 	  zeros from position i to j
		
		// Create left half of mask first
		int mask = -1;
		
		int left = mask << j;
		
		int right = (1 << i) - 1;

		int clearMask = left | right;
		n = clearMask & n;
		
		// 2. Move m into position to replace the bits
		int mMask = m << i;
		
		// 3. Perform an | operation and will thereby combine n and m
		return n | mMask;
	}

	public static void main(String[] args) {
		// Testing updateBits with 10000000000. That's one followed by ten zeros. Value of 2^9 = 512
		int n = 512;
		// M has value of 10011. Which equals 19
		int m = 19;
		
		// Answer should be 10001001100. Which is 76 (newly added M value) + 512 (original N value),
		// which equals 588.
		System.out.println(updateBits(n, m, 2, 6));
		
	}

}
