public class BubbleSort {

  public static void BubbleSort(int array[]) {
    // Keep going through array unless until no swaps are made.
    boolean swapped = true;
    while (swapped) {
      swapped = false;
      // Iterate through the array.
      for (int j = 1; j < array.length; j++) {
        // Swap if current element is bigger then next.
        if (array[j - 1] > array[j]) {
          // swap the bubbles
          int temp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = temp;
          swapped = true;
        }
      }
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] array = { 7, 8, 5, 2, 5, 3 };
    BubbleSort(array);
    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
  }

}
