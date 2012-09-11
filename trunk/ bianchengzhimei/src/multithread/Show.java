package multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Show {
	static int j = 0;
	public static void main(String[] args)throws Exception{
		int j = 0;
		ExecutorService es = Executors.newCachedThreadPool();
		AddOne ao = new AddOne(j);
		j = es.submit(ao).get();
		System.out.println(j);
		AddOne ao2 = new AddOne(j);
		j = es.submit(ao2).get();
		System.out.println(j);
		MinusOne mo = new MinusOne(j);
		j = es.submit(mo).get();
		System.out.println(j);
		MinusOne mo2 = new MinusOne(j);
		j = es.submit(mo).get();
		System.out.println(j);
		
		
		String s = "ÖÐ¹úÈË";
		
		String s2 = new String(s.getBytes("UTF-8"), "UTF-8");
		System.out.println(s2);
	}
}

//public class Show {
//	private int j;
//
//	public static void main(String args[]) {
//		Show tt = new Show();
//		Inc inc = tt.new Inc();
//		Dec dec = tt.new Dec();
//		for (int i = 0; i < 2; i++) {
//			Thread t = new Thread(inc);
//			t.start();
//			t = new Thread(dec);
//			t.start();
//		}
//	}
//
//	private synchronized void inc() {
//		j++;
//		System.out.println(Thread.currentThread().getName() + "-inc:" + j);
//	}
//
//	private synchronized void dec() {
//		j--;
//		System.out.println(Thread.currentThread().getName() + "-dec:" + j);
//	}
//
//	class Inc implements Runnable {
//		public void run() {
//			for (int i = 0; i < 100; i++) {
//				inc();
//			}
//		}
//	}
//	
//	class Dec implements Runnable {
//		public void run() {
//			for (int i = 0; i < 100; i++) {
//				dec();
//			}
//		}
//	}
//}