package practicepackage;

import java.util.Arrays;

public class Sort {
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		// Input validation
		if (arr == null || arr.length == 0) {
			return;
		}
		
		// No need to partition an array if there is only one element in the array
		if (left < right) {
			int partitionIndex = partition(arr, left, right);
			// Recurse on the left partition
			quickSort(arr, left, partitionIndex - 1);
			// Recurse on the right partition
			quickSort(arr, partitionIndex + 1, right);
		}
	}
	
	// Partition partitions an entire array around a pivot element. Selecting
	// the pivot element to always be the end of the boundary
	public static int partition(int[] arr, int left, int right) {
		int range = right - left + 1;
		// Find the range of all the elements beginning from the start but still need
		// to offset the beginning
		int pivot = (int) (Math.random() * range) + left;
		
		// Always move this randomly selected element to the end of the range first
		swap(arr, pivot, right);
		
		int lesser = left;
		int iter = left;
		
		while (iter < right) {
			// Found an element less than or equal to the pivot, move to the left half
			if (arr[iter] <= pivot) {
				swap(arr, iter, lesser);
				lesser++;
			}
			iter++;
		}
		
		// At the end, move the pivot element in the correct position
		swap(arr, right, lesser);
		return lesser;
	}
	
	public static void mergeSort(int[] arr) {
		if (arr == null) {
			return;
		}
		
		int length = arr.length;
		// Base case: array of one element is already sorted
		if (length <= 1) {
			return;
		}
		
		// Split the original array into two halves first
		int middle= length / 2;
		int[] leftArray = new int[middle];
		int[] rightArray = new int[length - middle];
		
		// Populate the two newly created arrays
		for (int i = 0; i < middle; i++) {
			leftArray[i] = arr[i];
		}
		
		for (int i = middle; i < length; i++) {
			rightArray[i - middle] = arr[i];
		}
		
		// Sort both of the arrays and then merge them together
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(arr, leftArray, rightArray);
	}
	
	public static void merge(int[] arr, int[] leftArray, int[] rightArray) {
		int left = 0;
		int right= 0;
		int curr = 0;
		
		while (left < leftArray.length && right < rightArray.length) {
			// Keep finding the smallest element to add to the newly sorted array
			if (leftArray[left] < rightArray[right]) {
				arr[curr] = leftArray[left];
				curr++;
				left++;
			} else {
				arr[curr] = rightArray[right];
				curr++;
				right++;
			}
		}
		
		// Move leftover elements from one array to the other
		while (left < leftArray.length) {
			arr[curr] = leftArray[left];
			left++;
			curr++;
		}
		
		while (right < rightArray.length) {
			arr[curr] = rightArray[right];
			right++;
			curr++;
		}
	}
	
	public static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	// This is problem 10.1 from CTCI
	public static void merge(int[] a, int [] b, int aSize, int bSize) {
		// Index of last element in array a
		int indexA = aSize - 1;
		// Index of last element in array b
		int indexB = bSize - 1;
		
		// Index of the largest element being inserted into the newly sorted array/
		// Assumption is that array a has enough buffer to fit the elements of array b
		int indexSorted = aSize + bSize - 1;
		
		while (indexB >= 0) {
			// Array a has the larger element!
			if (indexA >= 0 && a[indexA] > b[indexB]) {
				a[indexSorted] = a[indexA];
				indexA--;
			} else {
				// Array b has the larger element!
				a[indexSorted] = b[indexB];
				indexB--;
			}
			// Decrement the newly sorted array
			indexSorted--;
		}
	}
	
	public static void main(String[] args) {
		// Code for testing 10.1 from CTCI
		int[] arrA = new int[10];
		arrA[0] = 3;
		arrA[1] = 10;
		arrA[2] = 13;
		
		int[] arrB = new int[]{4, 5, 12};
		merge(arrA, arrB, 3, 3);
		System.out.println(Arrays.toString(arrA));
		
		// Testing merge sort
		int[] arr = new int[] {10, 20, 3, 5, 90, 1};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
