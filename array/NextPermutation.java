/*
 Implement the next permutation, which rearranges the list of numbers into Lexicographically next greater permutation of list of numbers.
  If such arrangement is not possible, it must be rearranged to the lowest possible order 
 i.e. sorted in an ascending order. You are given an list of numbers arr[ ] of size N.

Example 1:
Input: N = 6
arr = {1, 2, 3, 6, 5, 4}
Output: {1, 2, 4, 3, 5, 6}
Explaination: The next permutation of the 
given array is {1, 2, 4, 3, 5, 6}.
 */
package array;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import inputoutput.InputOutput;

public class NextPermutation {

	private static void nextPermutation(int[] arr,int n) {
		int i = 0;
		//Start from the right most digit  
        // and find the first digit that is smaller  
        // than the digit next to it
		for(i = n-1; i > 0;i--)
			if(arr[i] > arr[i-1])
				break;
		
		int x = arr[i-1];
		int min = i;
		// If no such digit is found, then all  
        // digits are in descending order means  
        // there cannot be a greater number with  
        // same set of digits 
		if(i == 0)
			return;
		else {
			// Find the smallest digit on right  
            // side of (i-1)'th digit that is greater  
            // than number[i-1] 
			for(int j = i+1 ;j < n; j++) {
				if(arr[j] > x && arr[j] < arr[min])
					min = j;
			}
			//Swap the above found smallest  
            // digit with number[i-1] 
			swap(arr,i-1,min);
			//Sort the digits after (i-1)  
            // in ascending order 
			Arrays.sort(arr, i, n);
		}
	}
	private static void swap(int[] arr, int i, int min) {
		int temp = arr[i];
		arr[i] = arr[min];
		arr[min] = temp;
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = InputOutput.inputArray(n);
		nextPermutation(arr,n);
		
		for(int ele:arr) 
			System.out.print(ele+" ");
		System.out.println();
		scan.close();
	}
}
