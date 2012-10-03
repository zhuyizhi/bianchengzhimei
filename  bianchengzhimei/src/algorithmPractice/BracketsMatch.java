package algorithmPractice;

import java.util.Arrays;
import util.Producer;

public class BracketsMatch {
	
	public static int count = 0;
	public static void printMatches(int n){
		int[] pos = new int[2*n];
		Arrays.fill(pos, -1);
		int depth = 0;
		int left = 0;
		
		while (depth >= 0) {//全部搜索完之后，搜索深度会回退到-1
			while (pos[depth] < 1) {
				pos[depth]++;
				boolean flag = false;
				if (pos[depth] == 0) {// 当前位置使用"("
					left++;
					if (left <= n) {// 左括号的数量没有超过要求
						depth++;
						flag = true;
					}
				} else if (pos[depth] == 1) {// 当前位置使用“）”
					left--;
					int right = depth + 1 - left;
					if (right <= left){ // 右括号的数量没有超过要求
						depth++;
						flag = true;
					}
				}
				if(flag && depth > 2*n - 1){//是一个解，输出结果，然后还原状态。
//					由于此时最后一个只可能是")"，因此只要将depth回退就可以了，不用管left
					Producer.printIntArr(pos);
					count++;
					depth = 2*n - 1;
				}
			}
			pos[depth] = -1;
			depth--;
		}
	}
	
	public static int catalan(int n){
		int res = 1;
		for(int i = 2*n; i >= n+1; i--)
			res *= i;
		for(int i = n + 1; i > 1; i--)
			res /= i;
		return res;
	}
	
	public static void main(String[] args)throws Exception{
		int n = 5;
		printMatches(n);
		System.out.println("total:" + count + " catalan:" + catalan(n));
	}
}
