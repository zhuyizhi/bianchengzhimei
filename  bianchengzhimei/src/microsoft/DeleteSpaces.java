package microsoft;

/**
 * 连续空格只能保留一个；
 * 开头没空格，结尾没空格；
 *“/n”前后都没有空格
 *
 *不能申请新字符串空间；
 *只能遍历一遍；
 *不用库函数；
 *可用两个函数：int intIsSapce(char str)，字符串空格时返回0；
 *int intIsNewLine(char str)，是"/n"时返回0；
 *
 * @author ucai
 *
 */
public class DeleteSpaces {
	
	public static int intIsSpace(char str){
		return str - ' ';
	}
	public static int intIsNewLine(char str){
		return str - '\n';
	}
	
	public static char[] deleteSpaces(char[] arr){
		int toInsert = 0;
		if(intIsSpace(arr[0]) == 0){
			toInsert = 1;
		}
		for(int deal = 1; deal < arr.length; deal++){
			if(intIsSpace(arr[deal]) == 0){
				while(deal + 1 < arr.length){
					deal++;
				}
				if(deal < arr.length){
					
				}
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args){
		char[] arr = {' ', 'a','b',' ', '\n', 'c', 'd'};
		deleteSpaces(arr);
	}
}
