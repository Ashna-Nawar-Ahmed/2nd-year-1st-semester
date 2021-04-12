
package binary.search.tree;

public class BinarySearchTree {

    public static void main(String[] args) {
        Tree bt = new Tree();
        bt.insert(new Node(110));
        bt.insert(new Node(100));
        bt.insert(new Node(150));
        bt.insert(new Node(90));
        bt.insert(new Node(105));
        bt.insert(new Node(210));
        bt.insert(new Node(104));
        bt.insert(new Node(106));
        bt.insert(new Node(220));
        bt.insert(new Node(30));
        bt.insert(new Node(215));
        bt.insert(new Node(221));
        bt.insert(new Node(10));
        if(bt.search(bt.root, 10)== null){
            System.out.println("Not Found");
        }
        else
            System.out.println("Found");
    }
}

class Node {

    int data;
    Node left, right, parent;
    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
        parent = null;
    }   
    public String toString(){
        return "" + this.data +"";
    }
}

class Tree{
    public static Node root;
    public Tree() {
        this.root= null;
    }
    Node search(Node x, int data){
        if(x==null || data==x.data)
            return x;
        if(data<x.data){
            return search(x.left, data);
        }
        else{
            return search(x.right,data);
        }
    }
    void insert(Node z){
        Node y= null;
        Node x= root;
        while(x!=null){
            y=x;
            if(z.data<x.data){
                x=x.left;
            }
            else{
                x=x.right;
            }
        }
        z.parent = y;
        if(y==null){
            root = z;
        }
        else if(z.data<y.data){
            y.left=z;
        }
        else{
            y.right = z;
        }
    }  
}
