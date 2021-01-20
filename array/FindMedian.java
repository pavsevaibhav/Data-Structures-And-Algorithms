/*
 Given an array arr[] of N integers, calculate the median
Example 1:
Input: N = 5
arr[] = 90 100 78 89 67
Output: 89
Explanation: After sorting the array 
middle element is the median 

Example 2:
Input: N = 4
arr[] = 56 67 30 79â€‹
Output: 61
Explanation: In case of even number of 
elemebts average of two middle elements 
is the median
 */
package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import inputoutput.InputOutput;

public class FindMedian {

	private static int findMedian(int[] arr,int n) {
		//if size of array is less than one then median is the first element
		if(n<1)
			return arr[n];
		
		int mid = n/2;
		//if size of array is odd then middle element is the median of array
		if(n%2!=0) {
			return arr[mid];
		}else {
		//if size of array is even then median of the elements at index mid and mid-1
			return (arr[mid]+arr[mid-1])/2;
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(buffer.readLine());
		int[] arr = InputOutput.inputArray(n);
		int median = findMedian(arr,n);
		System.out.println(median);
		buffer.close();
	}
}
