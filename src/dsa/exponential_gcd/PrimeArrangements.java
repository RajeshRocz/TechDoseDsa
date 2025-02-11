package dsa.exponential_gcd;

import java.util.Arrays;

public class PrimeArrangements {

    public static void main(String[] args) {
        System.out.println("Result:"+numPrimeArrangements(100));
    }

    public static int numPrimeArrangements(int n) {

        int mod = (int) 1e9 + 7;

        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        for (int i = 2; i * i <= n; i++) {
            if (isPrime(i)) {
                int j = 2;
                while (i * j <= n) {
                    primes[i * j] = false;
                    j++;
                }
            }
        }

        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                primeCount++;
            }
        }

        return (int) ((findFactorial(primeCount, mod) * findFactorial(n - primeCount, mod)) % mod);
    }

    private static long findFactorial(int n, int modValue) {
        long result = 1;

        for (int i = 2; i <= n; i++) {
            result = (result * i) % modValue;
        }

        return result;
    }

    private static boolean isPrime(int value) {
        for (int i = 2; i * i <= value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
