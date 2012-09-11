package multithread;

import java.util.concurrent.Callable;

public class MinusOne implements Callable<Integer>{
	private Integer j;
	public MinusOne(Integer j){
		this.j = j;
	}
	@Override
	public synchronized Integer call() throws Exception {
		// TODO Auto-generated method stub
		j = j - 1;
//		这里的运算一定要在return语句之前完成， 测试的时候，如果直接写 return j--;或者return j - 1;则可能运算出错
//		System.out.println(j);
		return j ;
	}
	
}
