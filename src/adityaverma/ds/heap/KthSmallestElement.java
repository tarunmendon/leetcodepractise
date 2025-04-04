package src.adityaverma.ds.heap;

import java.util.PriorityQueue;

public class KthSmallestElement {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 10, 4, 3, 20, 15};
        int k = 3;
        KthSmallestElement obj = new KthSmallestElement();
        System.out.println("kth smallest element:" + obj.findKthSmallest(arr, k));
    }

    public int findKthSmallest(int[] nums, int k) {
        /*Sort array by max number
         * 2 representations
         * */
        /*PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>((a, b) -> {
            if (a < b) {
                return 1;
            } else {
                return -1;
            }
        }
        );*/
        /*
        Max priority queue - Max value is stored at the top and small values are stored at
        the bottom.
         */
        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            maxPriorityQueue.add(num);
            if (maxPriorityQueue.size() > k) {
                maxPriorityQueue.poll();
            }
        }
        return maxPriorityQueue.poll();
    }
}
