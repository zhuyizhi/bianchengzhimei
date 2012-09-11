package graph.base;

public class BasicArcNode extends ArcNode {

	public BasicArcNode(long tailVexId, long headVexId, ArcNode nextHeadLink,
			ArcNode nextTailLink, ArcNodeInfo info) {
		super(tailVexId, headVexId, nextHeadLink, nextTailLink, info);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BasicArcNode [tailVexId=" + tailVexId + ", headVexId="
				+ headVexId  +  ", info=" + info + "]";
	}

	@Override
	public void update(ArcNodeInfo info) {
		// TODO Auto-generated method stub
		this.info.update(info);
	}
	
	

}
