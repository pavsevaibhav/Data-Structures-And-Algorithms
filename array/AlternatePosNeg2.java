/*
 Given an array of positive and negative numbers, 
 arrange them in an alternate fashion such that every positive number is followed by negative and 
 vice-versa maintaining the order of appearance. 
 */
package array;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import inputoutput.InputOutput;

public class AlternatePosNeg2 {

	//Method to right rotate array between outOfPlace and curr index
	private static void rightRotate(int[] arr,int outOfPlace,int curr) {
		int temp = arr[curr];
		for(int i = curr; i > outOfPlace; i--) {
			arr[i] = arr[i-1];
		}
		arr[outOfPlace] = temp;
	}
	//Method to rearrange the array
	private static void alternatePosNeg(int[] arr,int n) {
		int outOfPlace = -1;
		
		for(int index = 0;index < n;index++) {
			//outOfPlace is positive then
			if(outOfPlace >= 0) {
				//if element at curr index is positive and element at outOfPlace index is negative OR
				//if element at curr index is negative and element at outOfPlace index is positive
				//then right rotate the array between curr and outOfPlace index
				if((arr[index] >= 0 && arr[outOfPlace] < 0) || 
						(arr[index] < 0 && arr[outOfPlace] >= 0)) {
					rightRotate(arr,outOfPlace,index);
					//update the outOfPlace 
					if((index - outOfPlace) >=2)
						outOfPlace += 2;
					else
						outOfPlace = -1;
				}
			}
			//if outOfPlace is negative then
			if(outOfPlace == -1) {
				//if element at curr index is positive and curr index is even OR
				//if element at curr index is negative and curr index is odd then 
				//update the outOfPlace as curr index
				//(index & 0x01) check 33
				if((arr[index] >= 0 && (index & 0x01)==0) || (arr[index]<0 && (index & 0x01)==1))
					outOfPlace = index;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] arr = InputOutput.inputArray(size);
		alternatePosNeg(arr,size);
		System.out.println(Arrays.toString(arr));
		scan.close();
	}
}
