package com.mak;

public class JumpGame {

    public static void main(String[] args) {
        System.out.println(canJump(new int[] {3,0,8,2,0,0,1}));
    }

    private static boolean canJump(int[] nums) {
        int n = nums.length;
        int idx = n - 1;
        for(int i = n - 1; i >=0; i--){
            if(i + nums[i] >= idx){
                idx = i;
            }
        }

        return idx == 0;
    }
}
