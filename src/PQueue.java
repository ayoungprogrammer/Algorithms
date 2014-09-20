
public class PQueue {

    public int[] arr;
    public int size;
    
    public PQueue(int startSize){
        arr = new int[startSize];
        size = 0;
    }
    
    public void heapify(int arr[]){
        this.arr = arr;
        for(int i=0;i<Math.floor(arr.length/2.0);i++){
            int idx = i;
            while(idx<size){
                int left = idx*2+1;
                int right = idx*2+2;
                if(left<size && arr[left]>arr[idx]){
                    int swap = arr[left];
                    arr[left] = arr[idx];
                    arr[idx] = swap;
                    idx = left;
                }else if(right<size && arr[right]>arr[idx]){
                    int swap = arr[right];
                    arr[right]=arr[idx];
                    arr[idx] = swap;
                    idx = right;
                }else {
                    break;
                }
            }
        }
    }
    
    public void resize(){
        int[] newArr = new int[arr.length*2];
        for(int i=0;i<size;i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
    
    public void push(int x){
        
        if(size>=arr.length){
            resize();
        }
        arr[size] = x;
        size++;
        
        //Make sure parent is > child from the last element
        int idx = size-1;
        int parent = (idx-1)/2;
        while(idx>0 && arr[parent]<arr[idx]){
            int swap = arr[parent];
            arr[parent] = arr[idx];
            arr[idx] = swap;
            idx = parent;
            parent = (idx-1)/2;
        }
    }
    
    public int pop(){
        if(size==0)return 0;
        int ret = arr[0];
        arr[0] = arr[size-1];
        size--;
        
        int idx = 0;
        
        while(idx<size){
            int left = idx*2+1;
            int right = idx*2+2;
            if(left<size && arr[left]>arr[idx]){
                int swap = arr[left];
                arr[left] = arr[idx];
                arr[idx] = swap;
                idx = left;
            }else if(right<size && arr[right]>arr[idx]){
                int swap = arr[right];
                arr[right]=arr[idx];
                arr[idx] = swap;
                idx = right;
            }else {
                break;
            }
        }
        
        return ret;
    }
    
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PQueue pq = new PQueue(1);
        pq.push(5);
        pq.push(3);
        pq.push(1);
        pq.push(2);
        pq.push(4);
        while(pq.size>0){
            System.out.println(pq.pop());
        }

    }

}
