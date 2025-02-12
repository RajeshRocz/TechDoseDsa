package dsa.bit_manipulation;

public class Swap2Numbers {

    public static void main(String[] args) {
        Integer a = 5;
        Integer b = 6;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        swap(a, b);


    }

    private static void swap(Integer a, Integer b) {
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }
}
