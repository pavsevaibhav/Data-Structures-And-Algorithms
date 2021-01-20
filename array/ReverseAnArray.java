/*
 Given an array (or string), the task is to reverse the array/string.
Examples : 
Input  : arr[] = {1, 2, 3}
Output : arr[] = {3, 2, 1}

 */
package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import inputoutput.InputOutput;

public class ReverseAnArray {

	private static void reverseArray(int[] arr,int n) {
		int left = 0;
		int right = n-1;
		
		while(left<=right) {
			int temp  = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(buffer.readLine());
		int[] arr = InputOutput.inputArray(size);	
		reverseArray(arr,size);
		InputOutput.printArray(arr);
		buffer.close();
	}
	
}
