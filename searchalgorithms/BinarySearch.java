package searchalgorithms;

public class BinarySearch {

	public static boolean binarySearchRec(int[] arr, int start, int end, int ele) {
		
		int mid = start + (end - start)/2;
		if(arr[mid] == ele)
			return true;
		else if(arr[mid] > ele)
			return binarySearchRec(arr, start, mid-1, ele);
		else
			return binarySearchRec(arr, mid+1, end, ele);
	}
	
	public static boolean binarySearch(int[] arr,int ele) {
		
		int start = 0;
		int end = arr.length-1;
		while(start<end) {
			int mid = start + (end - start)/2;
			
			if(arr[mid] == ele)
				return true;
			else if(arr[mid] > ele)
				end = mid-1;
			else 
				start = mid+1;
		}
		
		return false;
	}
}
