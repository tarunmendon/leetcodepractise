package src.random;

public class MaxSumIncreasingSum {

    public int maxsumIncreaseSum(int[] arr) {
        if (arr == null)
            return -1;
        if (arr.length == 1)
            return arr[0];

        int sum = arr[0];
        int val = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                if (arr[i] + val > val) {
                    val = arr[i] + val;
                } else if (arr[i] > val) {
                    val = arr[i];
                } else {
                    //Ignore
                }
            } else {
                val = arr[i];
            }
            sum = Math.max(sum, val);
        }

        return sum;
    }

    public static void main(String[] args) {
        /*
        Input: arr[] = [1, 101, 2, 3, 100]
Output: 105
Input: arr[] = [4, 1, 2, 3]
Output: 6
         */
        int[] arr = new int[]{1, 101, 2, 3, 100};
        int[] arr1 = new int[]{4, 1, 2, 3};
        MaxSumIncreasingSum obj = new MaxSumIncreasingSum();
        System.out.println("Max increasing sub-sequence: " + obj.maxsumIncreaseSum(arr));
        System.out.println("Max increasing sub-sequence: " + obj.maxsumIncreaseSum(arr1));
    }
}
