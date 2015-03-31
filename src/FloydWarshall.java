import java.util.Vector;

public class FloydWarshall {

  public static final int UNDEFINED = Integer.MIN_VALUE;
  
  public static int[][] FloydWarshall(Vector<Vector<edge>> adjList) {
    int n = adjList.size();
    // Let dist[i][j] be the minimum distance from i to j.
    int[][] dist = new int[n][n];
  
    // Initialize all minimum distances to be undefined.
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dist[i][j] = UNDEFINED;
      }
    }
  
    // The minimum distance from a node to itself is 0.
    for (int i = 0; i < n; i++) {
      dist[i][i] = 0;
    }
  
    // Set distances for each edge.
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < adjList.get(i).size(); j++) {
        edge e = adjList.get(i).get(j);
        dist[e.source][e.dest] = e.weight;
      }
    }
  
    // Iterate through each intermediate node.
    for (int k = 0; k < n; k++) {
      // Iterate through each starting node.
      for (int i = 0; i < n; i++) {
        // Iterate through each ending node.
        for (int j = 0; j < n; j++) {
          // If there is a path from i to k and k to j.
          if (dist[i][k] != UNDEFINED && dist[k][j] != UNDEFINED) {
            // Distance from i to j is distance from i to k plus distance from k
            // to j.
            int newDist = dist[i][k] + dist[k][j];
            // Update distance from i to j, if the new distance is less than
            // current distance or if there is no existing path from i to j.
            if (dist[i][j] > newDist || dist[i][j] == UNDEFINED) {
              dist[i][j] = newDist;
            }
          }
        }
      }
    }
    // Check if there are negative cycles.
    for (int i = 0; i < n; i++) {
      // If the distance from a node to itself is negative, then there is a
      // negative cycle.
      if (dist[i][i] < 0) {
        System.out.println("negative cycle");
      }
    }
  
    return dist;
  }

  public static void addEdge(edge e, Vector<Vector<edge>> adjList) {
    adjList.get(e.source).add(e);
    adjList.get(e.dest).add(new edge(e.dest, e.source, e.weight));
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Vector<Vector<edge>> adjList;
    adjList = new Vector<Vector<edge>>();
    for (int i = 0; i < 3; i++) {
      adjList.add(new Vector<edge>());
    }
    addEdge(new edge(0, 1, -3), adjList);
    addEdge(new edge(1, 2, -5), adjList);
    int[][] res = FloydWarshall(adjList);
    for (int i = 0; i < res.length; i++) {
      for (int j = 0; j < res.length; j++) {
        System.out.print(res[i][j] + " ");
      }
      System.out.println();
    }
  }

}
