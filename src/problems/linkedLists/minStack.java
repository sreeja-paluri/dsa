package problems.linkedLists;
public class minStack {
    private class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }
    private Node top;
    private Stack minStack; // Tracks minimums

    public minStack() {
        minStack = new Stack();
    }

    public void push(int val) {
        Node newNode = new Node(val);
        newNode.next = top;
        top = newNode;
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (top == null) throw new IllegalStateException("Stack is empty");
        int val = top.data;
        top = top.next;
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (top == null) throw new IllegalStateException("Stack is empty");
        return top.data;
    }

    public int getMin() {
        if (minStack.isEmpty()) throw new IllegalStateException("Stack is empty");
        return minStack.peek();
    }

    public boolean isEmpty() {
        return top == null;
    }

    // Auxiliary Stack class with peek
    private class Stack {
        private class Node {
            int data;
            Node next;
            Node(int data) { this.data = data; }
        }
        private Node top;

        public void push(int data) {
           Node newNode = new Node(data);
           newNode.next = top;
           top = newNode;
        }

        public int pop() {
            if (top == null) throw new IllegalStateException("Stack is empty");
            int data = top.data;
            top = top.next;
            return data;
        }

        public int peek() {
            if (top == null) throw new IllegalStateException("Stack is empty");
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    public static void main(String[] args) {
        minStack minStack = new minStack();
        minStack.push(3);
        minStack.push(5);
        System.out.println(minStack.getMin()); // 3
        minStack.push(2);
        System.out.println(minStack.getMin()); // 2
        minStack.pop();
        System.out.println(minStack.getMin()); // 3
        System.out.println(minStack.top()); // 5
    }
}