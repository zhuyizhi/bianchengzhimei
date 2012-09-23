package basics.java;

public class StringRelated {
	
	public static void test(){
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= 1000; i++)
			sb.append(i);
		
		int sum = 0;
		for(int j = 0; j < sb.length(); j++){
			if(sb.charAt(j) == '0')
				sum++;
		}
		
		System.out.println(sum);
	}
	
	public static void main(String[] args){
		test();
	}
}
