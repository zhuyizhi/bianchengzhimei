package algorithmPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	public static void swap(char[] arr, int i, int j){
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void paiLieString(char[] arr, int pos) {
		if(pos == arr.length){
			Producer.printCharArray(arr);
		}else{
			for(int i = pos; i < arr.length; i++){
				swap(arr, pos ,i);
				paiLieString(arr, pos + 1);
				swap(arr, pos, i);
			}
		}
	}
	/**
	 * ��һ�仰����ת������硰welcome to innovation works.�� ��� ��works. innovation to welcome��
	 * @param arr
	 * @return
	 */
	public static char[] revertSentence(char[] arr){
		char[] result = new char[arr.length];
		int rp = 0;
		int ap = arr.length - 1;
		
		while(ap >= 0){
			int lastP = ap;
			while(ap >= 0 && arr[ap] != ' ')
				ap--;
			if(ap < 0){
				ap = 0;
			}else
				ap++;
			
			for(int i = ap; i <= lastP; i++, rp++){
				System.out.println("rp = " + rp + ", i=" + i);
				result[rp] = arr[i];
			}
			ap--;
			lastP = ap;
			while(ap>=0 && arr[ap] == ' '){
				result[rp++] = arr[ap];
				ap--;
			}
		}
		
		return result;
	}
	/**
	 * ����һ�����飬����������е�2a = b�����ԣ�����a��b���������е���
	 * @param arr
	 */
	public static void printDouble(int[] arr){
//		������
		Arrays.sort(arr);
		
//		Ѱ�������ķֽ���
		int posStart = 0;
		for(posStart = 0; posStart < arr.length; posStart++){
			if(arr[posStart] >= 0)
				break;
		}
		
//		��������
		for(int p1 = posStart, p2 = posStart + 1; p2 < arr.length;){
			if(2 * arr[p1] == arr[p2]){
				System.out.println(arr[p1] + " " + arr[p2]);
				p1++;
				p2++;
			}else if(2 * arr[p1] < arr[p2])
				p1++;
			else
				p2++;
		}
		
		for(int p1 = posStart - 1, p2 = p1 - 1; p2 >= 0;){
			if(2 * arr[p1] == arr[p2]){
				System.out.println(arr[p1] + " " + arr[p2]);
				p1--;
				p2--;
			}else if(2 * arr[p1] < arr[p2])
				p2--;
			else
				p1--;
		}
	}
	
	/**
	 * �ַ�����ֻ��R,G,B�����ַ������ﵽR��ǰ��G���У�B�ں�Ҫ��O(1)�ռ䡣
	 * @param str
	 */
	public static void RGBRank(char[] arr){
		int r = 0, p = 0, b = arr.length - 1;
		while(p <= b){
			switch(arr[p]){
			case 'G':
				p++;
				break;
			case 'R':
				if(p <= r)
					p++;
				else{
					arr[p] = 'G';
					arr[r] = 'R';
					p++;
					r++;
				}
				break;
			case 'B':
				if(p == b)
					p++;
				else{
					char tmp = arr[b];
					arr[b] = 'B';
					arr[p] = tmp;
					b--;
				}
			}
		}
		Producer.printCharArray(arr);
		countRGB(arr);
	}
	/**
	 * ������������������������R��G��B�Ķ���
	 * @param arr
	 */
	public static void countRGB(char[] arr){
		int r = 0, g = 0, b = 0;
		for(char c : arr)
			switch(c){
			case 'R':
				r++;
				break;
			case 'G':
				g++;
				break;
			case 'B':
				b++;
				break;
			}
		System.out.println("r=" + r + ", g=" + g + " ,b=" + b);
	}
	
	/**
	 * pattern�п��ܺ���*��?,*ƥ������������ַ���?ƥ��һ�������ַ�
	 * @param pattern
	 * @param str
	 * @return
	 */
	public static boolean stringMatch(String pattern, String str){
		String[] arr = pattern.split("[*]");
		int start = 0;
		for(String subPattern : arr){
			if(subPattern.length() > 0){
				int index;
				index = indexOf(subPattern, str, start);
				if(start == 0 && index > 0 && !pattern.startsWith("*"))
					start = -1;
				else
					start = index;
				if(start < 0)
					break;
				else
					start += subPattern.length();
			}
		}
		if(start < 0)
			return false;
		return true;
	}
	/**
	 * ���stringMatch�ĸ�������
	 * @param subPattern
	 * @param str
	 * @param start
	 * @return
	 */
	public static int indexOf(String subPattern, String str, int start){
		for(int i = start; i < str.length(); i++){
			if(subPattern.charAt(0) == '?' || str.charAt(i) == subPattern.charAt(0)){
				int k;
				for(k = 0; k < subPattern.length() && i + k < str.length() &&
						(subPattern.charAt(k) == '?' || str.charAt(i+k) == subPattern.charAt(k));k++);
					if(k >= subPattern.length())
						return i;
			}
		}
		return -1;
	}
	public static void testStringMatch(){
		String str = "haha you are good";
		String pattern = "hah?*yok";
		
		System.out.println(stringMatch(pattern, str));
		
	}
	
	public static void main(String[] args)throws Exception{
//		String str = "abc";
//		String sent = "welcome to innovation works.";
		String str = "1234";
		paiLieString(str.toCharArray(), 0);
//		permString(str);
//		permStringRecursively(str, 0, new char[str.length()]);
//		Producer.printCharArray(revertSentence(sent.toCharArray()));
		
//		int[] arr = Producer.getIntArray(10, 20);
//		int[] arr = {-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9};
//		Producer.printIntArr(arr);
//		System.out.println("###################################");
//		printDouble(arr);
		
		
//		char[] rgbs = Producer.getCharArray(20, new char[]{'R','G','B'});
//		countRGB(rgbs);
//		Producer.printCharArray(rgbs);
//		RGBRank(rgbs);
		
//		testStringMatch();
	}

}
