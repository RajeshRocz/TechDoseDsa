package dsa.exponential_gcd;

public class PrimeCheck {
    public static void main(String[] args) {

        System.out.println("isPrime: " + isPrimeCheck(19));

    }

    private static boolean isPrimeCheck(int n) {

        for (int i = 2; i * i < n; i++) {//i<n/2, i*i<n, i<Math.sqrt(n)
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
