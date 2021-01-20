/*
Given an array of integers, find the length of the longest sub-sequence such that 
elements in the subsequence are consecutive integers, the consecutive numbers can be in any order. 
Examples:  
Input: arr[] = {1, 9, 3, 10, 4, 20, 2}
Output: 4
Explanation: 
The subsequence 1, 3, 4, 2 is the longest 
subsequence of consecutive elements
 */
package array;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

import inputoutput.InputOutput;

public class LongestSubsequence {

	private static int longestSubsequence(int[] arr,int n) {
		int ans = 0;
		//hashset to store element of array
		HashSet<Integer> hash = new HashSet<Integer>();
		//traverse the array and store each element in hashset
		for(int i = 0; i < n; i++) {
			hash.add(arr[i]);
		}
		
		for(int i = 0; i < n; i++) {
			//check if current element is first element of subsequence
			if(!hash.contains(arr[i]-1)) {
				//then check next element of subsequence and update count
				int j = arr[i];
				while(hash.contains(j))
					j++;
				//update subsequence length
				if(ans < j-arr[i])
					ans = j - arr[i];
			}
		}
		return ans;
	}
	public static void main(String[] args) throws IOException {
		Scanner scan  = new Scanner(System.in);
		int size = scan.nextInt();
		int[] arr = InputOutput.inputArray(size);
		int count = longestSubsequence(arr,size);
		System.out.println(count);
		scan.close();
	}

}
