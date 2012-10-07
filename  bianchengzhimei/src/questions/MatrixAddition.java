package questions;

import java.util.Arrays;
import java.util.Random;

import util.Producer;

public class MatrixAddition {
	
	public static int[] randNeighbour(int x1, int y1, int size){
		Random r = new Random();
		switch(r.nextInt(4)){
		case 0://up
			if(y1 > 0)
				y1--;
			else
				y1++;
			break;
		case 1://right
			if(x1 < size - 1)
				x1++;
			else
				x1--;
			break;
		case 2://down
			if(y1 < size - 1)
				y1++;
			else
				y1--;
			break;
		case 3://left
			if(x1 > 0)
				x1--;
			else
				x1++;
			break;
			default:
				System.err.println("error generating");
		}
		return new int[]{x1,y1};
	}
	
	public static int[][] rightMatrix(int size, int step){
		int[][] matrix = new int[size][size];
		for(int[] arr : matrix)
			Arrays.fill(arr, 0);
		
		Random r = new Random();
		while(step-- > 0){
			int x = r.nextInt(size);
			int y = r.nextInt(size);
			
			int x1 = x;
			int y1 = y;
			switch(r.nextInt(4)){
			case 0://up
				if(y1 > 0)
					y1--;
				else
					y1++;
				break;
			case 1://right
				if(x1 < size - 1)
					x1++;
				else
					x1--;
				break;
			case 2://down
				if(y1 < size - 1)
					y1++;
				else
					y1--;
				break;
			case 3://left
				if(x1 > 0)
					x1--;
				else
					x1++;
				break;
				default:
					System.err.println("error generating");
			}
			matrix[x][y]++;
			matrix[x1][y1]++;
		}
		return matrix;
	}

	public static int dist(int x, int y, int x1, int y1){
		return (x - x1)*(x - x1) + (y - y1)*(y - y1);
	}
	public static int[][] wrongMatrix(int size, int step, int step2){
		int[][] matrix = rightMatrix(size, step);
		Random r = new Random();
		while(step2 -- > 0){
			int x = r.nextInt(size);
			int y = r.nextInt(size);
			int x1 = x;
			int y1 = y;
			while( dist(x,y,x1,y1) <= 1 ){
				x1 = r.nextInt(size);
				y1 = r.nextInt(size);
			}
			matrix[x][y]++;
			matrix[x1][y1]++;
		}
		return matrix;
	}
	public static boolean judge(int[][] matrix){
		System.out.println("###########################");
		for(int[] arr : matrix)
			Producer.printIntArr(arr);
		System.out.println("###########################");
		int count = 0;
		int max = Integer.MIN_VALUE;
		int size = matrix.length;
		int m_x = -1, m_y = -1;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(matrix[i][j] != 0)
					count++;
				if(matrix[i][j] != 0 && matrix[i][j] > max){
					max = matrix[i][j];
					m_x = i;
					m_y = j;
				}
			}
		}
		if(count == 0)
			return true;
		else if(count == 1)
			return false;
		else{
			if(m_x >= 0 && m_y >= 0){
				int aMax = Integer.MIN_VALUE;
				int a_x = -1, a_y = -1;
				if(m_y > 0)//up
					if(matrix[m_x][m_y - 1] != 0 && matrix[m_x][m_y - 1] > aMax){
						aMax = matrix[m_x][m_y - 1]; a_x = m_x; a_y = m_y - 1;
					}
				
				if(m_x < size - 1)//right
					if(matrix[m_x + 1][m_y] != 0 && matrix[m_x + 1][m_y] > aMax){
						aMax = matrix[m_x + 1][m_y]; a_x = m_x + 1; a_y = m_y;
					}
				
				if(m_y < size - 1)//down
					if(matrix[m_x][m_y + 1] != 0 && matrix[m_x][m_y + 1] > aMax){
						aMax = matrix[m_x][m_y + 1]; a_x = m_x; a_y = m_y + 1;
					}
				
				if(m_x > 0)//left
					if(matrix[m_x - 1][m_y] != 0 && matrix[m_x - 1][m_y] > aMax){
						aMax = matrix[m_x - 1][m_y]; a_x = m_x - 1; a_y = m_y;
					}
				
				if(a_x < 0 || a_y < 0){
					int[] nb = randNeighbour(m_x, m_y, size);
					a_x = nb[0];
					a_y = nb[1];
				}
				if(matrix[a_x][a_y] != 0){
					matrix[m_x][m_y] -= matrix[a_x][a_y];
					matrix[a_x][a_y] = 0;
				}else{
					matrix[a_x][a_y] -= matrix[m_x][m_y];
					matrix[m_x][m_y] = 0;
				}

				return judge(matrix);
			}else
				System.err.println("error in judge");
		}
		return false;
	}
	
	public static boolean batchTest(int times, int size, int step){
		while(times -- > 0){
			int[][] matrix = rightMatrix(size, step);
			if(!judge(matrix))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args)throws Exception{
//		int[][] matrix = wrongMatrix(3, 15, 6);
		int[][] matrix = {{1,0,0},{0,0,1},{0,0,0}};
		for(int[] arr : matrix)
			Producer.printIntArr(arr);
		System.out.println(judge(matrix));
//		boolean flag = batchTest(100, 5, 100);
//		System.out.println(flag);
	}
}
