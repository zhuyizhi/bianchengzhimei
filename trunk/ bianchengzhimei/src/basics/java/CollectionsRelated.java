package basics.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Random;

public class CollectionsRelated {
	
	public static void test(){
		HashSet<Integer> set = new HashSet<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		Random r = new Random();
		for(int i = 0; i < 1000; i++){
			set.add(r.nextInt(3000));
		}
		Entry[] et = new Entry[10];
		
		Comparable[] ct = new Comparable[10];
		
		System.out.println("this is pause");
		System.out.println(1 & 3);
	}
	
	public static void main(String[] args)throws Exception{
		test();
	}
}
