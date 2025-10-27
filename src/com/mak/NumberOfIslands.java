package com.mak;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfIslands {

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','0','1','1','1','1','1','1','1','1','1'
                        ,'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','0','0','0','1','1','1','1'
                        ,'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'
                        ,'1','1','1','1','1','1','1','1','1','1'}}));
    }

    private static int numIslands(char[][] grid) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        int count = 0;
        Set<String> seen = new HashSet<>();
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(grid[i][j] == '1' && !seen.contains(i + "-" + j)){
                    count++;
                    bfs(grid, i , j, seen);
                }
            }
        }
        return count;
    }


    private static void bfs(char [][] grid, int i, int j, Set<String> seen){
        var ij = String.format("%d-%d", i, j);
        Queue<String> queue = new LinkedList<>();
        queue.add(ij);
        while (!queue.isEmpty()){
            var currIj = queue.poll();
            var currI = Integer.parseInt(currIj.split("-")[0]);
            var currJ = Integer.parseInt(currIj.split("-")[1]);
            if(currI >= grid.length || currJ >= grid[0].length || seen.contains(currIj)){
                continue;
            }
            seen.add(currIj);
            if(grid[currI][currJ] == '1'){
                queue.add(Math.abs(currI - 1) + "-" + currJ);
                queue.add((currI + 1) + "-" + currJ);
                queue.add((currI) + "-" + (currJ + 1));
                queue.add((currI) + "-" + Math.abs(currJ - 1));
            }
        }
    }

}
