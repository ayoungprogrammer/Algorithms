import java.util.NoSuchElementException;


class Link{
	int value;
	Link next;
	public Link(int value){
		this.value = value;
		this.next = null;
	}
}


public class LinkedList {

	public Link head;
	public Link end;
	public int size;
	
	public LinkedList(){
		head = null;
		end = null;
		size = 0;
	}
	/*
	 * Creates a new node and adds it after the given node
	 */
	public void insert(int value, Link cur){
		Link newLink = new Link(value);
		newLink.next = cur.next;
		cur.next = newLink.next;
		size++;
	}
	/*
	 * Adds new node to head of linked list
	 */
	public void push(int value){
		Link newLink = new Link(value);
		if(size==0){
			head = end = newLink;
		}else{
			end.next = newLink;
			end = newLink;
		}
		size++;
	}
	/*
	 * Adds new node to head of linked list
	 */
	public int pop(){
		if(head==null){
			throw new NoSuchElementException();
		}
		int ret = head.value;
		head = head.next;
		size--;
		if(size==0){
			end = null;
		}
		return ret;
	}
	/*
	 * Gets the value at index
	 */
	public int get(int index){
		int i = 0;
		Link curNode = head;
		while(curNode!=null){
			if(index==i){
				return curNode.value;
			}
			curNode = curNode.next;
			i++;
		}
		throw new NoSuchElementException();
	}
	/*
	 * Deletes node after specified
	 */
	public void deleteNext(Link node){
		if(node.next==end){
			end = node;
		}
		node.next = node.next.next;
		size--;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		ll.push(3);
		ll.push(4);
		ll.push(5);
		ll.push(6);
		for(int i=0;i<ll.size;i++){
			System.out.println(ll.get(i));
		}
	}

}
