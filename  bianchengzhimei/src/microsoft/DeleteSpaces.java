package microsoft;

/**
 * �����ո�ֻ�ܱ���һ����
 * ��ͷû�ո񣬽�βû�ո�
 *��/n��ǰ��û�пո�
 *
 *�����������ַ����ռ䣻
 *ֻ�ܱ���һ�飻
 *���ÿ⺯����
 *��������������int intIsSapce(char str)���ַ����ո�ʱ����0��
 *int intIsNewLine(char str)����"/n"ʱ����0��
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
