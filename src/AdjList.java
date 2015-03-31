import java.util.Vector;

public class AdjList {

  public static Vector<Vector<edge>> getAdjList(Vector<edge> edges, int n) {
    Vector<Vector<edge>> adjList = new Vector<Vector<edge>>();
    for (int i = 0; i < n; i++){
      adjList.add(new Vector<edge>());
    }
    
    for(edge e: edges){
       adjList.get(e.source).add(e);
       adjList.get(e.dest).add(e);
    }
    return adjList;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Vector<edge> edges = new Vector<edge>();
    edges.add(new edge(1, 3, 3));
    edges.add(new edge(2, 3, 3));
    Vector<Vector<edge>> adjList = getAdjList(edges, 3);
  }

}
