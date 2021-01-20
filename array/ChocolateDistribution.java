/*
Given an array A of positive integers of size N, where each value represents number of chocolates in a packet. Each packet can have variable number of chocolates.
 There are M students, the task is to distribute chocolate packets such that :
1. Each student gets one packet.
2. The difference between the number of chocolates given to the students having packet with maximum chocolates and student having packet with minimum chocolates is minimum.
Input : arr[] = {7, 3, 2, 4, 9, 12, 56} , m = 3 
Output: Minimum Difference is 2 
Explanation:
We have seven packets of chocolates and 
we need to pick three packets for 3 students 
If we pick 2, 3 and 4, we get the minimum 
difference between maximum and minimum packet 
sizes.

Input : arr[] = {3, 4, 1, 9, 56, 7, 9, 12} , m = 5 
Output: Minimum Difference is 6 
Explanation:
The set goes like 3,4,7,9,9 and the output 
is 9-3 = 6
 */
package array;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import inputoutput.InputOutput;

public class ChocolateDistribution {
	
	private static int findMinDiff(int[] arr,int n,int mStudents) {
		int minDiff = Integer.MAX_VALUE;
		//if number of students are zero or size of packets are zero then return zero
		if(mStudents==0 || n==0)
			return 0;
		//if number of students are greater than number of packets then return -1
		if(mStudents > n)
			return -1;
		//sort the given packet
		Arrays.sort(arr);
		//Find the subarray of size m such that difference between last element of subarray and first element of subarray
		for(int i = 0; i < n-mStudents+1;i++) {
			int max = arr[i+mStudents-1];
			int min = arr[i];
			minDiff = Math.min(minDiff, max-min);
		}
		return minDiff;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = null;
		try {
			arr = InputOutput.inputArray(n);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int mStudents = scan.nextInt();
		int minDiff = findMinDiff(arr,n,mStudents);
		System.out.println(minDiff);
		scan.close();
	}
}
