package google;

import java.util.LinkedList;
import java.util.List;


public class Winner {
	
	public static void calculate_result(int n, int[][] winner, int[] order, int[] result){
		List<Integer> list = new LinkedList<Integer>();
		while(true){
			boolean flag = false;
			for(int i = 0; i < n;){
				int player1 = i;
				while(player1 < n && order[player1] == -1)  player1++;
				
				int player2 = player1 + 1;
				while(player2 < n && order[player2] == -1) player2++;
				if(player2 >= n){
					list.add(player1);
					flag = true;
					break;
				}
				
				if(winner[player1][player2] == player1){
					order[player2] = -1;
					list.add(player2);
				}else{
					order[player1] = -1;
					list.add(player1);
				}
				i = player2 + 1;
			}
			if(flag) break;
		}
		int index = n-1;
		for(int i : list)
			result[index--] = i;
	}
	
	public static void test(){
		int n = 4;
		int[][] winner = {{0,1,2,3},{1,1,2,1},{2,2,2,3},{3,1,3,3}};
		int[] order = {0,1,2,3};
		int[] result = new int[n];
		calculate_result(n, winner, order, result);
		for(int i : result)
			System.out.println(i);
	}
	
	public static void main(String[] args)throws Exception{
		test();
	} 
}
