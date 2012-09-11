package multithread;

import java.util.concurrent.Callable;

public class AddOne implements Callable<Integer> {
	public  AddOne(int j){
		this.j = j;
	}
	private int j ;
	public synchronized Integer call(){
		j = j + 1;
//		System.out.println(j);
		return j;
	}

}
