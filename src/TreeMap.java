public class TreeMap {

	class Node{
			Pair pair;
			Node left;
			Node right;
			Node parent;
			public Node(Pair p){
				this.pair = p;
				this.left = null;
				this.right = null;
				this.parent = null;
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
	
	public TreeMap(){
		size = 0;
		root = null;
	}
	
	public boolean insert(Pair p){
		if(root==null){
			root = new Node(p);
			return true;
		}
		Node curTree = root;
		while(curTree != null){
			if(p.key == curTree.pair.key){
				return false;
			}else if(p.key < curTree.pair.key){
				if(curTree.left == null){
					Node newTree = new Node(p);
					newTree.parent = curTree;
					curTree.left = newTree;
					return true;
				}
				curTree = curTree.left;
			}else {
				if(curTree.right == null){
					Node newTree = new Node(p);
					newTree.parent = curTree;
					curTree.right = newTree;
					return true;
				}
				curTree = curTree.right;
			}
		}
		return false;
	}
	
	public Pair get(int key){
		Node curTree = root;
		while(curTree!=null){
			if(key==curTree.pair.key){
				return curTree.pair;
			}else if(key<curTree.pair.key){
				curTree = curTree.left;
			}else{
				curTree = curTree.right;
			}
		}
		return null;
	}
	
	public boolean remove(int key){
		//Get node to remove
		Node curNode = root;
		while(curNode!=null){
			if(key==curNode.pair.key){
				break;
			}else if(key<curNode.pair.key){
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
			curNode.pair = rightmost.pair;
			rightmost.parent.replaceChild(rightmost, rightmost.left);
		}
		size--;
		return true;
	}
	
	public String dfs(Node curTree){
		if(curTree == null)return "";
		String ret = "";
		ret += dfs(curTree.left);
		ret += '('+curTree.pair.key+','+curTree.pair.value+')';
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
