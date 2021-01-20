/*
 * Given an array arr[] and a number K where K is smaller than size of array,
 the task is to find the Kth smallest element in the given array.
 *  It is given that all array elements are distinct.
 */

package array;

import java.util.Arrays;
import inputoutput.InputOutput;
import java.io.*;

public class KthMaxMin {

	static class KthMinMax {
		int min;
		int max;
	}
	//Method to find out maximum and minimum kth element
	private static KthMinMax getMinMax(int[] arr, int n, int k) {
		KthMinMax kthminmax = new KthMinMax();
		Arrays.sort(arr);
		kthminmax.max = arr[n-k];
		kthminmax.min = arr[k-1];
		return kthminmax;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String[] values = buffer.readLine().trim().split(" ");
		int n = Integer.parseInt(values[0]);
		int k = Integer.parseInt(values[1]);
		int[] arr = InputOutput.inputArray(n);
		
		
		KthMinMax kthminmax = getMinMax(arr,n,k);
		System.out.println(kthminmax.min+" "+kthminmax.max);
		buffer.close();
	}
}
