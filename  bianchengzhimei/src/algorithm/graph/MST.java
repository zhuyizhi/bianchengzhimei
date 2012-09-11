package algorithm.graph;

import java.util.Arrays;
import java.util.Random;

import graph.base.ArcNode;
import graph.base.ArcNodeInfo;
import graph.base.Graph;
import graph.base.OrthogonalGraph;
import graph.base.VexNode;

public class MST {
	/**
	 * prime算法：
	 * 
	 * 一 算法分析
	 * 所有节点分为两部分：已经在树中的A，还未在树中的V - A。
	 * 
	 * 1. 初始化时，将startNode移入A中，A到所有V-A中节点的距离初始化为startNode到各个节点的距离。
	 * 
	 * 2. while |V-A| > 0
	 * 		取A到V-A中所有节点中距离最小的一个边，将另一端节点v'移入A中（此时可对边进行操作，例如打印出来）
	 * 		利用v'的节点更新A到V-A的距离
	 * 
	 * 二 实现分析
	 * 
	 * 需要用到的重要数据结构，设点数为|V|，边数为|E|：
	 * 1. 表示一个节点是否在A中，即需要一个|V|大小的flag数组。
	 * 2. 维护当前A到V-A中各个节点的距离。为简便起见，同样使用|V|大小的flag数组代替。
	 * 3. 与2相对应，需要标志一个节点加入A是由那个节点引入的，为之后组建MST记录数据。
	 *    这里简便起见，以打印到控制台代替。
	 * 
	 * 
	 */
	public static void prime(OrthogonalGraph<String> g, String startNode){
		int vexNum = g.id2VexMap.size();
		boolean[] A = new boolean[vexNum];
		double[] dist = new double[vexNum];
		Arrays.fill(A, false);
		Arrays.fill(dist, Double.MAX_VALUE);
//		初始化
		VexNode<String> start = g.getVexNode(startNode);
		int index = (int)start.getId();//这里默认了id = index，只是为了方便，但一旦图进行了类似删除的操作，那么将导致错误。
		A[index] = true;
		dist[index] = 0;
		ArcNode arc = start.getFirstHeadArcNode();
		while(arc != null){
			int tailId = (int)arc.getTailVexId();
			if(A[tailId] == false){
				double weight = ((StringArcNodeInfo)arc.getInfo()).weight;
				if(weight < dist[tailId])
					dist[tailId] = weight;
			}
			arc = arc.getNextHeadLink();
		}
		
		for(int count = vexNum - 1; count > 0; count--){
			int min = -1;
			double minW = Double.MAX_VALUE;
			for(int i = 0; i < vexNum; i++){
				if(A[i] == false && dist[i] < minW){
					min = i;
					minW = dist[i];
				}
			}
			
			if(min == -1)
				System.out.println("不是连通图");
			A[min] = true;
			dist[min] = 0;
			System.out.println("node" + min);
			VexNode<String> tailNode = g.getVexNode("node" + min);
			arc = tailNode.getFirstHeadArcNode();
			while(arc != null){
				int tailId = (int)arc.getTailVexId();
				if(A[tailId] == false){
					double weight = ((StringArcNodeInfo)arc.getInfo()).weight;
					if(weight < dist[tailId])
						dist[tailId] = weight;
				}
				arc = arc.getNextHeadLink();
			}
		}
	}
	
	public static OrthogonalGraph<String> getGraph(int arcNum, int vexNum, int weightThreshold){
		OrthogonalGraph<String> g = new OrthogonalGraph<String>();
		Random r = new Random();
		for(int i = 0; i < vexNum; i++){
			g.insertVexSimple("node" + i);
		}
		for(int i = 0; i < arcNum; i++){
			while(true){
				int startNode = r.nextInt(vexNum);
				int endNode = r.nextInt(vexNum);
				if(startNode == endNode)
					continue;
				if(g.getArcNode("node" + startNode, "node" + endNode) != null)
					continue;
				StringArcNodeInfo info = new StringArcNodeInfo(r.nextInt(weightThreshold));
				g.insertArc("node" + startNode, "node" + endNode, info);
				g.insertArc("node" + endNode, "node" + startNode, info);
				break;
			}
		}
		return g;
	}
	
	public static void main(String[] args){
		int arcNum = 3 * 2;
		int vexNum = 5;
		int weightThreshold = 30;
		
		OrthogonalGraph<String> g = getGraph(arcNum, vexNum, weightThreshold); 
		System.out.println(g.toDebugString());
		
		System.out.println("####################################");
		prime(g, "node0");
		
	}
}

class StringArcNodeInfo extends ArcNodeInfo {
	double weight;

	@Override
	public void update(ArcNodeInfo info) {
		weight += ((StringArcNodeInfo)info).weight;
	}
	 
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public StringArcNodeInfo(double w){
		this.weight = w;
	}

	@Override
	public String toString() {
		return "StringArcNodeInfo [weight=" + weight + "]";
	}
}
