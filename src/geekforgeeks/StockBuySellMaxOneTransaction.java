package src.geekforgeeks;

public class StockBuySellMaxOneTransaction {
/*
https://www.geeksforgeeks.org/best-time-to-buy-and-sell-stock/
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        StockBuySellMaxOneTransaction obj = new StockBuySellMaxOneTransaction();
        System.out.println("Stock buy sell max profit:" + obj.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0, minSoFar = prices[0];
        for (int i = 1; i < prices.length; i++) {
                minSoFar=Math.min(minSoFar,prices[i]);
                maxProfit=Math.max(maxProfit,prices[i]-minSoFar);
        }
        return maxProfit;
    }
}
