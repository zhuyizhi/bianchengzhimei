package algorithmPractice;

import java.util.Arrays;

public class HuiWenString {
	/**
	 * ���˼���Ǵ��
	 * @param str
	 */
	public static void huiWen(String str){
		char[] cArr = str.toCharArray();
		int[] evenPos = new int[cArr.length];
		int[] oddPos = new int[cArr.length];
		Arrays.fill(evenPos, 0);
		Arrays.fill(oddPos, 0);
		
		for(int i = 1; i < cArr.length; i++){
			if (evenPos[i - 1] > 0) {// i - 1λ���л��ģ����濴�ܷ��������
				int left = i - 2 - evenPos[i - 1];
				if (left >= 0 && cArr[left] == cArr[i])// ƥ�����ˣ���������
					evenPos[i] = evenPos[i - 1] + 2;
			}
			
			if(oddPos[i - 1] > 0){
				int left = i - 2 - oddPos[i - 1];
				if(left >= 0 && cArr[left] == cArr[i])
					oddPos[i] = oddPos[i - 1] + 2;
			}
			
			if(evenPos[i] == 0)//û��ƥ���ϣ���ͼƥ��cac��
				if(i - 2 >= 0 && cArr[i - 2] == cArr[i])
					evenPos[i] = 2;
			

			if(oddPos[i] == 0)//��ͼƥ��cc��
				if(cArr[i - 1] == cArr[i])
					oddPos[i] = 1;
		}
	}
	
	public static void main(){
		
	}
}
