package dsa_aug_25.CapitalOne;

import java.util.*;

public class AccessCodeFragmentsDfs {
    public static int countWays(int[] fragments, int accessCode) {
        String code = String.valueOf(accessCode);

        // Track counts of each fragment
        Map<String, Integer> fragmentCount = new HashMap<>();
        for (int f : fragments) {
            fragmentCount.merge(String.valueOf(f), 1, Integer::sum);
        }

        System.out.println(fragmentCount);

        return dfs(code, 0, fragmentCount);
    }

    private static int dfs(String code, int index, Map<String, Integer> fragmentCount) {
        if (index == code.length()) {
            return 1; // reached the end successfully
        }

        int ways = 0;
        for (String frag : fragmentCount.keySet()) {
            int count = fragmentCount.get(frag);
            if (count > 0 && code.startsWith(frag, index)) {
                // use this fragment once
                fragmentCount.put(frag, count - 1);
                ways += dfs(code, index + frag.length(), fragmentCount);
                // backtrack
                fragmentCount.put(frag, count);
            }
        }
        return ways;
    }

    public static void main(String[] args) {
        int[] fragments = {1,212,12, 12, 1, 21};
        int accessCode = 1212;
        System.out.println("Number of ways: " + countWays(fragments, accessCode));
    }
}
