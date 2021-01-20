/*
 Given two arrays: arr1[0..m-1] and arr2[0..n-1]. Find whether arr2[] is a subset of arr1[] or not. 
 Both the arrays are not in sorted order. It may be assumed that elements in both array are distinct.
Examples: 
    Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1} 
    Output: arr2[] is a subset of arr1[]
    Input: arr1[] = {10, 5, 2, 23, 19}, arr2[] = {19, 5, 3} 
	Output: arr2[] is not a subset of arr1[] 
 */
package array;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import inputoutput.InputOutput;

public class SubsetOfAnotherArray {
	
	private static boolean isSubset(int[] arr1,int[] arr2,int n,int m) {
		//HashMap to store frequency of all the element of arr1
		HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
		//Traverse the first arr1
		for(int i = 0; i < n; i++) {
			frequency.put(arr1[i], frequency.getOrDefault(arr1[i], 0) + 1);
		}
		//traverse the second array
		for(int i = 0; i < m; i++) {
			// Decrease the frequency if the 
		    // element was found in the frequency 
		    // table with the frequency more than 0. 
		    // else return false and if loop is 
		    // completed return true. 
			if(frequency.getOrDefault(arr2[i], 0) > 0)
				frequency.put(arr2[i], frequency.getOrDefault(arr1[i], 0) - 1);
			else
				return false;
		}
		//we come to this line only if arr2[] is subset of arr1[] and return true
		return true;
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] arr1 = InputOutput.inputArray(n);
		int[] arr2 = InputOutput.inputArray(m);
		boolean isSubset = isSubset(arr1,arr2,n,m);
		if(isSubset)
			System.out.println("arr2[] is subset of arr1[]");
		else
			System.out.println("arr2[] is not a subset of arr1[]");
		scan.close();
	}
}
