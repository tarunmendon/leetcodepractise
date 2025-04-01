package src.leetcode.medium;

public class MaxProductSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 2, 0, -2, -2, 4};
        MaxProductSubArray obj = new MaxProductSubArray();
        System.out.println(obj.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        /*
        Refer neetcode youtube - https://www.youtube.com/watch?v=lXVy6YWFcRM
        or
         https://www.geeksforgeeks.org/maximum-product-subarray/
            {2, 3, 2, 0, -2, -2, 4} - Output would be -2,-2,4->16
            Output is always calculated as contiguous array product
            1. Maintain the min and max product value for each ith step.
            2. maxProduct=max(maxProduct,currMax);
            3. Do this in every iteration and return maxProduct.
         */
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxProd = nums[0], currMin = nums[0], currMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(nums[i], Math.max(nums[i] * currMax, nums[i] * currMin));
            currMin = Math.min(nums[i], Math.min(nums[i] * currMax, nums[i] * currMin));
            currMax = temp;
            maxProd = Math.max(currMax, maxProd);
        }
        return maxProd;
    }

}
