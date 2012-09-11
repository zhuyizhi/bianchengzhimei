package graph.base;

public class BasicVexNode<T> extends VexNode<T> {
	public BasicVexNode(long id, T obj, VexNodeInfo info) {
		super(id, obj, info);
	}
	@Override
	public void update(Object obj, VexNodeInfo info) {
		// TODO Auto-generated method stub
	}
	@Override
	public String toString() {
		return "BasicVexNode [id=" + id + ", obj=" + obj + ", info=" + info
//				+ ", firstInArcNode=" + firstInArcNode + ", firstOutArcNode="
//				+ firstOutArcNode 
				+ "]";
	}

	
}
