/*
  Smallest subarray with sum greater than x 
  Given an array of integers (A[])  and a number x, find the smallest subarray with sum greater than the given value.

Note: The answer always exists. It is guaranteed that x doesn't exceed the summation of a[i] (from 1 to N).
Example 1:

Input:
A[] = {1, 4, 45, 6, 0, 19}
x  =  51
Output: 3
Explanation:
Minimum length subarray is 
{4, 45, 6}

Example 2:
Input:
A[] = {1, 10, 5, 2, 7}
   x  = 9
Output: 1
Explanation:
Minimum length subarray is {10}
 */
package array;

import java.io.IOException;
import java.util.Scanner;

import inputoutput.InputOutput;

public class SumGreaterThanX {

	//return length of subarray whose sum is greater than X otherwise return n+1
	private static int smallestSubarray(int[] arr, int n, int X) {
		//Initialize current sum and minimum length
		int currSum = 0;
		int minLength = n+1;
		//initialize starting and ending indices
		int start = 0, end = 0;
		
		while(end < n) {
			//Keep adding array element while current sum is less than X
			while(currSum <= X && end < n) 
				currSum += arr[end++];
			//If current sum becomes greater than X
			while(currSum > X && start < n) {
				//update minLength
				if(end - start < minLength)
					minLength = end - start;
				//remove starting element
				currSum -= arr[start++];
			}
		}
		return minLength;
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = InputOutput.inputArray(n);
		int X = scan.nextInt();
		int subarray = smallestSubarray(arr,n,X);
		System.out.println(subarray);
		scan.close();
	}
}
