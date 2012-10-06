package algorithmPractice;
/**
 * 顺时针打印一个矩阵
 * 
 * @author ucai
 *
 */
public class ClockwisePrintMatrix {
	
	public static int printMatrixClockwise(int[][] matrix){
		int hStart = 0, hEnd = matrix.length;
		if(hEnd - hStart < 1)
			return -1;
		int wStart = 0, wEnd = matrix[0].length;
		
		while(true){
//			left -> right
			for(int i = wStart; i < wEnd; i++ )
				System.out.print(matrix[hStart][i] + ",");
			hStart++;
			if(hStart >= hEnd)
				return 1;
			
//			high -> low
			for(int i = hStart; i < hEnd; i++)
				System.out.print(matrix[i][wEnd - 1] + ",");
			wEnd--;
			if(wStart >= wEnd)
				return 1;
			
//			right -> left
			for(int i = wEnd - 1; i >= wStart; i-- )
				System.out.print(matrix[hEnd - 1][i] + ",");
			hEnd--;
			if(hStart >= hEnd)
				return 1;
			
//			low -> high
			for(int i = hEnd - 1; i >= hStart; i--)
				System.out.print(matrix[i][wStart] + ",");
			wStart++;
			if(wStart >= wEnd)
				return 1;
		}
	}
	
	public static void main(String[] args)throws Exception{
		int[][] matrix = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		printMatrixClockwise(matrix);
	}
}
