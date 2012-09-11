package baidu;

import java.util.Random;

/**
 * 字典排序，很多个字符串，如zcfgrgh， aotu，bidcfhu，abcd，gtysdsj，
 * 等排序之后结果应为abcd，aotu，bidcfhu，gtysds，zcfgrghj。
 * @author ucai
 *
 */
public class StringSort {
	
	public static void swap(String[] arr, int i, int j){
		String tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static int quickSort(String[] arr, int start, int end){
		String key = arr[start];
		
		int low = start, high = end;
		while(low < high){
			while(low < high && arr[high].compareTo(key) > 0)
				high--;
			if(low < high)
				swap(arr, low, high);
			
			while(low < high && arr[low].compareTo(key) <= 0)
				low++;
			if(low < high)
				swap(arr, low, high);
		}
		return low;
	}
	
	public static void useQuickSort(String[] arr, int start, int end){
		if(end - start > 1){
			int split = quickSort(arr, start, end);
			useQuickSort(arr, start, split - 1);
			useQuickSort(arr, split + 1, end);
		}
	} 
	
	public static Random r = new Random();
	
	public static String[] generateStringArr(int maxArrLength, int maxStringLength){
		int len = r.nextInt(maxArrLength) + 1;
		String[] arr = new String[len];
		for(int i = 0;i < len; i++){
			arr[i] = getString(maxStringLength);
		}
		return arr;
	}
	
	public static String getString(int maxStringLength){
		int strLen = r.nextInt(maxStringLength) + 1;
		char[] cArr = new char[strLen];
		for(int i = 0; i < strLen; i++){
			cArr[i] = getChar();
		}
		return new String(cArr);
	}
	
	public static char getChar(){
		return (char) ('a' + r.nextInt(26));
	}
	
	public static void printStringArr(String[] arr){
		int count = 0;
		for(String s : arr){
			System.out.print(s + "\t");
			if((count++) % 5 == 0)
				System.out.println();
		}
	}
	public static void main(String[] args)throws Exception{
		String[] arr = generateStringArr(100, 4);
		printStringArr(arr);
		System.out.println();
		System.out.println("##########################################");
		useQuickSort(arr, 0, arr.length - 1);
		printStringArr(arr);
	}
}
