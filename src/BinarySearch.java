public class BinarySearch {

  public static boolean exists(int[] arr, int x) {
    int start = 0;
    int end = arr.length - 1;
    while (end >= start) {
      int middle = (start + end) / 2;
      if (arr[middle] == x) {
        return true;
      }
      else if (arr[middle] < x) {
        start = middle + 1;
      }
      else if (arr[middle] > x) {
        end = middle - 1;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] arr = { -6, -5, 1, 2, 4, 5, 7, 19 };
    System.out.println(exists(arr, 2));
    System.out.println(exists(arr, 3));

  }

}
