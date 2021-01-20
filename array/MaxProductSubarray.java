/*
 Given an array A[] that contains both positive and negative integers, find the maximum product subarray.

Examples :

Input: A[] = { 6, -3, -10, 0, 2 }
Output: 180  // The subarray is {6, -3, -10}
 */
package array;

import java.io.IOException;
import java.util.Scanner;

import inputoutput.InputOutput;

public class MaxProductSubarray {

	private static int maxProduct(int[] arr, int n) {
		//initialize maxVal as first element of array
		int maxVal = arr[0];
		//initialize minVal as first element of array
		int minVal = arr[0];
		//initialize maxProduct as first element
		int maxProduct = arr[0];
		//traverse the array
		for(int i=1;i<n;i++) {
			//if current element is negative then swap maxVal and minVal 
			if(arr[i] < 0) {
				int temp = maxVal;
				maxVal = minVal;
				minVal = temp;
			}
			//update maxVal as max from current element and product of current element and maxVal
			maxVal = Math.max(arr[i], maxVal*arr[i]);
			//update minVal as min from current element and product of current element and minVal
			minVal = Math.min(arr[i], minVal*arr[i]);
			//update maxProduct as max from maxProduct and maxVal
			maxProduct = Math.max(maxProduct, maxVal);
		}
		return maxProduct;
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] arr = InputOutput.inputArray(size);
		int maxProduct = maxProduct(arr,size);
		System.out.println(maxProduct);
		scan.close();
	}
}
