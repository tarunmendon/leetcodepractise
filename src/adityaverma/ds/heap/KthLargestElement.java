package src.adityaverma.ds.heap;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 10, 4, 3, 20, 15};
        int k = 3;
        KthLargestElement obj = new KthLargestElement();
        System.out.println("kth largest element:" + obj.findKthLargest(arr, k));
    }

    public int findKthLargest(int[] nums, int k) {
        /*Sort array by max to min number but with minimum on top
         * 2 representations
         * */
        /*PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>((a, b) -> {
            if (a < b) {
                return -1;
            } else {
                return 1;
            }
        }
        );*/
        /*
           Min priority queue - small value is stored at the top.
         */
        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            minPriorityQueue.add(num);
            if (minPriorityQueue.size() > k) {
                minPriorityQueue.poll();
            }
        }
        return minPriorityQueue.poll();
    }
}
