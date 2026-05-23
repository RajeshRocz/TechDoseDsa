package dsa_aug_25.graph;

import java.util.*;

public class DNAVariantFinder {

    public static Set<String> findSuspectVariants(Set<String> variants, Set<String> sequences) {
        Set<String> suspects = new HashSet<>();

        for (String variant : variants) {
            for (String seq : sequences) {
                if (variant.length() != seq.length()) {
                    continue; // must be same length
                }
                int mismatches = countMismatches(variant, seq);
                if (mismatches <= 2) {
                    suspects.add(variant);
                }
            }
        }
        return suspects;
    }

    private static int countMismatches(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2) break; // optimization: stop early
            }
        }
        return count;
    }

    // Demo
    public static void main(String[] args) {
        Set<String> variants = new HashSet<>(Arrays.asList("TGAAC", "AAGGC", "TGACA"));
        Set<String> sequences = new HashSet<>(Arrays.asList("TAGTC", "TAAGC", "GTTTT", "TGAAC"));

        Set<String> suspects = findSuspectVariants(variants, sequences);
        System.out.println("Suspect variants: " + suspects);
    }
}

