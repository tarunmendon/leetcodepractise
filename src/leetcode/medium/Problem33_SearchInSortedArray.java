package src.leetcode.medium;

public class Problem33_SearchInSortedArray {
    public static void main(String[] args) {
        Problem33_SearchInSortedArray obj = new Problem33_SearchInSortedArray();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(obj.search(nums, target));

    }

    //Check recursive way by Nikhil Lohia
    public int search(int[] nums, int target) {
        if (nums == null)
            return -1;

        int left = 0, right = nums.length - 1, mid = 0;

        while (left <= right) {
            mid = left + ((right - left) / 2);

            if(nums[mid]==target)
                return mid;
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
        return -1;
    }
}
