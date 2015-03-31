import java.util.Vector;

public class AdvancedRecursion {

  static Vector<String> insertAll(char ch, Vector<String> strArr) {
    Vector<String> vec = new Vector<String>();
    for (int i = 0; i < strArr.size(); i++) {
      String str = strArr.get(i);
      for (int j = 0; j <= str.length(); j++) {
        vec.add(str.substring(0, j) + ch + str.substring(j, str.length()));
      }
    }
    return vec;
  }

  static Vector<String> permutation(String s) {
    int n = s.length();
    if (n == 1) {
      Vector<String> vec = new Vector<String>();
      vec.add(s.substring(0, 1));
      return vec;
    }
    return insertAll(s.charAt(0), permutation(s.substring(1)));
  }

  void hanoi(int N, int start, int helper, int destination) {
    // Base case to move one disk.
    if (N == 1) {
      System.out.println("Move " + start + " to " + destination);
    }
    else {

      // Move N-1 discs from start to helper.
      hanoi(N - 1, start, destination, helper);

      // Move 1 disc from start to end.
      hanoi(1, start, helper, destination);

      // Move N-1 discs from helper to end.
      hanoi(N - 1, helper, start, destination);
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(permutation("abc"));
  }

}
