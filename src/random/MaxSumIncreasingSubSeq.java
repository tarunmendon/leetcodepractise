package src.random;

import java.util.Arrays;

public class MaxSumIncreasingSubSeq {

    public int maxIncreaseSubSeq(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for (int[] val : dp)
            Arrays.fill(val, 0);

        return maxIncreasingSubSeqMemoization(nums, -1, 0, dp);

    }

    public int maxIncreasingSubSeqMemoization(int[] nums, int prevIndex, int currPos, int[][] dp) {
        if (currPos == nums.length)
            return 0;

        if (dp[prevIndex + 1][currPos] != 0)
            return dp[prevIndex + 1][currPos];

        int taken = 0, notTaken = 0;
        if (prevIndex < 0 || nums[prevIndex] < nums[currPos]) {
            taken = nums[currPos] + (maxIncreasingSubSeqMemoization(nums, currPos, currPos + 1, dp));
        }
        notTaken = maxIncreasingSubSeqMemoization(nums, prevIndex, currPos + 1, dp);
        dp[prevIndex + 1][currPos] = Math.max(taken, notTaken);
        return dp[prevIndex + 1][currPos];
    }

    public static void main(String[] args) {
        /*
        Input: arr[] = [1, 101, 2, 3, 100]
Output: 106
Input: arr[] = [4, 1, 2, 3]
Output: 6
         */
        int[] arr = new int[]{1, 101, 2, 3, 100};
        int[] arr1 = new int[]{4, 1, 2, 3};
        MaxSumIncreasingSubSeq obj = new MaxSumIncreasingSubSeq();
        System.out.println("Max increasing sub-sequence: " + obj.maxIncreaseSubSeq(arr));
        System.out.println("Max increasing sub-sequence: " + obj.maxIncreaseSubSeq(arr1));
    }
}
