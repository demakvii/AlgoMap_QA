package com.mak;

import java.util.Arrays;

public class CoinChange {


    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));
        System.out.println(coinChange(new int[]{1,2,5}, 14));
    }

    private static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int [] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                int r = i - coin;
                if(r < 0) break;
                if(dp[i - coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
