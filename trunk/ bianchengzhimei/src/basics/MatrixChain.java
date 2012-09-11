package basics;
/**
 * 矩阵链乘问题。使用动态规划算法求解。使用一个表记录各个子矩阵串的最小消耗，然后按照对角线填表.
 * 时间复杂度为O(n^3)，空间复杂度O(n^2)
 * @author ucai
 *
 */
public class MatrixChain {
	public static int getCost(int[] matrixes){
		final int matrixNum=matrixes.length-1;
		int[][] table=new int[matrixNum][matrixNum];
		
		for(int d=1;d<matrixNum;d++){//扫描各个对角线，从主对角线开始填充，即从d(1)-->d(matrixNum-1)。因为d(0)上的元素都是0。
			for(int i=0;i<matrixNum-d;i++){//填充对角线d(i)上的元素。对角线d(i)上的元素从table[0][i+1]开始，到table[matrixNum-i][matrixNum]。这里i控制行，j控制列
				int j=i+d;
				table[i][j]=Integer.MAX_VALUE;
				for(int k=i+1;k<=j;k++){//填充table[i][j]需要使用table[i][i]-->table[i][j-1] 和 table[i+1][j]-->table[j][j]。这里k记录的其实是从第几个矩阵处将连乘断开
					//由于使用数组存储的矩阵维数的关系，所以k要从i+1到j。
					int temp=table[i][k-1]+table[k][j]+matrixes[i]*matrixes[k]*matrixes[j+1];
					if(temp<table[i][j])
						table[i][j]=temp;
				}
			}
		}
		for(int i=0;i<matrixNum;i++){
			for(int j=0;j<matrixNum;j++)
				System.out.print(table[i][j]+" ");
			System.out.println();
		}
		return table[0][matrixNum-1];
	}
	
	public static void main(String[]args){
		int[] matrixes={5,10,4,6,10,2};
		System.out.println(getCost(matrixes));
	}
}
