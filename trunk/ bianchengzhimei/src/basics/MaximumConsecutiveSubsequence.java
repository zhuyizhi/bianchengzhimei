package basics;
/**
 * 最大连续子序列问题。记录了两个问题的解法。
 * 首先是加法的最大连续子序列问题：给定一个实数序列x1,...xn，寻找一个连续的子序列，使它们的和为最大。
 * 另外一个变形是乘法的最大连续子序列问题，即将运算符号改为乘。
 * 
 * 此题的答案是从《算法引论--一种创造性方法》找到的。
 * 1.要使用递推式解此题，直接的想法是设归纳假设是：
 * 												已知前n-1个元素的最大连续子序列。
 * 2.然后分析，若已知前n-1个元素的最大连续子序列，那么n个元素的最大连续子序列要么是等于前n-1个元素的最大连续子序列，要么是
 * 包含第n-1个元素的最大子序列再加上第n个元素的值组成的子序列。
 * 3.可以看出仅仅假设知道前n-1个元素的最大连续子序列是不够的，还需要知道包含第n-1个元素的最大连续子序列。于是这里要增强第1步
 * 里的假设，新的归纳假设是：
 * 							已知前n-1个元素的最大连续子序列，且已知包含元素n-1的最大连续子序列（书里面的说法是包含后缀的最大子序列）。
 * 这里更新包含后缀的最大子序列的方法是：如果加上第n个元素之后该子序列的值小于0，则设该子序列的值为0，即新的含后缀的最大子序列是从第n
 * 个元素开始的。否则就直接在原后缀上加上第n个元素。
 * 时间复杂度为O(n).
 * @author ucai
 *
 */
public class MaximumConsecutiveSubsequence {
	/**
	 * 
	 * @param arr 实数数组
	 * @return 最长连续子序列的元素的和。并输出序列的位置。
	 */
	public static int maximumConsecutiveSubsequence(int[]arr){
		int globalMax=0,suffixMax=0;//globalMax是全局最大值，suffixMax是维护的含后缀的最大值
		int startpoint=0,endpoint=-1,tempStartpoint=0;
		int len=arr.length;
		for(int i=0;i<len;i++){
			int tempSuffix=arr[i]+suffixMax;
			if(tempSuffix>globalMax)//
			{
				globalMax=tempSuffix;
				suffixMax=tempSuffix;
				endpoint=i;
				startpoint=tempStartpoint;
			}else if(tempSuffix>0){
				suffixMax=tempSuffix;
			}else{
				suffixMax=0;
				tempStartpoint=i+1;
			}
		}
		if(endpoint>=startpoint)
			System.out.println("start at:"+startpoint+" end at:"+endpoint);
		else
			System.out.println("all of the integers are negative!");
		return globalMax;
	}
	/**
	 * 乘法的最长子序列。假设空串的最长子序列为1。下面给出的解法不能解决最长子序列的积小于1的情况，碰到这种情况会返回1，即认为最长子序列为空串。
	 * 此题解法是自己根据上面的算法改写的，不同之处是将归纳假设改为如下形式：
	 * 																	已知前n-1个元素的最长子序列，以及含后缀的符号为正的最长子序列s_pos，以及含后缀的符号为负的绝对值最大的
	 * 																	最长子序列s_neg。
	 * 这样寻找前n个元素的最长子序列就可以如下方法：
	 * 1.如果第n个元素是正的，那么只需比较第n个元素乘以s_pos的结果与当前全局最大值。更新时，s_pos=s_pos*arr[n];s_neg=s_neg*arr[n]。
	 * 2.如果第n个元素是负的，那么需要比较第n个元素乘以s_neg的结果与当前全局最大值。更新是，s_pos=(old s_neg)*arr[n];s_neg=(old s_pos)*arr[n]。
	 * 3.如果第n个元素是0，那么不需要更新当前全局最大值，只需要重新将s_pos和s_neg设为1。
	 * @param arr
	 * @return
	 */
	public static int maximumConsecutiveSubsequenceMutiply(int[]arr){
		int globalMax=1,suffixMaxNegative=1,suffixMaxPositive=1;
		int len=arr.length;
		for(int i=0;i<len;i++){
			if(arr[i]>0)//若当前值为正
			{
				int tempSuffix=arr[i]*suffixMaxPositive;
				if(tempSuffix>globalMax){
					globalMax=tempSuffix;	
				}
				suffixMaxPositive=tempSuffix;
				suffixMaxNegative*=arr[i];
			}else if(arr[i]<0){//若当前值为负
				if(suffixMaxNegative>0)//表示arr[i]是数组中的第一个负数或者是在碰到0之后遇见的第一个负数，这时处理方法比较特殊。此时需要将正的含后缀的最大子序列重设为1，
					//即不包含任何元素；负的含后缀的最大子序列需要初始化为s_pos*arr[i]
				{
					suffixMaxNegative=suffixMaxPositive*arr[i];
					suffixMaxPositive=1;
				}else{
					int tempSuffix=arr[i]*suffixMaxNegative;
					if(tempSuffix>globalMax){
						globalMax=tempSuffix;	
					}
					suffixMaxNegative=suffixMaxPositive*arr[i];
					suffixMaxPositive=tempSuffix;
				}
			}else{
				suffixMaxNegative=suffixMaxPositive=1;
			}
		}
		
		return globalMax;
	}
	public static void main(String[]args){
		int[] arr1={4,5,-2,-7,8,9,10,-2};
		int[] arr2={-3,-4,5,-7};
		int[] arr3={-3,-4,-5,-7};
		int[] arr4={-3,-4,0,-5,-7};
		System.out.println(maximumConsecutiveSubsequenceMutiply(arr1));
		System.out.println(maximumConsecutiveSubsequenceMutiply(arr2));
		System.out.println(maximumConsecutiveSubsequenceMutiply(arr3));
		System.out.println(maximumConsecutiveSubsequenceMutiply(arr4));
	}
}
