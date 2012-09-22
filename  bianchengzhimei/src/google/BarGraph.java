package google;

import java.util.Stack;

/**
 * ����һ��Ǹ�������ʾһ����״ͼ������״ͼ��������ľ��Ρ�
 * 
 * ΢���ϳ����߸�����O(n)�㷨��
 * ����ջ�����浱ǰ��������п��ܵľ��κ;��ε���ʼλ�á�
 * 
 * ������һ���µ�Ԫ�ص�ʱ��
 *1�� ���Ǳȵ�ǰջ��Ԫ�ش���ôֱ����ջ��
 *2�� ���Ǳȵ�ǰջ��Ԫ��С����ô���ж�ջ�����б���С�����γ�ջ����ͳ��һ�ν����
 *		a. ���ջΪ�գ���ô����ǰԪ��ѹ��ջ���ұ��λ��Ϊ0��
 *		b. ���ջ��Ϊ�գ���ô����ǰԪ��ѹ��ջ�����λ��Ϊ��ǰλ�á�
 *
 *��������ڶ�ջ�е�Ԫ�س�ջ��ͳ��һ�ν����
 *
 *���ν����ȡ���ֵ���ɡ�
 * @author ucai
 *
 */
public class BarGraph {
	
	public static int max = Integer.MIN_VALUE;
	public static void getMaxMatrix(int[] arr){
		Stack<Pair> stack = new Stack<Pair>();
		for(int i = 0; i < arr.length; i++){
			if(stack.isEmpty()){
				Pair p = new Pair(arr[i], 0);
				stack.push(p);
			}else{
				if(stack.peek().val > arr[i]){
					Pair bp = stack.pop();
					int base = bp.val;
					int sum = 0, start = bp.pos;
					while(!stack.isEmpty() && stack.peek().val > arr[i]){
						Pair p = stack.pop();
						start = p.pos;
						base = p.val;
					}
					sum = base * (bp.pos - start + 1);//���ӵ�ǰֵ
					if(sum > max)
						max = sum;
					sum = arr[i] * (bp.pos - start + 2);
					if(sum > max)
						max = sum;
					
					if(stack.isEmpty())
						stack.push(new Pair(arr[i], 0));
					else
						stack.push(new Pair(arr[i], i));
				}else{
					stack.push(new Pair(arr[i], i));
				}
			}
		}
	}
	
	public static void main(String[] args){
		int[] arr = {2,6,3,8,1,7,5,4,6,2,5};
		getMaxMatrix(arr);
		System.out.println(max);
	}
}
class Pair{
	int val;
	int pos;
	public Pair(int val, int pos){
		this.val = val; this.pos = pos;
	}
	@Override
	public String toString() {
		return Integer.toString(val);
	}
}