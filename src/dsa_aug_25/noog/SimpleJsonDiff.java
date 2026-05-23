package dsa_aug_25.noog;

import java.util.*;

public class SimpleJsonDiff {

    // Compute minimal delta between oldDoc and newDoc
    public static Map<String, Object> computeDelta(Map<String, Object> oldDoc, Map<String, Object> newDoc) {
        Map<String, Object> delta = new HashMap<>();

        // Additions or modifications
        for (String key : newDoc.keySet()) {
            Object newVal = newDoc.get(key);
            Object oldVal = oldDoc.get(key);

            if (!oldDoc.containsKey(key)) {
                // New key added
                delta.put(key, newVal);
            } else if (!equalsValue(oldVal, newVal)) {
                // Value changed
                if (newVal instanceof Map && oldVal instanceof Map) {
                    // Recursively compute nested delta
                    Map<String, Object> childDelta = computeDelta(
                            (Map<String, Object>) oldVal,
                            (Map<String, Object>) newVal
                    );
                    if (!childDelta.isEmpty()) {
                        delta.put(key, childDelta);
                    }
                } else {
                    delta.put(key, newVal);
                }
            }
        }

        // Removals
        for (String key : oldDoc.keySet()) {
            if (!newDoc.containsKey(key)) {
                delta.put(key, null); // mark removed
            }
        }

        return delta;
    }

    // Equality check for primitives and null
    private static boolean equalsValue(Object oldVal, Object newVal) {
        if (oldVal == null && newVal == null) return true;
        if (oldVal == null || newVal == null) return false;

        // Only compare directly for primitives
        if (oldVal instanceof String || oldVal instanceof Number || oldVal instanceof Boolean) {
            return oldVal.equals(newVal);
        }

        // For nested maps, defer to recursive diff
        if (oldVal instanceof Map && newVal instanceof Map) {
            return false; // force recursive comparison
        }

        return oldVal.equals(newVal);
    }

    // Compare lists using Livingston (Levenshtein) approach
    private static List<String> diffLists(List<Object> oldList, List<Object> newList) {
        int m = oldList.size();
        int n = newList.size();

        // DP table for edit distance
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (Objects.equals(oldList.get(i - 1), newList.get(j - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j],    // deletion
                            Math.min(dp[i][j - 1], // insertion
                                    dp[i - 1][j - 1]) // substitution
                    );
                }
            }
        }

        // For simplicity, just return edit distance summary
        List<String> result = new ArrayList<>();
        result.add("Edit distance = " + dp[m][n]);
        return result;
    }


    // Example usage
    public static void main(String[] args) {
        Map<String, Object> oldDoc = new HashMap<>();
        oldDoc.put("z", true);
        oldDoc.put("f", null);
        oldDoc.put("a", Map.of("a", "World"));

        Map<String, Object> newDoc = new HashMap<>();
        newDoc.put("z", true); // unchanged
        newDoc.put("f", null); // unchanged
        newDoc.put("a", Map.of("a", "Universe")); // changed
        newDoc.put("x", 42); // new key

        Map<String, Object> delta = computeDelta(oldDoc, newDoc);
        System.out.println("Delta: " + delta);
        // Output: {a={a=Universe}, x=42}
    }
}

