/*Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
Example 1:
Input: nums = [1,3,4,2,2]
Output: 2
*/

package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import inputoutput.InputOutput;

public class DuplicateNumber {

	private static int findDuplicate(int[] arr,int n) {
		//sum variable is used to store sum of all array elements
		int sum = 0;
		//traverse through the array
		for(int i=0;i<n;i++) {
			sum += arr[i];
		}
		return sum - ((n-1)*n)/2;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(buffer.readLine());
		int[] arr = InputOutput.inputArray(size);
		int duplicateNumber = findDuplicate(arr,size);
		System.out.println(duplicateNumber);
	}
}
