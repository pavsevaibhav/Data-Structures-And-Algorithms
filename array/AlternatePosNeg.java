/*
 Given an array of positive and negative numbers, arrange them in an alternate fashion such that every positive number is followed by negative and vice-versa. Order of elements in output doesn’t matter. Extra positive or negative elements should be moved to end.
Examples: 
Input :
arr[] = {-2, 3, 4, -1}
Output :
arr[] = {-2, 3, -1, 4} OR {-1, 3, -2, 4}
 */
package array;

import java.io.*;
import java.util.Arrays;

import inputoutput.InputOutput;

public class AlternatePosNeg {

	private static void alternatePosNeg(int[] arr,int n) {
		int left = 0;
		int right = n-1;
		int k = 0;
		//move all the negative numbers at the end of the array
		while(left<right) {
			//if element at left index is positive then increment left
			while(left<=n-1 && arr[left]>0)
				left += 1;
			//if element at right index is negative then decrement right;
			while(right>=0 && arr[right]<0)
				right -=1;
			//else swap elements at index left and right
			if(left<right) {
				swap(arr,left,right);
			}
		}
		//swap alternative element
		while(k < n && left < n) {
			swap(arr,k,left);
			k += 2;
			left += 1;
		}
	}
	
	private static void swap(int[] arr,int left,int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(buffer.readLine());
		int[] arr = InputOutput.inputArray(size);
		alternatePosNeg(arr,size);
		System.out.println(Arrays.toString(arr));
	}
}
