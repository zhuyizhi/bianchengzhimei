package algorithmPractice;

class Tree{
	int val;
	Tree left;
	Tree right;
	Tree(int val){
		this.val = val;
		left = null;
		right = null;
	}
}

public class PathOfTree {
	/**
	 * 从根到任一叶节点上所有节点之和为一条路径的和，判断有没有和等于key的路径，有的话输出。
	 * @param t 当前处理子树的根节点
	 * @param parentSum 从根节点到t的父亲，这一路径的和
	 * @param key 需要查询的值
	 * @return
	 */
	public static boolean findPathSum(Tree t, int parentSum, int key){
		int cSum = parentSum + t.val;
		if(cSum == key && t.left == null && t.right == null){
			System.out.println(t.val);
			return true;
		}
		
		boolean leftFlag = false, rightFlag = false;
		if(t.left != null)
			leftFlag = findPathSum(t.left, cSum, key);
		if(t.right != null)
			rightFlag = findPathSum(t.right, cSum, key);
		
		if(leftFlag)
			System.out.println(" left of " + t.val);
		if(rightFlag)
			System.out.println(" right of " + t.val);
		
		return leftFlag || rightFlag; 
	} 
	/**
	 * 		1
	 * 	 2     3
	 * 4  5      6
	 *   7
	 * 
	 */
	public static void main(String[] args){
		Tree[] ta = new Tree[7];
		for(int i = 0; i < 7; i++)
			ta[i] = new Tree(i + 1);
		ta[4].left = ta[6];
		ta[2].right = ta[5];
		ta[1].right = ta[4];
		ta[1].left = ta[3];
		ta[0].left = ta[1];
		ta[0].right = ta[2];
		
		int key = 15;
		System.out.println(findPathSum(ta[0], 0, key));
	}
}
