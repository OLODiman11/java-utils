package ru.olodiman11.utils.sorting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

@DisplayName("Алгоритмы сортировки")
public class SortingTests {

	@Nested
	@DisplayName("Пузырьковая сортировка")
	public class BubbleSort {
		@Nested
		@DisplayName("В новом массиве")
		public class ClonedArray {			
			@ParameterizedTest
			@ArgumentsSource(UnsortedArrays.class)
			@DisplayName("Сортирует массив")
			public void sortsArray(int[] arr)
			{    	
				int[] res = Sorting.bubbleSort(arr);
				
				assertThat(isSorted(res)).isTrue();
			}
			
			@ParameterizedTest
			@ArgumentsSource(UnsortedArrays.class)
			@DisplayName("Не изменяет исходный массив")
			public void doesntModifyOriginalArray(int[] arr)
			{
				int[] arrClone = arr.clone();
				
				Sorting.bubbleSort(arr);
				
				assertThat(arr).isEqualTo(arrClone);
			}
		}
		
		@Nested
		@DisplayName("В исходном массиве")
		public class InPlace {
			@ParameterizedTest
			@ArgumentsSource(UnsortedArrays.class)
			@DisplayName("Сортирует массив")
			public void sortsArray(int[] arr)
			{
				Sorting.bubbleSortInPlace(arr);
				
				assertThat(isSorted(arr)).isTrue();
			}
			    
			@ParameterizedTest
			@ArgumentsSource(UnsortedArrays.class)
			@DisplayName("Изменяет исходный массив")
			public void modifiesOriginalArray(int[] arr)
			{
				int[] arrClone = arr.clone();
			
				Sorting.bubbleSortInPlace(arr);
				
				assertThat(arr).isNotEqualTo(arrClone);
			}
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
    }
    
    private boolean isSorted(int[] arr) {
    	for(int i = 0; i < arr.length - 1; i++) {
    		if(arr[i] > arr[i + 1]) return false;
    	}
    	return true;
    }
    
}
