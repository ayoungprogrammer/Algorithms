
public class ConnectedComponents {

	public static int getParent(int x,int[] parent){
		if(parent[x]==x)return x;
		parent[x] = getParent(parent[x],parent);
		return parent[x];
	}
	
	public static void cc(int adjMatrix[][]){
		int n = adjMatrix.length;
		int[] parent = new int[n];
		int i,j;
		for(i=0;i<n;i++){
			parent[i] = i;
		}
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				if(adjMatrix[i][j]>0){
					int pi = getParent(i,parent);
					int pj = getParent(j,parent);
					if(pi!=pj){
						parent[pj] = pi;
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
