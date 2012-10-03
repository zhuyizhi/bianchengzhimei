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
	 * ԭ��merge��
	 * ��1����lowλ�õıȽ�С����ôָ��һֱ���λ�ƶ���ֱ���ҵ���һ��arr[low]����arr[high]�ģ�
	 * ��ôarr[low - 1]����Ҫ�����λ�ã���ʱlow, high-1��ֵ���λ�ƶ�1��arr[low] = ԭ����arr[high]��Ȼ��low��highͬʱ��1��
	 * ��2����lowλ�ñȽϴ󣬱Ƚϼ򵥣�ֱ��low, high - 1���λ�ƶ�1��Ȼ��arr[low] = arr[high]��
	 * Ȼ��low��highͬʱ��1
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
