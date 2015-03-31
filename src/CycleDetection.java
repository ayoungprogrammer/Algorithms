public class CycleDetection {

  public static boolean hasCycle(int[][] adjMatrix) {
    int[] visited = new int[adjMatrix.length];

    // Mark each node as unvisited.
    for (int i = 0; i < adjMatrix.length; i++) {
      visited[i] = 0;
    }
    // Check if current node leads to a cycle.
    for (int i = 0; i < adjMatrix.length; i++) {
      if (hasCycleAt(adjMatrix, i, visited)) {
        return true;
      }
    }
    return false;
  }

  public static boolean hasCycleAt(int[][] adjMatrix, int i, int visited[]) {
    // If node has been reached again from the starting node, we have a cycle.
    if (visited[i] == 1) {
      return true;
    }
    // If node has been permanently visited, we know it was already checked.
    if (visited[i] == 2) {
      return false;
    }

    // Mark node as temporarily visited.
    visited[i] = 1;

    // Iterate through neighbors of current node.
    for (int j = 0; j < adjMatrix.length; i++) {
      if (adjMatrix[i][j] > 0) {
        // Recursively check is
        if (hasCycleAt(adjMatrix, j, visited)) {
          return true;
        }
        visited[j] = 0;
      }
    }
    // Permanently mark node as visited.
    visited[i] = 2;
    return false;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int n = 4;
    boolean[][] adjMatrix = new boolean[n][n];
    int i, j;
    for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++) {
        adjMatrix[i][j] = false;
      }
    }
    adjMatrix[0][1] = true;
    adjMatrix[1][2] = true;
    adjMatrix[2][3] = true;
    adjMatrix[0][3] = true;
    System.out.println();
  }

}
