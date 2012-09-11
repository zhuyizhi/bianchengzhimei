package algorithmPractice;

import util.Producer;
/**
 * 实现了两种方式的快排。详细见basics包里的QuickSort。
 * 
 * 其中，swapSort是原始种类的快排，思想是：
 * 
 * 低位初始的值，即key值，在交换过程中被频繁的移动，最后停在该元素应在的位置。
 * 注意，交换总是从高位开始的，否则key值为最高位的值。
 * 
 * 而sort的方法是总结出swapSort中，key值的移动其实只需一次，只要使用一个额外的空间记录该值，
 * 最后把它放到空出来的位置中即可。
 * @author ucai
 *
 */
public class QuickSort {
	
	public static int sort(int[] arr, int start, int end){
		int key = arr[start];
		
		while(start < end){
			while(arr[end] > key && start < end)
				end --;
			if(start < end)
				arr[start] = arr[end];
			
			while(arr[start] <= key && start < end)
				start ++;
			if(start < end)
				arr[end] = arr[start];
		}
		
		arr[start] = key;
		return start;
	}
	
	public static int swapSort(int[] arr, int start, int end){
		int key = arr[start];
		int m;
		while(start < end){
			while(arr[end] > key && start < end)
				end--;
			if(start < end)
			{
				m = arr[start];
				arr[start] = arr[end];
				arr[end] = m;
			}
			
			while(arr[start] <= key && start < end)
				start ++;
			if(start < end)
			{
				m = arr[end];
				arr[end] = arr[start];
				arr[start] = m;
			}
		}
		return start;
	}
	
	
	public static void quick_sort(int[] arr, int start, int end){
		if(start < end){
//			int m = sort(arr, start, end);
			int m = swapSort(arr, start, end);
			quick_sort(arr, start, m-1);
			quick_sort(arr, m + 1, end);
		}
	}
	
	
	public static void main(String[] args){
		Producer p = new Producer();
		int len = 20;
		int[] arr = p.getIntArray(len);
		Producer.printIntArr(arr);
		quick_sort(arr, 0, len - 1);
		Producer.printIntArr(arr);
	}
}
