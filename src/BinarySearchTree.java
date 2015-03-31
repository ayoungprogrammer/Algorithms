public class BinarySearchTree {

  public class Node {
    int value;
    Node left;
    Node right;
    Node parent;
  
    public Node(int val, Node parent) {
      this.value = val;
      this.left = null;
      this.right = null;
      this.parent = parent;
    }
  
    // Replaces the child node with the replacement one.
    public void replaceChild(Node child, Node replacement) {
      // If replacing left child.
      if (left == child) {
        left = replacement;
      }
      // If replacing right child.
      if (right == child) {
        right = replacement;
      }
      // Set replacement nodes parent.
      if (replacement != null) {
        replacement.parent = this;
      }
    }
  }

  int size;
  Node root;

  public BinarySearchTree() {
    size = 0;
    root = null;
  }

  public boolean insert(int x) {
    // If root is missing.
    if (root == null) {
      root = new Node(x, null);
      size = 1;
      return true;
    }
    Node curTree = root;
    while (curTree != null) {
      // Return if x already exists in set.
      if (x == curTree.value) {
        return false;
      }
      // Traverse left if x is less than current node.
      else if (x < curTree.value) {
        // If left child is empty, create new node.
        if (curTree.left == null) {
          curTree.left = new Node(x, curTree);
          size++;
          return true;
        }
        // Traverse left child.
        curTree = curTree.left;
      }
      // Traverse right otherwise.
      else {
        // If right child is empty, create new node.
        if (curTree.right == null) {
          curTree.right = new Node(x, curTree);
          size++;
          return true;
        }
        // Traverse right child.
        curTree = curTree.right;
      }
    }
    return false;
  }

  public boolean contains(int x) {
    Node curTree = root;
    // Iterate through tree.
    while (curTree != null) {
      // If found element return true.
      if (x == curTree.value) {
        return true;
      }
      // Traverse left tree if x is less than current node.
      else if (x < curTree.value) {
        curTree = curTree.left;
      }
      // Traverse right tree if x is greater then current node.
      else {
        curTree = curTree.right;
      }
    }
    // Return false if not found.
    return false;
  }

  public boolean remove(int x) {
    // Node to be removed.
    Node curNode = root;
  
    // Traverse through binary tree.
    while (curNode != null) {
      // If found element, use node.
      if (x == curNode.value) {
        break;
      }
      // Traverse through left child.
      else if (x < curNode.value) {
        curNode = curNode.left;
      }
      // Traverse through right child.
      else {
        curNode = curNode.right;
      }
    }
    // If node was not found, return false.
    if (curNode == null) {
      return false;
    }
    // Case 1: Removed node has no children.
    if (curNode.left == null && curNode.right == null) {
      // Special case if root.
      if (curNode == root) {
        this.root = null;
      }
      // Replace node with null.
      else {
        curNode.parent.replaceChild(curNode, null);
      }
    }
    // Case 2: Removed node only has a right child.
    else if (curNode.left == null) {
      // Special case if node is root.
      if (curNode == root) {
        root = curNode.right;
        root.parent = null;
      }
      // Replace current node with right child.
      else {
        curNode.parent.replaceChild(curNode, curNode.right);
      }
    }
    // Case 2: Removed node only has a left child.
    else if (curNode.right == null) {
      // Special case if node is root.
      if (curNode == root) {
        root = curNode.left;
        root.parent = null;
      }
      // Replace current node with left child.
      else {
        curNode.parent.replaceChild(curNode, curNode.left);
      }
    }
    // Case 3: Removed node has two children.
    else {
      // Get rightmost of left subtree.
      Node rightmost = curNode.left;
      while (rightmost.right != null) {
        rightmost = rightmost.right;
      }
      // Copy rightmost of left subtree to removed node's.
      curNode.value = rightmost.value;
      // Replace rightmost of left subtree with left child.
      rightmost.parent.replaceChild(rightmost, rightmost.left);
    }
    size--;
    return true;
  }

  public String dfs(Node curTree) {
    if (curTree == null) {
      return "";
    }
    String ret = "";
    // Print left child.
    ret += dfs(curTree.left);
    // Print current node.
    ret += curTree.value;
    ret += ",";
    // Print right child.
    ret += dfs(curTree.right);
    return ret;
  }

  @Override
  public String toString() {
    String ret = "";
    if (root != null) {
      ret += dfs(root);
    }
    return ret.substring(0, ret.length() - 1);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    BinarySearchTree set = new BinarySearchTree();
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
