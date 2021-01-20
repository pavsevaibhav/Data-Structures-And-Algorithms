/*
 * Given an array arr[] denoting heights of N towers and a positive integer K, 
 you have to modify the height of each tower either by increasing or decreasing them by K only once.
 After modifying, height should be a non-negative integer. 
Find out what could be the possible minimum difference of the height of shortest and 
longest towers after you have modified each tower.
Example 1:
Input:
K = 2, N = 4
Arr[] = {1, 5, 8, 10}
Output: 5
Explanation: The array can be modified as 
{3, 3, 6, 8}. The difference between 
the largest and the smallest is 8-3 = 5.
 */
package array;

import java.util.Arrays;
import java.io.*;

import inputoutput.InputOutput;

public class MinimizeTheMaximumHeight {

	private static int minimizeTheHeight(int[] heights, int size, int k) {
		//sort the array
		Arrays.sort(heights);
		
		//difference between first and last tower
		int ans = heights[size-1] - heights[0];
		
		int small = heights[0] + k;
		int big = heights[size-1] - k;
		
		if(small > big) {
			int temp  = small;
			small = big;
			big = temp;
		}
		
		for(int index = 0; index < size - 1 ; index++) {
			int subtract = heights[index] - k;
			int add = heights[index] + k;
			
			//if subtract is greater than small or add is smaller than big, Do nothing
			if(subtract >= small || add <= big)
				continue;
			
			if(big - subtract <= add - small)
				small = subtract;
			else
				big = add;
			
		}
		
		return Math.min(ans, big-small);
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = buffer.readLine().trim().split(" ");
		int size = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int[] heights = InputOutput.inputArray(size);
		int minimumDiff = minimizeTheHeight(heights,size,k);
		System.out.println(minimumDiff);
		buffer.close();

	}
}
