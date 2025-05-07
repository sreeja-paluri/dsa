package theory.java.inheritance;

abstract class AbstractTest{
    abstract void callme();
}

final class AC extends BC{
    void test (){
        System.out.println("Test");
    }
}

class BC extends AbstractTest{
    void callme(){
        System.out.println("Test Abstract");
    }
}
public class AbstractDemo {
    public static void main(String[] args) {
        BC bc = new BC();
        bc.callme();
    }
}
