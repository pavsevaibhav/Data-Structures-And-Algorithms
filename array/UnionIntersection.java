/*
 Given two arrays A and B of size N and M respectively. 
 The task is to find union between these two arrays.
Union of the two arrays can be defined as the set containing distinct elements from both the arrays.
 If there are repetitions, then only one occurrence of element should be printed in union.


 */
package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import inputoutput.InputOutput;

public class UnionIntersection {

	private static HashSet<Integer> intersectionUsingHashing(int[] arr1, int[] arr2, int n, int m) {
		HashSet<Integer> hash1 = new HashSet<>();
		HashSet<Integer> hash2 = new HashSet<>();
		//put all the element of first array in the first hashset
		for(int ele:arr1) {
			hash1.add(ele);
		}
		for(int ele:arr2) {
			//for each element of second array check whether it is present in hash1
			//if yes then put that element on second hashset
			if(hash1.contains(ele))
				hash2.add(ele);
		}
		hash1.clear();
		return hash2;				
	}

	private static HashSet<Integer> unionUsingHashing(int[] arr1, int[] arr2, int n, int m) {
		
		HashSet<Integer> union = new HashSet<>();
		//put all element of first array into hashset
		for(int ele:arr1) 
			union.add(ele);
		
		//put all element of second array into hashset
		for(int ele:arr2) {
			//if element of second array is not present in the hashset then only put.
			if(!union.contains(ele))
				union.add(ele);
		}
		return union;
		
	}

	private static ArrayList<Integer> interUsingSorting(int[] arr1, int[] arr2, int n, int m) {
		ArrayList<Integer> alist = new ArrayList<>();
		
		if(n>m) {
			int[] temp = arr1;
			arr1 = arr2;
			arr2 = temp;
			
			int templen = n;
			n = m;
			m = templen;
		}
		
		Arrays.sort(arr1);
		
		for(int ele:arr2) {
			if(binarySearch(arr1,0,n-1,ele))
				alist.add(ele);
		}
		return alist;
		
	}

	private static ArrayList<Integer> unionUsingSorting(int[] arr1, int[] arr2, int n, int m) {
		ArrayList<Integer> union  = new ArrayList<>();
		
		for(int ele:arr1) {
			union.add(ele);
		}
		
		for(int ele:arr2) {
			if(!union.contains(ele))
				union.add(ele);
		}
		return union;
	}

	private static boolean binarySearch(int[] arr,int left,int right,int ele) {
		if(left<right) {
			int mid = left+(right-left)/2;
			if(arr[mid]==ele)
				return true;
			else if(arr[mid]>ele)
				return binarySearch(arr,left,mid-1,ele);
			else
				return binarySearch(arr,mid+1,right,ele);
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		String[] values = buffer.readLine().trim().split(" ");
		int n = Integer.parseInt(values[0]);
		int m = Integer.parseInt(values[1]);
		int[] arr1 = InputOutput.inputArray(n);
		int[] arr2 = InputOutput.inputArray(m);
		
		int choice = Integer.parseInt(buffer.readLine());
		if(choice==0) {
			System.out.println("union using sorting: "+unionUsingSorting(arr1,arr2,n,m));
			System.out.println("intersection using sorting: "+interUsingSorting(arr1,arr2,n,m));
		} else {
			System.out.println("union using hashset: "+unionUsingHashing(arr1,arr2,n,m));
			System.out.println("intersection using hashset: "+intersectionUsingHashing(arr1,arr2,n,m));
		}
	}
}
