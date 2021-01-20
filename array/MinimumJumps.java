/*
 Given an array of integers where each element represents the max number of steps that can be made forward from that element.
 Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). 
 If an element is 0, they cannot move through that element.
Examples: 
Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3 (1-> 3 -> 8 -> 9)
Explanation: Jump from 1st element 
to 2nd element as there is only 1 step, 
now there are three options 5, 8 or 9. 
If 8 or 9 is chosen then the end node 9 
can be reached. So 3 jumps are made.
 */
package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import inputoutput.InputOutput;

public class MinimumJumps {

	private static int minJumps(int[] arr, int size) {
		if(arr.length<=1)
			return 0;
		if(arr[0]<=0) //if first element is less than 0 then we can't jump anymore
			return -1;
		
		int maxReach = arr[0]; //maximum index we can reach at this moment
		int steps = arr[0]; //maximum number of steps we can takes
		int jumps = 1;
		
		for(int level = 1; level < arr.length ; level++) {
			//check whether we reach to end of the array if Yes then simply return jumps
			if(level == arr.length-1)
				return jumps;
			//update maxReach
			maxReach = Math.max(maxReach, level+arr[level]);
			//decrease the steps
			steps--;
			//if steps becomes 0 then then update jumps and steps
			if(steps == 0) {
				jumps++;
				if(level >= maxReach)
					return -1;
				
				steps = maxReach - level;
			}
		}
		return -1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(buffer.readLine());
		int[] arr = InputOutput.inputArray(size);
		
		int minimumJumps = minJumps(arr,size);
		System.out.println(minimumJumps);
		buffer.close();
	}
}
