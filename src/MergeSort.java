import java.util.Collections;
import java.util.Vector;


public class MergeSort {
  // Merges two sorted arrays v1 and v2 into a new sorted array
  public static Vector<Integer> merge(Vector<Integer> v1, Vector<Integer> v2) {
    Vector<Integer> merged = new Vector<Integer>();
    int i = 0, j = 0;
    // Always take the smaller element of the two vectors
    while(i < v1.size() && j < v2.size()){
      if(v1.get(i) < v2.get(j)){
        merged.add(v1.get(i));
        i++;
      } else {
        merged.add(v2.get(j));
        j++;
      }
    }
    if (i >= v1.size()){
      // Add the rest of v2
      while(j < v2.size()){
        merged.add(v2.get(j));
        j++;
      }
    } else {
      // Add the rest of v1.
      while(i < v1.size()){
        merged.add(v1.get(i));
        i++;
      }
    }
    return merged;
  }
  
  // Merge sorts an array
  public static Vector<Integer> mergeSort(Vector<Integer> v) {
    // Base case if 1 or 0 elements.
    if (v.size() <= 1) {
      return v;
    }
    // Get middle of array.
    int middle = v.size()/2;
    // Split vector into two halves.
    Vector<Integer> firstHalf = new Vector<Integer>(v.subList(0, middle));
    Vector<Integer> secondHalf = new Vector<Integer>(v.subList(middle, v.size()));
    // Return merged halves.
    return merge(mergeSort(firstHalf), mergeSort(secondHalf));
  }
  
  public static void main(String[] args) {
    Vector<Integer> v = new Vector<Integer>();
    Collections.addAll(v, 5,4,10,8,9,2);
    System.out.println(mergeSort(v));
  }

}
