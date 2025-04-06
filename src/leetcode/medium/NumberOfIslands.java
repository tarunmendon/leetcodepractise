package src.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        /*
        Input: grid = [
                ["1,1,1,1,0},
                ["1,1,0,1,0},
                ["1,1,0,0,0},
                ["0,0,0,0,0}
                }
            Output: 1
         */
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        char[][] grid1 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        NumberOfIslands obj = new NumberOfIslands();
        System.out.println("Number of Islands: " + obj.numIslands(grid));
        System.out.println("Number of Islands: " + obj.numIslands(grid1));
    }

    public int numIslands(char[][] grid) {
        /*
        Below contains both DFS and BFS implementation
         */

        int numIslands = 0, rowSize = grid.length, colSize = grid[0].length;
        boolean[][] visited = new boolean[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == '1' && visited[i][j] != true) {
                    visited[i][j] = true;
                    dfs(grid, visited, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int dr = direction[0];
            int dc = direction[1];
            dr = dr + row;
            dc = dc + col;
            if ((dr >= 0 && dr < grid.length) && (dc >= 0 && dc < grid[0].length) && grid[dr][dc] == '1' && visited[dr][dc] != true) {
                visited[dr][dc] = true;
                dfs(grid, visited, dr, dc);
            }
        }
    }

    private void bfs(char[][] grid, boolean[][] visited, int row, int col) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] direction : directions) {
                int dr = curr[0] + direction[0];
                int dc = curr[1] + direction[1];
                if (dr >= 0 && dr < grid.length && dc >= 0 && dc < grid[0].length &&
                        grid[dr][dc] == '1' && !visited[dr][dc]) {
                    visited[dr][dc] = true;
                    queue.offer(new int[]{dr, dc});
                }
            }
        }
    }
}