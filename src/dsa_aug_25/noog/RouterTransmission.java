package dsa_aug_25.noog;

import java.util.*;

class RouterTransmission {
    static class Router {
        int x, y;
        String name;
        Router(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }
    }

    // Calculate Euclidean distance
    static double distance(Router a, Router b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    // Build adjacency list based on max range
    static Map<Router, List<Router>> buildGraph(List<Router> routers, double maxRange) {
        Map<Router, List<Router>> graph = new HashMap<>();
        for (Router r : routers) {
            graph.put(r, new ArrayList<>());
        }
        for (int i = 0; i < routers.size(); i++) {
            for (int j = i + 1; j < routers.size(); j++) {
                Router a = routers.get(i);
                Router b = routers.get(j);
                if (distance(a, b) <= maxRange) {
                    graph.get(a).add(b);
                    graph.get(b).add(a);
                }
            }
        }
        return graph;
    }

    // BFS to check connectivity
    static boolean canTransmit(Router source, Router destination, Map<Router, List<Router>> graph) {
        Set<Router> visited = new HashSet<>();
        Queue<Router> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            Router current = queue.poll();
            if (current == destination) return true;
            for (Router neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }

    // DFS recursive search
    static boolean dfs(Router current, Router destination,
                       Map<Router, List<Router>> graph, Set<Router> visited) {
        if (current == destination) return true;
        visited.add(current);

        for (Router neighbor : graph.get(current)) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, destination, graph, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Router A = new Router("A", 0, 4);
        Router B = new Router("B", 0, 7);
        Router C = new Router("C", 3, 9);
        Router D = new Router("D", 4, 9);

        List<Router> routers = Arrays.asList(A, B, C, D);
        double maxRange = 3.0;

        Map<Router, List<Router>> graph = buildGraph(routers, maxRange);

        boolean result = canTransmit(A, D, graph);
        System.out.println("Transmission possible from A to D? " + result);

        result = canTransmit(A, B, graph);
        System.out.println("Transmission possible from A to B? " + result);
        System.out.println("++===========");

        result = dfs(A, D, graph, new HashSet<>());
        System.out.println("Transmission possible from A to D? " + result);

        result = dfs(A, B, graph, new HashSet<>());
        System.out.println("Transmission possible from A to B? " + result);
    }
}

