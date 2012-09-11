package basics;

public class KnapSack {
	/**
	 * 0/1��������Ķ�̬�滮�汾������ʵ����һ����ͳ��ʹ��һ�Ŷ�ά������¼��ʱ����Ķ�̬�滮�㷨�����滹��һ���ĳ�ʹ��һ��һά��������¼��ʵ�֡�
	 * ����ʽΪ����1��.��i=0��j=0����ôV[i][j]=0;
	 * ��2��.��j<size[i-1]��������j�����Է���һ��i��Ʒ����ôV[i][j]=V[i-1][j];
	 * ��3��.����V[i][j]=MAX{V[i-1][j],V[i-1][j-size[i-1]]+value[i-1]};
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
	 * �Ľ��ռ临�Ӷȵİ汾���ĵ���theta(volum)��������Ϊ����ʱ����һ��һ�е���ģ�����ÿ��ֻ�õ���һ�е���Ϣ����˿��ڸ��µ�ʱ���ȱ���һ����Ϣ��Ȼ���ٸ��¡�
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
			int[] newTable=table.clone();//ע������Ҫ����ȿ���������Ҫ��ֵ��
			for(int j=1;j<=volum;j++)
				if(j>=size[i-1]){
					int temp=newTable[j-size[i-1]]+value[i-1];
					table[j]=temp>newTable[j]?temp:newTable[j];
				}
		}
		return table[volum];
	}
	/**
	 * ��0/1�����İ汾�������ԷŶ��ͬ����Ʒ�İ汾������ʵ�ֵ����Լ�д�İ汾������0/1�����Ļ����ϸĵġ�
	 * ��������ڵ��ƹ�ʽ�ĵ���������ϣ�
	 * ԭ���ǣ���3��.V[i][j]=MAX{V[i-1][j],V[i-1][j-size[i-1]]+value[i-1]};
	 * �����ǣ���3��.V[i][j]=MAX{V[i-1][j-k*size(i-1)]+k*value[i-1]};����k<--0 to [j/size(i-1)],���������Է��õĵ�i����Ʒ���������������
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
