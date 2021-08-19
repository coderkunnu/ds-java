package Elements;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data){
        this.data = data;
    }
    
    public void print() {
    	System.out.println(this.data);
    }
}
