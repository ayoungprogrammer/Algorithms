public class Backtracking {

  void subsets(int arr[], boolean use[], int i) {
    int n = arr.length;
    if (i >= n) {
      for (int j = 0; j < n; j++) {
        System.out.print(arr[i]);
      }
      System.out.println();
      return;
    }
    use[i] = false;
    subsets(arr, use, i + 1);
    use[i] = true;
    subsets(arr, use, i + 1);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
