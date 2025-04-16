package problems.linkedLists;

public class QueueStacks {
    Stack in;
    Stack out;
    class Stack{
        int[] arr;
        int top;

        public Stack(){
            arr = new int[1000];
            top = -1;
        }

        void push(int val) {
             arr[++top] = val;
        }

        int pop(){
            return arr[top--];
        }

        int peek(){
            return arr[top];
        }

        boolean isEmpty(){
            return top == -1;
        }
    }

    public QueueStacks(){
        in = new Stack();
        out = new Stack();
    }
    int top = -1;
    public void push(int val){
        in.push(val);
    }

    public int pop(){
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public int peek(){
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean isEmpty(){
        return in.isEmpty() && out.isEmpty();
    }

    public static void main(String[] args){
        QueueStacks queue = new QueueStacks();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());  // 1
        System.out.println(queue.peek()); // 2
        queue.push(4);
        System.out.println(queue.pop());  // 2
        System.out.println(queue.isEmpty());
    }
}
