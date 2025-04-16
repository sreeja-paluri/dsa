package problems.linkedLists;

public class StackLinkedList {
    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
        Node top;

        public void push(int data){
            Node newNode = new Node(data);
                newNode.next = top;
                top = newNode;
        }

        public int pop(){
            if(top == null) throw new IllegalStateException();
            int data = top.data;
            top = top.next;
            return data;
        }

        public int peek(){
            if(top == null) throw new IllegalStateException();
            return top.data;
        }

        public boolean isEmpty(){
            return (top == null);
        }


    }
}
