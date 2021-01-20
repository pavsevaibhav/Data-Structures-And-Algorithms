package sortingalgorithms;

public class SelectionSort {

	public static void selectionSort(int[] arr) {
		int n = arr.length;
		
		for(int i=0;i<n-1;i++) {
			int minIndex = i;
			for(int j=i;j<n;j++) {
				if(arr[j]<arr[minIndex])
					minIndex = j;
			}
			swap(arr,i,minIndex);
		}
	}
	
	public static void selectionSort(int[] arr, int n) {
		
		for(int i=0;i<n-1;i++) {
			int minIndex = i;
			for(int j=i;j<n;j++) {
				if(arr[j]<arr[minIndex])
					minIndex = j;
			}
			swap(arr,i,minIndex);
		}
	}
	public static void swap(int[] arr,int index1,int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
