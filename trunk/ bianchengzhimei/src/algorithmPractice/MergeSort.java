package algorithmPractice;

import util.Producer;
public class MergeSort {
	public static void merge(int[] arr, int high, int low, int mid){
		int[] c = new int[high - low + 1];
		int i = low, j = mid + 1, k = 0;
		while(i <= mid && j <= high)
			c[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
		while (j <= high)
			c[k++] = arr[j++];
		while (i <= mid)
			c[k++] = arr[i++];
		for(i = low; i < high + 1; i++)
			arr[i] = c[i - low];
	}
	
	public static void cmp(int a, int b, int small, int large){
		if(a > b){
			small = b;
			large = a;
		}else{
			small = a;
			large = b;
		}
	}
	
	public static void moveRight(int[] arr, int start, int end){
		for(int i = end; i >= start; i--){
			arr[i + 1] = arr[i];
		}
	}
	
	/**
	 * 原地merge：
	 * （1）若low位置的比较小，那么指针一直向高位移动，直到找到第一个arr[low]大于arr[high]的，
	 * 那么arr[low - 1]就是要插入的位置；此时low, high-1的值向高位移动1格，arr[low] = 原来的arr[high]；然后low和high同时加1；
	 * （2）若low位置比较大，比较简单，直接low, high - 1向高位移动1格，然后arr[low] = arr[high]；
	 * 然后low和high同时加1
	 * @param arr
	 * @param high
	 * @param low
	 * @param mid
	 */
	public static void mergeOnSite(int[] arr, int high, int low, int mid){
		
		for(int i = low, j = mid + 1; i <= j && j <= high; i++, j++){
			if(arr[i] < arr[j]){
				while(arr[i] < arr[j] && i < j)
					i++;
				int large = arr[j];
				moveRight(arr, i, j - 1);
				arr[i] = large;
			}else{
				int small = arr[j];
				moveRight(arr, i, j -1);
				arr[i] = small;
			}
		}
	}
	
	
	public static void mergeSort(int[] arr, int high, int low){
		if(low < high){
			int mid = (high + low) / 2;
			mergeSort(arr, mid, low);
			mergeSort(arr, high, mid + 1);
			mergeOnSite(arr, high, low, mid);
		}
	}
	public static void main(String[] args)throws Exception{
		int length = 7;
		int[] arr = Producer.getIntArray(length, 50);
//		int[] arr = {47, 48, 3, 41, 38, 16};
		Producer.printIntArr(arr);
//		long t1 = System.currentTimeMillis();
		mergeSort(arr, arr.length - 1, 0);
//		long t2 = System.currentTimeMillis();
//		System.out.println(t2 - t1);
		Producer.printIntArr(arr);
	}
}
