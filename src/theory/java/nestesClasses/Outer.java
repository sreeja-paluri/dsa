package theory.java.nestesClasses;

public class Outer {
    int x = 10;
    void test(){
        System.out.println(x);
        Inner inner = new Inner();
        inner.display();
    }

    class Inner{
        int y = 103;
        void display(){
            System.out.println(y);
            System.out.println(x);

        }
    }
    public static void main(String args[]){
        Outer outer = new Outer();
        outer.test();

    }
}
