
package in_pre_postorder;

import java.util.Stack;

public class In_Pre_PostOrder {

    public static void main(String[] args) {
        BinaryTreePreOrder bi = new BinaryTreePreOrder();
        TreeNode rootNode = createBinaryTree();
        System.out.println("Preorder using Recursive solution:");
        bi.preOrderRecursive(rootNode);
        System.out.println();
        System.out.println("Preorder using Iterative solution:");
        bi.preOrderIterative(rootNode);
        System.out.println();
        System.out.println("===================================");

        BinaryTreeInOrder bi1 = new BinaryTreeInOrder();
        System.out.println("Inorder using Recursive solution:");
        bi1.inOrderRecursive(rootNode);
        System.out.println();
        System.out.println("Inorder using Iterative solution:");
        bi1.inOrderIterative(rootNode);
        System.out.println();
        System.out.println("====================================");
        
        BinaryTreePostOrder bi2 = new BinaryTreePostOrder();
        System.out.println("Postorder using Recursive solution:");
        bi2.postOrderRecursive(rootNode);
        System.out.println();
        System.out.println("Postorder using Iterative solution:");
        bi2.postOrderIterative(rootNode);
        System.out.println();
        System.out.println("====================================");

    }
    public static TreeNode createBinaryTree() {

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

        return rootNode;
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

class BinaryTreePreOrder {

    public void preOrderRecursive(TreeNode root) {
        if (root != null) { 
            System.out.printf("%d ", root.data);
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }
    public void preOrderIterative(TreeNode root) {

        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {

            TreeNode n = stack.pop();
            System.out.printf("%d ", n.data);

            if (n.right != null) {
                stack.push(n.right);
            }
            if (n.left != null) {
                stack.push(n.left);
            }

        }

    }
}
class BinaryTreeInOrder {

    public void inOrderRecursive(TreeNode root) {
        if (root != null) {
            inOrderRecursive(root.left);
            System.out.printf("%d ", root.data);
            inOrderRecursive(root.right);
        }
    }
    public void inOrderIterative(TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode currentNode = root;

        while (!s.empty() || currentNode != null) {

            if (currentNode != null) {
                s.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode n = s.pop();
                System.out.printf("%d ", n.data);
                currentNode = n.right;
            }
        }
    }
}

class BinaryTreePostOrder {

    public void postOrderRecursive(TreeNode root) {
        if (root != null) {
            postOrderRecursive(root.left);
            postOrderRecursive(root.right);
            System.out.printf("%d ", root.data);
        }
    }

    public void postOrderIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode current = root;

        while (true) {

            if (current != null) {
                if (current.right != null) {
                    s.push(current.right);
                }
                s.push(current);
                current = current.left;
                continue;
            }

            if (s.isEmpty()) {
                return;
            }
            current = s.pop();

            if (current.right != null && !s.isEmpty() && current.right == s.peek()) {
                s.pop();
                s.push(current);
                current = current.right;
            } else {
                System.out.print(current.data + " ");
                current = null;
            }
        }
    }
}
