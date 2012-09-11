package basics;
/**
 * ����������������⡣��¼����������Ľⷨ��
 * �����Ǽӷ�������������������⣺����һ��ʵ������x1,...xn��Ѱ��һ�������������У�ʹ���ǵĺ�Ϊ���
 * ����һ�������ǳ˷�������������������⣬����������Ÿ�Ϊ�ˡ�
 * 
 * ����Ĵ��Ǵӡ��㷨����--һ�ִ����Է������ҵ��ġ�
 * 1.Ҫʹ�õ���ʽ����⣬ֱ�ӵ��뷨������ɼ����ǣ�
 * 												��֪ǰn-1��Ԫ�ص�������������С�
 * 2.Ȼ�����������֪ǰn-1��Ԫ�ص�������������У���ôn��Ԫ�ص��������������Ҫô�ǵ���ǰn-1��Ԫ�ص�������������У�Ҫô��
 * ������n-1��Ԫ�ص�����������ټ��ϵ�n��Ԫ�ص�ֵ��ɵ������С�
 * 3.���Կ�����������֪��ǰn-1��Ԫ�ص���������������ǲ����ģ�����Ҫ֪��������n-1��Ԫ�ص�������������С���������Ҫ��ǿ��1��
 * ��ļ��裬�µĹ��ɼ����ǣ�
 * 							��֪ǰn-1��Ԫ�ص�������������У�����֪����Ԫ��n-1��������������У��������˵���ǰ�����׺����������У���
 * ������°�����׺����������еķ����ǣ�������ϵ�n��Ԫ��֮��������е�ֵС��0������������е�ֵΪ0�����µĺ���׺������������Ǵӵ�n
 * ��Ԫ�ؿ�ʼ�ġ������ֱ����ԭ��׺�ϼ��ϵ�n��Ԫ�ء�
 * ʱ�临�Ӷ�ΪO(n).
 * @author ucai
 *
 */
public class MaximumConsecutiveSubsequence {
	/**
	 * 
	 * @param arr ʵ������
	 * @return ����������е�Ԫ�صĺ͡���������е�λ�á�
	 */
	public static int maximumConsecutiveSubsequence(int[]arr){
		int globalMax=0,suffixMax=0;//globalMax��ȫ�����ֵ��suffixMax��ά���ĺ���׺�����ֵ
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
	 * �˷���������С�����մ����������Ϊ1����������Ľⷨ���ܽ��������еĻ�С��1�������������������᷵��1������Ϊ�������Ϊ�մ���
	 * ����ⷨ���Լ�����������㷨��д�ģ���֮ͬ���ǽ����ɼ����Ϊ������ʽ��
	 * 																	��֪ǰn-1��Ԫ�ص�������У��Լ�����׺�ķ���Ϊ�����������s_pos���Լ�����׺�ķ���Ϊ���ľ���ֵ����
	 * 																	�������s_neg��
	 * ����Ѱ��ǰn��Ԫ�ص�������оͿ������·�����
	 * 1.�����n��Ԫ�������ģ���ôֻ��Ƚϵ�n��Ԫ�س���s_pos�Ľ���뵱ǰȫ�����ֵ������ʱ��s_pos=s_pos*arr[n];s_neg=s_neg*arr[n]��
	 * 2.�����n��Ԫ���Ǹ��ģ���ô��Ҫ�Ƚϵ�n��Ԫ�س���s_neg�Ľ���뵱ǰȫ�����ֵ�������ǣ�s_pos=(old s_neg)*arr[n];s_neg=(old s_pos)*arr[n]��
	 * 3.�����n��Ԫ����0����ô����Ҫ���µ�ǰȫ�����ֵ��ֻ��Ҫ���½�s_pos��s_neg��Ϊ1��
	 * @param arr
	 * @return
	 */
	public static int maximumConsecutiveSubsequenceMutiply(int[]arr){
		int globalMax=1,suffixMaxNegative=1,suffixMaxPositive=1;
		int len=arr.length;
		for(int i=0;i<len;i++){
			if(arr[i]>0)//����ǰֵΪ��
			{
				int tempSuffix=arr[i]*suffixMaxPositive;
				if(tempSuffix>globalMax){
					globalMax=tempSuffix;	
				}
				suffixMaxPositive=tempSuffix;
				suffixMaxNegative*=arr[i];
			}else if(arr[i]<0){//����ǰֵΪ��
				if(suffixMaxNegative>0)//��ʾarr[i]�������еĵ�һ������������������0֮�������ĵ�һ����������ʱ�������Ƚ����⡣��ʱ��Ҫ�����ĺ���׺���������������Ϊ1��
					//���������κ�Ԫ�أ����ĺ���׺�������������Ҫ��ʼ��Ϊs_pos*arr[i]
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
