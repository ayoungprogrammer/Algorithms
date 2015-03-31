public class Pair {
  int key;
  String value;

  public Pair(int key, String value) {
    this.key = key;
    this.value = value;
  }

  public boolean equals(Pair p) {
    return p.key == key;
  }
}
