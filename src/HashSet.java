import java.util.LinkedList;

public class HashSet {

	public LinkedList<Integer>[] buckets;
	public int bucketsSize = 10;
	public int size = 0;
	public static final double COLLISION_CHANCE = 0.3;
	
	public HashSet(){
		buckets = new LinkedList[10];
		for(int i=0;i<bucketsSize;i++){
			buckets[i] = new LinkedList<Integer>();
		}
		size = 0;
	}
	
	public int getHash(int x,int hashSize){
		return x % hashSize;
	}
	
	public void resize(){
		int newBucketsSize = bucketsSize*2;
		LinkedList<Integer>[] newBuckets = new LinkedList[newBucketsSize];
		for(int i=0;i<newBucketsSize;i++){
			newBuckets[i] = new LinkedList<Integer>();
		}
		for(int i=0;i<bucketsSize;i++){
			for(Integer y:buckets[i]){
				int hash = getHash(y,newBucketsSize);
				newBuckets[hash].push(y);
			}
		}
		buckets = newBuckets;
		bucketsSize = newBucketsSize;
	}
	
	public boolean insert(int x){
		int hash = getHash(x,bucketsSize);
		
		LinkedList<Integer> curBucket = buckets[hash];
		if(curBucket.contains(x)){
			return false;
		}
		curBucket.push(x);
		if( (float)size/bucketsSize>COLLISION_CHANCE){
			resize();
		}
		size++;
		return true;
	}
	public boolean remove(int x){
		int hash = getHash(x,bucketsSize);
		
		LinkedList<Integer> curBucket = buckets[hash];
		if(curBucket.remove((Integer)x)){
			return true;
		}
		return false;
	}
	public boolean contains(int x){
		int hash = getHash(x,bucketsSize);
		LinkedList<Integer> curBucket = buckets[hash];
		return curBucket.contains(x);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet set = new HashSet();
		set.insert(17);
		set.insert(8);
		System.out.println(set.contains(7));
	}

}
