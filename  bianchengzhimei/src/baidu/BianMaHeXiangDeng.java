package baidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * ��Ŀ������һ�����ֱ���N�����������¿����ҵ�һ�����ֱ���M����λ����N��ȣ����������0��ʼ������λ����֮����N��λ����֮�������M�Ǵ���N�����б�������С��һ����Ҳ����Ҫ�ҵı��벻���ڡ�
 * ��N=134, M = 143; N = 020, M = 101; ��ʽ������Ϊf(N) = M, ��M�����ڣ���f(N) = -1;
 * ���ڸ���һ��N��Nλ��������1000����С������10^500��������S(N),����S(0)=N, S(1)=f(N), S(2)=f(S(1)),...��S(i+1)=-1ʱ��������С��0��Ԫ�ز������������С�
 * 
 * 
 * ���˼·��
 * 
	* ��ԭ�����ֱ仯��С�ķ����ǣ���ĩλ��1�������ڶ�λ��1����134-->143
	* ���Կ�������˼���ǣ�Ѱ��һ��λ��high��low������high > low����high��λ���ϵ����ּ�1�������͵õ���һ����ԭ�����ָ��������highλ֮��ĳ�0�����Ч����Ӧ�����ܵ�С�������Ҫ����֮����Ͷ��ƶ���������Ч���ֵ����λ-1�������low��ע��Ч���ֵĿ�ʼ��
	* �������Ҫע����Ǳ߽��������9��0����һ��λ�����ֵΪ0ʱ�����ܽ��м�1�Ĳ�������һ��λ�õ�ֵ��9ʱ�����ܽ��м�1�Ĳ�����
	* �����㷨��;
	* 
		* �ӵ͵��ߣ�Ѱ�ҵ�һ����Ϊ0��λ����Ϊlow��
		* ��low��ʼ���ߴ���Ѱ�ҵ�һ����Ϊ9��λ����Ϊhigh��
		* arr[high]++��
		* ��high - 1 �� low��֮������ӵ͵��߽������򣬲�����Сֵ�Լ�1������Ľ������lowλ��������ĩβ����ԭλ�ô���0��
		* �㷨����ʧ�ܵ�λ�ã�
		* 
			* low �������ֵ��������ȫΪ0��
			* high�������ֵ�������ݴ����λ��low����9����999...999000...0000
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
