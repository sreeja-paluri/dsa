package theory.java;

public class DataTypes {
    public static void main(String[] args) {
        byte b = 100; // 8 bit -128 to 127
        short s = 1000;// 16 bits -32768 to 32767
        int i = 100000; // 32 bits -2^32 to 2^32-1
        long l = 12345678901l;// 64 bit -2^63 to 2^63-1

        float f = 3.14f;// 32 bits single precision that is 1 digit after decimal
        double d = 3.1458;// 64 bits double precision that is 2 digits after decimal

        char c = 'A'; //16 bits store unicode value('u0041') uses only single quotes double are for string
        boolean bool = true; // true or false [logic usage]

        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + bool);

        int apples = 5;
        double pricePerApple = 0.5;
        var totalPrice = apples * pricePerApple;
        System.out.println("total price : $ " + totalPrice);

        int a = 50;
        double ad = a; // automatic conversion no syntax is needed space will be increased expanding
        System.out.println("doubled value " + ad);

        double num = 123.456;
        int num1 = (int) num; //explicit conversion narrowing
        System.out.println("int value " + num1); // data is lost




    }

}
