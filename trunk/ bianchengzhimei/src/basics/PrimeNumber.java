package basics;

import java.util.HashSet;
/**
 * 关于素数测试的方法，在下载的文档里（在笔记--》2011年5月里有文档）介绍了几种方法。
 * 总结起来共有：（1）朴素测试的方法，即从2到根号N测试的方法；
 * （2）使用筛选法，就是这里实现的judgeByFiltering及judgeByFiltering2的方法。
 * 这种方法是给出小于某个值的所有素数。主要思想是，从2开始，去掉n以内的所有
 * 能被整除的数；然后向前移动，拿得到的下一个素数，继续删除后面能整除该数的数。
 * 下载的文档里说这个算法的时间复杂度是O(nloglogn)。
 * （3）朴素加筛选法，就是先用筛选法算出2到根号n里的所有素数，然后再用朴素测试除。
 * 在渐进意义上没有改进，提高的是实际执行效率
 * （4）另外两种方法是利用费马小定理的素性测试，以及随机算法。这两种方法没有看。
 * @author ucai
 *
 */
public class PrimeNumber {
/**
 * 这个是下载的文件里的实现方法
 * @param n
 */
	public static void judgeByFiltering(int n){
		boolean[] isNotPrime=new boolean[n+1];//java的boolean类型初始化为false。
		for(int i=2;i<=n;i++)//从2到n扫描
			if(isNotPrime[i]==false)//即当前数为素数，因为比它小的数都不能整除它
				for(int j=i+i;j<=n;j=j+i){
					//那么该素数的所有倍数都不是素数，注意这里的步长是i，因此扫描的很快
					isNotPrime[j]=true;
				}
		//输出结果
		for(int i=2;i<n;i++)
			if(isNotPrime[i]==false)
				System.out.print(i+" ");
		System.out.println();
		
	}
	/**
	 * 这个方法是自己开始的时候根据一个博客里的方法实现的。与后来找到的别人的方法的
	 * 不同是，这里记录了目前最大的没被判成合数的数。当除数扫描到该数之后就停止判断后面
	 * 的过程了。但是这样在判断的时候每一步的步长只能是1了，所以需要用取模运算，再加上
	 * 写的格式不够简洁，所以弃用了。
	 * @param n
	 */
	public static void judgeByFilteringDeprecate(int n){
		boolean[] isNotPrime=new boolean[n+1];//默认初始化false
		int pointer=2;//当前除数所在位置
		int max=n;
		while(pointer<max){
			max=pointer;
			for(int i=pointer+1;i<=n;i++){
				if(isNotPrime[i]==false&&(i%pointer)!=0)
					max=i;
				else
					isNotPrime[i]=true;
			}	
			//更新除数
			for(int i=pointer+1;i<=n;i++){
				if(isNotPrime[i]==false)
				{
					pointer=i;
					break;
				}
			}
		}
		//输出结果
		for(int i=2;i<n;i++)
			if(isNotPrime[i]==false)
				System.out.print(i+" ");
		System.out.println();
	}
	public static void main(String[]args){
		judgeByFiltering(500);
		judgeByFilteringDeprecate(500);
	}
}
