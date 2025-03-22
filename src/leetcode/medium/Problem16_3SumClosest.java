package src.leetcode.medium;

import java.util.Arrays;

public class Problem16_3SumClosest {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        Problem16_3SumClosest obj=new Problem16_3SumClosest();
        System.out.println(obj.threeSumClosest(nums,target));
    }

    public int threeSumClosest(int[] nums, int target) {


        if (nums == null || nums.length < 3)
            return -1;

        //Sort array
        Arrays.sort(nums);

        int left = 0, right = 0, sum = 0, prevSum = Integer.MAX_VALUE,finalOutput=0;
        //Set has been added to remove duplicates
        //Fix the first element and find the other 2 elements
        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;

            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }

              if(Math.abs(sum-target)<Math.abs(prevSum))
              {
                  prevSum=sum-target;
                  finalOutput=sum;
              }
            }
        }
        return finalOutput;
    }

}
