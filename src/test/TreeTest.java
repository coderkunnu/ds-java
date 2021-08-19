package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import DataStructure.BinaryTree;
import Elements.TreeNode;

public class TreeTest {
    public static void main(String[] args){
    	BinaryTree t = new BinaryTree();
        t.root = new TreeNode(1);
        t.root.left = new TreeNode(2);
        t.root.right = new TreeNode(3);
        t.root.left.left = new TreeNode(4);
        t.root.left.right = new TreeNode(5);
        t.root.right.left = new TreeNode(6);
        t.root.right.right = new TreeNode(7);
//        morrisTraversal(t.root);
        levelOrder(t.root);
        
    }
    
    public static void inorderByRecursion(TreeNode root) {
    	if(root.left != null) {
    		inorderByRecursion(root.left);
    	}
    	System.out.println(root.data);
    	if(root.right != null) {
    		inorderByRecursion(root.right);
    	}
    }
    
    public static void inorderByIteration(TreeNode root) {
    	TreeNode curr = root;
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	s.push(curr);
    	while(!s.isEmpty()) {
    		curr = curr.left;
			if(curr == null) {
				curr = s.pop();
    			System.out.println(curr.data);
				if(curr.right!=null) {
					curr = curr.right;
					s.push(curr);
				}
			}else {
				s.push(curr);
			}
    	}
    	
    	
    }
    
    public static void morrisTraversal(TreeNode root) {
    	TreeNode curr,pre;
    	curr = root;
    	
    	while(curr != null) {
    		if(curr.left == null) {
    			System.out.println(curr.data);
    			curr = curr.right;
    		}else {
    			pre = curr.left;
    			while (pre.right != null && pre.right != curr) {
    				pre = pre.right;
    			}	
    			if (pre.right == null) {
    				pre.right = curr;
    				curr = curr.left;
    			}else {
    				pre.right= null;
    				System.out.println(curr.data);
    				curr = curr.right;
    			}
    		}
    	}
    }
    
    public static void preorderByRecursion(TreeNode root) {
    	System.out.println(root.data);
    	if(root.left != null) {
    		preorderByRecursion(root.left);
    	}
    	if(root.right != null) {
    		preorderByRecursion(root.right);
    	}
    }
    
    public static void preorderByIteration(TreeNode root) {
    	// Code Space
    }
    
    public static void postorderByRecursion(TreeNode root) {
    	if(root.left != null) {
    		postorderByRecursion(root.left);
    	}
    	if(root.right != null) {
    		postorderByRecursion(root.right);
    	}
    	System.out.println(root.data);
    }
    
    public static void postorderByIteration(TreeNode root) {
    	// Code Space
    }
    
    public static void levelOrder(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		TreeNode temp = queue.poll();
    		temp.print();
    		if(temp.left!=null) {
    			queue.add(temp.left);
    		}
    		if(temp.right!=null) {
    			queue.add(temp.right);
    		}
    	}
    }
}