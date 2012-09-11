package multithread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
有四个线程1、2、3、4。线程1的功能就是输出1，线程2的功能就是输出2，以此类推.........
现在有四个文件ABCD。初始都为空。现要让四个文件呈如下格式：

A：1 2 3 4 1 2....

B：2 3 4 1 2 3....

C：3 4 1 2 3 4....

D：4 1 2 3 4 1....

请设计程序。
 * @author ucai
 *
 */

public class ThreadLoopGoogle {
	class Appender implements Runnable{
		private final int num;
		Runnable former;
		public Appender(int num, Runnable former){
			this.num = num;
			this.former = former;
		}
		public void setFormer(Runnable former){
			this.former = former;
		}
		boolean flag = false;
		@Override
		public void run() {
			while(true){
				System.out.println("in thread " + num + ", name=" + this.toString());
				if(former != null){
					System.out.println("thread " + num + " is waiting on former :" + former.toString());
					synchronized(former){
						try {
							former.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				synchronized(this){
					if(!flag){
						list.add(new StringBuilder());
						System.out.println("in thread " + num + " add a sb, list.size = " + list.size());
						flag = true;
						if(num == 1)
							this.former = last;
					}
					for(StringBuilder sb : list){
						sb.append(num);
					}
//					try {
//						Thread.sleep(500);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					this.notifyAll();
					
				}

				System.out.println("thread " + this.toString() + " just notifyAll");
			}
		}
	}
	List<StringBuilder> list = Collections.synchronizedList(new ArrayList<StringBuilder>());
	Runnable last;
	public static void main(String[] args)throws Exception{
		ThreadLoopGoogle loop = new ThreadLoopGoogle();
		Runnable one = loop.new Appender(1, null);
		Runnable two = loop.new Appender(2, one);
//		Runnable three = loop.new Appender(3, two);
//		Runnable four = loop.new Appender(4, three);
//		loop.last = four;
		loop.last = two;
		
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(one);
//		Thread.sleep(500);
		service.execute(two);
//		service.execute(three);
//		service.execute(four);
		
		while(true){
			Thread.sleep(1000);
			for(StringBuilder sb : loop.list){
				System.out.print(sb.toString() + "\t");
			}
			System.out.println();
		}
	}
}
