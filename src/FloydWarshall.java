import java.util.Vector;



public class FloydWarshall {

	public static final int UNDEFINED = Integer.MIN_VALUE;
	
	public static int[][] FloydWarshall(Vector<Vector<edge>> adjList){
		int n = adjList.size();
		//dist[i][j] is the minimum distance from i to j
		int[][] dist = new int[n][n];
		
		//initialize dist[i][j]
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				dist[i][j] = UNDEFINED;
			}
		}
		
		//dist[i][i] = 0
		for(int i=0;i<n;i++){
			dist[i][i]=0;
		}
		
		//initialize weights, dist[i][j] = edge from i to j
		for(int i=0;i<n;i++){
			for(int j=0;j<adjList.get(i).size();j++){
				
				edge e = adjList.get(i).get(j);
				dist[e.source][e.dest] = e.weight;
				
				System.out.println(e.source+" "+e.dest);
			}
		}
		
		for(int k=0;k<n;k++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					//If dist[i][k] and dist[k][j] have been set then use those values
					if(dist[i][k]!=UNDEFINED&&dist[k][j]!=UNDEFINED){
						//If the new distance is less than current or not used, then update
						int newDist = dist[i][k]+dist[k][j];
						if(dist[i][j] > newDist || dist[i][j]==UNDEFINED){
							dist[i][j] = newDist;
						}
					}
				}
			}
		}
		for(int i=0;i<n;i++){
			if(dist[i][i]<0){
				System.out.println("negative cycle");
			}
		}
		
		return dist;
	}
	
	public static void addEdge(edge e,Vector<Vector<edge>> adjList){
		adjList.get(e.source).add(e);
		adjList.get(e.dest).add(new edge(e.dest,e.source,e.weight));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Vector<edge>> adjList;
		adjList = new Vector<Vector<edge>>();
		for(int i=0;i<3;i++)adjList.add(new Vector<edge>());
		addEdge(new edge(0,1,-3),adjList);
		addEdge(new edge(1,2,-5),adjList);
		int[][] res =  FloydWarshall(adjList);
		for(int i=0;i<res.length;i++){
			for(int j=0;j<res.length;j++){
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
	}

}
