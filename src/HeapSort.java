import java.util.PriorityQueue;

public class HeapSort {

  public void heapSort(int[] arr) {
    // Use a built-in heap.
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
  
    // Add all elements into heap.
    for (int i = 0; i < arr.length; i++) {
      pq.add(arr[i]);
    }
    // Pop all elements from heap.
    for (int i = 0; i < arr.length; i++) {
      arr[i] = pq.poll();
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
