package com.mak;

import java.util.Arrays;

public class TwoSum_II_InputArrayIsSorted {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{2,3,4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{-1,0}, -1)));
    }

    private static int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r){
            int sum = numbers[l] + numbers[r];
            if(sum == target) {
                return new int[] {l + 1, r + 1};
            }else if(sum > target){
                r--;
            } else{
                l++;
            }
        }
        throw new RuntimeException("No 2 Sum found with target " + target);
    }

}
