package src.random;

public class SortNumber {


    public static void sort012(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;

        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
           else {//if (arr[mid] == 2)
                swap(arr, mid, high);
                high--;
            }
        }
    }

    public static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    public static void main(String[] args) {
        //Given an array of 0,1 and 2..sort them
        /*Solution in
        https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
         */
        int[] arr = new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        SortNumber.sort012(arr);
        for (int val : arr) {
            System.out.print(val + " ");
        }

    }
}
