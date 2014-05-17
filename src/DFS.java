
public class DFS {
	
	
	/**
	 * Performs a DFS on a binary tree
	 * tree - current tree DFS is at
	 */
	public static void DFS(Tree cur){
		if(cur==null)return;
		DFS(cur.left);
		System.out.println(cur.value);
		DFS(cur.right);
	}
	/**
	 * Performs a DFS on a graph
	 * adjMatrix - Adjacency matrix for a graph with positive edges. 0 indicates no edge.
	 * cur - Current node the DFS is at
	 * visited - Mutable array which keeps track of which nodes have been visited already
	 */
	public static void DFS_graph(int[][] adjMatrix,int cur,boolean[] visited){
		if(visited[cur])return;
		visited[cur] = true;
		System.out.println(cur);
		for(int i=0;i<adjMatrix.length;i++){
			if(adjMatrix[cur][i]>0)DFS_graph(adjMatrix,i,visited);
		}
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
