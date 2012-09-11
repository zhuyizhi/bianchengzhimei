package chapter.one;
import java.util.Random;
public class LaoBingSort {
	static int counter = 0;
	public static Integer[] getSorted_V1(Integer[] array, int bottom){
		if(bottom == 1){
			return array;
		}else{
			int maxPos = 0;
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < bottom; i++)
				if(array[i] > max)
				{
					max = array[i];
					maxPos = i;
				}
			if(maxPos == 0)
				array = reverse(array, bottom - 1);
			else if(maxPos != bottom -1)
				array = reverse(reverse(array, maxPos), bottom - 1);
			return getSorted_V1(array, bottom - 1);
		}
	}
	
	public static Integer[] reverse(Integer[] array, int index){
		if(index > 0){
			counter ++;
			Integer[] newArr = new Integer[array.length];
			for(int i = 0; i <= index; i++)
				newArr[i] = array[index - i];
			for(int i = index + 1; i < array.length; i++)
				newArr[i] = array[i];
			return newArr;
		}
		return array;
	}
	
	public static Integer[] produce(int length){
		Integer[] arr = new Integer[length];
		Random r = new Random();
		for(int i = 0; i < length; i++)
			arr[i] = r.nextInt(1000);
		return arr;
	}
	
	public static void print(Integer[] arr){
		for(Integer i : arr)
			System.out.print(i + "  ");
		System.out.println();
	}
	
	public static void main(String[] args)throws Exception{
		Integer[] array = produce(100);
		print(getSorted_V1(array, array.length));
		System.out.println("sort for " + LaoBingSort.counter + " times");
		print(getSorted_V1(array, array.length));
		System.out.println("sort for " + LaoBingSort.counter + " times");
	}
	
}
