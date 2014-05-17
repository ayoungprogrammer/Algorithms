import java.util.PriorityQueue;
import java.util.Vector;


public class Kruskal {
	
	public static int getParent(int parents[],int x){
		if(parents[x]==x)return x;
		parents[x] = getParent(parents,parents[x]);
		return parents[x];
	}
	public static int Kruskal(Vector<Vector<edge>> adjList){
		int n = adjList.size();
		int parents[] = new int[n];
		for(int i=0;i<n;i++)parents[i] = i;
		int sum = 0;
		
		PriorityQueue<edge> edges = new PriorityQueue<edge>();
		
		for(int i=0;i<n;i++){
			for(int j=0;j<adjList.get(i).size();j++){
				edges.add(adjList.get(i).get(j));
			}
		}
		
		while(!edges.isEmpty()){
			edge e = edges.poll();
			if(getParent(parents,e.source)!=getParent(parents,e.dest)){
				parents[e.source] = getParent(parents,e.dest);
				sum+=e.weight;
			}
		}
		
		return sum;
	}
	
	public static void addEdge(int x,int y,int w,Vector<Vector<edge>> adjList){
		adjList.get(x).add(new edge(x,y,w));
		adjList.get(y).add(new edge(y,x,w));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Vector<edge>> adjList = new Vector<Vector<edge>>();
		for(int i=0;i<3;i++){
			adjList.add(new Vector<edge>());
		}
		addEdge(0,2,2,adjList);
		addEdge(0,1,3,adjList);
		System.out.println(Kruskal(adjList));
	}

}
