package theory.java.inheritance;

class A{
    int i ;
    int j;
    void show(){
        System.out.println("i and j:" + i + " " + j);
    }
}

class B extends A{
    int k;

    void show(){
        super.show();
        System.out.println("K: "+ k);
    }
    void sum(){
        System.out.println("sum: "+ (i + j + k));
    }
}
class C extends B{
    int a;
    void show(){
        System.out.println("A: "+ a);
    }
    void sum(){
        super.show();
        System.out.println("sum: "+ (i + j + k + a));
    }
}
public class SimpleInheritance {
    public static void main (String[] args){
        A superOb = new A();
        superOb.i = 10;
        superOb.j = 20;
        superOb.show();
        B subOb = new B();
        subOb.k = 10;
        subOb.i = 30;
        subOb.j = 40;
        subOb.show();
        subOb.sum();
         C superOb1 = new C();
        superOb1.k = 10;
        superOb1.i = 30;
        superOb1.j = 40;
        superOb1.a = 20;
         superOb1.sum();

    }
}
