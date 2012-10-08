package algorithmPractice;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import util.Producer;

/**
 * 对链表排序
 * @author ucai
 *
 */
public class ListSort {
	
	public static List<Integer> merge(List<Integer> listA, List<Integer> listB){
		List<Integer> list = new LinkedList<Integer>();
		Iterator<Integer> iteA = listA.iterator();
		Iterator<Integer> iteB = listB.iterator();
		int a, b;
		a = iteA.next();
		b = iteB.next();
		while(true){
			if( a >= b){
				list.add(b);
				if(iteB.hasNext())
					b = iteB.next();
				else{
					b = -1;
					break;
				}
					
			}else{
				list.add(a);
				if(iteA.hasNext())
					a = iteA.next();
				else{
					a = -1;
					break;
				}
			}
		}
		if(a != -1)
			list.add(a);
		if(b != -1)
			list.add(b);
		while(iteA.hasNext())
			list.add(iteA.next());
		while(iteB.hasNext())
			list.add(iteB.next());
		return list;
	}
	
	/**
	 * 采用归并排序
	 * @param list
	 */
	public static List<Integer> mergeSortList(List<Integer> list){
		int size = list.size();
		if(size <= 1)
			return list;
		int mid = size/2;
		List<Integer> listA = list.subList(0, mid);
		List<Integer> listB = list.subList(mid, size);
		listA = mergeSortList(listA);
		listB = mergeSortList(listB);
		return merge(listA, listB);
	}
	
	public static void main(String[] args){
		List<Integer> list = new LinkedList<Integer>();
		int[] arr = Producer.getIntArray(10, 100);
//		int[] arr = {22,45,42,87};
		for(int i : arr)
			list.add(i);
		
		List<Integer> newList = mergeSortList(list);
		System.out.println("old list is:" );
		for(int i : list)
			System.out.print(i + ",");
		System.out.println();
		System.out.println("new list is:");
		for(int i : newList)
			System.out.print(i + ",");
	}
}
