package ru.olodiman11.utils.sorting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

@DisplayName("Алгоритмы сортировки")
public class SortingTests {

	@DisplayName("Сортирует массив на месте")
	@ParameterizedTest
	@ArgumentsSource(SortingAlgs.class)
	public void sortsArrayInPlace(Algorithm alg, int[][] cases) {
		for(int i = 0; i < cases.length; i++) {
			int[] c = cases[i];
			int[] origCase = c.clone();
			alg.run(c);
			String errorMsg = arrayToString(origCase) + " -> " + arrayToString(c);
			assertThat(isSorted(c)).as(errorMsg).isTrue();
		}
	}
	
    static class UnsortedArrays implements ArgumentsProvider {
        @Override
        public Stream<Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
					Arguments.of((Object) new int[] {5, 4, 3, 2, 1}),
					Arguments.of((Object) new int[] {-1, 2, 7, 2, 8})
            );
        }
        
        public static int[][] get() {
        	return new int[][] {
        		{5, 4, 3, 2, 1},
        		{-1, 2, 7, 2, 8}
        	};
        }
    }
	
    static class SortingAlgs implements ArgumentsProvider {
        @Override
        public Stream<Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
					Arguments.of(Named.of("Пузырьковая сортировка", (Algorithm) (int[] arr) -> Sorting.bubbleSort(arr)), UnsortedArrays.get()),
					Arguments.of(Named.of("Selection sort", (Algorithm) (int[] arr) -> Sorting.selectionSort(arr)), UnsortedArrays.get()),
					Arguments.of(Named.of("Insertion sort", (Algorithm) (int[] arr) -> Sorting.insertionSort(arr)), UnsortedArrays.get()),
					Arguments.of(Named.of("Merge sort", (Algorithm) (int[] arr) -> Sorting.mergeSort(arr)), UnsortedArrays.get())
            );
        }
    }
    
    public interface Algorithm {
    	public void run(int[] arr);
    }
    
    private boolean isSorted(int[] arr) {
    	for(int i = 0; i < arr.length - 1; i++) {
    		if(arr[i] > arr[i + 1]) return false;
    	}
    	return true;
    }
    
    private String arrayToString(int[] arr) {
    	StringBuilder sb = new StringBuilder("[");
    	for(int i = 0; i < arr.length; i++) {
    		sb.append(arr[i]);
    		if(i < arr.length - 1)
    			sb.append(", ");
    	}
    	sb.append("]");
    	return sb.toString();
    }
    
}
