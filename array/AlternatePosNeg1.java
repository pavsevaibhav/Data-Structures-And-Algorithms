/*
 Given an array of positive and negative numbers, 
 arrange them in an alternate fashion such that every positive number is followed by negative and 
 vice-versa 
 */
package array;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import inputoutput.InputOutput;

public class AlternatePosNeg1 {

	private static void swap(int[] arr,int left,int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	//without maintaining order of appearance
	private static void alterPosNeg(int[] arr,int n) {
		int left = 0;
		int right = n-1;
		while(left < right) {
			while(left <= n-1 && arr[left] >= 0)
				left++;
			while(right >= 0 && arr[right]<0)
				right--;
			if(left < right) {
				swap(arr,left,right);
				left++;
				right--;
			}
		}
		
		int k = 0;
		while(k < n && left < n) {
			swap(arr,k,left);
			k += 2;
			left += 1;
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = InputOutput.inputArray(n);
		alterPosNeg(arr,n);
		System.out.println(Arrays.toString(arr));
		scan.close();
	}

}
