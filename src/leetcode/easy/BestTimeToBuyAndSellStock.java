package src.leetcode.easy;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int stockPrice[]=new int[]{7,1,5,3,6,4};
        BestTimeToBuyAndSellStock obj=new BestTimeToBuyAndSellStock();
        System.out.println(obj.maxProfit(stockPrice));
    }
    public int maxProfit(int[] prices) {
        int maxProfit=0,minSoFar=prices[0];
        for(int i=1;i<prices.length;i++) {
            minSoFar=Math.min(minSoFar,prices[i]);
            maxProfit=Math.max(maxProfit,prices[i]-minSoFar);
        }
        return maxProfit;
    }
}
