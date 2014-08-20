import java.util.LinkedList;

public class HashMap {

	public LinkedList<Pair>[] buckets;
	public int bucketsSize = 10;
	public int size = 0;
	public static final double COLLISION_CHANCE = 0.3;
	
	public HashMap(){
		buckets = new LinkedList[10];
		for(int i=0;i<bucketsSize;i++){
			buckets[i] = new LinkedList<Pair>();
		}
		size = 0;
	}
	
	public int getHash(int x,int hashSize){
		return x % hashSize;
	}
	
	public void resize(){
		int newBucketsSize = bucketsSize*2;
		LinkedList<Pair>[] newBuckets = new LinkedList[newBucketsSize];
		for(int i=0;i<newBucketsSize;i++){
			newBuckets[i] = new LinkedList<Pair>();
		}
		for(int i=0;i<bucketsSize;i++){
			for(Pair p:buckets[i]){
				int hash = getHash(p.key,newBucketsSize);
				newBuckets[hash].push(p);
			}
		}
		buckets = newBuckets;
		bucketsSize = newBucketsSize;
	}
	
	public boolean insert(Pair p){
		int hash = getHash(p.key,bucketsSize);
		
		LinkedList<Pair> curBucket = buckets[hash];
		if(curBucket.contains(p.key)){
			return false;
		}
		curBucket.push(p);
		if( (float)size/bucketsSize>COLLISION_CHANCE){
			resize();
		}
		size++;
		return true;
	}
	public boolean remove(int key){
		int hash = getHash(key,bucketsSize);
		
		LinkedList<Pair> curBucket = buckets[hash];
		for(Pair p: curBucket){
			if(p.key==key){
				curBucket.remove(p);
				return true;
			}
		}
		return false;
	}
	public Pair get(int key){
		int hash = getHash(key,bucketsSize);
		LinkedList<Pair> curBucket = buckets[hash];
		for(Pair p:curBucket){
			if(p.key==key){
				return p;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet set = new HashSet();
		set.insert(17);
		set.insert(8);
		System.out.println(set.contains(7));
	}

}
