package theory.java;

public class QueueLL {
     class Node {
         int data;
         Node next;

         public Node(int data) {
             this.data = data;
             this.next = null;
         }
     }
         Node head, tail ;
         int size;

         public void enqueue(int data){
             Node newNode = new Node(data);
             size++;
             if(tail == null){
                 head = tail = newNode;
             }else{
                 tail.next = newNode;
                 tail = newNode;
             }
         }

         public int dequeue(){
             if(head == null) throw new IllegalStateException("Empty");
             int data = head.data;
             head = head.next;
             size--;
             if(head == null) tail = null;
             return data;
         }

         public int size() {
             return size;
         }

         public int getHeadData(){
             return head.data;
     }

     public boolean isEmpty(){
             return head == null;
     }

     public Iterator iterator(){
             return new Iterator();
     }
     public class Iterator {
         private Node current = head;

         public boolean hasNext() {
             return current != null;
         }

         public int next() {
             if (!hasNext()) throw new IllegalStateException("Empty");
             int data = current.data;
             current = current.next;
             return data;
         }
     }
}
