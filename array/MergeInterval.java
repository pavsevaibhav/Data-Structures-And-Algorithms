/*
 Given a set of time intervals in any order, merge all overlapping intervals into one and 
 output the result which should have only mutually exclusive intervals. Let the intervals be represented as pairs of integers for simplicity. 
For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8}}. 
The intervals {1,3} and {2,4} overlap with each other, so they should be merged and become {1, 4}.
 Similarly, {5, 7} and {6, 8} should be merged and become {5, 8}
 
 */
package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Interval {
	int start;
	int end;
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
public class MergeInterval {
	
	private static void mergeInterval(Interval[] arr,int n) {
		//sort the interval in decreasing order of starting time
		Arrays.sort(arr, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return i2.start - i1.start;
			}
		});
		
		int index = 0;
		for(int i = 1; i < n; i++) {
			//if this is not a first interval and overlap with previous one
			if(arr[index].end >= arr[i].start) {
				//merge previous and current interval
				arr[index].end = Math.max(arr[index].end, arr[i].end);
				arr[index].start = Math.min(arr[index].start, arr[i].start);
			} else {
				index++;
				arr[index] = arr[i];
			}
		}
		
		System.out.println("Merged Interval: ");
		for(int i = 0;i <= index; i++) {
			System.out.print("["+arr[i].start+","+arr[i].end+"],");
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Interval[] arr = new Interval[n];
		
		for(int i=0;i<n;i++) {
			int start = scan.nextInt();
			int end = scan.nextInt();
			arr[i] = new Interval(start,end);
		}
		mergeInterval(arr,n);
		scan.close();
	}
}
