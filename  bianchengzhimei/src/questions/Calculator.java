package questions;

import java.util.HashSet;
import java.util.Stack;



/**
 * 
 * 
 * @author ucai
 *
 */
public class Calculator {
	static final String[] symbols = {
			"+",
			"-",
			"*",
			"/",
			"(",
			")"
	};
	
	static HashSet<String> set = new HashSet<String>();
	static{
		for(String s : symbols)
			set.add(s);
	}
	
	static int[][] matrix = {
		{0,0,1,1,1,0},
		{0,0,1,1,1,0},
		{0,0,0,0,1,0},
		{0,0,0,0,1,0},
		{1,1,1,1,1,0}
	};
	Stack<Double> numberStack = new Stack<Double>();
	Stack<String> symbolStack = new Stack<String>();
	
	public static int getIndex(String symbol){
		for(int i = 0; i < symbols.length; i++){
			if(symbols[i].equals(symbol))
				return i;
		}
		return -1;
	}
	
	public double getResult(String expression){
		double result = 0;
		String[] arr = expression.split(" ");
		for(int i = 0; i < arr.length; i++){
			String token = arr[i];
			int type = getType(token);
			
			switch(type){
			case 0: 
				numberStack.add(Double.parseDouble(token));
				break;
			case 1:
				deal(token);
				break;
			}
		}
		
		if(!symbolStack.isEmpty()){//注意这里，接收输入完成之后，需要将还在堆栈里的结果算一遍。
			deal(")");
		}
		
		if(numberStack.size() != 1)
			System.out.println("wrong " + numberStack.size());
		else
			result = numberStack.pop();
		return result;
	}
	
	public void deal(String token){
		if(symbolStack.isEmpty())
			symbolStack.add(token);
		else{
			String sToken = symbolStack.peek();
			
			int index1 = getIndex(token);
			int index2 = getIndex(sToken);
			if(matrix[index2][index1] == 0){
				if(sToken.equals("("))
					symbolStack.pop();
				else{
					double number1 = numberStack.pop();
					double number2 = numberStack.pop();
					
					switch(getIndex(sToken)){
					case 0:
						numberStack.push(number1 + number2);
						break;
					case 1:
						numberStack.push(number2 - number1);
						break;
					case 2:
						numberStack.push(number1 * number2);
						break;
					case 3:
						numberStack.push(number2 / number1);
						break;
					}
					symbolStack.pop();
					deal(token);
				}
			}else{
				symbolStack.add(token);
			}
		}
	}
	
//	symbol is 1, number is 0
	public static int getType(String token){
		if(set.contains(token))
			return 1;
		return 0;
	}
	
	public static void main(String[] args){
		String expression = "1 + 2 * ( 5 / 3 )";
		Calculator c = new Calculator();
		System.out.println(c.getResult(expression));
	}
}
