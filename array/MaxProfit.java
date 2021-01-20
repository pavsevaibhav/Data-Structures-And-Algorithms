/*
 The cost of a stock on each day is given in an array, find the max profit that you can make by buying and 
 selling in those days. For example, if the given array is {100, 180, 260, 310, 40, 535, 695},
 the maximum profit can earned by buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6. 
 If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
 */

package array;

import java.io.IOException;
import java.util.Scanner;

import inputoutput.InputOutput;

public class MaxProfit {

	private static int maximumProfit(int[] stock,int n) {
		int profit = 0;
		int j = 0;
		
		for(int i = 1; i < n ;i++) {
			
			if(stock[i-1] > stock[i])
				j = i;
			if((stock[i-1] < stock[i]) && (((i+1) == n)||(stock[i] > stock[i+1]))) {
				profit += stock[i] - stock[j];
			}
		}
		return profit;
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = InputOutput.inputArray(n);
		int maxProfit = maximumProfit(arr,n);
		System.out.println(maxProfit);
		scan.close();
	}
}
