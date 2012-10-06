package algorithmPractice;

import java.util.PriorityQueue;

import util.Producer;

public class HeapSort {

	/*
	 * #堆排序#% #数组实现#%
	 */
	// #筛选算法#%
//	static void sift(int d[], int ind, int len) {
//		// #置i为要筛选的节点#%
//		int i = ind;
//
//		// #c中保存i节点的左孩子#%
//		int c = i * 2 + 1; // #+1的目的就是为了解决节点从0开始而他的左孩子一直为0的问题#%
//
//		while (c < len)// #未筛选到叶子节点#%
//		{
//			// #如果要筛选的节点既有左孩子又有右孩子并且左孩子值小于右孩子#%
//			// #从二者中选出较大的并记录#%
//			if (c + 1 < len && d[c] < d[c + 1])
//				c++;
//			// #如果要筛选的节点中的值大于左右孩子的较大者则退出#%
//			if (d[i] > d[c])
//				break;
//			else {
//				// #交换#%
//				int t = d[c];
//				d[c] = d[i];
//				d[i] = t;
//				//
//				// #重置要筛选的节点和要筛选的左孩子#%
//				i = c;
//				c = 2 * i + 1;
//			}
//		}
//
//		return;
//	}
//
//	static void heap_sort(int d[], int n) {
//		// #初始化建堆, i从最后一个非叶子节点开始#%
//		for (int i = n / 2; i >= 0; i--)
//			sift(d, i, n);
//
//		Producer.printIntArr(d);
//		
//		for (int i = 0; i < n; i++) {
//			// #交换#%
//			int t = d[0];
//			d[0] = d[n - i - 1];
//			d[n - i - 1] = t;
//
//			// #筛选编号为0 #%
//			sift(d, 0, n - i - 1);
//
//		}
//	}
	
	public static void siftDown(int[] arr, int i, int size){
		int child = arr[2*i + 1];
		int pos = 2 * i + 1;
		if(2 * i + 2 < size && child < arr[2 * i + 2]){
			child = arr[2 * i + 2];
			pos++;
		}
		if(arr[i] < child){
			int temp = arr[i];
			arr[i] = child;
			arr[pos] = temp;
			
			if(pos * 2 + 1 < size)
				siftDown(arr, pos, size);
		}
	}
	
	public static void heapSort(int[] arr){
		for(int i = arr.length/2 - 1; i >= 0; i--){
			siftDown(arr, i, arr.length);
		}
		for(int i = 0; i < arr.length; i++){
			int temp = arr[0];
			arr[0] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
			if(arr.length - i - 1 > 1)
				siftDown(arr, 0, arr.length - i - 1);
		}
	}
	
	public static void main(String[] args)throws Exception{
		int length = 7;
		int[] arr = Producer.getIntArray(length, 50);
		Producer.printIntArr(arr);
//		heap_sort(arr, arr.length);
		heapSort(arr);
		Producer.printIntArr(arr);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i : arr)
			pq.add(i);
		while(!pq.isEmpty())
			System.out.print(pq.poll() + " ");
		System.out.println();
	}
}
