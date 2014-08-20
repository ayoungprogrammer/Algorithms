public class TreeSet {

	public class Node {
		int value;
		Node left;
		Node right;
		Node parent;
		public Node(int val,Node parent){
			this.value = val;
			this.left = null;
			this.right = null;
			this.parent = parent;
		}
		public void replaceChild(Node child,Node replacement){
			if(left==child){
				left = replacement;
				if(replacement!= null){
					replacement.parent = this;
				}
			}
			if(right==child){
				right = replacement;
				if(replacement!= null){
					replacement.parent = this;
				}
			}
		}
	}
	
	int size;
	Node root;
	
	public TreeSet(){
		size = 0;
		root = null;
	}
	
	public boolean insert(int x){
		if(root==null){
			root = new Node(x,null);
			size = 1;
			return true;
		}
		Node curTree = root;
		while(curTree != null){
			if(x == curTree.value){
				return false;
			}else if(x < curTree.value){
				if(curTree.left == null){
					curTree.left =  new Node(x,curTree);
					size++;
					return true;
				}
				curTree = curTree.left;
			}else {
				if(curTree.right == null){
					curTree.right = new Node(x,curTree);
					size++;
					return true;
				}
				curTree = curTree.right;
			}
		}
		return false;
	}
	
	public boolean contains(int x){
		Node curTree = root;
		while(curTree!=null){
			if(x==curTree.value){
				return true;
			}else if(x<curTree.value){
				curTree = curTree.left;
			}else{
				curTree = curTree.right;
			}
		}
		return false;
	}
	
	public boolean remove(int x){
		//Get node to remove
		Node curNode = root;
		while(curNode!=null){
			if(x==curNode.value){
				break;
			}else if(x<curNode.value){
				curNode = curNode.left;
			}else{
				curNode = curNode.right;
			}
		}
		if(curNode==null){
			return false;
		}
		//Case 1: leaf node
		if(curNode.left==null && curNode.right==null){
			//if root
			if(curNode==root){
				this.root = null;
			}else{
				curNode.parent.replaceChild(curNode,null);
			}
		}
		//Case 2: one child
		else if(curNode.left==null){
			//If root
			if(curNode==root){
				root = curNode.right;
				root.parent = null;
			}else {
				curNode.parent.replaceChild(curNode,curNode.right);
			}
		}
		else if(curNode.right==null){
			//If root
			if(curNode==root){
				root = curNode.left;
				root.parent = null;
			}else {
				curNode.parent.replaceChild(curNode,curNode.left);
			}
		}
		//Case 3: two children
		else {
			//Get rightmost of left subtree
			Node rightmost = curNode.left;
			while(rightmost.right!=null){
				rightmost = rightmost.right;
			}
			curNode.value = rightmost.value;
			rightmost.parent.replaceChild(rightmost, rightmost.left);
		}
		size--;
		return true;
	}
	
	public String dfs(Node curTree){
		if(curTree == null)return "";
		String ret = "";
		ret += dfs(curTree.left);
		ret += curTree.value;
		ret += ",";
		ret += dfs(curTree.right);
		return ret;
	}
	
	public String toString(){
		String ret = "";
		if(root!=null){
			ret += dfs(root);
		}
		return ret.substring(0,ret.length()-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet set = new TreeSet();
		set.insert(2);
		set.insert(1);
		set.insert(3);
		set.remove(2);
		set.insert(2);
		set.insert(-1);
		set.insert(0);
		set.insert(-2);
		set.remove(-1);
		System.out.println(set.toString());
	}

}
