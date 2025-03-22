package src.geekforgeeks;

public class StockBuySell_MaximizeProfit {
    /* Buy and sell stock any number of times to maximize profit
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
     */

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,4,5};
        StockBuySell_MaximizeProfit obj = new StockBuySell_MaximizeProfit();
        System.out.println("Stock buy sell max profit:" + obj.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }
        return maxProfit;
    }
}
