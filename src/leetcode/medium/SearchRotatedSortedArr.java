package src.leetcode.medium;

public class SearchRotatedSortedArr {

    public static void main(String args[]) {
        int[] nums = new int[]{7, 8, 9, 10, 11, 1, 2, 3};
        SearchRotatedSortedArr obj = new SearchRotatedSortedArr();

        //System.out.println(obj.findPivot(nums));
        System.out.println(obj.findPivot1(nums));
        System.out.println(obj.search(nums, 3));
    }

    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        int left = 0, right = 0, mid = 0;
        if (target > nums[pivot] && target <= nums[nums.length - 1]) {
            left = pivot + 1;
            right = nums.length - 1;
        } else {
            right = pivot - 1;
        }

        while (left <= right) {
            mid = (left + right) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) //if element is larger than mid then go right
                left = mid + 1;
            else
                right = mid - 1;

        }
        return -1;
    }

    public int findPivot(int nums[]) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1, midPoint = -1;

        while (left < right) {
            midPoint = left + (right - left) / 2;

            if (nums[midPoint] > nums[right]) {
                left = midPoint + 1;
            } else {
                right = midPoint;
            }

        }
        return left;
    }


    public int findPivot1(int nums[]) {
		/*
		 * 
		 * 1. If array[0] <= array[length of array - 1], it means the array is not rotated, so return 0.
		   2. Initialize start = 0, end = length of array - 1.
		   3. Repeat following steps till start <= end
   				a). Set mid = (start+end)/2.
   				b). If mid+1 is pivot, then break.
   				c). If array[start] <= array[mid], it means from start to mid, all elements are in sorted order.
       				Set start = mid+1, so that we look for pivot in second half of the array.
   				d). Else set end = mid-1, to look for pivot in first half.
		 */
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1, midPoint = -1;

        if (nums[left] <= nums[right])
            return 0;
        while (left <= right) {
            midPoint = (left + right) / 2;

            if (nums[midPoint] > nums[midPoint + 1]) {
                return midPoint + 1;
            }
            if (nums[left] <= nums[midPoint])
                left = midPoint + 1;
            else
                right = midPoint - 1;

        }
        return left;
    }
}
