package src.leetcode.easy;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/
public class MaxProductOf2Elements {
    public int maxProduct(int[] nums) {

        if(nums==null||nums.length==0) {
            return 0;
        }
        int length= nums.length;
        if(length>2)
        {
            Arrays.sort(nums);
        }
        return (nums[length-1]-1)*(nums[length-2]-1);
    }
}
