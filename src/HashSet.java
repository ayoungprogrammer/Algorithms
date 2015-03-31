import java.util.LinkedList;

public class HashSet {

  public LinkedList<Integer>[] buckets;
  public int bucketsSize = 10;
  public int size = 0;
  public static final double COLLISION_CHANCE = 0.3;

  public HashSet() {
    // Create buckets.
    buckets = new LinkedList[10];
    for (int i = 0; i < bucketsSize; i++) {
      buckets[i] = new LinkedList<Integer>();
    }
    size = 0;
  }

  public int getHash(int x, int hashSize) {
    // Use modulus as hash function.
    return x % hashSize;
  }

  public void resize() {
    // Double number of buckets.
    int newBucketsSize = bucketsSize * 2;
    LinkedList<Integer>[] newBuckets = new LinkedList[newBucketsSize];
    
    // Create new buckets.
    for (int i = 0; i < newBucketsSize; i++) {
      newBuckets[i] = new LinkedList<Integer>();
    }
    
    // Copy elements over and use new hashes.
    for (int i = 0; i < bucketsSize; i++) {
      for (Integer y : buckets[i]) {
        int hash = getHash(y, newBucketsSize);
        newBuckets[hash].push(y);
      }
    }
    
    // Set new buckets.
    buckets = newBuckets;
    bucketsSize = newBucketsSize;
  }

  public boolean insert(int x) {
    // Get hash of x.
    int hash = getHash(x, bucketsSize);
  
    // Get current bucket from hash.
    LinkedList<Integer> curBucket = buckets[hash];
    
    // Stop, if current bucket already has x.
    if (curBucket.contains(x)) {
      return false;
    }
    
    // Otherwise, add x to the bucket.
    curBucket.push(x);
    
    // Resize if the collision chance is higher than threshold.
    if ((float) size / bucketsSize > COLLISION_CHANCE) {
      resize();
    }
    size++;
    return true;
  }
  
  public boolean contains(int x) {
    // Get hash of x.
    int hash = getHash(x, bucketsSize);
    
    // Get current bucket from hash.
    LinkedList<Integer> curBucket = buckets[hash];
    
    // Return if bucket contains x.
    return curBucket.contains(x);
  }

  public boolean remove(int x) {
    // Get hash of x.
    int hash = getHash(x, bucketsSize);
    
    // Get bucket from hash.
    LinkedList<Integer> curBucket = buckets[hash];
    
    // Remove x from bucket and return if operation successful.
    return curBucket.remove((Integer) x);
  }

  public static void main(String[] args) {
    HashSet set = new HashSet();
    set.insert(17);
    set.insert(8);
    System.out.println(set.contains(7));
  }

}
