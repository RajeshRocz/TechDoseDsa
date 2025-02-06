package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeList {
    public static void main(String[] args) {
        System.out.println("Result:" + getPrimeList(250));
    }

    private static List<Integer> getPrimeList(int n) {

        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        List<Integer> primeList = new ArrayList<>();

        for (int i = 2; i * i < n; i++) {
            if (isPrime(i)) {
                int j = 2 * i;
                while (j < n) {
                    primes[j] = false;
                    j = j + i;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                primeList.add(i);
            }
        }

        return primeList;

    }

    private static boolean isPrime(int n) {
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
