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
    
    private static int[] swapItems(int[] arr, int i1, int i2) {
    	int temp = arr[i1];
    	arr[i1] = arr[i2];
    	arr[i2] = temp;
    	return arr;
    }
}
