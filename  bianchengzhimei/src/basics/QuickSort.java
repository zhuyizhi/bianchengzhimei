package basics;
/**
 * �ֱ�ʵ�������ֿ��������split���������������ַ�����Ч�ʡ�
 * ��һ�������㷨�α����㷨������ʹ�õ��߼��ϱȽ������ķ�������������������Ԫ�صĽ������÷���ά����
 * ��ָ��i��j��iָ��֮ǰ��Ԫ�ض�С�ڵ���pivot element����ʼ��Ϊ���λ�ã�����һ��ָ��jָ��ǰɨ���
 * λ�ã�jɨ����λ��֮ǰ��Ԫ�ض��ǰ�Ҫ���źõġ��㷨ִ��ʱ��j�ӵڶ���Ԫ�ؿ�ʼɨ�裬������ֵ��pivotС�ģ�
 * �����Ƚ�i��ǰ�ƶ�һ����Ȼ�����i��jָ���Ԫ�ء�
 * 
 * ���ַ���˼·�Ƚ��������������ף�����exchange�����ȽϺ�ʱ��ʵ��ʱ���֣���Ԫ�ز���ʱ����ʵ��Ч��������
 * ��������С��
 * 
 * �ڶ����ǽ������ݽṹ�̲��е�ʵ�ַ�����Ҳ������ε�����е�ʵ�ַ�����
 * ���ַ���������һ������Ԫ�ش洢low��ֵ�����Ҵ����˽���ɨ�衣�����������£�
 * 1.���Ƚ���׼Ԫ�أ��������pivot�����ڱ���k�У�����low��λ�þͿճ����ˡ��������ظ�����Ĳ��裺
 * 2.��������ʼ��顣���high��ֵ����k����ô��λ������ȷ�ģ�high��1��������ǰ���ֱ������һ��С��k�ġ�
 * 3.��С��k�����ֵ����low��λ�á���ʱhigh��λ���ֿճ����ˡ�Ȼ���lowλ�ô������Ҽ�飬ֱ������һ������k�ġ�
 * 4.��lowλ�õ�ֵ����highλ�á�
 * 5.�ظ�����2��4�Ĳ��裬ֱ��low��high�ص�����k�����λ�á�
 * 
 * ���ַ���ʵ���Ը��ӣ��������ݶ��ʱ���ٶȸ��졣
 * 
 * ������ͼ��������������򡣵����������鱾������������ɵģ������������Ԫ�ز�����ӿ����򣬷�����Ϊ�����������
 * ���ں�ʱ���������ٶ��½������Թ�������㷨��ʵ�鲻���д����ԡ�
 * @author ucai
 *
 *
 *
 *׷�ӣ���algorithmPractice���д��һ����ε���̲��Ͻ���ĳ�ʼ�汾��quickSort��������������swap�����Ǹ�ֵ�ģ�����
 *�ĵڶ��ַ������ɸ��ַ����ݱ�����ġ�
 */
