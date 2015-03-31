import java.util.PriorityQueue;

public class Dijkstra {

  static class node implements Comparable<node> {
    // Current weight to reach node.
    int weight;
    // Current index of node.
    int index;

    public node(int weight, int index) {
      this.weight = weight;
      this.index = index;
    }

    @Override
    public int compareTo(node e) {
      return weight - e.weight;
    }
  }

  public static int dijkstra(int[][] adjMatrix, int start, int end) {
  
    int n = adjMatrix.length;
    PriorityQueue<node> pq = new PriorityQueue<node>();
  
    // Initialize visited to false.
    boolean visited[] = new boolean[n];
    for (int i = 0; i < n; i++) {
      visited[i] = false;
    }
  
    // Add the start node to the queue.
    pq.add(new node(0, start));
  
    // Keep going until all nodes are visited or queue is empty.
    while (!visited[end] && !pq.isEmpty()) {
  
      // Get node with lowest total weight.
      node curNode = pq.poll();
  
      // Skip node is already visited.
      if (visited[curNode.index]) {
        continue;
      }
  
      // Mark node as visited.
      visited[curNode.index] = true;
  
      // If current node is end node then we are done.
      if (curNode.index == end) {
        return curNode.weight;
      }
  
      // Iterate through neighbors of current node.
      for (int i = 0; i < n; i++) {
        // Iterate through each unvisited neighbor.
        if (adjMatrix[curNode.index][i] > 0 && !visited[i]) {
          // Set add edge weight to current weight.
          int newWeight = curNode.weight + adjMatrix[curNode.index][i];
          pq.add(new node(newWeight, i));
        }
      }
    }
    return -1;
  }

  public static void main(String args[]) {
    int[][] adjMatrix = new int[][] { { 0, 3, 0 }, { 3, 0, 5 }, { 0, 5, 0 } };
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(" " + adjMatrix[i][j]);
      }
      System.out.println("");
    }
    System.out.println(dijkstra(adjMatrix, 0, 2));
  }

}
