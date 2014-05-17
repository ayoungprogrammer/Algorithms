class edge implements Comparable<edge>{
	int weight,source,dest;
	public edge(int source,int dest,int weight){
		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}
	public int compareTo(edge e){
		return weight-e.weight;
	}
}