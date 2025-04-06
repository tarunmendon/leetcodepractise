package src.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        /*
        https://leetcode.com/problems/rotting-oranges/description/

        Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
        Output: 4
         */
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        RottenOranges obj = new RottenOranges();
        System.out.println(obj.orangesRotting(grid));
    }

    record Position(int row, int col) {
    }

    public int orangesRotting(int[][] grid) {
        /*
        https://www.youtube.com/watch?v=y704fEOx0s0
        Use BFS to traverse and get the count
        1. Loop through grid and store rotten row & col in queue.
        Also keep the count of freshOranges
        2. Loop through queue until it not empty and find the adjacent tomatoes that are fresh
         2.a Mark the fresh tomatoes as rotten and store row,col in queue.
         2.b reduce count of fresh orange by 1.
        3. If fresh orange count is 0 then return 0 else return -1.
         */
        Queue<Position> rottenOrangesQueue = new ArrayDeque<Position>();
        int rowSize = grid.length, colSize = grid[0].length;
        int freshOranges = 0, timeTaken = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    rottenOrangesQueue.add(new Position(i, j));
                }

            }
        }

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int row = 0, col = 0;
        while (freshOranges > 0 && rottenOrangesQueue.size() > 0) {
            int queueSize = rottenOrangesQueue.size();
            for (int i = 0; i < queueSize; i++) {
                Position p = rottenOrangesQueue.poll();
                for (int[] pos : directions) {
                    row = pos[0] + p.row();
                    col = pos[1] + p.col();
                    if ((row < 0 || row == rowSize) ||
                            (col < 0 || col == colSize) ||
                            (grid[row][col] != 1)) {
                        continue;
                    }
                    grid[row][col] = 2;
                    rottenOrangesQueue.add(new Position(row, col));
                    freshOranges--;
                }
            }
            timeTaken++;
        }

        return (freshOranges == 0) ? timeTaken : -1;
    }
}
