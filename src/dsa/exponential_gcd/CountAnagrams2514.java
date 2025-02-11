package dsa.exponential_gcd;

import java.util.HashMap;
import java.util.Map;

public class CountAnagrams2514 {

    public static void main(String[] args) {
        System.out.println("Result:"+countAnagrams("b okzojaporykbmq tybq zrztwlolvcyumcsq jjuowpp"));
    }

    public static int countAnagrams(String s) {
        int mod = (int) 1e9 + 7;
        String[] words = s.split(" ");
        long[] ways = new long[words.length];
        for (int i = 0; i < words.length; i++) {
            long nFact = findFact(words[i].length(), mod);
            long rFact = getRepeatedValue(words[i], mod);
            ways[i] = (long) (((nFact % mod) * (getMmi(rFact, mod)%mod)) % mod);

        }
        long result = 1;
        for (int i = 0; i < ways.length; i++) {
            result = ((result%mod) * (ways[i]%mod)) % mod;
        }

        return (int)result;

    }

    private static long getMmi(long rFact, int mod) {
        if (rFact == 1) {
            return 1;
        }
        return (findExp(rFact, mod - 2, mod)) % mod;

    }

    private static long getRepeatedValue(String word, int mod) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : word.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        long result = 1;
        for (int i : frequency.values()) {
            if (i > 1) {
                result = ((result%mod) * (findFact(i, mod)%mod)) % mod;
            }
        }
        return result;

    }

    private static long findFact(int n, int mod) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = ((result%mod) * (i%mod)) % mod;
        }
        return result;
    }

    private static long findExp(long b, int p, int mod) {
        long result = 1;

        while (p > 0) {
            if (p % 2 == 1) {
                result = ((result%mod) * (b%mod)) % mod;
            }
            b = ((b%mod) * (b%mod))%mod;
            p = p / 2;
        }
        return result;
    }
}
