package algorithmPractice;

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
	
	
	public static void main(String[] args)throws Exception{
		
		
	}
}
