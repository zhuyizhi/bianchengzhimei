package multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class T implements Callable{
	int start, end;
	
	public T(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public Double call() throws Exception {
		double sum = 0;
		for(int i = start; i < end; i++){
			sum += Math.sqrt(i);
		}
		return new Double(sum);
	}
	
}
public class TestCallable {
	
	public static void test2(int end){
		double sum = 0;
		for(int i = 0; i < end; i++){
			sum += Math.sqrt(i);
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args)throws Exception{
		int middle = 100000000, end = 200000000, end2 = 300000000;
		long startTime = System.currentTimeMillis();
		
		ExecutorService exec = Executors.newCachedThreadPool();
//		Future<Double> f1 = exec.submit(new T(0, middle));
		Future<Double> f1 = exec.submit(new T(0, middle));
		Future<Double> f2 = exec.submit(new T(middle, end));
		Future<Double> f3 = exec.submit(new T(end, end2));
//		Future<Double> f1 = exec.submit(new T(0, end2/2));
//		Future<Double> f2 = exec.submit(new T(end2/2, end2));
		double sum = f1.get() + f2.get() + f3.get();
//		double sum = f1.get() + f2.get();
		System.out.println(sum);
//		test2(end2);
		
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) + "s");
		exec.shutdown();
	}
}
