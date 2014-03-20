import java.util.Vector;

class edge{
	int weight,source,dest;
	public edge(int source,int dest,int weight){
		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}
}

public class BellmanFord {

	public static int BellmanFord(Vector<Vector<edge>> adjList,int startNode,int endNode){
		
		int n = adjList.size();
		//dist[i] is minimum distance from start to i
		int[] dist=new int[n];
		
		//used[i] is if dist[i] has been initialized
		boolean[] used = new boolean[n];
		
		for(int i=0;i<n;i++){
			dist[i] = 0;
			used[i] = false;
		}
		used[startNode] = true;
		dist[startNode] = 0;
		for(int i=0;i<n-1;i++){
			//Iterate through adjacency list
			for(int j=0;j<n;j++){
				for(int k=0;k<adjList.get(j).size();k++){
					if(!used[j])continue;
					edge e = adjList.get(j).get(k);
					if(used[e.source]){
						int newDist = dist[e.source]+e.weight;
						if(newDist<dist[e.dest] || !used[e.dest]){
							used[e.dest]= true; 
							dist[e.dest] = newDist;
						}
					}
				}
			}
		}
		
		for(int j=0;j<n;j++){
			for(int k=0;k<adjList.get(j).size();k++){
				edge e = adjList.get(j).get(k);
				//If negative cycle
				if(dist[e.source]+e.weight < dist[e.dest]){
					System.out.println("Negative cycle");
				}
			}
		}
		
		//If no path exists
		if(!used[endNode]){
			System.out.println("No path from start to end");
		}
		
		//Return distance from start to end
		return dist[endNode];
	}
	
	public static void addEdge(edge e,Vector<Vector<edge>> adjList){
		adjList.get(e.source).add(e);
		adjList.get(e.dest).add(e);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Vector<edge>> adjList;
		adjList = new Vector<Vector<edge>>();
		for(int i=0;i<3;i++)adjList.add(new Vector<edge>());
		addEdge(new edge(0,1,3),adjList);
		addEdge(new edge(1,2,5),adjList);
		System.out.println( BellmanFord(adjList,0,2));
	}

}
