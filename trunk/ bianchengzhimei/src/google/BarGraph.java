package google;

import java.util.Stack;

/**
 * 给定一组非负整数表示一个柱状图，求柱状图内面积最大的矩形。
 * 
 * 微博上出题者给出的O(n)算法：
 * 利用栈来保存当前计算过程中可能的矩形和矩形的起始位置。
 * 
 * 当遇到一个新的元素的时候：
 *1） 若是比当前栈顶元素大，那么直接入栈；
 *2） 若是比当前栈顶元素小，那么所有堆栈中所有比它小的依次出栈，且统计一次结果：
 *		a. 如果栈为空，那么将当前元素压入栈，且标记位置为0；
 *		b. 如果栈不为空，那么将当前元素压入栈，标记位置为当前位置。
 *
 *最后所有在堆栈中的元素出栈，统计一次结果。
 *
 *各次结果中取最大值即可。
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
					sum = base * (bp.pos - start + 1);//不加当前值
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