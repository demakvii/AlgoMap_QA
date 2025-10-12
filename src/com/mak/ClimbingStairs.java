package com.mak;

public class ClimbingStairs {

    public static void main(String[] args) {
        climbStairs(5);
        climbStairs(3);
        climbStairs(1);
    }

    private static void climbStairs(int n) {
        if(n == 0) {
            System.out.println(n);
            return;
        }
        if(n == 1) {
            System.out.println(n);
            return;
        }
        if(n == 2) {
            System.out.println(n);
            return;
        }
        int[] steps = new int[n + 1];
        steps[0] = 0;
        steps[1] = 1;
        steps[2] = 2;

        for(int i = 3; i <=n; i++){
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        System.out.println(steps[n]);
    }

}
