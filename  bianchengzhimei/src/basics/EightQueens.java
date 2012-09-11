package basics;

public class EightQueens {
	
	public static int getStatus(int[] chess,int step){//����-1��ʾ����״̬������������0��ʾ���ֽ⣬1��ʾһ�����н⡣
		boolean[] flag=new boolean[8];
		for(int i=0;i<step;i++){//����û������ͬ�е�
			if(flag[chess[i]])
				return -1;
			else
				flag[chess[i]]=true;
		}
		
		for(int i=0;i<step;i++){//������������������x1,y1��-(x2,y2)=(x3,y3)��ʹ��(x3/y3)==1��-1����ô�����ж�����������һ��б����
			for(int j=i+1;j<step;j++){
				int a=j-i;
				int b=chess[j]-chess[i];
				double res=(double)a/(double)b;
				if(res==1||res==-1)
				{
//					System.out.println("����ͬһб��");
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
	/*ע������㷨��д����
	����whileѭ�������ѭ��line���������������������Σ��ڲ�ѭ����chess[line]��������ÿ������Ϻ�������������ڸ���λ��ʹ��һ��int����
	���ɴ洢������������ϵ�����ʹ�ü򵥵�chess[line]++���ɱ�ʾ��
	������ʱ�򣺣�1������ǰ�Ľ�Ϊ���ֽ���Ӧ�������һ�㣬��line++��
	��2������ǰ��Ϊ����ⷨ����ôӦ�ü����ڱ����������н⣬��chess[line]++���������ڲ��whileѭ��ʱ��֤�������걾�㶼û�ҵ��⣬��ʱӦ�����Ȼ�
	�������״̬�Ա����������chess[line]=0����Ȼ�����һ��line--��
	��3������ǰ��Ϊ��ȷ�⣬��ôֱ������ѭ�����ɡ�
	����㷨д�ļ���ԭ���ǣ�����������֯�����ǳ��򵥡�ʹ��һ��һά���飬�����±����ǰ��Σ��������ݴ���ò��������㡣����������ÿ����
	�����������Ĳ�εĸı䡢״̬�Ļָ����ǳ��򵥡�
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
					System.out.println("�õ�һ�����н�");
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
