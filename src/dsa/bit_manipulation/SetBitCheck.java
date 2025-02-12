package dsa.bit_manipulation;

public class SetBitCheck {
    public static void main(String[] args) {
        int n = 120074832;
        System.out.println("Binary string: " + Integer.toBinaryString(n));
        System.out.println("isIthBitSetBit: " + isIthBitSetBit(n, 4));
        System.out.println("SetBits count: " + getSetBitCount(n));
        System.out.println("SetBits count(fasterWay): " + getSetBitCountFasterWay(n));

    }

    private static int getSetBitCount(int n) {

        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    private static int getSetBitCountFasterWay(int n) {

        int count = 0;
        while (n != 0) {
            n = (n & (n - 1));
            count++;
        }
        return count;
    }

    private static boolean isIthBitSetBit(int n, int i) {
        //1<<ith time then & value and check is it non 0, based on index start we can decide i or i-1

        n = (n & (1 << i - 1));
        return n != 0;
    }
}
