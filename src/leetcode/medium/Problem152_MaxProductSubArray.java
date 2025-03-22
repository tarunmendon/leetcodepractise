package src.leetcode.medium;

public class Problem152_MaxProductSubArray {
 public static void main(String[] args) {
int[] nums=new int[]{2,3,-2,4};
     Problem152_MaxProductSubArray obj=new Problem152_MaxProductSubArray();
     System.out.println(obj.maxProduct(nums));
 }
    public int maxProduct(int[] nums) {
        /*Solution from GFG -
        https://www.geeksforgeeks.org/maximum-product-subarray/
        */
        int maxProd=nums[0],currMin=nums[0],currMax=nums[0];
        for(int i=1; i<nums.length;i++)
        {
            int temp= Math.max(nums[i],Math.max(currMax*nums[i],currMin*nums[i]));
            currMin=Math.min(nums[i],Math.min(currMax*nums[i],currMin*nums[i]));
            currMax=temp;
            maxProd=Math.max(maxProd,currMax);
        }
        return maxProd;
    }
}