package dsa.bit_manipulation;

public class OddOrEvenNumberCheck {

    public static void main(String[] args) {
        System.out.println("IsEven Or Odd: "+checkAddOrEvenNumber(6));

    }

    private static String checkAddOrEvenNumber(int n){
        int i=(n&1);
        if(i==0){
            return "Even number";
        }
        return "Odd number";
    }
}
