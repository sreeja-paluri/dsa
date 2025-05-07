package theory.java.inheritance;

class Test{
    Test() {
        System.out.println("A's constructor");
    }
}

class Test1 extends Test{
    Test1() {
        System.out.println("B's constructor");
    }
}
class Test2 extends Test1{
    Test2() {
        System.out.println("C's constructor");
    }
}
public class ConstructorOrder {
    public static void main(String[] args){
        Test2 c = new Test2();
    }
}
