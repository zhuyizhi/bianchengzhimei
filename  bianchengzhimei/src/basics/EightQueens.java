package basics;

public class EightQueens {
	
	public static int getStatus(int[] chess,int step){//返回-1表示棋盘状态不满足条件，0表示部分解，1表示一个可行解。
		boolean[] flag=new boolean[8];
		for(int i=0;i<step;i++){//看有没有两个同列的
			if(flag[chess[i]])
				return -1;
			else
				flag[chess[i]]=true;
		}
		
		for(int i=0;i<step;i++){//如果有两个坐标相减（x1,y1）-(x2,y2)=(x3,y3)，使得(x3/y3)==1或-1，那么可以判定两个棋子在一条斜线上
			for(int j=i+1;j<step;j++){
				int a=j-i;
				int b=chess[j]-chess[i];
				double res=(double)a/(double)b;
				if(res==1||res==-1)
				{
//					System.out.println("两条同一斜线");
					return -1;
				}
			}
		}
		if(step<8)
			return 0;
		else
			return 1;
	}
	public static void showBoard(int[] chess){
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++)
			{
				if(chess[i]==j)
					System.out.print("1 ");
				else
					System.out.print("0 ");
			}
			System.out.println();
		}
	}
	/*注意回溯算法的写法。
	两层while循环，外层循环line变量控制搜索树的纵深层次，内层循环的chess[line]变量控制每个层次上横向的搜索。由于各个位置使用一个int变量
	即可存储，这里横向层次上的搜索使用简单的chess[line]++即可表示。
	搜索的时候：（1）若当前的解为部分解则应该向更深一层，即line++；
	（2）若当前解为错误解法，那么应该继续在本层搜索可行解，即chess[line]++。当跳出内层的while循环时，证明搜索完本层都没找到解，此时应该首先恢
	复本层的状态以便后续搜索（chess[line]=0），然后回退一层line--。
	（3）若当前解为正确解，那么直接跳出循环即可。
	这个算法写的简洁的原因是：搜索树的组织方法非常简单。使用一个一维数组，数组下标代表当前层次，数组内容代表该层的搜索结点。这样无论是每层上
	的搜索、树的层次的改变、状态的恢复都非常简单。
	*/
	public static int eightQueens(){
//		int[][] chessBoard=new int[8][8];
		int[] chess=new int[8];
		for(int i=0;i<8;i++)
			chess[i]=-1;
		int line=0;
		while(line>=0){
			while(chess[line]<7){
//				chess[line]=column;
				chess[line]++;
				int stat=getStatus(chess,line+1);
//				System.out.println("stat="+stat);
				switch(stat){
				case 1:
					System.out.println("得到一个可行解");
					showBoard(chess);
					return 1;
				case 0:
					line++;
					break;
				default:
				}
			}
			chess[line]=0;
			line--;
		}
		return 0;
	}
	
	public static void main(String[]args){
		eightQueens();
	}
}
