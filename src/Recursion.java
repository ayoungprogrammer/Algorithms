public class Recursion {

  int factorial(int n){
    if (n == 1) {
      return 1;
    }
    return n * factorial(n - 1);
  }
  
  int sum(String str) {
    int n = str.length();
    // Base case when string is empty.
    if (n == 0) {
      return 0;
    }
    // Case when string is not empty.
    else {
      // Convert ASCII to number.
      int charToNum = (str.charAt(0) - '0');
      return charToNum + sum(str.substring(1, n));
    }
  }
  
  int count(String str) {
    int n = str.length();
  
    // Base case for empty string.
    if (n == 0) {
      return 0;
    }
    // Case if first character is a 'c'.
    if (str.charAt(0) == 'c') {
      return count(str.substring(1, n)) + 1;
    }
    // Case if first character is not a 'c'.
    else {
      return count(str.substring(1, n));
    }
  }
  
  int exponent(int b, int n){
    //Base case when n is 1.
    if (n == 1) {
      return b;
    }
    // Case when n is even.
    if(n % 2 == 0) {
      int x = exponent(b, n / 2);
      return (x * x) % 10000;
    }
    // Case when n is odd.
    else {
      int x = exponent(b, n / 2);
      return (x * x * b) % 10000;
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
