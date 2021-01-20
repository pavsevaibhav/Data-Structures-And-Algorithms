/*
 Given an array of size N containing only 0s, 1s, and 2s; 
 sort the array in ascending order.
Example 1:
Input: 
N = 5
arr[]= {0 2 1 2 0}
Output: 0 0 1 2 2
Explanation: 0s 1s and 2s are segregated 
into ascending order.
 */
package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import inputoutput.InputOutput;

public class Sort012 {
	
	private static void sort012UsingCount(int[] arr,int n) {
		int zerosCount = 0;
		int onesCount = 0;
		int twosCount = 0;
		
		for(int i=0;i<n;i++) {
			switch(arr[i]) {
				 
			case 0:
				//count number of zero's in array
				zerosCount++;
				break;
				
			case 1:
				//count number of one's in an array
				onesCount++;
				break;
				
			case 2:
				//count number of two's in an array
				twosCount++;
				break;
			}
		}
		
		int i = 0;
		while(zerosCount-->0)
			arr[i++] = 0;
		
		while(onesCount-->0)
			arr[i++] = 1;
		
		while(twosCount-->0)
			arr[i++] = 2;
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(buffer.readLine());
		int[] arr = InputOutput.inputArray(size);
		
		sort012UsingCount(arr,size);
		InputOutput.printArray(arr);
		buffer.close();

	}
}
