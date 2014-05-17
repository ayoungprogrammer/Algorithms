import java.util.PriorityQueue;
import java.util.Vector;


public class Prims {

	
	public static int Prims(Vector<Vector<node>> adjList){
		int cost = 0;
		int n = adjList.size();
		PriorityQueue<node> pq = new PriorityQueue<node>();
		boolean visited[] = new boolean[n];
		for(int i=0;i<n;i++){
			visited[i] = false;
		}
		int inTree = 1;
		visited[0] = true;
		for(int i=0;i<adjList.get(0).size();i++){
			pq.add(adjList.get(0).get(i));
		}
		while(!pq.isEmpty()&&inTree<n){
			node cur = pq.poll();
			if(visited[cur.index])continue;
			inTree++;
			visited[cur.index]=true;
			cost+=cur.weight;
			for(int i=0;i<adjList.get(cur.index).size();i++){
				pq.add(adjList.get(cur.index).get(i));
			}
		}
		//Graph is not connected
		if(inTree<n)return -1;
		
		return cost;
	}
	
	public static void addEdge(int x,int y,int w,Vector<Vector<node>> adjList){
		adjList.get(x).add(new node(w,y));
		adjList.get(y).add(new node(w,x));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Vector<node>> adjList = new Vector<Vector<node>>();
		for(int i=0;i<3;i++){
			adjList.add(new Vector<node>());
		}
		addEdge(0,2,2,adjList);
		addEdge(0,1,3,adjList);
		System.out.println(Prims(adjList));
	}

}
