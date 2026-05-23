package dsa_aug_25.noog;

import java.util.*;

class GraphNode {
    char val;
    List<GraphNode> neighbors = new ArrayList<>();
    GraphNode(char val) {
        this.val = val;
    }
}

public class PathInGraph {

    public static boolean hasPath(GraphNode[] graph, String target) {
        for (GraphNode node : graph) {
            if (node.val == target.charAt(0)) {
                if (dfs(node, target, 0, new HashSet<>())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(GraphNode node, String target, int index, Set<GraphNode> visited) {
        if (node.val != target.charAt(index)) return false;
        if (index == target.length() - 1) return true;

        visited.add(node);

        for (GraphNode neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, target, index + 1, visited)) {
                    return true;
                }
            }
        }

        visited.remove(node); // backtrack
        return false;
    }

    public static void main(String[] args) {
        GraphNode A = new GraphNode('A');
        GraphNode B = new GraphNode('B');
        GraphNode C = new GraphNode('C');
        GraphNode D = new GraphNode('D');
        GraphNode E = new GraphNode('E');
        GraphNode G = new GraphNode('G');
        GraphNode H = new GraphNode('H');

        // Correct connections (undirected)
        A.neighbors.addAll(Arrays.asList(B, C, D, G));
        B.neighbors.addAll(Arrays.asList(A, C, E, G));
        C.neighbors.addAll(Arrays.asList(A, B, D, E, G));
        D.neighbors.addAll(Arrays.asList(A, C, E, H));
        E.neighbors.addAll(Arrays.asList(B, C, D));
        G.neighbors.addAll(Arrays.asList(A, B, C));
        H.neighbors.add(D);



        GraphNode[] graph = {A, B, C, D, E, G, H};

        System.out.println(hasPath(graph, "DEBCAGB")); // true
        System.out.println(hasPath(graph, "BGAB"));    // false
        System.out.println(hasPath(graph, "DECDE"));   // false
    }

}
