/*
 
 */
package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import inputoutput.InputOutput;

public class MinMaxInPair {
	
	static class Pair {
		int min ;
		int max;
		
	}
	//find minimum and maximum element in pair
	private static Pair getMinMax(int[] arr,int n) {
		Pair minmax = new Pair();
		//if length of array is 1 then minimum and maximum element at index 0
		if(n==1) {
			minmax.max = arr[0];
			minmax.min = arr[0];
			return minmax;
		}else {
			int i=0;
			//check whether size of array is even or odd
			//if size of array is even then find out maximum and minimum between first and second element
			if(n%2==0) {
				if(arr[0]>arr[1]) {
					minmax.max = arr[0];
					minmax.min = arr[1];
				}else {
					minmax.max = arr[1];
					minmax.min = arr[0];
				}
				i=2;
			}
			//otherwise initialize minimum and maximum element as first element from array
			else {
				minmax.max = arr[0];
				minmax.min = arr[0];
				i=1;
			}
			
			while(i<n-1) {
				//compare ith and (i+1)th element
				if(arr[i]>arr[i+1]) {
					if(arr[i]>minmax.max) {
						minmax.max = arr[i];
					}
					if(arr[i+1]<minmax.min) {
						minmax.min = arr[i+1];
					}
				} else {
					if(arr[i+1]>minmax.max) {
						minmax.max = arr[i+1];
					}
					if(arr[i]<minmax.min) {
						minmax.min = arr[i];
					}
				}
				i += 2;
			}
			return minmax;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(buffer.readLine());
		int[] arr = InputOutput.inputArray(size);
		
		Pair minmax = getMinMax(arr,size);
		System.out.println(minmax.min+" "+minmax.max);
		buffer.close();
	}

}
