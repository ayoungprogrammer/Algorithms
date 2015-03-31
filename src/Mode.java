public class Mode {

  public int mode1(int[] arr, int m) {
    int n = arr.length;
    int maxMode = 0;
    int maxOccurences = 0;
    
    // O(n) to loop through each number in array.
    for (int i = 0; i < n; i++) {
      int occurances = 0;
      // O(n) to count number of occurnaces of that number in array.
      for (int j = 0; j < n; j++) {
        if (arr[j] == arr[i]) {
          occurances++;
        }
      }
      // O(1) to update mode number of occurrences is greater. 
      if (occurances > maxOccurences) {
        maxOccurences = occurances;
        maxMode = arr[i];
      }
    }
    return maxMode;
  }

  public int mode2(int[] arr, int m) {
    int n = arr.length;
    // O(m) memory to store occurrences of each number. Let occurrences[i] be 
    // number of times i appears in arr.
    int[] occurrences = new int[m+1];
    // O(m) runtime to set number of occurrences to 0 for each number.
    for (int i = 0; i <= m; i++) {
      occurrences[i] = 0;
    }
    // O(n) runtime to loop through array and increment number of occurrences.
    for (int j = 0; j < n; j++) {
      occurrences[arr[j]]++;
    }
    int mode = 0;
    // O(m) runtime to loop through occurrences.
    for (int i = 0; i <= m; i++) {
      // O(1) runtime to compare update mode if occurrences of current number is bigger.
      if (occurrences[i] > occurrences[mode]) {
        mode = i;
      }
    }
    return mode;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
