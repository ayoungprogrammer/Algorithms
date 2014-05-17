class node implements Comparable<node>{
	int weight,index;
	public node(int weight,int index){
		this.weight = weight;
		this.index = index;
	}
	public int compareTo(node e){
		return weight-e.weight;
	}
}




