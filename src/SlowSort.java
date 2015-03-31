public class SlowSort {

  public void nextPermutation(int[] arr) {

  }

  void permuteSort(int[] arr) {
    while (!sorted(arr)) {
      nextPermutation(arr);
    }
  }

  boolean sorted(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] < arr[i - 1]) {
        return false;
      }
    }
    return true;
  }

  public void bozoSort(int[] arr) {

    int i = 0;

    // Keep trying until sorted.
    while (!sorted(arr)) {
      // Pick two random positions.
      int x = (int) (Math.random() * arr.length);
      int y = (int) (Math.random() * arr.length);
      // Swap array positions.
      int temp = arr[x];
      arr[x] = arr[y];
      arr[y] = temp;
    }
  }

  public void miracleSort(int[] arr) {
    boolean sorted = false;
    do {
      sorted = true;
      for (int i = 1; i < arr.length; i++) {
        if (arr[i] < arr[i - 1]) {
          sorted = false;
          break;
        }
      }
    } while (!sorted);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
