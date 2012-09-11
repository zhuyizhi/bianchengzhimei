package algorithmPractice;

import util.Producer;
public class MergeSort {
	public static void merge(int[] arr, int high, int low, int mid){
		int[] c = new int[high - low + 1];
		int i = low, j = mid + 1, k = 0;
		while(i <= mid && j <= high){
			if(arr[i] <= arr[j])
				c[k++] = arr[i++];
			else
				c[k++] = arr[j++];
		}
		while (j <= high)
			c[k++] = arr[j++];
		while (i <= mid)
			c[k++] = arr[i++];
		for(i = low; i < high + 1; i++)
			arr[i] = c[i - low];
	}
	
	
	public static void mergeSort(int[] arr, int high, int low){
		if(low < high){
			int mid = (high + low) / 2;
			mergeSort(arr, mid, low);
			mergeSort(arr, high, mid + 1);
			merge(arr, high, low, mid);
		}
	}
	public static void main(String[] args)throws Exception{
		int[] arr = Producer.getIntArray(250000000);
//		Producer.printIntArr(arr);
		long t1 = System.currentTimeMillis();
		mergeSort(arr, arr.length - 1, 0);
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
//		Producer.printIntArr(arr);
	}
}
