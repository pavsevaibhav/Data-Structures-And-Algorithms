package array;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import inputoutput.InputOutput;

public class PairSum {

	private static int countPair(int[] arr,int n,int sum) {
		int count = 0;
		HashMap<Integer,Integer> hashmap = new HashMap<Integer, Integer>();
		for(int i=0;i<n;i++) {
			if(!hashmap.containsKey(arr[i]))
				hashmap.put(arr[i], 0);
			hashmap.put(arr[i], hashmap.get(arr[i])+1);
		}
		
		for(int i=0;i<n;i++) {
			if(hashmap.get(sum-arr[i])!=null)
				count += hashmap.get(sum - arr[i]);
			
			if((sum - arr[i]) == arr[i])
				count--;
		}
		return count/2;
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] arr = InputOutput.inputArray(size);
		int sum = scan.nextInt();
		int countPair = countPair(arr,size,sum);
		System.out.println(countPair);
		scan.close();
	}
}
