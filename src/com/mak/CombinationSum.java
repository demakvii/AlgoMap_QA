package com.mak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        var result = combinationSum(new int[] {2, 3, 5}, 8);
        result.forEach(t -> System.out.print(Arrays.toString(t.toArray())));
        System.out.println();
        result = combinationSum(new int[] {2, 3, 5}, 2);
        result.forEach(t -> System.out.print(Arrays.toString(t.toArray())));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combination(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private static void combination(int[] candidates, int target, int idx, int total, List<Integer> combo,
                                    List<List<Integer>> result){
        if(target == total){
            result.add(new ArrayList<>(combo));
            return;
        }
        if(total > target || idx >= candidates.length){
            return;
        }

        combo.add(candidates[idx]);
        combination(candidates, target, idx, total + candidates[idx], combo, result);
        combo.remove(combo.size() - 1);
        combination(candidates, target, idx + 1, total, combo, result);
    }
}
