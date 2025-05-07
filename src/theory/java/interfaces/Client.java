package theory.java.interfaces;

public class Client implements Callback, Callback2{
   public void callback(int param){
        System.out.println("implementing class");
    }
    void nonMethod(){
        System.out.println("class method");
    }
    public interface Callback3{
         void callback(int param);
    }
}
