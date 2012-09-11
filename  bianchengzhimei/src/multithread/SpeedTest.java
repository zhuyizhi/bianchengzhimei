package multithread;

class T1 implements Runnable{
	Double[] sum;
	int start, end;
	int index;
	public T1(Double[] sum1, int index, int start, int end){
		sum = sum1;
		this.start = start;
		this.end = end;
		this.index = index;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = start; i < end; i++){
			sum[index] += Math.sqrt(i);
		}
	}
	
}


public class SpeedTest {
	public static void test(Integer[] i){
		i[0]++;
		System.out.println(i[0]);
	}
	
	public static void test2(int end){
		double sum = 0;
		for(int i = 0; i < end; i++){
			sum += Math.sqrt(i);
		}
		System.out.println(sum);
	}
	public static void main(String[] args)throws Exception{
		Double[] sum = {0.0, 0.0};
		int middle = 100000000, end = 200000000;
		long startTime = System.currentTimeMillis();
		Thread t1 = new Thread(new T1(sum, 0, 0, middle));
		Thread t2 = new Thread(new T1(sum, 1, middle, end));
		t1.start();
		t2.start();
//		t1.join();
//		t2.join();
		while(t1.isAlive() || t2.isAlive()){}
		System.out.println(sum[0] + sum[1]);
//		test2(end);
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime)/1000 + "s");
		
		Integer[] ii = {0};
		test(ii);
		System.out.println(ii[0]);
	}
}
