package theory.java.interfaces;

public class Client2 implements Client.Callback3{
    public void callback(int param){
        System.out.println("test nested interface");
    }
}
