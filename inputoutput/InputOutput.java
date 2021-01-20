package inputoutput;

import java.io.*;

public class InputOutput {
	
	public static int[] inputArray(int size) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[size];
		String[] str = buffer.readLine().trim().split(" ");
		for(int i=0;i<size;i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		return arr;
	}

	
	public static void printArray(int[] arr) {
		for(int ele:arr) {
			System.out.print(ele+" ");
		}
		System.out.println();
	}
}
