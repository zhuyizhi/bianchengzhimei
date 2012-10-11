package util;

import java.util.Random;

public class Producer {
	public static int MAX = 10000;
	public static int[] getIntArray(int length){
		return getIntArray(length, MAX);
	}
	
	public static int[] getIntArray(int length, int max){
		Random r = new Random();
		int[] arr = new int[length];
		for(int i = 0; i < length; i ++)
			arr[i] = r.nextInt(max);
		return arr;
	}
	
	public static char[] getCharArray(int length, char[] source){
		Random r = new Random();
		char[] arr = new char[length];
		for(int i = 0; i < length; i++){
			int index = r.nextInt(source.length);
			arr[i] = source[index];
		}
		return arr;
	}
	
	public static void printIntArr(int[] arr){
		for(int i : arr){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void printCharArray(char[] arr){
		for(char c : arr)
			System.out.print(c);
		System.out.println();
	}
}
