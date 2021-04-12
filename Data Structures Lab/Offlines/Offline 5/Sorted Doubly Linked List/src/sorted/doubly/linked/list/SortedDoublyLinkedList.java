package sorted.doubly.linked.list;

import static java.lang.System.exit;
import java.util.Scanner;

class Node {

    protected int data;
    protected Node next, prev;

    public Node() {
        next = null;
        prev = null;
        data = 0;
    }

    public Node(int d, Node n, Node p) {
        data = d;
        next = n;
        prev = p;
    }

    public void setLinkNext(Node n) {
        next = n;
    }

    public void setLinkPrev(Node p) {
        prev = p;
    }

    public Node getLinkNext() {
        return next;
    }

    public Node getLinkPrev() {
        return prev;
    }

    public void setData(int d) {
        data = d;
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
        Node nptr = new Node(val, null, null);
        Node tmp, ptr;
        boolean ins = false;
        if (start == null) {
            start = nptr;
        } else if (val <= start.getData()) {
            nptr.setLinkNext(start);
            start.setLinkPrev(nptr);
            start = nptr;
        } else {
            tmp = start;
            ptr = start.getLinkNext();
            while (ptr != null) {
                if (val >= tmp.getData() && val <= ptr.getData()) {
                    tmp.setLinkNext(nptr);
                    nptr.setLinkPrev(tmp);
                    nptr.setLinkNext(ptr);
                    ptr.setLinkPrev(nptr);
                    ins = true;
                    break;
                } else {
                    tmp = ptr;
                    ptr = ptr.getLinkNext();
                }
            }
            if (!ins) {
                tmp.setLinkNext(nptr);
                nptr.setLinkPrev(tmp);
            }
        }
        size++;
    }

    public void deleteAtPos(int pos) {
        if (pos == 1) {
            if (size == 1) {
                start = null;
                size = 0;
                return;
            }
            start = start.getLinkNext();
            start.setLinkPrev(null);
            size--;
            return;
        }
        if (pos == size) {
            Node ptr = start;

            for (int i = 1; i < size - 1; i++) {
                ptr = ptr.getLinkNext();
            }
            ptr.setLinkNext(null);
            size--;
            return;
        }
        Node ptr = start.getLinkNext();
        for (int i = 2; i <= size; i++) {
            if (i == pos) {
                Node p = ptr.getLinkPrev();
                Node n = ptr.getLinkNext();

                p.setLinkNext(n);
                n.setLinkPrev(p);
                size--;
                return;
            }
            ptr = ptr.getLinkNext();
        }
    }

    public void display() {
        System.out.print("Doubly Linked List = ");
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }
        if (start.getLinkNext() == null) {
            System.out.println(start.getData());
            return;
        }
        Node ptr = start;
        System.out.print(start.getData() + " <-> ");
        ptr = start.getLinkNext();
        while (ptr.getLinkNext() != null) {
            System.out.print(ptr.getData() + " <-> ");
            ptr = ptr.getLinkNext();
        }
        System.out.print(ptr.getData() + "\n");
    }
}

public class SortedDoublyLinkedList {

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
