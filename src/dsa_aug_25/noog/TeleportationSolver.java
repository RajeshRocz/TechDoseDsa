package dsa_aug_25.noog;

import java.util.*;

public class TeleportationSolver {

    // Warm-up: BFS to find minimum teleportations avoiding broken teleporters
    public static int minTeleportations(int n, List<List<Integer>> connections,
                                        Set<Integer> broken, int start, int dest) {
        Queue<int[]> queue = new LinkedList<>(); // {node, steps}
        boolean[] visited = new boolean[n];
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0], steps = curr[1];

            if (node == dest) return steps;

            for (int next : connections.get(node)) {
                if (!visited[next] && !broken.contains(next)) {
                    visited[next] = true;
                    queue.add(new int[]{next, steps + 1});

                }
            }
        }
        return -1; // no path
    }

    // Main question: Dijkstra-like approach minimizing broken teleporters
    public static int minBrokenTeleporters(int n, List<List<Integer>> connections,
                                           Set<Integer> broken, int start, int dest) {
        int[] dist = new int[n]; // number of broken teleporters encountered
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = broken.contains(start) ? 1 : 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, dist[start]});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], cost = curr[1];

            if (node == dest) return cost;
            for (int next : connections.get(node)) {
                int newCost = cost + (broken.contains(next) ? 1 : 0);
                if (newCost < dist[next]) {
                    dist[next] = newCost;
                    pq.add(new int[]{next, newCost});
                }
            }
        }
        return -1; // no path
    }

    // Example usage
    public static void main(String[] args) {
        int n = 7;
        List<List<Integer>> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) connections.add(new ArrayList<>());

        connections.get(0).add(6);
        connections.get(1).addAll(Arrays.asList(2, 5));
        connections.get(2).addAll(Arrays.asList(1, 3, 4, 5));
        connections.get(3).addAll(Arrays.asList(1, 4, 5));
        connections.get(4).add(6);
        connections.get(5).add(6);
        connections.get(6).addAll(Arrays.asList(0, 1));

        Set<Integer> broken = new HashSet<>(List.of(5));
        int start = 1, dest = 6;

        System.out.println("Warm-up (min teleportations avoiding broken): " +
                minTeleportations(n, connections, broken, start, dest));

        System.out.println("Main question (min broken teleporters): " +
                minBrokenTeleporters(n, connections, broken, start, dest));
    }
}

