import java.util.LinkedList;

public class HashMap {

  public LinkedList<Pair>[] buckets;
  public int bucketsSize = 10;
  public int size = 0;
  public static final double COLLISION_CHANCE = 0.3;

  public HashMap() {
    // Create buckets.
    buckets = new LinkedList[10];
    for (int i = 0; i < bucketsSize; i++) {
      buckets[i] = new LinkedList<Pair>();
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
    LinkedList<Pair>[] newBuckets = new LinkedList[newBucketsSize];
    
    // Create new buckets.
    for (int i = 0; i < newBucketsSize; i++) {
      newBuckets[i] = new LinkedList<Pair>();
    }
    // Copy elements over and use new hashes.
    for (int i = 0; i < bucketsSize; i++) {
      for (Pair y : buckets[i]) {
        int hash = getHash(y.key, newBucketsSize);
        newBuckets[hash].push(y);
      }
    }
    // Set new buckets.
    buckets = newBuckets;
    bucketsSize = newBucketsSize;
  }

  public boolean put(int key, String value) {
    // Get hash of x.
    int hash = getHash(key, bucketsSize);
  
    // Get current bucket from hash.
    LinkedList<Pair> curBucket = buckets[hash];
    
    // Check if bucket contains key.
    for(Pair p: curBucket){
      // Overwrite value if key already exists and return false.
      if(p.key == key){
        p.value = value;
        return false;
      }
    }
    
    // Otherwise, add pair to the bucket.
    curBucket.push(new Pair(key, value));
    
    // Resize if the collision chance is higher than threshold.
    if ((float) size / bucketsSize > COLLISION_CHANCE) {
      resize();
    }
    size++;
    return true;
  }
  
  public String get(int key) {
    // Get hash of x.
    int hash = getHash(key, bucketsSize);
    
    // Get current bucket from hash.
    LinkedList<Pair> curBucket = buckets[hash];
    
    // Look for key in bucket.
    for(Pair p: curBucket){
      // Return value if keys are equal.
      if(p.key == key){
        return p.value;
      }
    }
    // Return null if not found.
    return null;
  }

  public boolean remove(int key) {
    // Get hash of x.
    int hash = getHash(key, bucketsSize);
    
    // Get bucket from hash.
    LinkedList<Pair> curBucket = buckets[hash];
    
    // Remove x from bucket and return if operation successful.
    for(Pair p: curBucket){
      // Remove pair from bucket if keys match.
      if(p.key == key){
        return curBucket.remove(p);
      }
    }
    // Return false if key not found in map.
    return false;
  }

  public static void main(String[] args) {
    HashMap map = new HashMap();
    map.put(1, "abc");
    map.put(4, "test");
    System.out.println(map.get(1));
    System.out.println(map.get(5));
  }

}
