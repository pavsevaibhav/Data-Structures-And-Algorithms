package sortingalgorithms;
import java.util.Arrays;
public class MergeSort {

	public static void mergeSort(int[] arr) {
		int maxEle = Arrays.stream(arr).max().getAsInt()+1;
		mergeSort(arr,0,arr.length-1,maxEle);
	}
	
	public static void mergeSort(int[] arr, int start, int end,int maxEle) {
		if(start<end) {
			int mid = start + (end - start)/2;
			mergeSort(arr,start,mid,maxEle);
			mergeSort(arr,mid+1,end,maxEle);
			merge(arr,start,mid,end,maxEle);
		}
	}
	
	private static void merge(int[] arr,int start,int mid,int end,int maxEle) {
		int i = start;
		int j = mid+1;
		int k = start;
		
		while(i<=mid && j<=end) {
			if(arr[i]%maxEle <= arr[j]%maxEle) {
				arr[k] = arr[k] + ( arr[i] % maxEle ) * maxEle;
				k++;
				i++;
			} else {
				arr[k] = arr[k] + ( arr[j] % maxEle ) * maxEle;
				k++;
				j++;
			}
		}
		
		while(i<=mid) {
			arr[k] = arr[k] + (arr[i] % maxEle) * maxEle;
			k++;
			i++;
		}
		
		while(j<=end) {
			arr[k] = arr[k] + (arr[j] % maxEle) * maxEle;
			k++;
			j++;
		}
		
		for(i = start;i<=end;i++) {
			arr[i] = arr[i]/maxEle;
		}
	}
}
