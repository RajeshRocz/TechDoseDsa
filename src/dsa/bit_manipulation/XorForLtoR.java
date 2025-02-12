package dsa.bit_manipulation;

public class XorForLtoR {
    public static void main(String[] args) {
        //Find XOR(L,R) this will have pattern of XOR value if %4=0 result n,
        // %4=1 result 1, %4=2 result n+1, %4=3 result 0
        //XOR(L,R)=XOR(1,L-1)^XOR(1,R)
        int result = getXorValue(3, 12);
        System.out.println("XOR(3,12): " + result);
        System.out.println("Binary value: " + Integer.toBinaryString(result));
    }

    private static int getXorValue(int l, int r) {
        int lLower = getValue(l - 1);
        int rValue = getValue(r);
        return (lLower ^ rValue);
    }

    private static int getValue(int n) {
        return switch (n % 4) {
            case 1 -> 1;
            case 2 -> n + 1;
            case 3 -> 0;
            default -> n;

        };
    }
}
