package array;

import inputoutput.InputOutput;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class smallestSumSubarray {

	public static void main(String[] args) throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(buffer.readLine());
		int[] arr = InputOutput.inputArray(size);
		minSumSubarray(arr,size);
		buffer.close();
	}

	//Using kadane's algorithm
	private static void minSumSubarray(int[] arr,int n) {
		int minSoFar = Integer.MAX_VALUE;
		int minEndingHere = Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++) {
			if(minEndingHere>0) {
				minEndingHere = arr[i];
				
			} else {
				minEndingHere += arr[i];
			}
			minSoFar = Math.min(minSoFar, minEndingHere);
		}
		System.out.println("Minimum sum subarray: "+minSoFar);
	}
}
