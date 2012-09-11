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
	 * prime�㷨��
	 * 
	 * һ �㷨����
	 * ���нڵ��Ϊ�����֣��Ѿ������е�A����δ�����е�V - A��
	 * 
	 * 1. ��ʼ��ʱ����startNode����A�У�A������V-A�нڵ�ľ����ʼ��ΪstartNode�������ڵ�ľ��롣
	 * 
	 * 2. while |V-A| > 0
	 * 		ȡA��V-A�����нڵ��о�����С��һ���ߣ�����һ�˽ڵ�v'����A�У���ʱ�ɶԱ߽��в����������ӡ������
	 * 		����v'�Ľڵ����A��V-A�ľ���
	 * 
	 * �� ʵ�ַ���
	 * 
	 * ��Ҫ�õ�����Ҫ���ݽṹ�������Ϊ|V|������Ϊ|E|��
	 * 1. ��ʾһ���ڵ��Ƿ���A�У�����Ҫһ��|V|��С��flag���顣
	 * 2. ά����ǰA��V-A�и����ڵ�ľ��롣Ϊ��������ͬ��ʹ��|V|��С��flag������档
	 * 3. ��2���Ӧ����Ҫ��־һ���ڵ����A�����Ǹ��ڵ�����ģ�Ϊ֮���齨MST��¼���ݡ�
	 *    ������������Դ�ӡ������̨���档
	 * 
	 * 
	 */
	public static void prime(OrthogonalGraph<String> g, String startNode){
		int vexNum = g.id2VexMap.size();
		boolean[] A = new boolean[vexNum];
		double[] dist = new double[vexNum];
		Arrays.fill(A, false);
		Arrays.fill(dist, Double.MAX_VALUE);
//		��ʼ��
		VexNode<String> start = g.getVexNode(startNode);
		int index = (int)start.getId();//����Ĭ����id = index��ֻ��Ϊ�˷��㣬��һ��ͼ����������ɾ���Ĳ�������ô�����´���
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
				System.out.println("������ͨͼ");
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
