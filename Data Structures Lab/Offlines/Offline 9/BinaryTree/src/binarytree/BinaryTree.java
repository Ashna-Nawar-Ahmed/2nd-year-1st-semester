
package binarytree;

public class BinaryTree {
    public static void main(String[] args) {

        System.out.println("Creating Complete Binary Tree...");
        TreeNode rootNode = new TreeNode(40);
        TreeNode node20 = new TreeNode(20);
        TreeNode node10 = new TreeNode(10);
        TreeNode node30 = new TreeNode(30);
        TreeNode node60 = new TreeNode(60);
        TreeNode node50 = new TreeNode(50);
        TreeNode node70 = new TreeNode(70);

        rootNode.left = node20;
        rootNode.right = node60;

        node20.left = node10;
        node20.right = node30;

        node60.left = node50;
        node60.right = node70;
        
        System.out.println("Complete Binary Tree has been created.");
        System.out.println("    "+rootNode.data+"\n   "+"/  \\\n  "+rootNode.left.data+"   "+rootNode.right.data+"\n /  \\ /  \\\n"+
                rootNode.left.left.data+" "+rootNode.left.right.data+" "+rootNode.right.left.data+" "+rootNode.right.right.data);
       
    }  
}
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data) {
        this.data = data;
    }
}