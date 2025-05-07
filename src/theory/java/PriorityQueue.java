package theory.java;

public class PriorityQueue extends QueueLL{

    @Override
    public void enqueue(int data){
        Node newNode = new Node(data);
        size++;
        if( head == null  ){
            newNode.next = head;
            head = newNode;
            if(tail == null) tail = newNode;
        }else {
            Node current = head;
            while( current.next != null ){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            if(newNode.next == null) tail = newNode;
        }
    }
    public int dequeue(){
        if( head == null) throw new IllegalStateException("Empty");
        int data = head.data;
        head = head.next;
        if( head == null) tail = null;
        size --;
        return data;

    }
}

