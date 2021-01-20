/*
 Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
Note: can you take care of the duplicates without using any additional Data Structure?

Example 1:

Input:
n1 = 6; A = {1, 5, 10, 20, 40, 80}
n2 = 5; B = {6, 7, 20, 80, 100}
n3 = 8; C = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20 80
 */
package array;

import java.io.*;
import java.util.ArrayList;

import inputoutput.InputOutput;

public class CommonBet3Arrays {

	private static ArrayList<Integer> commonElement(int[] arr1,int[] arr2,int[] arr3,
													int n1,int n2,int n3) {
		//ArrayList to store common element from three arrays
		ArrayList<Integer> alist = new ArrayList<>();
		int i = 0,j = 0,k = 0;
		//traverse through the array
		while(i<n1 && j<n2 && k<n3) {
			//check whether element is common in three arrays
			if(arr1[i]==arr2[j] && arr2[j]==arr3[k]) {
				//check whether element is already present in arraylist or not 
				if(!alist.contains(arr1[i])) {
					alist.add(arr1[i]);
				}
				i++; j++; k++;
			} else if(arr1[i] < arr2[j]) {
				i++;
			} else if(arr2[j] < arr3[k]) {
				j++;
			} else {
				k++;
			}
		}
		return alist;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String[] values = buffer.readLine().trim().split(" ");
		int n1 = Integer.parseInt(values[0]);
		int n2 = Integer.parseInt(values[1]);
		int n3 = Integer.parseInt(values[2]);
		
		int[] arr1 = InputOutput.inputArray(n1);
		int[] arr2 = InputOutput.inputArray(n2);
		int[] arr3 = InputOutput.inputArray(n3);
		
		ArrayList<Integer> output = commonElement(arr1,arr2,arr3,n1,n2,n3);
		
		System.out.println(output.toString());
	}
}
