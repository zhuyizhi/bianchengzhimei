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
//		���������һ��Ҫ��return���֮ǰ��ɣ� ���Ե�ʱ�����ֱ��д return j--;����return j - 1;������������
//		System.out.println(j);
		return j ;
	}
	
}
