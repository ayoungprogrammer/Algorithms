import java.util.Vector;

public class AdjMatrix {
  public static int[][] getAdjMatrix(Vector<edge> edges, int n) {
    int adjMatrix[][] = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        adjMatrix[i][j] = 0;
      }
    }

    for (int i = 0; i < edges.size(); i++) {
      edge e = edges.get(i);
      adjMatrix[e.source][e.dest] = e.weight;
      adjMatrix[e.dest][e.source] = e.weight;
    }
    return adjMatrix;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Vector<edge> edges = new Vector<edge>();
    edges.add(new edge(1, 3, 3));
    edges.add(new edge(2, 3, 3));
    getAdjMatrix(edges, 4);
  }

}
