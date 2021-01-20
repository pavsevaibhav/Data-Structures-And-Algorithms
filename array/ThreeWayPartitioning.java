/*
 Given an array of size N and a range [a, b]. The task is to partition the array around the range
  such that array is divided into three parts.
1) All elements smaller than a come first.
2) All elements in range a to b come next.
3) All elements greater than b appear in the end.
The individual elements of three sets can appear in any order. You are required to return the modified array.
 */
package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import inputoutput.InputOutput;

public class ThreeWayPartitioning {

	private static void partitioning(int[] arr,int n,int lowVal,int highVal) {
		//initialize the positions
		int low = 0,mid = 0 ,high = n-1;
		//traverse the array from left to right
		while(mid<=high) {
			//if element at mid position is less than lowVal then swap 
			//element at index mid and low
			if(arr[mid]<lowVal) {
				swap(arr,low,mid);
				low++;mid++;
			}
			//if element at mid position is greater than highVal then swap
			//element at index mid and high
			else if(arr[mid]>highVal) {
				swap(arr,mid,high);
				high--;
			}
			//if element at mid position is greater than lowVal and less than
			//highVal then just increment mid
			else {
				mid++;
			}
		}
	}
	private static void swap(int[] arr,int low,int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(buffer.readLine());
		int[] arr = InputOutput.inputArray(size);
		String[] values = buffer.readLine().trim().split(" ");
		int lowValue = Integer.parseInt(values[0]);
		int highValue = Integer.parseInt(values[1]);
		partitioning(arr,size,lowValue,highValue);
		System.out.println();
		System.out.println(Arrays.toString(arr));
		buffer.close();
	}
}
