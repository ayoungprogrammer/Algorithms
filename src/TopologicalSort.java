import java.util.LinkedList;

public class TopologicalSort {

	public static LinkedList<Integer> order;
	public static boolean[] visited;
	
	public static void dfs(int[][] adjMatrix,int ind){
		int j;
		if(!visited[ind]){
			for(j=0;j<adjMatrix.length;j++){
				if(adjMatrix[ind][j]>0){
					dfs(adjMatrix,j);
				}
			}
			visited[ind] = true;
			order.push(ind);
		}
	}
	
	public static LinkedList<Integer> topsort(int [][] adjMatrix){
		int n = adjMatrix.length;
		order = new LinkedList<Integer>();
		int i;
		for(i=0;i<n;i++){
			visited[i] = false;
		}
		for(i=0;i<n;i++){
			if(visited[i]==false)dfs(adjMatrix,i);
		}
		return order;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
