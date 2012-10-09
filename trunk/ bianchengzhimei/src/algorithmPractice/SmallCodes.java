package algorithmPractice;

import java.util.Arrays;

import util.Producer;

public class SmallCodes {
	
	/**
	 * ����a,b,c����λ����Ҫ�������������Ӽ��˳���λ���㣬�Ƚϣ�������
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
	 * �����ַ���str����֤���е���ĸ���ǲ�ͬ�ġ�Ҫ���ֵ������һ��ͬ�����ȵ��ַ��������е��ַ���str
	 * ����ĸ�����С�������ab�����aa,ab,ba,bb��
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
