package basics;

public class KnapSack {
	/**
	 * 0/1背包问题的动态规划版本。这里实现了一个正统的使用一张二维表来记录临时结果的动态规划算法，后面还有一个改成使用一个一维数组来记录的实现。
	 * 递推式为：（1）.若i=0或j=0，那么V[i][j]=0;
	 * （2）.若j<size[i-1]，即容量j不足以放下一个i物品，那么V[i][j]=V[i-1][j];
	 * （3）.否则，V[i][j]=MAX{V[i-1][j],V[i-1][j-size[i-1]]+value[i-1]};
	 * @param size
	 * @param value
	 * @param volum
	 * @return
	 */
	public static int zeroOneKnapSack(int[] size,int[] value,int volum){
		int n=size.length;
		int[][] table=new int[n+1][volum+1];
		for(int i=1;i<=n;i++)
			for(int j=1;j<=volum;j++)
			{
				if(j<size[i-1])
					table[i][j]=table[i-1][j];
				else
				{
					int temp=table[i-1][j-size[i-1]]+value[i-1];
					table[i][j]=temp>table[i-1][j]?temp:table[i-1][j];
				}
			}	
		return table[n][volum];
	}
	/**
	 * 改进空间复杂度的版本，改到了theta(volum)。这是因为填表的时候是一行一行的填的，而且每次只用到上一行的信息，因此可在更新的时候先备份一遍信息，然后再更新。
	 * @param size
	 * @param value
	 * @param volum
	 * @return
	 */
	public static int zeroOneKnapSackImproved(int[] size,int[] value,int volum){
		int n=size.length;
		int[] table=new int[volum+1];
		for(int i=1;i<=n;i++)
		{
			int[] newTable=table.clone();//注意这里要用深度拷贝，即需要传值。
			for(int j=1;j<=volum;j++)
				if(j>=size[i-1]){
					int temp=newTable[j-size[i-1]]+value[i-1];
					table[j]=temp>newTable[j]?temp:newTable[j];
				}
		}
		return table[volum];
	}
	/**
	 * 非0/1背包的版本，即可以放多个同样物品的版本。这里实现的是自己写的版本，是在0/1背包的基础上改的。
	 * 具体表现在递推公式的第三种情况上：
	 * 原来是：（3）.V[i][j]=MAX{V[i-1][j],V[i-1][j-size[i-1]]+value[i-1]};
	 * 现在是：（3）.V[i][j]=MAX{V[i-1][j-k*size(i-1)]+k*value[i-1]};其中k<--0 to [j/size(i-1)],即搜索可以放置的第i种物品数量的所有情况。
	 * @param size
	 * @param value
	 * @param volum
	 * @return
	 */
	public static int knapSack(int[]size,int[]value,int volum){
		int n=size.length;
		int[][]table=new int[n+1][volum+1];
		for(int i=1;i<=n;i++)
			for(int j=1;j<=volum;j++)
			{
				if(j<size[i-1])
					table[i][j]=table[i-1][j];
				else{
					int num=j/size[i-1];
					for(int k=0;k<=num;k++){
						int temp=table[i-1][j-k*size[i-1]]+k*value[i-1];
						if(table[i][j]<temp)
							table[i][j]=temp;
					}
				}
			}
		return table[n][volum];
	}
	public static void main(String[]args){
		int volum=9;
		int[] size={2,3,4,5};
		int[] value={3,4,5,7};
		System.out.println(zeroOneKnapSack(size,value,volum));
		System.out.println(zeroOneKnapSackImproved(size,value,volum));
		System.out.println(knapSack(size,value,volum));
	}
}
