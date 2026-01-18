package dsa_aug_25.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToGetFood1730 {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'O', 'X', 'O', '#', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'O', 'O', '#', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
        };

        System.out.println("Result: " + shortestPath(grid));
    }


    private static int shortestPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] root = new int[2];
        for (int i = 0; i < m * n; i++) {
            int row = i / m;
            int col = i % m;
            if (grid[row][col] == '*') {
                root[0] = row;
                root[1] = col;
                break;
            }

        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(root);
        int[][] directions = new int[][]{
                {0, -1}, {-1, 0}, {0, 1}, {1, 0}
        };
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();

                if (grid[top[0]][top[1]] == '#') {
                    return steps;
                }
                for (int[] d : directions) {
                    int row = top[0] + d[0];
                    int col = top[1] + d[1];
                    if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col] && grid[row][col] != 'X') {
                        visited[row][col] = true;
                        queue.add(new int[]{row, col});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
