/*
 Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
Example 1:
Input:
N = 5
arr[] = {1,2,3,-2,5}
Output: 9
Explanation: Max subarray sum is 9
of elements (1, 2, 3, -2, 5) which 
is a contiguous subarray.
 */

package array;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import inputoutput.InputOutput;

public class KadanesAlgorithms {

	// Method to find maximum sum subarray where all elements may be negative
	private static int maxSumSubarray(int[] arr,int n) {

		int currmax = arr[0];
		int maxsofar = arr[0];
		
		for(int i=1;i<n;i++) {
			currmax = Math.max(arr[i], currmax+arr[i]);
			maxsofar = Math.max(maxsofar, currmax);
		}
		return maxsofar;
	}
	//Method to find maximum sum subarray and print subarray
	private static void maxSumSubarrays(int[] arr,int n) {
		int maxsofar = Integer.MIN_VALUE, maxendinghere = 0;
		int start = 0,s = 0,end=0;
		
		for(int i=0;i<n;i++) {
			maxendinghere += arr[i];
			if(maxsofar<maxendinghere) {
				//starting index of the subarray
				start = s;
				//ending index of the subarray
				end = i;
				maxsofar = maxendinghere;
			}
			if(maxendinghere<0) {
				maxendinghere = 0;
				s = i+1;
			}
		}
		System.out.println("Maximum sum : "+maxsofar);
		System.out.println("subarray: ");
		for(int i=start;i<=end;i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args)throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(buffer.readLine());
		int[] arr = InputOutput.inputArray(n);
		System.out.println(maxSumSubarray(arr,n));
		maxSumSubarrays(arr,n);
		buffer.close();
	}
}
