package com.mak;

import java.util.*;

public class FindIfPathExistsInGraph {

    public static void main(String[] args) {
        System.out.println(validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));
        System.out.println(validPath(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));
    }

    private static boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Set<Integer>> dataSet = new ArrayList<>();

        for(int i = 0; i < n; i++){
            dataSet.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            dataSet.get(edge[0]).add(edge[1]);
            dataSet.get(edge[1]).add(edge[0]);
        }

        Set<Integer> seen = new HashSet<>();

        System.out.println(dataSet);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while(!queue.isEmpty()) {
            var moveList = dataSet.get(queue.poll());
            if(!moveList.isEmpty()) {
                if(moveList.contains(destination)){
                    return true;
                }
                for(var move : moveList){
                    if(!seen.contains(move)) {
                        seen.add(move);
                        queue.add(move);
                    }
                }
            }

        }

        return false;
    }
}
