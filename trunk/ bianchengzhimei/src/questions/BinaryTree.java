package questions;

public class BinaryTree<T> {
	public T node;
	public BinaryTree leftChild;
	public BinaryTree rightChild;
	
	public BinaryTree(T n){
		leftChild = null;
		rightChild = null;
		node = n;
	}
	
	public void addToLeft(BinaryTree n){
		leftChild = n;
	}
	public void addToRight(BinaryTree n){
		rightChild = n;
	}
}
