package algorithmPractice;

import java.util.PriorityQueue;

import util.Producer;

public class HeapSort {

	/*
	 * #������#% #����ʵ��#%
	 */
	// #ɸѡ�㷨#%
	static void sift(int d[], int ind, int len) {
		// #��iΪҪɸѡ�Ľڵ�#%
		int i = ind;

		// #c�б���i�ڵ������#%
		int c = i * 2 + 1; // #+1��Ŀ�ľ���Ϊ�˽���ڵ��0��ʼ����������һֱΪ0������#%

		while (c < len)// #δɸѡ��Ҷ�ӽڵ�#%
		{
			// #���Ҫɸѡ�Ľڵ�������������Һ��Ӳ�������ֵС���Һ���#%
			// #�Ӷ�����ѡ���ϴ�Ĳ���¼#%
			if (c + 1 < len && d[c] < d[c + 1])
				c++;
			// #���Ҫɸѡ�Ľڵ��е�ֵ�������Һ��ӵĽϴ������˳�#%
			if (d[i] > d[c])
				break;
			else {
				// #����#%
				int t = d[c];
				d[c] = d[i];
				d[i] = t;
				//
				// #����Ҫɸѡ�Ľڵ��Ҫɸѡ������#%
				i = c;
				c = 2 * i + 1;
			}
		}

		return;
	}

	static void heap_sort(int d[], int n) {
		// #��ʼ������, i�����һ����Ҷ�ӽڵ㿪ʼ#%
		for (int i = n / 2; i >= 0; i--)
			sift(d, i, n);

		Producer.printIntArr(d);
		
		for (int i = 0; i < n; i++) {
			// #����#%
			int t = d[0];
			d[0] = d[n - i - 1];
			d[n - i - 1] = t;

			// #ɸѡ���Ϊ0 #%
			sift(d, 0, n - i - 1);

		}
	}
	
	public static void main(String[] args)throws Exception{
		int length = 7;
		int[] arr = Producer.getIntArray(length, 50);
		Producer.printIntArr(arr);
		heap_sort(arr, arr.length);
		Producer.printIntArr(arr);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i : arr)
			pq.add(i);
		
	}
}
