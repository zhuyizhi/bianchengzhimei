package graph.base;

public class LongPair {
	private long headId;
	private long tailId;
	
	public long getHeadId() {
		return headId;
	}

	public void setHeadId(long headId) {
		this.headId = headId;
	}

	public long getTailId() {
		return tailId;
	}

	public void setTailId(long tailId) {
		this.tailId = tailId;
	}

	public LongPair(long headId, long tailId){
		this.headId = headId;
		this.tailId = tailId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (headId ^ (headId >>> 32));
		result = prime * result + (int) (tailId ^ (tailId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LongPair other = (LongPair) obj;
		if (headId != other.headId)
			return false;
		if (tailId != other.tailId)
			return false;
		return true;
	}
}
