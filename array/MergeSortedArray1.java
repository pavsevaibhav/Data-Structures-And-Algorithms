/*
 * Given two sorted arrays arr1[] of size N and arr2[] of size M. Each array is sorted in non-decreasing order. 
 * Merge the two arrays into one sorted array in non-decreasing order without using any extra space.
Example 1:
Input:
N = 4, M = 5
arr1[] = {1, 3, 5, 7}
arr2[] = {0, 2, 6, 8, 9}
Output: 0 1 2 3 5 6 7 8 9
Explanation: Since you can't use any 
extra space, modify the given arrays
to form 
arr1[] = {0, 1, 2, 3}
arr2[] = {5, 6, 7, 8, 9}
 */
package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import inputoutput.InputOutput;

public class MergeSortedArray1 {
	
	private static void mergeSort(int[] arr1,int[] arr2,int n,int m) {
		int gap = (n+m);
		int i = 0;
		int j = 0;
		
		for(gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
			//comparing elements in the first array at index i and i+gap
			for(i = 0; i + gap < n; i++) {
				if(arr1[i] > arr1[i+gap])
					swap(arr1,i,(i+gap));
			}
			//comparing elements in both arrays at index i and j
			for(j = gap > n ? gap-n:0 ; i<n && j<m ; i++,j++) {
				if(arr1[i] > arr2[j]) {
					int temp = arr1[i];
					arr1[i] = arr2[j];
					arr2[j] = temp;
				}
			}
			//comparing elements in the second array at index j and j+gap
			if(j < m) {
				for(j = 0 ; j + gap < m ; j++) {
					if(arr2[j] > arr2[j+gap])
						swap(arr2,j,(j+gap));
				}
			}
		}
	}
	
	//Method to find next gap
	private static int nextGap(int gap) {
		if(gap<=1)
			return 0;
		return (gap/2)+(gap%2);
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		String[] values = buffer.readLine().trim().split(" ");
		int n = Integer.parseInt(values[0]);
		int m = Integer.parseInt(values[1]);
		int[] arr1 = InputOutput.inputArray(n);
		int[] arr2 = InputOutput.inputArray(m);
		mergeSort(arr1,arr2,n,m);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}
}
