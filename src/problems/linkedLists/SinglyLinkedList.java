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
     * Detects if the likedlist has a cycle
     * @param n head node of the linked list
     * @return true if there is a cycle otherwise return false
     */
    public boolean hasCycle(Node n){
        if(head == null){
            System.out.println("Empty");
            return false;
        }
        Node fast = n;
        Node slow = n;

        while(fast != null && fast.next != null){
            slow =  slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;

    }

    /**
     * Removes nth node from the end of the list
     * @param n integer number of the node to be removed
     */
    public void removeNthNode( int n){
    Node dummy = new Node(0);
    dummy.next = head;
    Node slow = dummy;
    Node fast = dummy;

    for(int i = 0 ; i< n+1 ; i++){
        fast = fast.next;
    }

    while(fast != null){
        slow = slow.next;
        fast = fast.next;
    }
    slow.next = slow.next.next;
    head =  dummy.next;
    }


    /**
     * Adds data at specified index.
     * @param data Integer to add
     * @param index Position to insert (0-based)
     */
    public void add(int data,int index){
        if(index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node newNode = new Node(data);
        size++;
        if(index == 0){
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        for(int i = 0; i < index-1 ;i++){
            current = current.next; // last will be equal to index-1
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    /**
     * Finds the intersection node of the two linkedlists
     * @param list1 head of the first list
     * @param list2 head of the seconde list
     * @return intersection node or null if no intersection
     */
    public Node getIntersection(Node list1, Node list2){
        Node p1 = list1;
        Node p2 = list2;

        while(p1 != p2){
            p1 = (p1 == null) ? list2 : p1.next;
            p2 = (p2 == null) ? list1 : p2.next;
        }

        return p1;
    }

    /**
     * Checks if the linked list is a palindrome.
     * @return True if palindrome, false otherwise
     */
    public boolean isPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node current = slow;

        while(current != null){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        Node p1 = head;
        Node p2 = prev;
        while(p2 != null){
            if(p1.data != p2.data) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    /**
     *
     */
    public int get(int index){
        if(index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node current = head;
        for(int i = 0; i < index ; i++){
            current = current.next;
        }
        return current.data;
    }

    /**
     * Removes node at specified index.
     * @param index 0-based position to remove
     */
    public void removeAt(int index){
        if(index < 0  || index >= size) throw new IndexOutOfBoundsException();
        size--;
        if(index == 0){
            head = head.next;
            return;
        }
        Node current = head;
        for(int i = 0 ; i < index -1; i++){
            current = current.next;
        }
        current.next = current.next.next;

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
        list1.removeNthNode(2);
        list1.print();
        SinglyLinkedList list3 = new SinglyLinkedList();
        list3.add(10);
        list3.add(30);
        list3.add(40);
        list3.head.next.next.next = list3.head;
        System.out.println("cycle detected  " + list.hasCycle(list1.head));
        System.out.println("cycle detected  " + list.hasCycle(list3.head));
        list1.add(80,3);
        list1.print();
        list1.add(90,3);
        list1.print();
        SinglyLinkedList list4 = new SinglyLinkedList();
        SinglyLinkedList list5 = new SinglyLinkedList();
        list4.add(1);
        list4.add(2);
        list4.add(3);
        list5.add(4);
        Node intersectNode = list4.head.next.next;
        list5.head.next = intersectNode;
        System.out.print("List A: ");
        list4.print(); // 1 -> 2 -> 3 -> null
        System.out.print("List B: ");
        list5.print();
        SinglyLinkedList util = new SinglyLinkedList();
        Node intersection = util.getIntersection(list4.head, list5.head);
        System.out.println("Intersection at: " + (intersection != null ? intersection.data : "null"));
        SinglyLinkedList list7 = new SinglyLinkedList();
        list7.add(1);
        list7.add(2);
        list7.add(2);
        list7.add(1);
        list7.print();
        System.out.println("Palindrome: " + list7.isPalindrome()); // true
        list7.print();
        SinglyLinkedList list6 = new SinglyLinkedList();
        list6.add(1);
        list6.add(2);
        list6.add(3);
        list6.print();
        System.out.println("Palindrome: " + list6.isPalindrome());
        list1.removeAt(2);
        list1.print();
        System.out.println("Index data: " +  list1.get(1));

}
}

