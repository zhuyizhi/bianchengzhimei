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
		
		while (depth >= 0) {//ȫ��������֮��������Ȼ���˵�-1
			while (pos[depth] < 1) {
				pos[depth]++;
				boolean flag = false;
				if (pos[depth] == 0) {// ��ǰλ��ʹ��"("
					left++;
					if (left <= n) {// �����ŵ�����û�г���Ҫ��
						depth++;
						flag = true;
					}
				} else if (pos[depth] == 1) {// ��ǰλ��ʹ�á�����
					left--;
					int right = depth + 1 - left;
					if (right <= left){ // �����ŵ�����û�г���Ҫ��
						depth++;
						flag = true;
					}
				}
				if(flag && depth > 2*n - 1){//��һ���⣬��������Ȼ��ԭ״̬��
//					���ڴ�ʱ���һ��ֻ������")"�����ֻҪ��depth���˾Ϳ����ˣ����ù�left
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
