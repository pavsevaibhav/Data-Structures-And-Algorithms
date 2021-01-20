/*
 Given two sorted arrays, a[] and b[], the task is to find the median of these sorted arrays, 
 in O(log n + log m) time complexity, when n is the number of elements in the first array,
  and m is the number of elements in the second array.
  Input: ar1[] = {-5, 3, 6, 12, 15}
        ar2[] = {-12, -10, -6, -3, 4, 10}
Output : The median is 3.
Explanation : The merged array is :
        ar3[] = {-12, -10, -6, -5 , -3,
                 3, 4, 6, 10, 12, 15},
       So the median of the merged array is 3
 */
package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import inputoutput.InputOutput;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		String[] values = buffer.readLine().trim().split(" ");
		int n = Integer.parseInt(values[0]);
		int m = Integer.parseInt(values[1]);
		int[] arr1 = InputOutput.inputArray(n);
		int[] arr2 = InputOutput.inputArray(m);
		int median =  findMedian(arr1,arr2,n,m);
		System.out.println(median);
	}
	private static int findMedian(int[] arr1,int[] arr2,int n,int m) {
		merge(arr1,arr2,n,m);
		int mid = (n+m)/2;
		if((n+m)%2!=0) {
			if(mid<n)
				return arr1[mid];
			else
				return arr2[m-mid];
		} else {
			if(mid<n) {
				return (arr1[mid]+arr1[mid-1])/2;
			} else {
				return (arr2[m-mid]+arr2[m-mid-1])/2; 
			}
		}
	}
	private static void merge(int[] arr1,int[] arr2,int n,int m) {
		int maxEle = Arrays.stream(arr1).max().getAsInt();
		int maxEle1 = Arrays.stream(arr2).max().getAsInt();
		maxEle = maxEle>maxEle1?maxEle:maxEle1;
		maxEle++;
		int i = 0,j = 0,k =0;
		while(i<n && j<m &&k<(n+m)) {
			int ele1 = arr1[i]%maxEle;
			int ele2 = arr2[j]%maxEle;
			if(ele1<=ele2) {
				if(k<n) {
					arr1[k] += (ele1*maxEle);
				} else {
					arr2[k-n] += (ele1*maxEle);
				}
				i++;
				k++;
			} else {
				if(k<n) {
					arr1[k] += (ele2*maxEle);
				} else {
					arr2[k-n] += (ele2*maxEle);
				}
				j++;
				k++;
			}
		}
		
		while(i<n) {
			int ele = arr1[i]%maxEle;
			if(k<n) {
				arr1[k] += (ele*maxEle);
			}else {
				arr2[k - n] += (ele*maxEle);
			}
			i++;
			k++;
		}
		
		while(j<m) {
			int ele = arr2[j]%maxEle;
			if(k<n) {
				arr1[k] += (ele*maxEle);
			}else {
				arr2[k-n] += (ele*maxEle);
			}
			j++;
			k++;
		}
		
		for(i=0;i<n;i++) {
			arr1[i] = arr1[i]/maxEle;
		}
		for(i=0;i<m;i++) {
			arr2[i] = arr2[i]/maxEle;
		}
	}
}
