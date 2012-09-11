package extension;

public class Factorial {
	public static int numberOfZeros(int n){
		long res=1;
		int counter=0;
		for(int i=2;i<=n;i++)
		{
			res*=i;
			if(res%10==0)
			{
				counter++;
				res/=10;
			}
		}
		return counter;
	}
	
	public static int lowestOne(int n){//��λ�ô�0��ʼ��������������1000��1�ڵ�3λ��
		//��ʼ��ʱ��д����
		long res=1;
		int counter=0;
		for(int i=2;i<=n;i++){
			res*=i;
			while(res%2==0)//���￪ʼд����if(res%2==0)�������Ľ�����Ǵ�ģ���Ϊ��4����
				//��i=2ʱִ��һ��++����ʱ��ȷ������i=4ʱ����ʵ��Ҫ��������++��������дֻ��ִ��һ��
			{
				counter++;
//				res=res/2;
				res>>=1;//Ч��������һ��
			}
		}
		return counter;
	}
	public static int lowestOne2(int n){//�����ֱ��������������������2�ĸ���
		int counter=0;
		for(int i=2;i<=n;i++){
			int temp=i;
			while(temp%2==0){
				counter++;
				temp>>=1;
			}
		}
		return counter;
	}
	
	public static void main(String[]args){
		int n=20;
		System.out.println(numberOfZeros(n));
		System.out.println(lowestOne2(10));
		System.out.println(lowestOne2(15));
		System.out.println(lowestOne2(20));
		//�õ��Ľ��Ӧ����8��11��18
	}
}
