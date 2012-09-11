package algorithmPractice;
/**
 * ���������в���������Ϊx������Ҫ�������㷨
 * @author ucai
 *
 */
public class SumEqualToX {
	/**
	 * �ٶ��ǽ������У����Ӵ�С��˼��������������������ָ�룬Ȼ�������ָ��ָ���Ԫ��֮�͵�����ƶ�ָ�롣
	 * ��ָ��������û���������ʵĽ⣬��ô˵��û��������һ��Ԫ�ش��ڡ�
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
				System.out.println("�ҵ��𰸣�"+arr[start]+":"+arr[end]);
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
