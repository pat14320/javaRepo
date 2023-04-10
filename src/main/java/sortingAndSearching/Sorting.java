package sortingAndSearching;

import java.util.Arrays;

public class Sorting {
	public static void quickSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		
		quickSort(arr, 0, arr.length - 1);
	}
	
	public static void quickSort(int[] arr, int low, int high) {
		// No need to sort an array with one element
		if(low < high) {
			int range = high - low + 1;
			int pivot = (int)(Math.random() * range) + low;
			
			// Partition the whole data around a pivot
			int partitionIndex = partition(arr, pivot, low, high);
			
			
			// Now go perform sorting in both sides
			quickSort(arr, low, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, high);
		}
	}
	
	public static void mergeSort(int[] arr) {
		int length = arr.length;
		
		// Base case
		if (length <= 1) {
			return;
		}
		
		// Split array into two halves
		int middle = length / 2;
		int[] leftArray = new int[middle];
		int[] rightArray = new int[length - middle];
		
		for (int i = 0; i < middle; i++) {
			leftArray[i] = arr[i];
		}
		
		for (int i = middle; i < length; i++) {
			rightArray[i - middle] = arr[i];
		}
		
		// Sort both halves
		mergeSort(leftArray);
		mergeSort(rightArray);
		
		// Now merge together the answer in one sorted array and override answer
		merge(arr, leftArray, rightArray);
	}
	
	public static void merge(int[] arr, int[] leftArray, int[] rightArray) {
		int arrIndex = 0, leftIndex = 0, rightIndex = 0;
		
		while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
			if (leftArray[leftIndex] < rightArray[rightIndex]) {
				arr[arrIndex] = leftArray[leftIndex];
				leftIndex++;
				arrIndex++;
			} else {
				arr[arrIndex] = rightArray[rightIndex];
				rightIndex++;
				arrIndex++;
			}
		}
		
		// Fill over any leftover elements
		while (leftIndex < leftArray.length) {
			arr[arrIndex] = leftArray[leftIndex];
			leftIndex++;
			arrIndex++;
		}
		
		while (rightIndex < rightArray.length) {
			arr[arrIndex] = rightArray[rightIndex];
			rightIndex++;
			arrIndex++;
		}
	}
	
	public static int partition(int[] arr, int pivotIndex, int low, int high) {
		int pivotVal = arr[pivotIndex];
		int lesser = low;
		
		swap(arr, pivotIndex, high);
		
		for (int i = low; i < high; i++) {
			if (arr[i] < pivotVal) {
				swap(arr, i, lesser);
				lesser++;
			}
		}
		
		swap(arr, lesser, high);
		return lesser;
	}
	
	public static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{100, 95, 200, 34, 523};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
