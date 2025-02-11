package dsa.exponential_gcd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SegmentedSievePrimeMethod {

    public static void main(String[] args) {
        System.out.println("Result:" + getPrimeListUsingSegmentedSieve(16, 32));
    }

    private static List<Integer> getPrimeListUsingSegmentedSieve(int start, int end) {
        List<Integer> primeList = getPrimes((int) Math.sqrt(end));

        boolean[] primes = new boolean[end - start + 1];
        Arrays.fill(primes, true);
        List<Integer> resultList = new ArrayList<>();
        for (int p : primeList) {
            for (int d = (int) Math.ceil((double) start / p); d * p <= end; d++) {
                primes[d * p - start] = false;
            }
        }
        for (int i = 0; i < end - start + 1; i++) {
            if (primes[i]) {
                resultList.add(start + i);
            }
        }

        return resultList;

    }

    private static List<Integer> getPrimes(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            if (isPrime(i)) {
                int j = 2;
                while (j * i <= n) {
                    primes[j * i] = false;
                    j = j + 1;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                primeList.add(i);
            }
        }
        return primeList;
    }

    private static boolean isPrime(int n) {

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
