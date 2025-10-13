package com.mak;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    private static int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length + 1];

        for(int i = 2; i<= cost.length; i++){
            dp[i] = Math.min((dp[i - 2] + cost[i - 2]), (dp[i - 1] + cost[i - 1]));
        }
        return dp[cost.length];
    }
}
