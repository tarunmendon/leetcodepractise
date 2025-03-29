package src.leetcode.medium;

public class MaximumSubArraySum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2};
        MaximumSubArraySum obj = new MaximumSubArraySum();
        System.out.println(obj.maxSubArray(arr));
    }

    public int maxSubArray(int[] nums) {
        /*Kadane's algorithm*/
        int sum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    /*public int maxSubArray(int[] nums) {
     *//* Implement Kadane's Algo*//*
        int res=nums[0];
        int maxEnding=nums[0];
        for(int i=1;i<nums.length;i++)
        {

            maxEnding=Math.max(maxEnding+nums[i],nums[i]);
            res=Math.max(res,maxEnding);
        }
        return res;
    }*/
}
