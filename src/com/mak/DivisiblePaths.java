package com.mak;

public class DivisiblePaths {

    public static void main(String[] args) {
        //n = 5
        //1, 5 -> 1-> 5 : 1
        //n = 4
        // 1,2 -> 1-> 4, 1->2->4 : 2

        int n = 12;
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {   // j * j
                if (i % j == 0) {
                    //int q = i / j;
                    if (j < i) {
                        sum += dp[j];
                    }
                    // if (q != j && q < n) sum += dp[q];
                }
            }
            dp[i] = sum;
        }
        System.out.println(dp[n]);
    }
}
