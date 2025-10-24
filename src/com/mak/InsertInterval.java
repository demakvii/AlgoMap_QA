package com.mak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][]{{1,3},{6,9}}, new int[] {2,5})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}},
        new int[] {4,8})));
    }

    private static int[][] insert(int[][] intervals, int[] newIntervals) {
        List<int[]> intervalList = new ArrayList<>(List.of(intervals));
        intervalList.add(newIntervals);
        intervalList.sort(Comparator.comparingInt(o -> o[0]));

        List<int[]> newIntervalList = new ArrayList<>();
        newIntervalList.add(intervalList.get(0));

        for (int i = 1; i < intervalList.size(); i++) {
            var previous = newIntervalList.get(newIntervalList.size() - 1);
            var current = intervalList.get(i);
            if(previous[1] >= current[0]){
                var newInterval = new int[]{Math.min(previous[0], current[0]), Math.max(previous[1], current[1])};
                newIntervalList.set(newIntervalList.size() - 1, newInterval);
            } else {
                newIntervalList.add(intervalList.get(i));
            }
        }
        return newIntervalList.toArray(new int[0][0]);
    }
}

