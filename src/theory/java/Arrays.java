package theory.java;

public class Arrays {
    public static void main(String[] args) {
        //decalration and intialisation
        int[] array = new int[5];
        array[0] = 10;
        array[1] = 20;

        for(int num : array){
            System.out.println(num);
        }

        for(int i = 0 ; i<array.length; i++){
            System.out.println(array[i]);
        }

    }
}
