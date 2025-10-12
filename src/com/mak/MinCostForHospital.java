package com.mak;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MinCostForHospital {

    public static void main(String[] args) {
        int n = 3;
        long[] cost = {1, 3, 5};
        int[][] edges = {
                {1, 2}
                ,{2, 3}
                ,{1, 3}
        };

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        boolean[] seen = new boolean[n];
        long total = 0;

        for (int i = 0 ; i < n; i++){
            if(!seen[i]){
                Deque<Integer> queue = new ArrayDeque<>();
                queue.push(i);
                seen[i] = true;
                long sum = 0;
                long max = Long.MIN_VALUE;
                while (!queue.isEmpty()){
                    int x = queue.pop();   // 1 2
                    sum += cost[x];        // 1 4 9
                    if (cost[x] > max) max = cost[x]; // 1 3 5
                    for(int y : adj.get(x)){  // [2, 3] [3, 3]
                        if (!seen[y]) {
                            seen[y] = true;
                            queue.push(y);
                        }
                    }
                }
                total += (sum - max);
            }
        }

        System.out.println(total);
    }

}
