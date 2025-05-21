package com.mak;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static List<String> summaryRanges(int... nums) {
        List<String> result = new ArrayList<>();
        var iStart = 0;
        while (iStart < nums.length) {
            var start = nums[iStart];
            var end = start;
            var i = iStart + 1;
            for (; i < nums.length; i++) {
                if (end + 1 == nums[i]) {
                    end = nums[i];
                } else {
                    break;
                }
            }
            iStart = i;
            if(start != end)
                result.add(start + "->" + end);
            else
                result.add(start + "");
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(0,1,2,4,5,7));
        System.out.println(summaryRanges(0,1,2,3,4,5,7));
        System.out.println(summaryRanges(0,2,3,4,6,8,9));
    }

}
