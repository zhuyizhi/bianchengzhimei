package baidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * 题目：给定一个数字编码N，大多数情况下可以找到一个数字编码M，其位数与N相等（编码可以以0开始），各位数字之和与N各位数字之和相等且M是大于N的所有编码中最小的一个；也可能要找的编码不存在。
 * 如N=134, M = 143; N = 020, M = 101; 形式化表述为f(N) = M, 若M不存在，则f(N) = -1;
 * 现在给定一个N，N位数不超过1000，大小不超过10^500，求序列S(N),其中S(0)=N, S(1)=f(N), S(2)=f(S(1)),...当S(i+1)=-1时结束。但小于0的元素不包含在序列中。
 * 
 * 
 * 解答思路：
 * 
	* 对原来数字变化最小的方法是，将末位减1，倒数第二位加1，如134-->143
	* 可以看出，其思想是，寻找一对位置high和low，其中high > low。对high的位置上的数字加1，这样就得到了一个比原来数字更大的数。high位之后的除0外的有效数字应尽可能的小，因此需要排序之后向低端移动，并且有效数字的最高位-1。这里的low标注有效数字的开始。
	* 设计中需要注意的是边界情况，即9和0。当一个位置里的值为0时，不能进行减1的操作；当一个位置的值是9时，不能进行加1的操作。
	* 最后的算法是;
	* 
		* 从低到高，寻找第一个不为0的位，设为low；
		* 从low开始往高处，寻找第一个不为9的位，设为high；
		* arr[high]++；
		* 从high - 1 到 low这之间的数从低到高进行排序，并将最小值自减1。排序的结果后移low位，即到最末尾处，原位置处填0。
		* 算法可能失败的位置：
		* 
			* low 超过最大值，即数据全为0；
			* high超过最大值，即数据从最高位到low都是9，即999...999000...0000
 * 
 * @author ucai
 *
 */
public class BianMaHeXiangDeng {
	
	public static int getSum(int[] arr){
		int sum = 0;
		for(int i : arr){
			sum += arr[i];
		}
		return sum;
	}
	
	public static void printArr(int[] arr){
		for(int i = 0; i < arr.length ; i++){
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	public static void getSequence(int[] arr){
		int count = 0;
		System.out.print("S[" + (count++) + "]=");
		printArr(arr);
		while(true){
			boolean result = changeM_new(arr);
			if(!result)
				break;
			System.out.print("S[" + (count++) + "]=");
			printArr(arr);
		}
	}
	
	public static boolean changeM_new(int[] M){
		
		int low = M.length - 1;
		while(low >= 0 && M[low] == 0)
			low--;
		if(low <= 0)
			return false;
		
		int high = low - 1;
		while(high >= 0 && M[high] == 9)
			high--;
		
		if(high < 0)
			return false;
		M[high]++;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = low; i > high; i--)
			list.add(M[i]);
		
		for(int i = low; i > high; i--)
			M[i] = 0;
		
		Collections.sort(list);
		int len = list.size();
		
		list.set(0, list.get(0) - 1);
		
		int pos = M.length - len;
		for(int i = 0; i < len; i++){
			int val = list.get(i);
			M[pos++] = val;
		}
		
		return true;
	}
	
 	public static int[] getArr(int length){
		int[] arr = new int[length];
		Random r = new Random();
		for(int i = 0; i < length; i++)
			arr[i] = r.nextInt(10);
		return arr;
	}
	
	public static void main(String[] args)throws Exception{
//		int[] arr = {0,9,9};
//		int[] arr = {1,3,4};
//		int[] arr = {1,8,9,6,0,0,0,0};
//		int[] arr = getArr(30);
		int[] arr = {1,0,9,9,6,0,0,0,0};
		long start = System.currentTimeMillis();
		getSequence(arr);
		long end = System.currentTimeMillis();
		System.out.println("cost : " + (end - start)/1000 + "s");
	}
}