public class QuickSort {
	/**
	 * ��һ�ַ�����splitʵ��
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	public static  int splitExchange(double[] arr,int low,int high){
			double key=arr[low];
			int i=low;
			for(int j=low+1;j<=high;j++){
				if(arr[j]<=key){
					i++;
					if(i!=j)
					{
						double temp=arr[i];
						arr[i]=arr[j];
						arr[j]=temp;
					}
				}
			}
			double temp=arr[i];
			arr[i]=key;
			arr[low]=temp;
		return i;
	}
	/**
	 * �ڶ��ַ�����splitʵ��
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	public static int splitAssign(double[] arr,int low, int high){
		double key=arr[low];
		while(high>low){
			while(high>low&&arr[high]>key){
				high--;
			}
			if(high>low){
				arr[low]=arr[high];
				low++;
			}
			
			while(high>low&&arr[low]<=key)
				low++;
			if(high>low)
			{
				arr[high]=arr[low];
				high--;
			}
		}
		arr[low]=key;
		return low;
	}
	
	/**
	 * �ڶ��ַ������������splitʵ��
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	public static int splitAssignRandom(double[] arr,int low, int high){
		if(high>low){
			java.util.Random rd=new java.util.Random();
			int r=rd.nextInt()%(high-low);
			if(r<0)
				r=-r;
			
			int lowPlace=r+low;
			double temp=arr[lowPlace];
			arr[lowPlace]=arr[low];
			arr[low]=temp;
		}
		
		double key=arr[low];
		while(high>low){
			while(high>low&&arr[high]>key){
				high--;
			}
			if(high>low){
				arr[low]=arr[high];
				low++;
			}
			
			while(high>low&&arr[low]<=key)
				low++;
			if(high>low)
			{
				arr[high]=arr[low];
				high--;
			}
		}
		arr[low]=key;
		return low;
	}
	/**
	 * ��һ�ַ���������ʵ��
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void quickSortExchange(double[] arr,int low,int high){
		if(high>low){
			int mid=splitExchange(arr,low,high);
			quickSortExchange(arr,low,mid-1);
			quickSortExchange(arr,mid+1,high);
		}
	}
	/**
	 *  �ڶ��ַ���������ʵ��
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void quickSortAssign(double[]arr, int low, int high){
		if(high>low){
			int mid=splitAssign(arr,low,high);
			quickSortAssign(arr,low,mid-1);
			quickSortAssign(arr,mid+1,high);
		}
	}
	/**
	 *  �ڶ��ַ��������������ʵ��
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void quickSortAssignRandom(double[]arr, int low, int high){
		if(high>low){
			int mid=splitAssignRandom(arr,low,high);
			quickSortAssignRandom(arr,low,mid-1);
			quickSortAssignRandom(arr,mid+1,high);
		}
	}
	/**
	 * ���Ե�һ�ַ����͵ڶ��ַ�����Ч��
	 */
	public static void testExchangeVersusAssign(){
		final int length=100000;
		final int testTimes=500;
		double[] arr=new double[length];
		java.util.Random rd=new java.util.Random();
		long time1=System.currentTimeMillis();
		for(int j=0;j<testTimes;j++){
			for(int i=0;i<arr.length;i++){
				arr[i]=rd.nextInt()%1000;
			}
			quickSortAssign(arr,0,length-1);
		}
		long time2=System.currentTimeMillis();
		
		long time3=System.currentTimeMillis();
		for(int j=0;j<testTimes;j++){
			for(int i=0;i<arr.length;i++){
				arr[i]=rd.nextInt()%1000;
			}
			quickSortExchange(arr,0,length-1);
		}
		long time4=System.currentTimeMillis();
		System.out.println("Exchange:"+(time4-time3)+"  "+"Assign:"+(time2-time1));
		/**
		 * ʵ������Ԫ��Ϊ100000��500�β��ԣ�Exchange:9517 Assign:8795
		 *		           Ԫ��Ϊ1000000��500�β��ԣ�Exchange:354080  Assign:303203
		 */
	}
	/**
	 * ���Եڶ��ַ����͵ڶ��ַ������������Ч��
	 */
	public static void testRandom(){
		final int length=100000;
		final int testTimes=500;
		double[] arr=new double[length];
		java.util.Random rd=new java.util.Random();
		long time1=System.currentTimeMillis();
		for(int j=0;j<testTimes;j++){
			for(int i=0;i<arr.length;i++){
				arr[i]=rd.nextInt()%1000;
			}
			quickSortAssignRandom(arr,0,length-1);
//			for(double d:arr){
//				System.out.println(d);
//			}
		}
		long time2=System.currentTimeMillis();
		
		long time3=System.currentTimeMillis();
		for(int j=0;j<testTimes;j++){
			for(int i=0;i<arr.length;i++){
				arr[i]=rd.nextInt()%1000;
			}
			quickSortAssign(arr,0,length-1);
		}
		long time4=System.currentTimeMillis();
		System.out.println("random:"+(time2-time1)+"  "+"definite:"+(time4-time3));
		/**
		 * ��������500�β��ԣ�:Ԫ������:100000����һ�Σ�random:16648  definite:8795���ڶ��Σ�random:16627  definite:8800
		 * 					          Ԫ������:1000000��random:393344  definite:317652
		 */
	}
	public static void main(String[]args){
		testRandom();
//		testExchangeVersusAssign();
	}
}
