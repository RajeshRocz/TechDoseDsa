package dsa.bit_manipulation;

public class AndForLtoR {
    public static void main(String[] args) {

        int result = getAndForLtoR(175, 185);
        System.out.println("getAndForLtoR: " + result);
        System.out.println("Binary value: " + Integer.toBinaryString(result));
    }

    private static int getAndForLtoR(int l, int r) {
        //Get AND value for l to r, if we and for all operation from left to right if bit value is same for then bits not rotated,
        // so we have to check from left until value equals rest of right item will be 0s
        // so we have to right shift both values until both equals so that shifted bits will be removed and then right shift

        int shiftedBitCount = 0;
        while (l != r) {
            l = l >> 1;
            r = r >> 1;
            shiftedBitCount++;

        }
        return l << shiftedBitCount; //can use l or r
    }
}
