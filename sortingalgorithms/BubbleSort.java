package sortingalgorithms;

public class BubbleSort {

	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		
		for(int i=0;i<n;i++) {
			boolean isSorted = false;

			for(int j = 0;j < n-i-1; j++) {
				if(arr[j]<arr[j+1]) {
					SelectionSort.swap(arr, j, j+1);
					isSorted = true;
				}
			}
			if(!isSorted)
				return;
		}
	}
	
	public static void bubbleSort(int[] arr,int n) {
		for(int i=0;i<n;i++) {
			boolean isSorted = false;

			for(int j = 0;j < n-i-1; j++) {
				if(arr[j]>arr[j+1]) {
					SelectionSort.swap(arr, j, j+1);
					isSorted = true;
				}
			}
			if(!isSorted)
				return;
		}
	}
}
