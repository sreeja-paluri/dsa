package problems.linkedLists;

public class SinglyLinkedList {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    //add
    public void add(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        //traversing the list
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;

    }

    //AddFirst
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        newNode.next = head;
        head = newNode;
    }

    //remove
    public void remove(int data) {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
        if (head.data == data) {
            System.out.println("Single number in the list");
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Not Found");
            return;
        }
        current.next = current.next.next;
        size--;
    }

    //removeFirst
    public void removeFirst() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        head = head.next;
        size--;
        System.out.println("Removed first node");
    }

    //size
    public int size() {
        int count = 0;
        if (head == null) {
            System.out.println("Empty size 0");
            return count;
        }
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    //reverse
    public void reverse() {
        Node prev = null;
        Node next = null;
        Node current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    //find middle
    public int middle() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    //print
    public void print() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedList emptyList = new SinglyLinkedList();
        emptyList.print();
        emptyList.remove(10);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.print();
        System.out.println("size " + list.size());
        list.addFirst(5);
        list.print();
        System.out.println("size " + list.size());
        list.removeFirst();
        list.print();
        list.remove(30);
        list.print();
        System.out.println("size after removed " + list.size());
        list.reverse();
        list.print();
        System.out.println("middle number " + list.middle());

    }
}

