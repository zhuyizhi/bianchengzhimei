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
	
	public static int lowestOne(int n){//设位置从0开始计数，即二进制1000，1在第3位。
		//开始的时候写错了
		long res=1;
		int counter=0;
		for(int i=2;i<=n;i++){
			res*=i;
			while(res%2==0)//这里开始写的是if(res%2==0)。这样的结果就是错的，因为如4！，
				//当i=2时执行一次++，此时正确，但当i=4时，事实上要进行两次++，但这样写只会执行一次
			{
				counter++;
//				res=res/2;
				res>>=1;//效果与上面一样
			}
		}
		return counter;
	}
	public static int lowestOne2(int n){//这个是直接算各个数字里面的因子2的个数
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
		//得到的结果应该是8，11，18
	}
}
