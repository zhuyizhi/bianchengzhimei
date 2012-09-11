package algorithmPractice;

import util.Producer;
/**
 * ʵ�������ַ�ʽ�Ŀ��š���ϸ��basics�����QuickSort��
 * 
 * ���У�swapSort��ԭʼ����Ŀ��ţ�˼���ǣ�
 * 
 * ��λ��ʼ��ֵ����keyֵ���ڽ��������б�Ƶ�����ƶ������ͣ�ڸ�Ԫ��Ӧ�ڵ�λ�á�
 * ע�⣬�������ǴӸ�λ��ʼ�ģ�����keyֵΪ���λ��ֵ��
 * 
 * ��sort�ķ������ܽ��swapSort�У�keyֵ���ƶ���ʵֻ��һ�Σ�ֻҪʹ��һ������Ŀռ��¼��ֵ��
 * �������ŵ��ճ�����λ���м��ɡ�
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
