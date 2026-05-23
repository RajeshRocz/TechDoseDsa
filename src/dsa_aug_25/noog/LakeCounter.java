package dsa_aug_25.noog;

import java.util.*;

public class LakeCounter {

    public static int countLakes(char[][] image, int[] coord) {
        int rows = image.length;
        int cols = image[0].length;
        int r = coord[0], c = coord[1];

        if (image[r][c] != 'X') {
            return 0; // clicked on water, not land
        }

        // Step 1: Find the island using DFS
        Set<String> island = new HashSet<>();
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{r, c});

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int x = cell[0], y = cell[1];
            String key = x + "," + y;

            if (island.contains(key)) continue;
            if (x < 0 || x >= rows || y < 0 || y >= cols) continue;
            if (image[x][y] != 'X') continue;

            island.add(key);

            stack.push(new int[]{x + 1, y});
            stack.push(new int[]{x - 1, y});
            stack.push(new int[]{x, y + 1});
            stack.push(new int[]{x, y - 1});
        }

        // Step 2: Find lakes inside island
        Set<String> visited = new HashSet<>();
        int lakes = 0;

        for (String cell : island) {
            String[] parts = cell.split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);

            int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                String key = nx + "," + ny;

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols &&
                        image[nx][ny] == '.' && !visited.contains(key)) {

                    // Explore water region
                    boolean touchesOutside = false;
                    Set<String> waterRegion = new HashSet<>();
                    Stack<int[]> waterStack = new Stack<>();
                    waterStack.push(new int[]{nx, ny});

                    while (!waterStack.isEmpty()) {
                        int[] w = waterStack.pop();
                        int wx = w[0], wy = w[1];
                        String wKey = wx + "," + wy;

                        if (visited.contains(wKey)) continue;
                        visited.add(wKey);
                        waterRegion.add(wKey);

                        for (int[] d2 : dirs) {
                            int nx2 = wx + d2[0], ny2 = wy + d2[1];
                            String key2 = nx2 + "," + ny2;

                            if (nx2 < 0 || nx2 >= rows || ny2 < 0 || ny2 >= cols) {
                                touchesOutside = true; // water touches grid boundary → ocean
                            } else if (image[nx2][ny2] == '.' && !visited.contains(key2)) {
                                waterStack.push(new int[]{nx2, ny2});
                            } else if (image[nx2][ny2] == 'X' &&  !island.contains(nx2 + "," + ny2)) {
                                touchesOutside = true; // water touches land outside this island → ocean
                            }
                        }

                    }

                    if (!touchesOutside) {
                        lakes++;
                    }
                }
            }
        }

        return lakes;
    }

    // Quick test
    public static void main(String[] args) {
        char[][] grid = {
                "....................".toCharArray(),
                "....................".toCharArray(),
                "..XXX...............".toCharArray(),
                ".....XXX....XXXXXX..".toCharArray(),
                ".....X.X....X.X.XX..".toCharArray(),
                ".....XXX....XXXXXX..".toCharArray(),
                "....................".toCharArray(),
                "....................".toCharArray()
        };

        System.out.println(countLakes(grid, new int[]{4,5})); // → 1
        System.out.println(countLakes(grid, new int[]{5,6})); // → 1
        System.out.println(countLakes(grid, new int[]{3,12})); // → 2

    }
}

