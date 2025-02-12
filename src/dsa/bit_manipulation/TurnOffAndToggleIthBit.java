package dsa.bit_manipulation;

public class TurnOffAndToggleIthBit {

    public static void main(String[] args) {
        turnOffIthBit(15, 2);
        turnOnIthBit(11, 2);
        toggleIthBit(11, 2);

    }

    private static void turnOffIthBit(int n, int i) {
        //0011111 turn off i th bit so mask ith bit should be 0 others should 1 so that if and then will get turn off
        System.out.println("Before turn off: " + Integer.toBinaryString(n));
        n = (n & ~(1 << i));
        System.out.println("After turn off: " + Integer.toBinaryString(n));
    }

    private static void turnOnIthBit(int n, int i) {
        System.out.println("Before turn on: " + Integer.toBinaryString(n));
        n = n | (1 << i);
        System.out.println("After turn on: " + Integer.toBinaryString(n));
    }

    private static void toggleIthBit(int n, int i) {
        System.out.println("Before toggle: " + Integer.toBinaryString(n));
        n = (n ^ (1 << i));
        System.out.println("After toggle: " + Integer.toBinaryString(n));
    }
}
