/*
 Given an array of positive and negative numbers, find if there is a subarray (of size at-least one) with 0 sum.

Examples :

Input: {4, 2, -3, 1, 6}
Output: true 
There is a subarray with zero sum from index 1 to 3.
 */
package array;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

import inputoutput.InputOutput;

public class ZeroSumSubarray {

	private static boolean zeroSumSubarray(int[] arr,int n) {
		//Create an empty hashset
		HashSet<Integer> hashset = new HashSet<Integer>();
		int sum = 0;
		for(int i=0;i<n;i++) {
			//add each element in sum variable
			sum += arr[i];
			// Return true in following cases 
            // a) Current element is 0 
            // b) sum of elements from 0 to i is 0 
            // c) sum is already present in hashset 
			if(sum==0 || arr[i]==0 || hashset.contains(sum))
				return true;
			//add sum to hashset
			hashset.add(sum);
		}
		//we only reach to this line if there is no zero sum subarray
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = InputOutput.inputArray(n);
		if(zeroSumSubarray(arr,n))
			System.out.println("Array: "+Arrays.toString(arr)+" contains zero sum");
		else
			System.out.println("Array: "+Arrays.toString(arr)+" doesn't contains zero sum");
		scan.close();
	}
}
