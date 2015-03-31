import java.util.PriorityQueue;
import java.util.Vector;

public class Prims {

  public static int Prims(Vector<Vector<node>> adjList) {
    // Current cost of MST.
    int cost = 0;
    int n = adjList.size();
    
    PriorityQueue<node> pq = new PriorityQueue<node>();
    
    // Keep track if each node is visited.
    boolean visited[] = new boolean[n];
    for (int i = 0; i < n; i++) {
      visited[i] = false;
    }
    
    // Number of nodes visited.
    int inTree = 1;
    
    // Mark starting node as visited.
    visited[0] = true;
    
    // Add all edges of starting node.
    for (int i = 0; i < adjList.get(0).size(); i++) {
      pq.add(adjList.get(0).get(i));
    }
    // Keep going until all nodes visited.
    while (!pq.isEmpty() && inTree < n) {
      // Get the edge with the smallest weight.
      node cur = pq.poll();
      // Skip if node already used.
      if (visited[cur.index]) {
        continue;
      }
      inTree++;
      visited[cur.index] = true;
      cost += cur.weight;
      // Add all the edges of the new node to the priority queue.
      for (int i = 0; i < adjList.get(cur.index).size(); i++) {
        pq.add(adjList.get(cur.index).get(i));
      }
    }
    // Graph not connected if number of nodes used is less than total nodes.
    if (inTree < n) {
      return -1;
    }
  
    return cost;
  }

  public static void addEdge(int x, int y, int w, Vector<Vector<node>> adjList) {
    adjList.get(x).add(new node(w, y));
    adjList.get(y).add(new node(w, x));
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Vector<Vector<node>> adjList = new Vector<Vector<node>>();
    for (int i = 0; i < 3; i++) {
      adjList.add(new Vector<node>());
    }
    addEdge(0, 2, 2, adjList);
    addEdge(0, 1, 3, adjList);
    System.out.println(Prims(adjList));
  }

}
