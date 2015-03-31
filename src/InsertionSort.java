public class InsertionSort {

  public static void InsertionSort(int[] array) {
    int i, j;

    // Iterate through size of array.
    for (j = 1; j < array.length; j++) {
      int element = array[j];
      // Shift all elements until beginning of array or correct position.
      for (i = j - 1; (i >= 0) && (array[i] < element); i--) {
        array[i + 1] = array[i];
      }
      // Insert element into correct position.
      array[i + 1] = element;
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
