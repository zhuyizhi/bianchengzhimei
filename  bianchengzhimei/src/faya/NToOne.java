package faya;

import util.Producer;

/**
 * http://fayaa.com/tiku/view/21/
 * 
 * һ������ n ��������������ѭ��������

�� n ���������� n ����һ�����һ��

�� n ��ż����������Сһ�롣

����̵Ĳ���� n ��� 1��


����д����һ����֦�޽緽����������ͬ��˼��ĳɶ�̬�滮����
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
