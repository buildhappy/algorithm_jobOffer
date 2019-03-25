package com.buildhappy.leedcode.medium;

import com.buildhappy.leedcode.Task;

/**
 * https://leetcode.com/problems/friend-circles/
 *
 * 这道题让我们求朋友圈的个数，题目中对于朋友圈的定义是可以传递的，比如A和B是好友，B和C是好友，
 * 那么即使A和C不是好友，那么他们三人也属于一个朋友圈。
 * 那么比较直接的解法就是DFS搜索，对于某个人，遍历其好友，然后再遍历其好友的好友，
 * 那么我们就能把属于同一个朋友圈的人都遍历一遍，我们同时标记出已经遍历过的人，
 * 然后累积朋友圈的个数，再去对于没有遍历到的人在找其朋友圈的人，这样就能求出个数
 */
public class _547_FriendCircles extends Task {
    @Override
    public void run() {

    }

    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            dfs(M, visited, i);
            count++;
        }
        return count;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}
