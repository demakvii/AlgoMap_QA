package com.mak;

public class FindClosestNumberToZero {

    public static void main(String[] args) {
        System.out.println(findClosestNumber(new int[] {-4,-2,1,4,8}));
        System.out.println(findClosestNumber(new int[] {2,-1,1}));
    }
    public static int findClosestNumber(int[] nums) {
        // -4, -2, 1, 4, 8
        int closest = nums[0];
        for(int num : nums){
            if(Math.abs(closest) > Math.abs(num)) {
                closest = num;
            }else if(Math.abs(closest) == Math.abs(num) && num > closest){
                closest = num;
            }
        }
        return closest;
    }
}
