package structure;

import java.util.Stack;

public class Stacks {
	public static Integer[] arr = {6,5,7,9,1};
	public static void testMinStack(){
		StackWithMin mStack = new StackWithMin();
		for(int i = 0; i < 3; i++)
			mStack.push(arr[i]);
		System.out.println("Min = " + mStack.getMin());
		for(int i = 3; i < arr.length; i++)
			mStack.push(arr[i]);
		
		while(!mStack.isEmpty()){
			System.out.print("Min =" + mStack.getMin());
			System.out.println("\tpop " + mStack.pop());
		}
	}
	
	public static void testTwoStackQueue(){
		TwoStackQueue q = new TwoStackQueue();
		for(int i = 0; i < arr.length; i++)
			q.enqueue(arr[i]);
		while(!q.isEmpty())
			System.out.println(q.dequeue());
	}
	public static void main(String[] args)throws Exception{
//		testMinStack();
//		testTwoStackQueue();
	}
}

class TwoStackQueue{
	Stack<Integer> inputStack;
	Stack<Integer> outputStack;
	public TwoStackQueue(){
		inputStack = new Stack<Integer>();
		outputStack = new Stack<Integer>();
	}
	public void enqueue(Integer item){
		inputStack.push(item);
	}
	public Integer dequeue(){
		if(outputStack.isEmpty()){
			if(inputStack.isEmpty())
				return null;
			while(!inputStack.isEmpty()){
				Integer tmp = inputStack.pop();
				outputStack.push(tmp);
			}
		}
		return outputStack.pop();
	}
	public boolean isEmpty(){
		if(outputStack.isEmpty() && inputStack.isEmpty())
			return true;
		return false;
	}
}

class StackWithMin{
	Stack<Integer> normalStack;
	Stack<Integer> minStack;
	public StackWithMin(){
		normalStack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	
	public void push(Integer t){
		normalStack.push(t);
		if(minStack.isEmpty())
			minStack.push(t);
		else if(minStack.peek().intValue() > t.intValue())
			minStack.push(t);
	}
	
	public Integer pop(){
		Integer i = normalStack.pop();
//		if(minStack.peek().equals(i)){
		if(minStack.peek() == i){
			minStack.pop();
		}
		return i;
	}
	
	public Integer getMin(){
		return minStack.peek();
	}
	
	public boolean isEmpty(){
		return normalStack.isEmpty();
	}
}