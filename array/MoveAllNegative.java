/*
 An array contains both positive and negative numbers in random order. 
 Rearrange the array elements so that all negative numbers appear before all positive numbers.
Examples : 
Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
Output: -12 -13 -5 -7 -3 -6 11 6 5
 */
package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import inputoutput.InputOutput;

public class MoveAllNegative {

	private static void moveAllNegPos(int[] arr,int left,int right) {
		if(left<right) {
			int m = left+(right-left)/2;
			moveAllNegPos(arr, left, m);
			moveAllNegPos(arr, m+1, right);
			merge(arr,left,m,right);
		}
	}
	
	private static void merge(int[] arr,int left,int mid,int right) {
		int i = left;
		int j = mid+1;
		
		while(i<=mid && arr[i]<0)
			i++;
		
		while(j<=right && arr[j]<0)
			j++;
		
		reverse(arr,i,mid);
		reverse(arr,mid+1,j-1);
		reverse(arr,i,j-1);
	}
	
	private static void reverse(int[] arr,int left,int right) {
		if(left<right) {
			swap(arr,left,right);
			reverse(arr,++left,--right);
		}
	}
	
	private static void swap(int[] arr,int left,int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}


	public static void main(String[] args)throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(buffer.readLine());
		int[] arr = InputOutput.inputArray(size);
		moveAllNegPos(arr,0,size-1);
		InputOutput.printArray(arr);
		buffer.close();
	}
	
}
