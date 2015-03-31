public class ConnectedComponents {

  public static int getParent(int x, int[] parent) {
    // If nodes parent is itself, then we reach the highest parent.
    if (parent[x] == x) {
      return x;
    }
  
    // Set current nodes parent to highest parent.
    parent[x] = getParent(parent[x], parent);
  
    // Return highest parent.
    return parent[x];
  }
  
  public static void connectedComponents(int adjMatrix[][]) {
    int n = adjMatrix.length;
    int[] parent = new int[n];
    int i, j;
  
    // Initialize every nodes parent to itself.
    for (i = 0; i < n; i++) {
      parent[i] = i;
    }
    // Iterate through each node.
    for (i = 0; i < n; i++) {
      // Iterate through each other node.
      for (j = 0; j < n; j++) {
        // If the two nodes have an edge.
        if (adjMatrix[i][j] > 0) {
          // Recursively get parents of each node.
          int pi = getParent(i, parent);
          int pj = getParent(j, parent);
          // Set parent of one to the other if they are different.
          if (pi != pj) {
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
