import java.util.Vector;



public class FloydWarshall {

	public static int[][] FloydWarshall(Vector<Vector<edge>> adjList){
		int n = adjList.size();
		//dist[i][j] is the minimum distance from i to j
		int[][] dist = new int[n][n];
		//used[i][j] is if the dist from i to j has been used
		boolean[][] used = new boolean[n][n];
		
		//initialize dist[i][j]
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				dist[i][j] = 0;
				used[i][j] = false;
			}
		}
		
		//dist[i][i] = 0
		for(int i=0;i<n;i++){
			dist[i][i]=0;
			used[i][i]=true;
		}
		
		//initialize weights, dist[i][j] = edge from i to j
		for(int i=0;i<n;i++){
			for(int j=0;j<adjList.get(i).size();j++){
				
				edge e = adjList.get(i).get(j);
				dist[e.source][e.dest] = e.weight;
				used[e.source][e.dest] = true; 
				
				System.out.println(e.source+" "+e.dest);
			}
		}
		
		for(int k=0;k<n;k++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					//If dist[i][k] and dist[k][j] have been set then use those values
					if(used[i][k]&&used[k][j]){
						//If the new distance is less than current or not used, then update
						int newDist = dist[i][k]+dist[k][j];
						if(dist[i][j] > newDist || !used[i][j]){
							dist[i][j] = newDist;
							used[i][j] = true;
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
