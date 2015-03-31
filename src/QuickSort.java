import java.util.Collections;
import java.util.Vector;

public class QuickSort {

  // Quick sorts array from [first..last]
  public static Vector<Integer> quickSort(Vector<Integer> arr) {
    // Base case if sorting one or zero elements.
    if (arr.size() <= 1) {
      return arr;
    }
    // Select a random pivot.
    int pivot = (int) (Math.random() * arr.size());
  
    // Store each part.
    Vector<Integer> lower = new Vector<Integer>();
    Vector<Integer> higher = new Vector<Integer>();
    Vector<Integer> equal = new Vector<Integer>();
  
    // Splits element into each part.
    for (int i = 0; i < arr.size(); i++) {
      if (arr.get(i) < arr.get(pivot)) {
        lower.add(arr.get(i));
      }
      else if (arr.get(i) > arr.get(pivot)) {
        higher.add(arr.get(i));
      }
      else {
        equal.add(arr.get(i));
      }
    }
  
    // Combine results of all parts.
    Vector<Integer> result = new Vector<Integer>();
    result.addAll(quickSort(lower));
    result.addAll(quickSort(equal));
    result.addAll(quickSort(higher));
    return result;
  }

  public static void main(String[] args) {
    Vector<Integer> v = new Vector<Integer>();
    Collections.addAll(v, 5,4,10,8,9,2);
    System.out.println(quickSort(v));
  }

}
