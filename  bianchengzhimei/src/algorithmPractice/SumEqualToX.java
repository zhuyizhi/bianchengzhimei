package algorithmPractice;
/**
 * 有序序列中查找两个和为x的数，要求线性算法
 * @author ucai
 *
 */
public class SumEqualToX {
	/**
	 * 假定是降序排列，即从大到小。思想是在数组两端设两个指针，然后根据两指针指向的元素之和的情况移动指针。
	 * 若指针相遇还没有碰到合适的解，那么说明没有这样的一对元素存在。
	 * @param arr
	 * @param x
	 * @return
	 */
	public static boolean findSumX(double[] arr,double x){
		int start=0,end=arr.length-1;
		while(start<end){
			double res=arr[start]+arr[end];
			if(res<x)
				end--;
			else if(res>x)
				start++;
			else {
				System.out.println("找到答案："+arr[start]+":"+arr[end]);
				return true;
			}
		}
		return false;
	}
	public static void main(String[]args){
		double[]arr={10,9,6,5,4,2};
		System.out.println(findSumX(arr,14));
		System.out.println(findSumX(arr,17));
	}
}
