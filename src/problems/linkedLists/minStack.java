package problems.linkedLists;
public class minStack {
    Stack values;
    Stack mins;

   class Stack{
     int[] arr;
     int top;
     Stack() {
         arr = new int[1000];
         top = -1;
     }
         void push(int val) { arr[++top] = val;}
       int pop(){
        return arr[top--];
     }
     int peek(){ return arr[top];}
       boolean isEmpty(){ return top == -1;}
  }

  public minStack(){
       values = new Stack();
       mins = new Stack();
  }

  public void push(int val){
       values.push(val);
       if(mins.isEmpty() || val <=  mins.peek()){
           mins.push(val);
       }
  }

  public void pop(){
       int val = values.pop();
       if(val == mins.peek()){
           mins.pop();
       }
  }

  public int top(){
       return values.peek();
  }
  public int getMin(){
       return mins.peek();
  }

    public static void main(String[] args) {
        minStack minStack = new minStack();
        minStack.push(3);
        minStack.push(5);
        minStack.push(2);
        minStack.push(1);
        System.out.println(minStack.getMin()); // 1
        System.out.println(minStack.top());    // 1
        minStack.pop();
        System.out.println(minStack.getMin()); // 2
        minStack.pop();
        System.out.println(minStack.getMin()); // 3
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}