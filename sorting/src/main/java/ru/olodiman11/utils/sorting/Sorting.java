package ru.olodiman11.utils.sorting;

/**
 * Hello world!
 *
 */
public class Sorting
{
	private Sorting() {}
	
	public static void bubbleSort(int[] arr) { 
    	while(true) {    		
    		boolean sorted = true;
    		for(int i = 0; i < arr.length - 1; i++) {
    			if(arr[i] > arr[i + 1]) {
    				swapItems(arr, i, i + 1);
    				sorted = false;
    			}
    		}
    		if(sorted) break;
    	} 
	}
	
	public static void selectionSort(int[] arr) {
		int ind = 0;
		while(true) {
			boolean sorted = true;
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for(int i = ind; i < arr.length; i++) {
				if(arr[i] < min) {
					min = arr[i];
					minIndex = i;
				}
				if(i < arr.length - 1 && arr[i] > arr[i+1])
					sorted = false;
			}
			if(sorted) break;
			swapItems(arr, ind, minIndex);
			ind++;
		}
	}
	
	public static void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int backInd = i - 1;
			while(backInd >= 0 && arr[i] < arr[backInd]) 
				backInd--;
			moveItem(arr, i, backInd + 1);
		}
	}
	
	public static void mergeSort(int[] arr) {
		arr = mergeSortUtil(arr);
	}
	
	private static int[] mergeSortUtil(int[] arr) {
		if(arr.length <= 1) return arr;
		
		int[] arr1 = getSubsequence(arr, 0, arr.length / 2);
		int[] arr2 = getSubsequence(arr, arr.length / 2, arr.length);
		
		int[] sArr1 = mergeSortUtil(arr1);
		int[] sArr2 = mergeSortUtil(arr2);
		
		int i1 = 0;
		int i2 = 0;
		for(int i = 0; i < arr.length; i++) {
			if(sArr1[i1] < sArr2[i2]) {
				arr[i] = sArr1[i1++];
				if(i1 >= sArr1.length) {
					finishTail(arr, sArr2, i + 1);
					break;
				}
			}
			else {
				arr[i] = sArr2[i2++];
				if(i2 >= sArr2.length) {
					finishTail(arr, sArr1, i + 1);
					break;
				}
			}
		}
		
		return arr;
	}
	
	private static void finishTail(int[] arr1, int[] arr2, int from) {
		int i2 = arr2.length - (arr1.length - from);
		for(int i = from; i < arr1.length; i++)
			arr1[i] = arr2[i2++];
	}
	
	private static int[] getSubsequence(int[] arr, int from, int to) {
		int[] res = new int[to-from];
		for(int i = from; i < to; i++)
			res[i-from] = arr[i];
		return res;
	}
	
	private static void moveItem(int[] arr, int from, int to) {
		if(from == to) return;
		
		int absDelta = Math.abs(to - from);
		int dir = (to - from) / absDelta;
		int temp = arr[from];
		
		for(int i = from; Math.abs(i - from) < absDelta; i += dir) 
			arr[i] = arr[i + dir];
		
		arr[to] = temp;
	}
	
    private static void swapItems(int[] arr, int i1, int i2) {
    	if(i1 == i2) return;
    	
    	int temp = arr[i1];
    	arr[i1] = arr[i2];
    	arr[i2] = temp;
    }
}
