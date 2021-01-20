/*
 Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, 
 compute how much water can be trapped between the blocks during the rainy season. 
Example 1:
Input:
N = 6
arr[] = {3,0,0,2,0,4}
Output: 10
 */
package array;

import java.io.IOException;
import java.util.Scanner;

import inputoutput.InputOutput;

public class TrappingWatdr {

	private static int trappingWater(int[] arr,int n) {
		//initialize output
		int result = 0;
		//maximum element on left
		int leftMax = 0;
		//maximum element on right
		int rightMax = 0;
		
		int low = 0, high = n-1;
		
		while(low <= high) {
			if(arr[low] < arr[high]) {
				if(arr[low] > leftMax)
					//update left maximum
					leftMax = arr[low];
				else
					result += leftMax - arr[low];
				low++;
			} else {
				if(arr[high] > rightMax)
					//update right maximum
					rightMax = arr[high];
				else
					result += rightMax - arr[high];
				high--;
			}
		}
		return result;
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = InputOutput.inputArray(n);
		int output = trappingWater(arr,n);
		System.out.println(output);
		scan.close();
	}

}
