
public class Arr {

	
	public static int getElement(int[] arr,int i){
		if(i<0 || i>=arr.length){
	        throw new ArrayIndexOutOfBoundsException();
	    }
	    return arr[i];
	}
	
	public static int[] insertElement(int[] arr,int index,int e){
		int[] arr2 = new int[arr.length+1];
		//Copy element up to index of insertion
		for(int i=0;i<index;i++){
			arr2[i] = arr[i];
		}
		//Copy everything after index of insertion
		for(int i=index;i<arr.length;i++){
			arr2[i+1] = arr[i];
		}
		//Set inserted element
		arr2[index] = e;
		return arr2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
