package basics.java;

public class ByteOperation {

	public static byte reverse(byte b){
//		byte[] arr = new byte[8];
		int[] arr = new int[8];
		for(int i = 7; i >= 0; i--){
//			arr[i] = (byte)(b & masks[i]);
			arr[i] = (b & masks[i]);
		}
		
		for(int step = 0; step < 4; step++){
			arr[step] <<= 7 - step * 2;
			arr[7 - step] >>>= 7 - step * 2;
		}
		
		byte res = 0;
		for(int bt : arr)
			res |= bt;
		
		return res;
	}
	
	public static int[] masks = {1, 2, 4, 8, 16, 32, 64, 128};
	
	public static void test(byte b){
		for(int i = 7; i >= 0; i--){
			System.out.print((b & masks[i]) >>> i); 
		}
	}
	
	public static void testChuangXinAnd(int num){
		int count = 0;
		while(true){
			
			
		}
	}
	
	public static void main(String[] args){
		byte b = -125;
//		System.out.println(reverse(b, 3));
//		printByte(b);
//		test(b);
//		 System.out.println(~b);
		System.out.println(reverse(b));
		
		byte bb = -128;
		System.out.println((int)bb);
	}
}
