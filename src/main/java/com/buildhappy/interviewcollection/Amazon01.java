package com.buildhappy.interviewcollection;

/**
 * 输入一个由0、1组成的二维矩阵，找出其中连通的1的个数
 * 比如：
 * 输入：
 * 0 0 0 0
 * 0 1 1 0
 * 0 1 1 0
 * 0 0 0 0
 * 输出：1
 * 解析：因为矩阵中的1都是相连的(只要上下左右有一个方向相通就行)
 * 输入
 * 0 0 0 0
 * 0 1 0 0
 * 0 0 1 0
 * 0 0 0 0
 * 输出：2
 * @autor caijianfu
 * @date 2015年10月11日09:41:31
 */
public class Amazon01 {
    public static int countHomes(int[][] grid){
        int ans = 0;
        int r = grid.length;
        int c = grid[0].length;
        boolean vis[][] = new boolean[r + 10][c + 10];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    visit(grid , vis , i , j , r , c);
                    ans++;
                }
            }
        }
        return ans;
    }
    public static void visit(int[][] grid, boolean[][] vis,int x,int y,int r,int c){
        int row[] = {1 , -1 , 0 , 0};
        int col[] = {0 , 0 , 1 , -1};
        for(int i = 0; i < 4; i++){
            if(x + row[i] < c && x + row[i] >= 0 && y + col[i] < c && y + col[i] >= 0
                    && grid[x + row[i]][y + col[i]] == 1 && !vis[x + row[i]][y + col[i]]){
                vis[x + row[i]][y + col[i]] = true;
                visit(grid , vis , x + row[i],y + col[i] , r, c);
            }
        }
    }
    public static void main(String[] args){
        int[][] grid = {{0,0,0,0} , {0,1,1,0} , {0,1,1,0} , {0,0,0,1}};
        System.out.println(countHomes(grid));
    }
}
