package graph.base;

public abstract class VexNode<T> {
	long id;
	T obj;
	VexNodeInfo info;
	ArcNode firstTailArcNode;
	ArcNode firstHeadArcNode;
	
	public abstract void update(T obj, VexNodeInfo info);

	public VexNode(long id, T obj, VexNodeInfo info) {
		super();
		this.id = id;
		this.obj = obj;
		this.info = info;
		this.firstTailArcNode = null;
		this.firstHeadArcNode = null;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public VexNodeInfo getInfo() {
		return info;
	}

	public void setInfo(VexNodeInfo info) {
		this.info = info;
	}

	public ArcNode getFirstTailArcNode() {
		return firstTailArcNode;
	}

	public void setFirstTailArcNode(ArcNode firstTailArcNode) {
		this.firstTailArcNode = firstTailArcNode;
	}

	public ArcNode getFirstHeadArcNode() {
		return firstHeadArcNode;
	}

	public void setFirstHeadArcNode(ArcNode firstHeadArcNode) {
		this.firstHeadArcNode = firstHeadArcNode;
	}
	
}
