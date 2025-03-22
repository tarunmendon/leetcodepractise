package src.leetcode.hard;

import java.util.Arrays;

public class MinCostToCutStick {
/*
From Chatgpt
Ref: https://www.youtube.com/watch?v=EVxTO5I0d7w
 */
    public int minCost(int n, int[] cuts) {
        // Add the boundaries of the stick (0 and n) to the cuts array.
        int[] allCuts = new int[cuts.length + 2];
        System.arraycopy(cuts, 0, allCuts, 1, cuts.length);
        allCuts[0] = 0;
        allCuts[allCuts.length - 1] = n;

        // Sort the cuts array for proper processing.
        Arrays.sort(allCuts);

        // Initialize memoization table.
        int[][] memo = new int[allCuts.length][allCuts.length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Call the recursive function.
        return minCostRec(allCuts, 0, allCuts.length - 1, memo);
    }

    private int minCostRec(int[] cuts, int left, int right, int[][] memo) {
        // Base case: no cuts to be made.
        if (left + 1 >= right) {
            return 0;
        }

        // If already computed, return the result.
        if (memo[left][right] != -1) {
            return memo[left][right];
        }

        int cost = Integer.MAX_VALUE;

        // Try making a cut at every possible position between left and right.
        for (int i = left + 1; i < right; i++) {
            int currentCost = cuts[right] - cuts[left] + minCostRec(cuts, left, i, memo) + minCostRec(cuts, i, right, memo);
            cost = Math.min(cost, currentCost);
        }

        // Store the result in the memoization table.
        memo[left][right] = cost;
        return cost;
    }

    public static void main(String[] args) {
        MinCostToCutStick obj = new MinCostToCutStick();

        // Example input
        int n = 7;
        int[] cuts = new int[]{1, 3, 4, 5};

        System.out.println("Min cost: " + obj.minCost(n, cuts));
    }
}
