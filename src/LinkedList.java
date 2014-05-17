
class Link{
	int value;
	Link next;
	Link prev;
	public Link(int value){
		this.value = value;
		this.next = null;
		this.prev = null;
	}
}


public class LinkedList {

	public Link start;
	public int size;
	
	public LinkedList(){
		start = null;
		size = 0;
	}
	/*
	 * Creates a new node and adds it after the given node
	 */
	public void addAfterNode(int value, Link node){
		if(start==null){
			start = new Link(value);
		}else {
			Link nn = new Link(value);
			nn.next = node.next;
			node.next = nn;
		}
		size++;
	}
	/*
	 * Adds new node to head of linked list
	 */
	public void addToHead(int value){
		Link nn = new Link(value);
		nn.next = start;
		start.prev = nn;
		start = nn;
		size++;
	}
	/*
	 * Gets the value at index
	 */
	public int get(int index){
		int i = 0;
		Link curNode = start;
		while(curNode!=null){
			if(index==i){
				return curNode.value;
			}
			curNode = curNode.next;
			i++;
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	/*
	 * Deletes value at current node
	 */
	public void delete(Link node){
		if(node.prev!=null)node.prev.next = node.next;
		if(node.next!=null)node.next.prev = node.prev;
		size--;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		ll.addToHead(3);
		ll.addToHead(4);
		ll.addToHead(5);
		ll.addToHead(6);
		for(int i=0;i<ll.size;i++){
			System.out.println(ll.get(i));
		}
	}

}
