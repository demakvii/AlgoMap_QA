package com.mak;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf1(1, 2, 3, 4)));
        System.out.println(Arrays.toString(productExceptSelf1(-1,1,0,-3,3)));
        System.out.println(Arrays.toString(productExceptSelf1(0,0)));
        System.out.println(Arrays.toString(productExceptSelf1(0,0, 1)));
    }

    public static int[] productExceptSelf1(int... nums) {
        int n = nums.length;
        int[] result = new int[n];

        int leftProduct = 1;
        int rightProduct = 1;

        // Calculate left products
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }
        System.out.println(Arrays.toString(result));
        // Calculate right products and final result
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        System.out.println(Arrays.toString(result));

        return result;
    }
    public static int[] productExceptSelf(int... nums) {
        var product = 1;
        var zeroCount = 0;
        for(var num : nums){
            if (num != 0)
                product *= num;
            else
                zeroCount++;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                if(zeroCount == 1)
                    nums[i] = product;
                else
                    nums[i] = 0;
            else {
                if(zeroCount > 0)
                    nums[i] = 0;
                else
                    nums[i] = product / nums[i];
            }
        }
        return nums;
    }

}
