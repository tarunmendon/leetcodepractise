package src.geekforgeeks;

import java.util.PriorityQueue;

public class StockBuySellAtmostTwoTransaction {
    /*
    https://www.geeksforgeeks.org/best-time-to-buy-and-sell-stock/
    https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/ - This one

     */
    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        StockBuySellAtmostTwoTransaction obj = new StockBuySellAtmostTwoTransaction();
        System.out.println("Stock buy sell max profit:" + obj.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0, minSoFar = prices[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>(2, (a, b) -> b - a);
        for (int i = 1; i < prices.length; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            queue.add(prices[i] - minSoFar);
        }
        for (int i = 0; i < 2; i++) {
            maxProfit += queue.poll();
        }
        return maxProfit;
    }
}
