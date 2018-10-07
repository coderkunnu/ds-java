package test;

import DataStructure.Tree;
import Elements.TreeNode;

public class TreeTest {
    public static void main(String[] args){
        Tree t = new Tree();
        t.root = new TreeNode(1);
        t.root.left = new TreeNode(2);
        t.root.right = new TreeNode(3);
        t.root.left.left = new TreeNode(4);
        t.root.left.right = new TreeNode(5);
        t.root.right.left = new TreeNode(6);
        t.root.right.right = new TreeNode(7);
    }
}
