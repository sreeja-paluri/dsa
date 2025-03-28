package problems.linkedLists;
/** A Single linked list implementation with functions to add, remove, reverse.
 * @author sreeja */
public class SinglyLinkedList {

    /**
     * Represents a Node in a linked list
     */
    public class Node {
        int data;
        Node next;

        /**
         * Constructs a new node with given data
         * @param data integer value stored in the node
         */
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    int size;

    /**
     * Initializes empty list
     */
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Adds a new node with specified data to end of the list
     * @param data Integer value to add
     */
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

    /**
     * Adds a new node with specified data at beginning of the list
     * @param data Integer value to add
     */
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        newNode.next = head;
        head = newNode;
    }

    /**
     * Removes first occurrence of  a node with specified data from the list
     * @param data Integer value to remove.
     */
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

    /**
     * Removes first value from the list
     */
    public void removeFirst() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        head = head.next;
        size--;
        System.out.println("Removed first node");
    }

    /**
     * Returns length of the list.
     * @return int number of elements
     */
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

    /**
     * Reverse order of the linked list
     */
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

    /**
     * Finds middle element of the list using fast and slow pointer
     * @return data of thr middle node (second middle if its even)
     * @throws IllegalStateException if list is empty
     */
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

    /**
     * Merges two sorted linked lists into a single sorted list using a dummy node.
     * @param list1 Head of the first sorted linked list to merge.
     * @param list2 Head of the second sorted linked list to merge.
     * @return Head of the merged sorted linked list, or null if both inputs are null.
     */
    public Node merge(Node list1, Node list2){
        Node dummy = new Node(0);
        Node current = dummy;

        while(list1 != null && list2 != null){
            if(list1.data <= list2.data){
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
    /**
     * Prints Linked lists in readable format
     */
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
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();
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
        list1.add(10);
        list1.add(30);
        list1.add(40);
        list1.add(60);
        list1.print();
        list2.add(20);
        list2.add(30);
        list2.add(50);
        list2.print();
        list1.merge(list1.head , list2.head);
        list1.print();

    }
}

