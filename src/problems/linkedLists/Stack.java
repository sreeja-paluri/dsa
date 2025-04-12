package problems.linkedLists;

class Solution {
    private Stack stack;

    public Solution() {
        stack = new Stack();
    }

    /**
     * Validates if a string of parentheses is balanced.
     *
     * @param s String with parentheses
     * @return True if valid, false otherwise
     */
    public boolean isValid(String s) {
       for(char c : s.toCharArray()){
           if(c == '(' || c == '{' || c =='['){
               stack.push(c);
           }else{
               if(stack.isEmpty()) return false;
               int top = stack.pop();
               if(c == ')' && top != '(') return false;
               if(c == '}' && top != '{') return false;
               if(c == ']' && top != '[') return false;
           }
       }
       return stack.isEmpty();
    }
}

public class Stack {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node top;
//    private Stack stack;
//    public Stack(){
//        stack = new Stack();
//    }

    public void push(int val) {
        Node newNode = new Node(val);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) throw new IllegalStateException("Empty Stack");
        int data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop()); // 2
        System.out.println(stack.pop()); // 1
        System.out.println(stack.isEmpty());
        Solution stack1 = new Solution();
        System.out.println(stack1.isValid("()")); // true
        System.out.println(stack1.isValid("({[]})")); // true
        System.out.println(stack1.isValid("(]")); // false
        System.out.println(stack1.isValid("([)"));

    }

}
