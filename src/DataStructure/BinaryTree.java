package DataStructure;

import Elements.TreeNode;

public class BinaryTree {
    public TreeNode root;
    
    BinaryTree(int key){
    	this.root = new TreeNode(key);
    }
    
    public BinaryTree(){
    	this.root = null;
    }
}
