package com.mak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {

    public static void main(String[] args) {
        threeSum(new int[] {-1,0,1,2,-1,-4});
        threeSum(new int[] {0,1,1});
        threeSum(new int[] {0,0,0});
        threeSum(new int[] {-3, -2, -1 , 0, 1, 2, 3, 4, 5});
    }

    private static void threeSum(int[] nums) {
        Arrays.sort(nums);
        int target = 0;
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            if(nums[i] > 0)
                break;
            if (i > 0 && nums[i - 1] == nums[i]){
                continue;
            }
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == target){
                    result.add(List.of(nums[i],  nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                }
                else if(sum > target){
                    r--;
                }else {
                    l++;
                }
            }
        }
        System.out.println(result);
    }
}
