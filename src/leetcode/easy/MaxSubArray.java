package src.leetcode.easy;

public class MaxSubArray {

	 public int maxSubArray(int[] nums) {
	        int maxSum=Integer.MIN_VALUE,sum=0;
	        
	        for(int i=0;i<nums.length;i++)
	        {
	        	sum+=nums[i];
	        	maxSum=Math.max(maxSum, Math.max(sum, nums[i]));
	        	if(nums[i]>sum)
	        		sum=nums[i];
	        }
	 return maxSum;   
	 }
	public static void main(String[] args) {

		int nums[]=new int[] {-2,1,-3,4,-1,2,1,-5,4};
		int nums1[]=new int[] {5,4,-1,7,8};
		MaxSubArray maxSubArray=new MaxSubArray();
		System.out.println(maxSubArray.maxSubArray(nums));
		System.out.println(maxSubArray.maxSubArray(nums1));
		
	}

}
