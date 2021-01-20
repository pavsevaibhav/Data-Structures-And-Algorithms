/*
 Given an array of size n, find all elements in array that appear more than n/k times. For example, 
 if the input arrays is {3, 1, 2, 2, 1, 2, 3, 3} and k is 4, then the output should be [2, 3]. 
 Note that size of array is 8 (or n = 8), so we need to find all elements that appear more than 2 (or 8/4) times. 
 There are two elements that appear more than two times, 2 and 3
 */
package array;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import inputoutput.InputOutput;

public class MoreThanNdK {

	private static void moreThanNdK (int[] arr,int n,int k) {
		int x = n/k;
		//HashMap to store frequency of each element
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer> ();
		//count frequency of elements
		for(int i=0;i<n;i++) {
			if(!hmap.containsKey(arr[i]))
				hmap.put(arr[i], 0);
			
			hmap.put(arr[i], hmap.get(arr[i])+1);
		}
		
		for(Map.Entry<Integer, Integer> m: hmap.entrySet()) {
			Integer temp = (Integer) m.getValue();
			//check frequency, if it is more than x then print key value
			if(temp > x)
				System.out.print(m.getKey()+" ");
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] arr = InputOutput.inputArray(size);
		int k = scan.nextInt();
		moreThanNdK(arr,size,k);
		scan.close();
	}
}
