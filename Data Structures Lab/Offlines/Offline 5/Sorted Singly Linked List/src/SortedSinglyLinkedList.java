
import static java.lang.System.exit;
import java.util.Scanner;

class Node {

    protected int data;
    protected Node link;

    public Node() {
        link = null;
        data = 0;
    }

    public Node(int d, Node n) {
        data = d;
        link = n;
    }

    public void setLink(Node n) {
        link = n;
    }

    public void setData(int d) {
        data = d;
    }

    public Node getLink() {
        return link;
    }

    public int getData() {
        return data;
    }
}

class linkedList {

    protected Node start;
    public int size;

    public linkedList() {
        start = null;
        size = 0;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public int getSize() {
        return size;
    }

    public void insert(int val) {
        Node nptr, ptr, tmp = null;
        nptr = new Node(val, null);
        boolean ins = false;
        if (start == null) {
            start = nptr;
        } else if (val <= start.getData()) {
            nptr.setLink(start);
            start = nptr;
        } else {
            tmp = start;
            ptr = start.getLink();
            while (ptr != null) {
                if (val >= tmp.getData() && val <= ptr.getData()) {
                    tmp.setLink(nptr);
                    nptr.setLink(ptr);
                    ins = true;
                    break;
                } else {
                    tmp = ptr;
                    ptr = ptr.getLink();
                }
            }
            if (ins == false) {
                tmp.setLink(nptr);
            }
        }
        size++;
    }

    public void deleteAtPos(int pos) {
        if (pos == 1) {
            start = start.getLink();
            size--;
            return;
        }
        if (pos == size) {
            Node ptr = start;

            for (int i = 1; i < size - 1; i++) {
                ptr = ptr.getLink();
            }
            ptr.setLink(null);
            size--;
            return;
        }
        Node ptr = start;
        pos = pos - 1;
        for (int i = 1; i < size - 1; i++) {
            if (i == pos) {
                Node tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size--;
    }

    public void display() {
        System.out.print("Sorted Singly Linked List = ");
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }
        if (start.getLink() == null) {
            System.out.println(start.getData());
            return;
        }
        Node ptr = start;
        System.out.print(start.getData() + "->");
        ptr = start.getLink();
        while (ptr.getLink() != null) {
            System.out.print(ptr.getData() + "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData() + "\n");
    }
}

public class SortedSinglyLinkedList {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        linkedList list = new linkedList();
        System.out.println("Sorted Singly Linked List Test");
        System.out.println("Sorted Singly Linked List Operations");
        char ch;
        int choice = 0;

        do {
            System.out.println("Enter a choice: 1.Insert 2.Delete 3.Show 4.Exit");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter integer element to insert");
                    list.insert(scan.nextInt());
                    break;
                case 2:
                    System.out.println("Enter position");
                    int p = scan.nextInt();
                    if (p < 1 || p > list.getSize()) {
                        System.out.println("Invalid position\n");
                    } else {
                        list.deleteAtPos(p);
                    }
                    break;
                case 3:
                    list.display();
                    break;
                case 4:
                    exit(0);
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }

        } while (choice <= 4 && choice >= 1);
    }
}
