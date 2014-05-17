import java.util.PriorityQueue;




public class Dijkstra {

	

	public static int dijkstra(int[][] adjMatrix,int start,int end){
		
		int n = adjMatrix.length;
		PriorityQueue <node> pq = new PriorityQueue<node>();
		
		boolean visited[] = new boolean[n];
		for(int i=0;i<n;i++)visited[i] = false;

		pq.add(new node(0,start));
		while(!visited[end] && !pq.isEmpty()){
			node curNode = pq.poll();
		
			if(visited[curNode.index])continue;
			visited[curNode.index] = true;
			if(curNode.index==end){
				return curNode.weight;
			}
			for(int i=0;i<n;i++){
				if(adjMatrix[curNode.index][i]>0 && !visited[i]){
					int newWeight = curNode.weight+adjMatrix[curNode.index][i];
					pq.add(new node(newWeight,i));
				}
			}
		}
		return -1;
	}
	public static void main(String args[]){
		int[][] adjMatrix = new int[][] {{0,3,0},{3,0,5},{0,5,0}};
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(" "+adjMatrix[i][j]);
			}
			System.out.println("");
		}
		System.out.println( dijkstra(adjMatrix,0,2));
	}
	
	
}
