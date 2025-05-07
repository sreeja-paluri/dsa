package theory.java.interfaces;

public class Main {
    public static void main(String[] args){
        Callback c = new Client();
        Client.Callback3 cb = new Client2();
        Client ab = new Client();
        c.callback(9);
        ab.nonMethod();
        cb.callback(2);
    }
}
