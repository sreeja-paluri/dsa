package theory.java.packages;

public class Protection {
    int n = 10;
    private int n_private = 20;
    protected int n_pro = 30;
    public int n_pub = 40;

    public Protection(){
        System.out.println("base constuctors");
        System.out.println(n);
        System.out.println(n_private);
        System.out.println(n_pro);
        System.out.println(n_pub);
    }
}
