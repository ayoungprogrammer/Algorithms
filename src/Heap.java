public class Heap {

  public int[] arr;
  public int size;

  public Heap(int startSize) {
    arr = new int[startSize];
    size = 0;
  }

  public void swap(int a, int b) {
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }

  public void heapify(int arr[]) {
    this.arr = arr;
    // Reach height of tree.
    for (int i = 0; i < Math.floor(arr.length / 2.0); i++) {
      // Iterate through array.
      bubbleDown(i);
    }
  }

  public void resize() {
    int[] newArr = new int[arr.length * 2];
    for (int i = 0; i < size; i++) {
      newArr[i] = arr[i];
    }
    arr = newArr;
  }

  public void bubbleDown(int idx) {
    while (idx < size) {
      int left = idx * 2 + 1;
      int right = idx * 2 + 2;
      // If both child exists.
      if (left < size && right < size) {
        // If left child is larger than right child and current node.
        if (arr[left] > arr[right] && arr[left] > arr[idx]) {
          swap(left, idx);
          idx = left;
        }
        // If right child is larger or equal than left child and current node.
        else if (arr[right] >= arr[left] && arr[right] > arr[idx]) {
          swap(right, idx);
          idx = right;
        }
        // If no children, stop.
        else {
          break;
        }
      }
      // If there is only a left child.
      else if (left < size) {
        swap(left, idx);
        idx = left;
      }
      // If there is only a right child.
      else if (right < size) {
        swap(right, idx);
        idx = right;
      }
      else {
        break;
      }
    }
  }

  public void push(int x) {

    if (size >= arr.length) {
      resize();
    }

    // Insert to the end of the heap.
    arr[size] = x;
    size++;

    int idx = size - 1;
    int parent = (idx - 1) / 2;

    // Push the node up until the parent is larger.
    while (idx > 0 && arr[parent] < arr[idx]) {
      swap(parent, idx);
      idx = parent;
      parent = (idx - 1) / 2;
    }
  }

  public int pop() {
    if (size == 0) {
      return 0;
    }
    // Swap root and last element of heap.
    int ret = arr[0];
    arr[0] = arr[size - 1];
    size--;

    // Push the root down until parent is greater than children
    bubbleDown(0);

    return ret;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Heap pq = new Heap(1);
    pq.push(5);
    pq.push(3);
    pq.push(1);
    pq.push(2);
    pq.push(4);
    while (pq.size > 0) {
      System.out.println(pq.pop());
    }

  }

}
