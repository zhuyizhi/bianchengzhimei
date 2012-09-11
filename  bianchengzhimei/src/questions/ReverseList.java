package questions;

import java.util.LinkedList;

public class ReverseList {
	MyList list = new MyList();
	
	ReverseList(){
		MyList current = list;
		for(int i = 0; i < 3; i++){
			current.next = new MyList();
			current = current.next;
		}
	}
	
	void print(){
		MyList ml = list;
		while(ml != null){
			System.out.println(ml.id);
			ml = ml.next;
		}
	}
	
	void reverse(){
		if(list.next != null){
			MyList m1 = null;
			MyList m2 = list;
			MyList m3 = m2.next;
			
			while(m2 != null){
				m2.next = m1;
				if(m3 != null){
					m1 = m2;
					m2 = m3;
					m3 = m3.next;
				}else{
//					list.next = null;
					list = m2;
					break;
				}
			}
		}
	}
	
	public static void main(String[] args){
		ReverseList rl = new ReverseList();
		rl.print();
		rl.reverse();
		rl.print();
	}
}


class MyList{
	static int count = 0;
	int id;
	MyList next;
	MyList(){
		id = count;
		count++;
		next = null;
	}
}