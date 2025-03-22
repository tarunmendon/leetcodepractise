package src.leetcode.medium;

public class Problem34_FirstAndLastPosOfElementsInSortedArray {
    public static void main(String[] args) {
        Problem34_FirstAndLastPosOfElementsInSortedArray obj=new Problem34_FirstAndLastPosOfElementsInSortedArray();
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        System.out.println(obj.searchRange(nums,target));
    }


    //Copied from Problem33_SearchInSortedArray
    public int[] searchRange(int[] nums, int target) {
        if (nums == null)
            return new int[]{-1,-1};

        int left = 0, right = nums.length - 1, mid = 0;

        while (left <= right) {
            mid = left + ((right - left) / 2);

            if (nums[mid] == target) {
                int l = mid, r = mid;
                while (l > 0 && nums[l - 1] == target) {
                    l--;
                }
                while (r < nums.length - 1 && nums[r+1] == target) {
                    r++;
                }
                return new int[]{l,r};
            }
            //Check if left is sorted
            if (nums[left] <= nums[mid]) {
                //Check if target in left array
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {
                //Here right is sorted
                if (nums[mid + 1] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return new int[]{-1, -1};
    }
}
