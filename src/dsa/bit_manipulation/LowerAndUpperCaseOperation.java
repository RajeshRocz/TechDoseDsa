package dsa.bit_manipulation;

public class LowerAndUpperCaseOperation {
    public static void main(String[] args) {
        //a=97,b=98... A=65,B=66...

        System.out.println("ToLowerCase of D: " + toLowerCase('D'));
        System.out.println("ToUpperCase of j: " + toUpperCase('j'));
        System.out.println("ToConvertCase of r: " + convertCase('r'));


    }

    private static char toLowerCase(char c) {
        return (char) (c | (1 << 5));
    }

    private static char toUpperCase(char c) {
        return (char) (c & (~(1 << 5)));
    }

    private static char convertCase(char c) {
        return (char) (c ^ (1 << 5));
    }
}
