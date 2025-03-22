package src.adityaverma.ds.unboundedknapsack;

import java.util.Arrays;

public class CoinChangeMInCoins {
    int[][] t;

    CoinChangeMInCoins(int[][] t) {
        this.t = t;
        for (int[] rows : t) {
            Arrays.fill(rows, -1);
        }
    }

    public int coinChangeMinCoins(int[] coins_wt, int W, int N) {
        /*
        When W == 0, the correct return value should be 0 because no coins are needed to make a sum of 0.
         */
        if (W == 0)
            return 0;
        if (N == 0)
            return Integer.MAX_VALUE-1;

        if (t[N][W] != -1)
            return t[N][W];

        if (coins_wt[N - 1] <= W) {
            t[N][W]=Math.min(1+coinChangeMinCoins(coins_wt,W-coins_wt[N-1],N),
                    coinChangeMinCoins(coins_wt, W, N - 1));
        /*    // Include the coin + Exclude the coin
            int include = coinChangeMinCoins(coins_wt, W - coins_wt[N - 1], N);
            *//*Condition check suggested from chat gpt*//*
            if (include != Integer.MAX_VALUE) { // Check to avoid overflow
                include = 1 + include;
            }
            t[N][W] = Math.min(include, coinChangeMinCoins(coins_wt, W, N - 1));
*/
        } else if (coins_wt[N - 1] > W) {
            t[N][W] = coinChangeMinCoins(coins_wt, W, N - 1);
        }
        return t[N][W];
    }

    public static void main(String[] args) {
        int[] coin = new int[]{1, 2, 3};
        int sum = 5;
        CoinChangeMInCoins obj = new CoinChangeMInCoins(new int[coin.length + 1][sum + 1]);
        System.out.println("Min number of coins in coin change:" + obj.coinChangeMinCoins(coin, sum, coin.length));
        /*Note:This would not work if the coin array has duplicate elements. For ex: coin:{1,1,2}
         * For this, we should remove the duplicates from the array
         * */

    }
}
