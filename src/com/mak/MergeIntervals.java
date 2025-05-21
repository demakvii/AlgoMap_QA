package com.mak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println("----------");
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {4, 5}})));
        System.out.println("----------");
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {0, 4}})));
        System.out.println("----------");
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {2, 3}})));
    }


    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.deepToString(intervals));
        int start = intervals[0][0];
        int end = intervals[0][1];
        int i = 0;
        List<int[]> result = new ArrayList<>();
        while(i < intervals.length){
            int nxtStart = intervals[i][0];
            int nxtEnd = intervals[i][1];
            if(end >= nxtStart){
                end = Math.max(end, nxtEnd);
                i++;
            }else {
                result.add(new int[]{Math.min(nxtStart, start), end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
            if(i == intervals.length){
                result.add(new int[]{Math.min(nxtStart, start), end});
            }
        }
        return result.toArray(new int[0][0]);
    }

    public static int[][] mergeFailed(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        int[][] result = new int[intervals.length][2];
        int idx = 0;
        for(int i = 1; i < intervals.length; i++){
            if(end >= intervals[i][0] && end <= intervals[i][1]){
                end = intervals[i][1];
            } else {
                idx++;
                start = intervals[i][0];
                end = intervals[i][1];
                i--;
            }
            result[idx][1] = end;
            result[idx][0] = start;
        }
        int[][] finalResult = new int[idx + 1][2];
        for(int i = 0; i < idx+1; i++){
            finalResult[i][0] = result[i][0];
            finalResult[i][1] = result[i][1];
        }
        return finalResult;
    }
}
