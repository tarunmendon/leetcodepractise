package src.random;

import java.util.Arrays;
import java.util.HashMap;

public class MinSwapstoSortArray {

    /*https://www.hackerrank.com/challenges/minimum-swaps-2
https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
* */
    public static void main(String[] args) {
        /*
        Input: arr[] = [2, 8, 5, 4]
Output: 1
Explanation: Swap 8 with 4 to get the sorted array.


Input: arr[] = [10, 19, 6, 3, 5]
Output: 2
Explanation: Swap 10 with 3 and 19 with 5 to get the sorted array.
         */
        int arr[] = new int[]{1, 3, 4, 5, 6};
        System.out.println(MinSwapstoSortArray.minimumSwaps(arr));

    }

    static int minimumSwaps(int[] arr) {
        HashMap<Integer,Integer> posMap=new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            posMap.put(i,arr[i]);
        }
        Arrays.sort(arr);
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=posMap.get(i)) {
                count++;
            }
        }
        return count/2;
    }
}
