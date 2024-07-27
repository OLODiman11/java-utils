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
    				arr = swapItems(arr, i, i + 1);
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
	
    private static int[] swapItems(int[] arr, int i1, int i2) {
    	if(i1 == i2) return arr;
    	
    	int temp = arr[i1];
    	arr[i1] = arr[i2];
    	arr[i2] = temp;
    	return arr;
    }
}
