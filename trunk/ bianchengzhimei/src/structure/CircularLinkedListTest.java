package structure;

public class CircularLinkedListTest {
/**
 * ��֪n���ˣ��Ա��1��2��3��...��n�ֱ��ʾ��Χ����һ��Բ����Χ���ӱ��Ϊk���˿�ʼ������
 * ����m���Ǹ��˳��У�������һ�����ִ�k��ʼ����������m���Ǹ��˳��У������ظ���ȥ��
 * ֱ��Բ������ȫ�����С�	
 */
	public static void countRoundTable(CircularList<Integer> start,
			int n, int m, int k){
		int step = k;
		CircularList<Integer> first = start;
		while(--step > 0)
			first = first.next;
		
		while(first != null){
//			int count = k;
			int count = 0;
//			if(first.next == null || first.equals(first.next)){
//				System.out.println(first);
//				break;
//			}
			while(++count < m)
				first = first.next;
			if(first.next == null || first.equals(first.next)){
				System.out.println(first);
				break;
			}
			CircularList<Integer> toDelete = first.next;
			first.next = toDelete.next;
			System.out.print(toDelete +"-->");
//			first = first.next;
		}
	}
	
	public static void main(String[] args){
		CircularList<Integer> root = new CircularList<Integer>(1, null);
		int n = 29;
		CircularList<Integer> current = root;
		for(int i = 2; i <= n; i++){
			current.next = new CircularList<Integer>(i, null);
			current = current.next;
		}
		current.next = root;
		String s = "haa";
		s.indexOf("ha");
		countRoundTable(root, 29, 6, 3);
	}
}

class CircularList<T>{
	T val;
	CircularList<T> next;
	public CircularList(T val, CircularList next){
		this.val = val;
		this.next = next;
	}
	public void setNext(CircularList next){
		this.next = next;
	}
	public String toString(){
		return val.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result + ((val == null) ? 0 : val.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(((CircularList<T>)obj).val.equals(val))
			return true;
		else
			return false;
	}
	
}