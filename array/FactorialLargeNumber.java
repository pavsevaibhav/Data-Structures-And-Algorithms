package array;

import java.util.Scanner;

public class FactorialLargeNumber {

	private static void largeNumberFactorial(int num) {
		int[] res = new int[1000];
		res[0] = 1;
		int resSize = 1;
		
		for(int x=2;x<=num;x++) {
			resSize = multiply(res,x,resSize);
		}
		
		System.out.println("factorial of number:");
		for(int i = resSize-1;i>=0;i--) {
			System.out.print(res[i]);
		}
	}
	
	private static int multiply(int[] res,int x,int resSize) {
		int carry = 0;
		
		for(int i=0;i<resSize;i++) {
			int prod = res[i]*x + carry;
			res[i] = prod%10;
			carry = prod/10;
		}
		
		while(carry!=0) {
			res[resSize] = carry%10;
			carry = carry/10;
			resSize++;
		}
		return resSize;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		largeNumberFactorial(num);
		scan.close();
	}
}
