package google;

import util.Producer;

public class ArrayRelated {
	/**
	 *���⣺ һ����n�����飬�������ַ�ΧΪ[0,n-1]�����һ��ʱ�临�Ӷ�O(n)���ռ临�Ӷ�
	 *O(1)���㷨�ҳ�����һ���ظ�������
	 *
	 *
	 * @param arr
	 * @return
	 */
	public static int getDuplicate(int[] arr){
//	     int n = arr.length;
	     for(int i = 0; i < arr.length; i++){
	          while(arr[i] != i){
	               if(arr[i] == arr[arr[i]])
	                    return arr[i];
	               else{
	                    int tmp = arr[i];
	                    arr[i] = arr[tmp];
	                    arr[tmp] = tmp;
	               }                    
	          } 
	     }   
	     return -1;
	}

	
	public static void main(String[] args)throws Exception{
		int[] arr = Producer.getIntArray(10, 10);
		int[] arr1 = {0,1,2,3,4,5,6};
		int[] arr2 = {1,1};
		Producer.printIntArr(arr);
		System.out.println(getDuplicate(arr));
	}
}
