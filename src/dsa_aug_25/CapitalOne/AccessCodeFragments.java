package dsa_aug_25.CapitalOne;

import java.util.*;

public class AccessCodeFragments {
    public static int countWays(int[] fragments, int accessCode) {
        String code = String.valueOf(accessCode);
        Set<String> fragmentSet = new HashSet<>();
        for (int f : fragments) {
            fragmentSet.add(String.valueOf(f));
        }

        int n = code.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // base case: empty prefix

        for (int i = 0; i < n; i++) {
            if (dp[i] > 0) {
                for (int j = i + 1; j <= n; j++) {
                    String sub = code.substring(i, j);
                    if (fragmentSet.contains(sub)) {
                        dp[j] += dp[i];
                    }
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] fragments = {1, 12, 23, 34, 345};
        int accessCode = 12345;
        System.out.println("Number of ways: " + countWays(fragments, accessCode));
    }
}

