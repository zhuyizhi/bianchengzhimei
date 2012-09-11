package basics;
/**
 * 最长公共子序列问题
 * @author ucai
 *
 */
public class LongestCommonSequence {
	public static int  LCS(String a,String b){
		final int aLen=a.length(),bLen=b.length();
		int[][] table=new int[aLen+1][bLen+1];
		for(int i=1;i<=aLen;i++)
			for(int j=1;j<=bLen;j++)
				if(a.charAt(i-1)==b.charAt(j-1))
					table[i][j]=table[i-1][j-1]+1;
				else
					table[i][j]=table[i][j-1]>table[i-1][j]? table[i][j-1]:table[i-1][j];
					
		//下面是自己添加的，用来输出最长公共子序列的程序。从table的右下角开始倒着追踪生成序列
		int i=aLen,j=bLen;
		boolean[] flags=new boolean[aLen];
		while(i>0&&j>0){
			if(a.charAt(i-1)==b.charAt(j-1)){
				flags[i-1]=true;
				i--;
				j--;
			}else{
				if(table[i][j-1]>table[i-1][j])
					j--;
				else
					i--;
			}
		}
		System.out.println("最长公共子序列如下：");
		for(i=0;i<aLen;i++){
			if(flags[i])
				System.out.print(a.charAt(i));
		}
		System.out.println();			
					
		return table[aLen][bLen];
	}
	public static void main(String[]args){
		String a="zxyxyz";
		String b="xyyzx";
		System.out.println(LCS(a,b));
	}
}
