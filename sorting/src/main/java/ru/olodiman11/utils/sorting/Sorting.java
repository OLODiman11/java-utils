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
