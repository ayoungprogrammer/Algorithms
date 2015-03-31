import java.util.PriorityQueue;
import java.util.Vector;

public class Kruskal {

  // Gets parent of node x.
  public static int getParent(int parents[], int x) {
    // Base Case: parent of x is itself.
    if (parents[x] == x) {
      return x;
    }
    // Set current's parent to highest parent.
    parents[x] = getParent(parents, parents[x]);
  
    // Returns parent.
    return parents[x];
  }
  
  public static int Kruskal(Vector<Vector<edge>> adjList) {
    int n = adjList.size();
    // Parents of each node. Nodes with the same parents are in the same
    // component.
    int parents[] = new int[n];
  
    // Set parents of each node to itself.
    for (int i = 0; i < n; i++) {
      parents[i] = i;
    }
  
    int sum = 0;
    PriorityQueue<edge> edges = new PriorityQueue<edge>();
  
    // Iterate through each node.
    for (int i = 0; i < n; i++) {
      // Iterate through edges of node.
      for (int j = 0; j < adjList.get(i).size(); j++) {
        // Add edge to priority queue.
        edges.add(adjList.get(i).get(j));
      }
    }
  
    // Iterate through all edges.
    while (!edges.isEmpty()) {
      // Get edge with smallest weight.
      edge e = edges.poll();
      // Take edge if highest parent of source and destination nodes are
      // different i.e. take the edge if it connects different components
      if (getParent(parents, e.source) != getParent(parents, e.dest)) {
        // Set parent of source to highest parent of destination node.
        parents[e.source] = getParent(parents, e.dest);
        
        // Add edge weight to MST weight.
        sum += e.weight;
      }
    }
  
    // Return MST weight.
    return sum;
  }

  public static void addEdge(int x, int y, int w, Vector<Vector<edge>> adjList) {
    adjList.get(x).add(new edge(x, y, w));
    adjList.get(y).add(new edge(y, x, w));
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Vector<Vector<edge>> adjList = new Vector<Vector<edge>>();
    for (int i = 0; i < 3; i++) {
      adjList.add(new Vector<edge>());
    }
    addEdge(0, 2, 2, adjList);
    addEdge(0, 1, 3, adjList);
    System.out.println(Kruskal(adjList));
  }

}
