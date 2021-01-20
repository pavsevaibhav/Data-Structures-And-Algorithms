package array;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialUsingBigInteger {

	private static BigInteger largeNumberFact(int num) {
		BigInteger fact = BigInteger.ONE;
		for(int i=2;i<=num;i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		return fact;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		BigInteger fact = largeNumberFact(num);
		System.out.println(fact);
		scan.close();
	}
}
