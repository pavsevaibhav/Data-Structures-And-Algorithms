/*Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 

Example 1:

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 
has three inversions (2, 1), (4, 1), (4, 3).

Example 2:

Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already 
sorted so there is no inversion count.
*/


package array;

import java.io.*;
import java.util.Arrays;

import inputoutput.InputOutput;

public class InversionCount {

	private static int inversionCount(int[] arr,int low,int high) {
		//total inversion count = left subarray count+
		//right subarray count
		int count = 0;
		if(low < high) {
			int mid = low + (high - low)/2;
			//left subarray count
			count += inversionCount(arr, low, mid);
			//right subarray count
			count += inversionCount(arr, mid+1, high);
			//merge count
			count += merge(arr,low,mid,high);
		}
		return count;
	}
	//Method to count inversion during merge process
	private static int merge(int[] arr,int low,int mid,int high) {
		int count = 0;
		//left subarray
		int[] left = Arrays.copyOfRange(arr, low, mid+1);
		//right subarray
		int[] right = Arrays.copyOfRange(arr, mid+1, high+1);
		
		int i=0,j=0,k=0;
		
		while(i<left.length && j<right.length) {
			if(left[i] <= right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
				count += (mid+i) - (low+i);
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(buffer.readLine());
		int[] arr = InputOutput.inputArray(size);
		int inv_count = inversionCount(arr,0,size-1);
		System.out.println(inv_count);
		buffer.close();		
	}
}
