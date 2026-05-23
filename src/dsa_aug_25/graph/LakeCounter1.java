package dsa_aug_25.graph;

import java.util.*;

public class LakeCounter1 {
    static int rows, cols;
    static char[][] grid;
    static boolean[][] visited;

    // Directions for 4-neighbor traversal
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public static int countLakes(char[][] image, int startRow, int startCol) {
        grid = image;
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];

        // Step 1: Flood-fill island
        Set<int[]> island = new HashSet<>();
        int[] bounds = {startRow, startRow, startCol, startCol}; // minR, maxR, minC, maxC
        floodFillIsland(startRow, startCol, island, bounds);

        // Step 2: Find lakes inside bounding box
        boolean[][] waterVisited = new boolean[rows][cols];
        int lakes = 0;

        for (int r = bounds[0]; r <= bounds[1]; r++) {
            for (int c = bounds[2]; c <= bounds[3]; c++) {
                if (grid[r][c] == '.' && !waterVisited[r][c]) {
                    if (isLake(r, c, bounds, waterVisited)) {
                        lakes++;
                    }
                }
            }
        }
        return lakes;
    }

    private static void floodFillIsland(int r, int c, Set<int[]> island, int[] bounds) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0], cc = cur[1];
            island.add(cur);

            bounds[0] = Math.min(bounds[0], cr);
            bounds[1] = Math.max(bounds[1], cr);
            bounds[2] = Math.min(bounds[2], cc);
            bounds[3] = Math.max(bounds[3], cc);

            for (int[] d : dirs) {
                int nr = cr + d[0], nc = cc + d[1];
                if (nr>=0 && nr<rows && nc>=0 && nc<cols &&
                        !visited[nr][nc] && grid[nr][nc]=='X') {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr,nc});
                }
            }
        }
    }

    private static boolean isLake(int r, int c, int[] bounds, boolean[][] waterVisited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        waterVisited[r][c] = true;
        boolean touchesBoundary = false;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0], cc = cur[1];

            // If water touches bounding box edge → ocean
            if (cr == bounds[0] || cr == bounds[1] || cc == bounds[2] || cc == bounds[3]) {
                touchesBoundary = true;
            }

            for (int[] d : dirs) {
                int nr = cr + d[0], nc = cc + d[1];
                if (nr>=bounds[0] && nr<=bounds[1] && nc>=bounds[2] && nc<=bounds[3]) {
                    if (!waterVisited[nr][nc] && grid[nr][nc]=='.') {
                        waterVisited[nr][nc] = true;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
        return !touchesBoundary;
    }

    // Example usage
    public static void main(String[] args) {
        char[][] image = {
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','X','X','X','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','X','X','X','X','X','X','.','.','.','.'},
                {'.','.','.','.','.','X','X','X','.','.','.','X','.','X','X','.','.','.','.','.'},
                {'.','.','.','.','.','X','.','X','.','.','.','X','X','X','X','X','.','.','.','.'},
                {'.','.','.','.','.','X','X','X','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}
        };

        System.out.println(countLakes(image, 2, 2));  // → 0
        System.out.println(countLakes(image, 6, 5));  // → 1
        System.out.println(countLakes(image, 12, 5)); // → 2
    }
}

