import java.util.NoSuchElementException;


public class Vec {

	private int[] arr;
	int size = 0;
	
	public Vec(int size){
		arr = new int[size];
	}
	
	public void resize(){
		int[] new_arr = new int[2*arr.length];
		for(int i=0;i<size;i++){
			new_arr[i] = arr[i];
		}
		arr = new_arr;
	}
	
	public void add(int x){
		if(size>=arr.length){
			resize();
		}
		arr[size] = x;
		size++;
	}
	
	public int pop(){
		if(size==0){
			throw new NoSuchElementException();
		}
		int ret = arr[size];
		size--;
		return ret;
	}
	
	public int get(int idx){
		if(idx<0||idx>=size){
			throw new ArrayIndexOutOfBoundsException();
		}
		return arr[idx];
	}
	
	public int remove(int idx){
		if(idx<0||idx>=size){
			throw new ArrayIndexOutOfBoundsException();
		}
		int ret = arr[idx];
		while(idx+1<size){
			arr[idx]=arr[idx+1];
			idx++;
		}
		size--;
		return ret;
	}
	
	public void insert(int idx,int x){
		if(idx<0||idx>size){
			throw new ArrayIndexOutOfBoundsException();
		}
		size++;
		if(size>=arr.length){
			resize();
		}
		int idx2 = size;
		while(idx2>idx){
			arr[idx2]=arr[idx2-1];
			idx2--;
		}
		arr[idx] = x;
	}
	
	public String toString(){
		String str = "";
		for(int i=0;i<size;i++){
			str+=arr[i]+" ";
		}
		return str;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vec vec = new Vec(1);
		vec.add(1);
		vec.add(2);
		vec.add(3);
		System.out.println(vec);
		vec.remove(0);
		System.out.println(vec);
		vec.insert(0, 5);
		System.out.println(vec);
	}

}
