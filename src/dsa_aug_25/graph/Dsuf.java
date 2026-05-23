package dsa_aug_25.graph;

import java.util.Arrays;

public class Dsuf {

    public static void main(String[] args) {
        // Example 1: Graph with 5 nodes and 3 edges
        int n1 = 5; int[][] edges1 = { {0, 1}, {1, 2}, {3, 4} };
        System.out.println("Number of components (Example 1): " + countComponents(n1, edges1));
        // Expected output: 2 (components are {0,1,2} and {3,4})
        // Example 2: Graph with 4 nodes and no edges
        int n2 = 4; int[][] edges2 = {};
        System.out.println("Number of components (Example 2): " + countComponents(n2, edges2));
        // Expected output: 4 (each node is its own component)
        // Example 3: Graph with 6 nodes fully connected
        int n3 = 6; int[][] edges3 = { {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5} };
        System.out.println("Number of components (Example 3): " + countComponents(n3, edges3));
        // Expected output: 1 (all nodes connected)
        }

    public static int countComponents(int n, int[][] edges) {

        int[] dsuf = new int[n];
        for (int i = 0; i < n; i++) {
            dsuf[i] = i;
        }

        for (int[] e : edges) {
            dsuf[find(dsuf, e[0])] = find(dsuf, e[1]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (i == find(dsuf, i)) {
                ans++;
            }
        }

        return ans;

    }

    private static int find(int[] dsuf, int x) {
        if (dsuf[x] == x) {
            return x;
        }
        return find(dsuf, dsuf[x]);
    }
}
