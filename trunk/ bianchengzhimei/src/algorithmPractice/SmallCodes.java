package algorithmPractice;

import java.util.Arrays;

import util.Producer;

public class SmallCodes {
	
	/**
	 * 返回a,b,c的中位数，要求整数操作（加减乘除，位运算，比较）尽量少
	 */
	public static int median(int a, int b, int c){
		if(a > b){// 1
			if( a < c)// 2
				return a;
			else
				return b > c ? b : c;// 3
		}else{
			if( b < c)
				return b;
			else
				return a > c ? a : c;
		}
	}
	
	/**
	 * 输入字符串str，保证其中的字母都是不同的。要求字典序输出一组同样长度的字符串，其中的字符是str
	 * 中字母的排列。如输入ab，输出aa,ab,ba,bb。
	 * @param str
	 */
	public static void permString(String str){
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		int maxDepth = arr.length;
		int[] result = new int[maxDepth];
		Arrays.fill(result, -1);
		int depth = 0;
		while(depth >= 0){
			if(depth >= maxDepth){
				Producer.printIntArr(result);
				depth--;
			}else if(result[depth] >= arr.length - 1){
				result[depth] = -1;
				depth--;
			}else{
				result[depth]++;
				depth++;
			}
		}
	}
	
	public static void permStringRecursively(String str, int step, char[] arr){
		if(step >= str.length()){
			Producer.printCharArray(arr);
		}else{
			for(int i = 0; i < str.length(); i++){
				arr[step] = str.charAt(i);
				permStringRecursively(str, step + 1, arr);
			}
		}
	}
	
	public static void main(String[] args)throws Exception{
		String str = "abc";
//		permString(str);
		permStringRecursively(str, 0, new char[str.length()]);
	}
}
