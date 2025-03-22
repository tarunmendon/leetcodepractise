package src.leetcode.medium;

public class Problem55_JumpGame {
    public static void main(String[] args) {
        Problem55_JumpGame obj = new Problem55_JumpGame();
        int[] nums = new int[]{3,2,1,0,4};
       // System.out.println(obj.canJump(nums));
        System.out.println(obj.canJumpNeetCodeSoln(nums));
    }

    public boolean canJumpNeetCodeSoln(int[] nums)
    {
    int goalPost=nums.length-1;
    for(int i=nums.length-1;i>=0;i--)
    {
        if(i+nums[i]>=goalPost)
            goalPost=i;
    }
    return goalPost==0;
    }

    public boolean canJump(int[] nums) {
        return canJump_Helper(nums, 0, nums.length - 1);
    }

    public boolean canJump_Helper(int[] nums, int pos, int target) {
        if (pos == target)
            return true;
        else if (nums[pos] == 0)
            return false;
        else if (nums[pos] + pos <= target) {
            return canJump_Helper(nums, nums[pos] + pos, target) || canJump_Helper(nums, pos + 1, target);
        } else {
            return false;
        }
    }
}
