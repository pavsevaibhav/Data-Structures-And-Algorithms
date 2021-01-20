/*
 Input:   price[] = {10, 22, 5, 75, 65, 80}
Output:  87
Trader earns 87 as sum of 12 and 75
Buy at price 10, sell at 22, buy at 5 and sell at 80
 */
package array;

import java.io.IOException;
import java.util.Scanner;

import inputoutput.InputOutput;

public class MaxProfitAtMostTwice {

	private static int maximumProfit(int[] stock,int n) {
		int buy1 = Integer.MAX_VALUE;
		int buy2 = Integer.MAX_VALUE;
		int profit1 = 0;
		int profit2 = 0;
		
		for(int i = 0;i < n; i++) {
			    //Money lent to buy the stock
		        // should be minimum as possible.
		        // buy1 tracks the minimum possible
		        // stock to buy from 0 to i-1.
			buy1 = Math.min(buy1, stock[i]);
			// Profit after selling a stock
	        // should be maximum as possible.
	        // profit1 tracks maximum possible
	        // profit we can make from 0 to i-1.
			profit1 = Math.max(profit1, stock[i] - buy1);
			// Now for buying the 2nd stock,
	        // we will integrate profit made
	        // from selling the 1st stock
			buy2 = Math.min(buy2,stock[i] - profit1);
			 // Profit after selling a 2 stocks
	        // should be maximum as possible.
	        // profit2 tracks maximum possible
	        // profit we can make from 0 to i-1.
			profit2 = Math.max(profit2, stock[i] - buy2);
		}
		return profit2;
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
