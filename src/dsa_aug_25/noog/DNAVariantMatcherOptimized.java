package dsa_aug_25.noog;

import java.util.*;

public class DNAVariantMatcherOptimized {

    // Trie Node
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfVariant = false;
        String variant = null;
    }

    // Build Trie from variants
    private static TrieNode buildTrie(Set<String> variants) {
        TrieNode root = new TrieNode();
        for (String variant : variants) {
            TrieNode node = root;
            for (char ch : variant.toCharArray()) {
                node = node.children.computeIfAbsent(ch, k -> new TrieNode());
            }
            node.isEndOfVariant = true;
            node.variant = variant;
        }
        return root;
    }

    // DFS search with mismatch tolerance
    private static void dfs(TrieNode node, String seq, int index, int mismatches, int maxErrors, Set<String> suspects) {
        if (mismatches > maxErrors) return; // prune path
        if (index == seq.length()) {
            if (node.isEndOfVariant) {
                suspects.add(node.variant);
            }
            return;
        }

        char currentChar = seq.charAt(index);
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            char nextChar = entry.getKey();
            TrieNode child = entry.getValue();
            int newMismatches = mismatches + (currentChar == nextChar ? 0 : 1);
            dfs(child, seq, index + 1, newMismatches, maxErrors, suspects);
        }
    }

    // Main method
    public static Set<String> findSuspectVariants(Set<String> variants, Set<String> sequences, int maxErrors) {
        Set<String> suspects = new HashSet<>();
        TrieNode root = buildTrie(variants);

        for (String seq : sequences) {
            dfs(root, seq, 0, 0, maxErrors, suspects);
        }
        return suspects;
    }

    // Example run
    public static void main(String[] args) {
        Set<String> variants = new HashSet<>(Arrays.asList("TGAAC", "AAGGC", "TGACA"));
        Set<String> sequences = new HashSet<>(Arrays.asList("TAGTC", "TAAGC", "GTTTT", "TGAAC"));

        Set<String> suspects = findSuspectVariants(variants, sequences, 2);
        System.out.println("Suspect Variants: " + suspects);
    }
}

