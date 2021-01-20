package searchalgorithms;

public class LinearSearch {
	
	
	public static boolean linearSearch(int[] arr, int ele) {
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==ele)
				return true;
		}
		return false;
	}

	public static boolean linearSearch(int[] arr, int n, int ele) {
		
		for(int i=0;i<n;i++) {
			if(arr[i]==ele)
				return true;
		}
		return false;
	}
}
