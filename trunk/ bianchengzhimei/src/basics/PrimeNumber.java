package basics;

import java.util.HashSet;
/**
 * �����������Եķ����������ص��ĵ���ڱʼ�--��2011��5�������ĵ��������˼��ַ�����
 * �ܽ��������У���1�����ز��Եķ���������2������N���Եķ�����
 * ��2��ʹ��ɸѡ������������ʵ�ֵ�judgeByFiltering��judgeByFiltering2�ķ�����
 * ���ַ����Ǹ���С��ĳ��ֵ��������������Ҫ˼���ǣ���2��ʼ��ȥ��n���ڵ�����
 * �ܱ�����������Ȼ����ǰ�ƶ����õõ�����һ������������ɾ����������������������
 * ���ص��ĵ���˵����㷨��ʱ�临�Ӷ���O(nloglogn)��
 * ��3�����ؼ�ɸѡ������������ɸѡ�����2������n�������������Ȼ���������ز��Գ���
 * �ڽ���������û�иĽ�����ߵ���ʵ��ִ��Ч��
 * ��4���������ַ��������÷���С��������Բ��ԣ��Լ�����㷨�������ַ���û�п���
 * @author ucai
 *
 */
public class PrimeNumber {
/**
 * ��������ص��ļ����ʵ�ַ���
 * @param n
 */
	public static void judgeByFiltering(int n){
		boolean[] isNotPrime=new boolean[n+1];//java��boolean���ͳ�ʼ��Ϊfalse��
		for(int i=2;i<=n;i++)//��2��nɨ��
			if(isNotPrime[i]==false)//����ǰ��Ϊ��������Ϊ����С����������������
				for(int j=i+i;j<=n;j=j+i){
					//��ô�����������б���������������ע������Ĳ�����i�����ɨ��ĺܿ�
					isNotPrime[j]=true;
				}
		//������
		for(int i=2;i<n;i++)
			if(isNotPrime[i]==false)
				System.out.print(i+" ");
		System.out.println();
		
	}
	/**
	 * ����������Լ���ʼ��ʱ�����һ��������ķ���ʵ�ֵġ�������ҵ��ı��˵ķ�����
	 * ��ͬ�ǣ������¼��Ŀǰ����û���гɺ���������������ɨ�赽����֮���ֹͣ�жϺ���
	 * �Ĺ����ˡ������������жϵ�ʱ��ÿһ���Ĳ���ֻ����1�ˣ�������Ҫ��ȡģ���㣬�ټ���
	 * д�ĸ�ʽ������࣬���������ˡ�
	 * @param n
	 */
	public static void judgeByFilteringDeprecate(int n){
		boolean[] isNotPrime=new boolean[n+1];//Ĭ�ϳ�ʼ��false
		int pointer=2;//��ǰ��������λ��
		int max=n;
		while(pointer<max){
			max=pointer;
			for(int i=pointer+1;i<=n;i++){
				if(isNotPrime[i]==false&&(i%pointer)!=0)
					max=i;
				else
					isNotPrime[i]=true;
			}	
			//���³���
			for(int i=pointer+1;i<=n;i++){
				if(isNotPrime[i]==false)
				{
					pointer=i;
					break;
				}
			}
		}
		//������
		for(int i=2;i<n;i++)
			if(isNotPrime[i]==false)
				System.out.print(i+" ");
		System.out.println();
	}
	public static void main(String[]args){
		judgeByFiltering(500);
		judgeByFilteringDeprecate(500);
	}
}
