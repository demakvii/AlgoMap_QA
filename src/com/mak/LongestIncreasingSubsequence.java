package com.mak;

import java.util.Arrays;

public class LongestIncreasingSubsequence {


    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {0,1,0,3,2,3}));
    }

    private static int lengthOfLIS(int[] nums) {
        int count = 1;
        int [] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        for(int i = nums.length - 1; i >= 0; i--){
            int max = Integer.MIN_VALUE;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] > nums[i]){
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = Math.max(dp[i], max + 1);
            count = Math.max(count, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return count;
    }
}
