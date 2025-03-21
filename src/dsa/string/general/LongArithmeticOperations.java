package dsa.string.general;

public class LongArithmeticOperations {

    public static void main(String[] args) {
        System.out.println("Result:"+getMultiplication("124","123"));
    }

    private static String getMultiplication(String s1, String s2){

        int carry=0;
        StringBuilder sb=new StringBuilder();
for(int i=s2.length()-1;i>=0;i++) {
    for (int j = s1.length() - 1; j >= 0; j++) {
            char c1 = s1.charAt(i);
            int d1 = c1 - '0';

            char c2 = s2.charAt(i);
            int d2 = c2 - '0';

        int mulValue = d1 * d2 + carry;
        carry = mulValue / 10;
        sb.append(mulValue % 10);
        i--;
    }
}

        return sb.toString();
    }
}
