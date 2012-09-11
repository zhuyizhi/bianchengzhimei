package basics;
/**
 * �����������⡣ʹ�ö�̬�滮�㷨��⡣ʹ��һ�����¼�����Ӿ��󴮵���С���ģ�Ȼ���նԽ������.
 * ʱ�临�Ӷ�ΪO(n^3)���ռ临�Ӷ�O(n^2)
 * @author ucai
 *
 */
public class MatrixChain {
	public static int getCost(int[] matrixes){
		final int matrixNum=matrixes.length-1;
		int[][] table=new int[matrixNum][matrixNum];
		
		for(int d=1;d<matrixNum;d++){//ɨ������Խ��ߣ������Խ��߿�ʼ��䣬����d(1)-->d(matrixNum-1)����Ϊd(0)�ϵ�Ԫ�ض���0��
			for(int i=0;i<matrixNum-d;i++){//���Խ���d(i)�ϵ�Ԫ�ء��Խ���d(i)�ϵ�Ԫ�ش�table[0][i+1]��ʼ����table[matrixNum-i][matrixNum]������i�����У�j������
				int j=i+d;
				table[i][j]=Integer.MAX_VALUE;
				for(int k=i+1;k<=j;k++){//���table[i][j]��Ҫʹ��table[i][i]-->table[i][j-1] �� table[i+1][j]-->table[j][j]������k��¼����ʵ�Ǵӵڼ������󴦽����˶Ͽ�
					//����ʹ������洢�ľ���ά���Ĺ�ϵ������kҪ��i+1��j��
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
