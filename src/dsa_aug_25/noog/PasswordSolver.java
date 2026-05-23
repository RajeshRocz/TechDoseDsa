package dsa_aug_25.noog;

import java.util.*;

public class PasswordSolver {
    public static void main(String[] args) {
        // Example tuples
        String[][] tuples = {
                {"b", "c", "a"},
                {"b", "c", "d"},
                {"c", "a", "d"}
        };

        String password = findPassword(tuples);
        System.out.println("Password: " + password);
    }

    public static String findPassword(String[][] tuples) {
        // Step 1: Build graph
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();

        for (String[] tuple : tuples) {
            for (String ch : tuple) {
                graph.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
            // a -> b, b -> c
            addEdge(tuple[0], tuple[1], graph, indegree);
            addEdge(tuple[1], tuple[2], graph, indegree);
        }

        // Step 2: Topological sort (Kahn’s algorithm)
        Queue<String> queue = new LinkedList<>();
        for (String ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                queue.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            String node = queue.poll();
            sb.append(node);
            for (String neighbor : graph.get(node)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return sb.toString();
    }

    private static void addEdge(String from, String to, Map<String, Set<String>> graph, Map<String, Integer> indegree) {
        if (graph.get(from).add(to)) {
            indegree.put(to, indegree.get(to) + 1);
        }
    }
}

