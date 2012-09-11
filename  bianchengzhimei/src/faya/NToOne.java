package faya;

import util.Producer;

/**
 * http://fayaa.com/tiku/view/21/
 * 
 * 一个整数 n ，对它进行如下循环操作：

若 n 是奇数，将 n 增加一或减少一；

若 n 是偶数，将它减小一半。

求最短的步骤把 n 变成 1。


这里写的是一个分枝限界方法，可以以同样思想改成动态规划方法
 * @author ucai
 *
 */
public class NToOne {
	
	public static int[] step;
	public static int[] maxStep;
	public static int MAX;
	
	
	public static void getStep(int n, int cs){
		if(n == 1 && cs < MAX)
		{
			MAX = cs;
			maxStep = step.clone();
			step[cs] = 0;
		}else if(cs >= MAX){
			step[cs] = 0;
		}else if(n % 2 == 1){
			step[cs] = -1;
			getStep(n - 1, cs + 1);
			step[cs] = 1;
			getStep(n + 1, cs + 1);
			step[cs] = 0;
		}else{
			step[cs] = 2;
			getStep(n / 2, cs + 1);
		}
	}
	
	public static void main(String[] args){
		int n = 20100816;
		MAX = n;
		step = new int[n];
		maxStep = new int[n];
		getStep(n, 0);
//		System.out.println();
//		Producer.printIntArr(maxStep);
		for(int i = 0; i < MAX; i++)
			System.out.print(maxStep[i] + " ");
		System.out.println();
		System.out.println(MAX);
	}
}
