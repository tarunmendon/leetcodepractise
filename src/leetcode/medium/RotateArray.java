package src.leetcode.medium;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        RotateArray obj = new RotateArray();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        obj.rotate(nums, 3);
        String output = Arrays.stream(nums).mapToObj(val -> new String("" + val)).reduce((n1, n2) -> n1 + "," + n2).get();
        System.out.println("Rotated array:" + output);
    }


    public void rotate(int[] nums, int k) {
    /*
    https://codeandalgo.com/rotate-array/
    1. Reverse the entire array.
    2. Reverse the first k elements.
    3. Reverse the last n-k elements.
     */
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

    }

    private void reverse(int[] nums, int start, int end) {
        int temp = 0;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
