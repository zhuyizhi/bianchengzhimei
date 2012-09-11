package basics;
/**
 * 分别实现了两种快速排序的split方法，并测试两种方法的效率。
 * 第一种是在算法课本和算法导论中使用的逻辑上比较清晰的方法，基本操作是数组元素的交换。该方法维持两
 * 个指针i和j，i指针之前的元素都小于等于pivot element，初始化为最低位置；另外一个指针j指向当前扫描的
 * 位置，j扫过的位置之前的元素都是按要求排好的。算法执行时，j从第二个元素开始扫描，当遇到值比pivot小的，
 * 就首先将i往前移动一步，然后调换i和j指向的元素。
 * 
 * 这种方法思路比较清晰，编码容易，但是exchange操作比较耗时。实验时发现，当元素不多时，该实现效率与下面
 * 方法差距很小。
 * 
 * 第二种是交大数据结构教材中的实现方法，也就是严蔚敏书中的实现方法。
 * 这种方法利用了一个额外元素存储low的值，并且从两端交替扫描。书中描述如下：
 * 1.首先将标准元素（即上面的pivot）放在变量k中，这样low的位置就空出来了。接下来重复下面的步骤：
 * 2.从右向左开始检查。如果high的值大于k，那么该位置是正确的，high减1，继续往前检查直到遇到一个小于k的。
 * 3.将小于k的这个值放入low的位置。此时high的位置又空出来了。然后从low位置从左往右检查，直到遇到一个大于k的。
 * 4.将low位置的值放入high位置。
 * 5.重复上面2到4的步骤，直到low和high重叠。将k放入此位置。
 * 
 * 这种方法实现稍复杂，但在数据多的时候速度更快。
 * 
 * 另外试图测试随机快速排序。但是由于数组本来就是随机生成的，所以随机交换元素并不会加快排序，反而因为随机数的生成
 * 过于耗时，而导致速度下降。所以关于随机算法的实验不具有代表性。
 * @author ucai
 *
 *
 *
 *追加：在algorithmPractice包里，写了一个严蔚敏教材上讲解的初始版本的quickSort，即基础操作是swap而不是赋值的，这里
 *的第二种方法是由该种方法演变而来的。
 */
public class QuickSort {
	/**
	 * 第一种方法的split实现
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
	 * 第二种方法的split实现
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
	 * 第二种方法加上随机的split实现
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
	 * 第一种方法的整体实现
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
	 *  第二种方法的整体实现
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
	 *  第二种方法加随机的整体实现
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
	 * 测试第一种方法和第二种方法的效率
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
		 * 实验结果：元素为100000，500次测试：Exchange:9517 Assign:8795
		 *		           元素为1000000，500次测试：Exchange:354080  Assign:303203
		 */
	}
	/**
	 * 测试第二种方法和第二种方法加随机化的效率
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
		 * 试验结果（500次测试）:元素数量:100000。第一次：random:16648  definite:8795。第二次：random:16627  definite:8800
		 * 					          元素数量:1000000。random:393344  definite:317652
		 */
	}
	public static void main(String[]args){
		testRandom();
//		testExchangeVersusAssign();
	}
}
