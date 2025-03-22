package src.adityaverma.ds.unboundedknapsack;

import java.util.Arrays;

public class CoinChangeMaxWays {
    int[][] t;

    CoinChangeMaxWays(int[][] t) {
        this.t = t;
        for (int[] rows : t) {
            Arrays.fill(rows, -1);
        }
    }

    public int coinChange(int[] coins_wt, int W, int N) {
        if (W == 0)
            return 1;
        if (N == 0)
            return 0;

        if (t[N][W] != -1)
            return t[N][W];

        if (coins_wt[N - 1] <= W) {
            t[N][W] = coinChange(coins_wt, W - coins_wt[N - 1], N) + coinChange(coins_wt, W, N - 1);
        } else if (coins_wt[N - 1] > W) {
            t[N][W] = coinChange(coins_wt, W, N - 1);
        }
        return t[N][W];
    }

    public static void main(String[] args) {
        int[] coin = new int[]{1, 2, 3};
        int sum = 5;
        CoinChangeMaxWays obj = new CoinChangeMaxWays(new int[coin.length + 1][sum + 1]);
        System.out.println("Max ways for coin change:" + obj.coinChange(coin, sum, coin.length));
        /*Note:This would not work if the coin array has duplicate elements. For ex: coin:{1,1,2}
         * For this, we should remove the duplicates from the array
         * */

    }
}
