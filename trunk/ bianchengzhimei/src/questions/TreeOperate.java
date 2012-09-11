package questions;

import java.util.Stack;

public class TreeOperate {
	public BinaryTree<Integer> bt;
	/**
	 *                          8
	 *                         / \
	 *                        5  15
	 *                       / \
	 *                      2  7
	 */
	{
		bt = new BinaryTree<Integer>(8);
		bt.addToLeft(new BinaryTree<Integer>(5));
		bt.addToRight(new BinaryTree<Integer>(15));
		BinaryTree bt2 = bt.leftChild;
		bt2.addToLeft(new BinaryTree<Integer>(2));
		bt2.addToRight(new BinaryTree<Integer>(7));
//		bt2 = bt2.leftChild;
//		bt2.addToLeft(new BinaryTree<Integer>(1));
	}
	
	public static void preorder(BinaryTree b){
		if(b != null){
			System.out.println(b.node);
			preorder(b.leftChild);
			preorder(b.rightChild);
		}
	}
	
	
	public static void middleorder(BinaryTree b){
		if(b != null){
			middleorder(b.leftChild);
			System.out.println(b.node);
			middleorder(b.rightChild);
		}
	}
	
	/**
	 * 一直往左走，走到空的时候，回退一步，就是要输出的点。打印之后，将该点弹出，并将其右孩子压栈，然后继续算法。
	 * @param b
	 */
	public static void middleorder_no_recursion(BinaryTree b){
		Stack<BinaryTree> s = new Stack<BinaryTree>();
		s.add(b);
		while(!s.isEmpty()){
			BinaryTree bt = s.peek();
			while(bt != null){
				bt = bt.leftChild;
				s.add(bt);//这两步的顺序不要弄反
			}
			s.pop();
			if(! s.isEmpty())
			{
				bt = s.pop();
				System.out.println(bt.node);
				s.add(bt.rightChild);
			}
		}
	}
	
	/**
	 * 前序与中序的唯一不同就是输出语句的位置不同，前序的栈中存放的都是输出过的节点，而中序的栈里都是尚未输出的节点。
	 * @param b
	 */
	public static void preorder_no_recursion(BinaryTree b){
		if(b != null){
			Stack<BinaryTree> s = new Stack<BinaryTree>();
			s.add(b);
//			System.out.println(b.node);
			while(!s.isEmpty()){
				BinaryTree bt = s.peek();
				while(bt != null){
					System.out.println(bt.node);
					bt = bt.leftChild;
					s.add(bt);
				}
				s.pop();
				if(! s.isEmpty())
				{
					bt = s.pop();
//					System.out.println(bt.node);
					s.add(bt.rightChild);
				}
			}
		}
	}
	
	
//	public Integer getCoAncestor(Integer i1, Integer i2){
//		
//	}
	
	public static void main(String[] args){
		TreeOperate to = new TreeOperate();
//		to.preorder(to.bt);
//		middleorder(to.bt);
//		middleorder_no_recursion(to.bt);
		preorder_no_recursion(to.bt);
	}
	
}
