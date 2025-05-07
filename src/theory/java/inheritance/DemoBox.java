package theory.java.inheritance;

class Box{
   private double width;
   private double height;
   private double depth;

    //constructor used when all dimensions are specified
    public Box(double w, double h, double d){
        width = w;
        height = h;
        depth = d;
    }

    //constructs clone of an object
    public Box(){
        width = -1;
        height = -1;
        depth = -1;
    }

    //constructor used when no dimensions are specified
    public Box(Box o){
       width = o.width;
       height = o.height;
       depth = o.depth;
    }

     double volume (){
        return width * height * depth;
    }
}

class BoxWeight extends Box{
    double boxWeight ;
    BoxWeight (double w, double h, double d, double bw){
      super(w,d,h);
        System.out.println(super.volume());
        boxWeight = bw;

    }
    BoxWeight (){
        super();
        System.out.println(super.volume());

    }
}

class cost extends BoxWeight{
    int amt;

}
public class DemoBox {
    public static void main(String[] args){
        BoxWeight box = new BoxWeight(10,20, 30, 33.4);
        BoxWeight box1 = new BoxWeight();
        double vol;
        vol = box.volume();
        System.out.println(vol);
        System.out.println(box.boxWeight);
    }
}
