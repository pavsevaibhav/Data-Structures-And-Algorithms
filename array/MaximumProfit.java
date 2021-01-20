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

public class MaximumProfit {

	private static int maximumProfit(int[] prices,int n) {
		int cost = 0;
		int maxProfit = 0;
		
		if(n==0)
			return 0;
		
		int minPrice = prices[0];
		
		for(int i=0;i<n;i++) {
			//Compare first element with all the elements of the array and find minimum element
			minPrice = Math.min(minPrice, prices[i]);
			//since minPrice is the smallest element of the array, so subtract with every element of the array
			//and return maxProfit
			cost = prices[i] - minPrice;
			
			maxProfit = Math.max(maxProfit, cost);
		}
		return maxProfit;
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
