package src.leetcode.medium;

public class Problem45_JumpGameII {
    public static void main(String[] args) {
        Problem45_JumpGameII obj = new Problem45_JumpGameII();
        int[] nums = new int[]{3, 2, 1, 1, 4};
        // System.out.println(obj.canJump(nums));
        System.out.println(obj.jump(nums));
    }

    public int jump(int[] nums) {
        int l = 0, r = 0, farthest = 0, res = 0;

        while (r < nums.length - 1 ) {
            farthest = 0;
            for (int i = l; i < r + 1; i++) {
               farthest=Math.max(farthest,i+nums[i]);
            }
            l=r+1;
            r=farthest;
            res+=1;
            if(l>r)
                return 0;
        }

        return res;
    }

}
