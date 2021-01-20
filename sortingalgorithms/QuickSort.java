package sortingalgorithms;

public class QuickSort {

	public static void quickSort(int[] arr) {
		quickSort(arr,0,arr.length-1);
	}
	
	public static void quickSort(int[] arr,int start,int end) {
		if(start<end) {
			int pi = partition(arr,start,end);
			quickSort(arr,start,pi-1);
			quickSort(arr,pi+1,end);
		}
	}
	
	private static int partition(int[] arr,int start,int end) {
		int pivot = arr[end];
		int i = (start-1);
		
		for(int j = start; j <= end ;j++) {
			if(arr[j]<pivot) {
				i++;
				SelectionSort.swap(arr, i, j);
			}
		}
		SelectionSort.swap(arr, i+1, end);
		return (i+1);
	}
}
