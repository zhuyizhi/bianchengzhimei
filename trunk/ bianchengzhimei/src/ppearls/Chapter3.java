package ppearls;

import algorithmPractice.MergeSort;
import util.Producer;

public class Chapter3 {
	static boolean search(int[] arr, int low, int high, int element){
		if(high > low){
			int mid = (low + high) / 2;
			if(arr[mid] == element)
				return true;
			else if(element < arr[mid])
				return search(arr, low, mid, element); 
			else
				return search(arr, mid + 1, high, element);
		}else if(arr[low] == element ){
			return true;
		}else 
			return false;
	}
	
	static boolean search2(int[] arr, int low, int high, int element){
		if(low > high)
			return false;
		int mid = (low + high) / 2;
		if(arr[mid] == element)
			return true;
		else if(arr[mid] < element)
			return search2(arr, mid + 1, high, element);
		else
			return search2(arr, low, mid - 1, element);
	}
	
	static boolean search3(int[] arr, int low, int high, int element){
		while(low <= high){
			int mid = (low + high)/2;
			if(arr[mid] == element)
				return true;
			else if(arr[mid] > element)
				high = mid - 1;
			else 
				low = mid + 1;
		}
		return false;
	}
	
	static void test(int[] arr){
		for(int i : arr){
			assert(search(arr, 0, arr.length - 1, i));
		}
		assert(!search(arr, 0, arr.length - 1, 23));
		assert(!search(arr, 0, arr.length - 1, 45));
		assert(!search(arr, 0, arr.length - 1, 78));
	}
	
	static void test2(int[] arr){
		for(int i : arr){
			assert(search2(arr, 0, arr.length - 1, i));
		}
		assert(!search2(arr, 0, arr.length - 1, 23));
		assert(!search2(arr, 0, arr.length - 1, 45));
		assert(!search2(arr, 0, arr.length - 1, 78));
	}
	
	static void test3(int[] arr){
		for(int i : arr){
			boolean get = search3(arr, 0, arr.length - 1, i);
			assert(get): "wrong";
		}
		assert(!search3(arr, 0, arr.length - 1, 23));
		assert(!search3(arr, 0, arr.length - 1, 45));
		assert(!search3(arr, 0, arr.length - 1, 78));
	}
	
	public static void main(String[] args)throws Exception{
//		int[] arr = {1,2,3,7,9,112,453,789};
//		System.out.println(search(arr, 0, arr.length - 1, 11));
		int [] arr2 = Producer.getIntArray(10);
		Producer.printIntArr(arr2);
		MergeSort.mergeSort(arr2, arr2.length - 1, 0);
		Producer.printIntArr(arr2);
		test(arr2);
		test2(arr2);
		test3(arr2);
	}
}
