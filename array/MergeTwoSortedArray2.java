/*
 *  Given two sorted arrays arr1[] of size N and arr2[] of size M. Each array is sorted in non-decreasing order. 
 * Merge the two arrays into one sorted array in non-decreasing order without using any extra space.
Example 1:
Input:
N = 4, M = 5
arr1[] = {1, 3, 5, 7}
arr2[] = {0, 2, 6, 8, 9}
Output: 0 1 2 3 5 6 7 8 9
Explanation: Since you can't use any 
extra space, modify the given arrays
to form 
arr1[] = {0, 1, 2, 3}
arr2[] = {5, 6, 7, 8, 9}]
 */

package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import inputoutput.InputOutput;

public class MergeTwoSortedArray2 {

	private static void mergeArray(int[] arr1,int[] arr2,int n,int m) {
		int maxEle = Arrays.stream(arr1).max().getAsInt();
		int maxEle1 = Arrays.stream(arr2).max().getAsInt();
		//find maximum from both the arrays
		maxEle = maxEle>maxEle1 ? maxEle:maxEle1;
		//increment by one to avoid collision and maximum element
		//of the array in module operation
		maxEle++;
		int i=0,j=0,k=0;
		while(i<n && j<m && k<(n+m)) {
			//recover back original element to compare
			int ele1 = arr1[i]%maxEle;
			int ele2 = arr2[j]%maxEle;
			//update element by adding multiplication with new number
			if(ele1<=ele2) {
					if(k<n) {
					arr1[k] += (ele1*maxEle);
					} else {
					arr2[k-n] += (ele1*maxEle);
				}
				i++;
				k++;
			} else {
				//update element by adding multiplication with new number
				if(k<n) {
					arr1[k] += (ele2*maxEle);
				}else {
					arr2[k-n] += (ele2*maxEle);
				}
				j++;
				k++;
			}
		}
		
		//process those element which are left in first array
		while(i<n) {
			int ele = arr1[i]%maxEle;
			if(k<n) {
				arr1[k] += (ele*maxEle);
			}else {
				arr2[k-n] += (ele*maxEle);
			}
			i++;k++;
		}
		//process those element which are left in second array
		while(j<m) {
			int ele = arr2[j]%maxEle;
			if(k<n) {
				arr1[k] += (ele*maxEle); 
			}else {
				arr2[k-n] += (ele*maxEle);
			}
			j++;k++;
		}
		//finally update element by dividing with maximum element
		for(i=0;i<n;i++) 
			arr1[i] = arr1[i]/maxEle;
		//finally update element by dividing with maximum element
		for(j = 0;j<m;j++) {
			arr2[j] = arr2[j]/maxEle;
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		String[] values = buffer.readLine().trim().split(" ");
		int n = Integer.parseInt(values[0]);
		int m = Integer.parseInt(values[1]);
		int[] arr1 = InputOutput.inputArray(n);
		int[] arr2 = InputOutput.inputArray(m);
		mergeArray(arr1,arr2,n,m);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}
}
