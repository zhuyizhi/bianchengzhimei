package graph.base;

import java.util.HashMap;

public class OrthogonalGraph<T> extends Graph<T>{
	public HashMap<Long, VexNode<T>> id2VexMap;
	public HashMap<T, Long> obj2IdMap;
	public HashMap<LongPair, ArcNode> arcMap;
	long idCounter;
	public long nextId(){
		if(idCounter < Long.MAX_VALUE)
			return idCounter++;
		else
			System.err.println("Node id exceed MAX_VALUE !");
		return -1;
	}
	
	public OrthogonalGraph(){
		id2VexMap = new HashMap<Long, VexNode<T>>();
		obj2IdMap = new HashMap<T, Long>();
		arcMap = new HashMap<LongPair, ArcNode>();
		idCounter = 0;
	}
	
	
	public void insertVex(T obj, VexNodeInfo info){
		if(obj2IdMap.containsKey(obj)){// if this is an old object
			long id = obj2IdMap.get(obj);
			VexNode<T> vexNode = id2VexMap.get(id);
			vexNode.info.update(info);
		}else{// this is a new object
			long id = nextId();
			VexNode<T> vexNode = new BasicVexNode<T>(id, obj, info);
			this.id2VexMap.put(id, vexNode);
			this.obj2IdMap.put(obj, id);
		}
	}
	
	public boolean insertVexSimple(T obj){
		if(!obj2IdMap.containsKey(obj)){
			long id = nextId();
			VexNode<T> vexNode = new BasicVexNode<T>(id, obj, null);
			this.id2VexMap.put(id, vexNode);
			this.obj2IdMap.put(obj, id);
			return true;
		}
		return false;
	}
	
	public void insertArc(T objFrom, T objTo, ArcNodeInfo info){
		if(!obj2IdMap.containsKey(objFrom)){
			System.out.println("need simple objFrom :" + objFrom);
			insertVexSimple(objFrom);
		}
		Long idFrom = obj2IdMap.get(objFrom);
		
		if(!obj2IdMap.containsKey(objTo)){
			System.out.println("need simple objTo :" + objTo);
			insertVexSimple(objTo);
		}
		Long idTo = obj2IdMap.get(objTo);
		
		LongPair key = new LongPair(idFrom, idTo);		
		if(this.arcMap.containsKey(key)){
			ArcNode arcNode = this.arcMap.get(key);
			arcNode.update(info);
		}else{
			VexNode<T> headNode = this.id2VexMap.get(idFrom);
			VexNode<T> tailNode = this.id2VexMap.get(idTo);
			ArcNode arcNode = new BasicArcNode(idTo, idFrom, headNode.firstHeadArcNode, tailNode.firstTailArcNode, info);
			headNode.firstHeadArcNode = arcNode;
			tailNode.firstTailArcNode = arcNode;
			this.arcMap.put(new LongPair(idFrom, idTo), arcNode);
		}
	}
	
	public void deleteArc(ArcNode aNode){
		VexNode<T> headNode = this.id2VexMap.get(aNode.getHeadVexId());
		VexNode<T> tailNode = this.id2VexMap.get(aNode.getTailVexId());
		
		ArcNode preNode = headNode.firstHeadArcNode;
		ArcNode currentNode ;
		while(preNode != null){
			currentNode = preNode.nextHeadLink;
			if(currentNode != null){
				if(currentNode.equals(aNode)){
					preNode.nextHeadLink = currentNode.nextHeadLink;
				}
			}else if(preNode.equals(aNode)){//arc number from 1 --> 0
				headNode.firstHeadArcNode = null;
			}
		}
		
		preNode = tailNode.firstTailArcNode;
		while(preNode != null){
			currentNode = preNode.nextTailLink;
			if(currentNode != null){
				if(currentNode.equals(aNode)){
					preNode.nextTailLink = currentNode.nextTailLink;
				}
			}else if(preNode.equals(aNode)){//arc number from 1 --> 0
				tailNode.firstTailArcNode = null;
			}
		}
	}

	public void deleteVex(T obj){
//		delete all the arcs that related with vex
		VexNode<T> vNode = obj2Vex(obj);
		ArcNode aNode = null;
		while((aNode = vNode.firstHeadArcNode) != null){
			deleteArc(aNode);
		}
		while((aNode = vNode.firstTailArcNode) != null){
			deleteArc(aNode);
		}
		
//		delete the node itself
		this.obj2IdMap.remove(obj);
		this.id2VexMap.remove(vNode.id);
	}
	
	public String toDebugString(){
		StringBuilder sb = new StringBuilder();
		sb.append("id:vex\n");
		for(Long id : this.id2VexMap.keySet()){
			sb.append(id + ":" + this.id2VexMap.get(id) + "\t");
		}
		sb.append("\n##############################################################\n" +
				"arcs:\n");
		for(Long id : this.id2VexMap.keySet()){
			VexNode<T> vNode =this.id2VexMap.get(id);
			
			sb.append("from node " + vNode + ": " );
			ArcNode aNode = vNode.firstHeadArcNode;
			while(aNode != null){
				sb.append(aNode + "\t");
				aNode = aNode.nextHeadLink;
			}
			sb.append("\n");
			
			sb.append("to node " + vNode + ": " );
			aNode = vNode.firstTailArcNode;
			while(aNode != null){
				sb.append(aNode + "\t");
				aNode = aNode.nextTailLink;
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public VexNode<T> getVexNode(T obj){
		return obj2Vex(obj);
	}
	public ArcNode getArcNode(T objFrom, T objTo){
		VexNode<T> fromNode = obj2Vex(objFrom);
		long toId = this.obj2IdMap.get(objTo);
		ArcNode aNode = fromNode.firstHeadArcNode;
		while(aNode != null){
			if(aNode.tailVexId == toId){
				return aNode;
			}
			aNode = aNode.getNextHeadLink();
		}
		return null;
	}
	
	public static void main(String[] args)throws Exception{
		OrthogonalGraph<String> g = new OrthogonalGraph<String>();
		g.insertVexSimple("node1");
		g.insertVexSimple("node2");
		g.insertVexSimple("node3");
		g.insertVexSimple("node4");
		g.insertArc("node1", "node2", null);
		g.insertArc("node3", "node1", null);
		g.insertArc("node1", "node3", null);
		System.out.println(g.toDebugString());
	}
	
	public VexNode<T> obj2Vex(T obj){
		return this.id2VexMap.get(this.obj2IdMap.get(obj));
	}
}