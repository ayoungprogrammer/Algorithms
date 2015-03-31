public class NQueen {

  public static int nqueen(int col, boolean row[], boolean d1[], boolean d2[]) {
    
    int n = row.length;
    
    // Base case if 8 queens are placed.
    if (col >= n) {
      return 1;
    }
  
    int sum = 0;
  
    for (int r = 0; r < n; r++) {
      if (!row[r] && !d1[r + col] && !d2[n - 1 - r + col]) {
        // Mark rows and diagonals as filled.
        row[r] = true;
        d1[r + col] = true;
        d2[n - 1 - r + col] = true;
        // Backtrack positions.
        sum += nqueen(col + 1, row, d1, d2);
        // Clear rows and diagonals.
        row[r] = false;
        d1[r + col] = false;
        d2[n - 1 - r + col] = false;
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    int n = 10;
    boolean[] row = new boolean[n];
    boolean[] d1 = new boolean[2*n];
    boolean[] d2 = new boolean[2*n];
    for (int i = 0; i < n; i++) {
      row[i] = false;
      d1[i] = d2[i] = false;
    }

    System.out.println(nqueen(0, row, d1, d2));
  }
}
