public class DynamicProgramming {

  public int fib(int n) {
    int fibArr[] = new int[n];
    fibArr[0] = 1;
    fibArr[1] = 1;
    for (int x = 2; x < n; x++) {
      fibArr[x] = fibArr[x - 1] + fibArr[x - 2];
    }
    return fibArr[n];
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
