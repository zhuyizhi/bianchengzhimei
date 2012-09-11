package graph.base;

public abstract class ArcNode {
	long tailVexId;
	long headVexId;
	ArcNode nextHeadLink;
	ArcNode nextTailLink;
	ArcNodeInfo info;
	public ArcNode(long tailVexId, long headVexId, ArcNode nextHeadLink,
			ArcNode nextTailLink, ArcNodeInfo info) {
		super();
		this.tailVexId = tailVexId;
		this.headVexId = headVexId;
		this.nextHeadLink = nextHeadLink;
		this.nextTailLink = nextTailLink;
		this.info = info;
	}
	public long getTailVexId() {
		return tailVexId;
	}
	public void setTailVexId(long tailVexId) {
		this.tailVexId = tailVexId;
	}
	public long getHeadVexId() {
		return headVexId;
	}
	public void setHeadVexId(long headVexId) {
		this.headVexId = headVexId;
	}
	public ArcNode getNextHeadLink() {
		return nextHeadLink;
	}
	public void setNextHeadLink(ArcNode nextHeadLink) {
		this.nextHeadLink = nextHeadLink;
	}
	public ArcNode getNextTailLink() {
		return nextTailLink;
	}
	public void setNextTailLink(ArcNode nextTailLink) {
		this.nextTailLink = nextTailLink;
	}
	public ArcNodeInfo getInfo() {
		return info;
	}
	public void setInfo(ArcNodeInfo info) {
		this.info = info;
	}
	
	@Override
	public String toString() {
		return "ArcNode [tailVexId=" + tailVexId + ", headVexId=" + headVexId
				+ ", info=" + info + "]";
	}
	public abstract void update(ArcNodeInfo info);
	
}
