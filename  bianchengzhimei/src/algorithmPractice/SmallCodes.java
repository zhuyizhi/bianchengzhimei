package algorithmPractice;

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
	
	
	public static void main(String[] args)throws Exception{
		
		
	}
}
