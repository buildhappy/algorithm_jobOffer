package com.buildhappy.swordOffer._020_PrintMatrixLockWise;
/**
 * 顺时针打印矩阵
 * @author buildhappy
 *
 */
public class Item20PrintMatrix {
	//顺时针打印矩阵
	public static void printMatrixClockwisely(int[][] matrix , int rows , int colums){
		if(null == matrix || colums <= 0 || rows <= 0)
			return;
		for(int start = 0; ((start << 1) < rows) && ((start << 1) < colums); start++){
			printMaticInCircle(matrix , rows , colums , start);
		}
	}
	//打印矩阵的一圈,以(start,start)为起始点
	public static void printMaticInCircle(int[][] matrix , int rows , int colums , int start){
		int endX = rows - 1 - start;
		int endY = colums - 1 - start;
		//从左到右打印最上面的一行(不用判断一定要打印)
		for(int i = start; i <= endY; i++)
			printEle(matrix[start][i]);
		
		//打印最右边的一列(保证有两行)
		if(start < endX){
			for(int i = start + 1; i <= endX; i++){
				printEle(matrix[i][endY]);
			}
		}
		
		//打印最下面的一行(保证至少两列两行)
		if(start < endY && start < endX){
			for(int i = endY - 1; i > start; i--){
				printEle(matrix[endY][i]);
			}
		}
		
		//打印最左边的一列(保证有三行，保证至少两列)
		if(start < endY && start < endX - 1){
			for(int i = endX; i > start; i--){
				printEle(matrix[i][start]);
			}
		}
	}
	
	public static void printEle(int i){
		System.out.print(i + " ");
	}
	public static void main(String[] args){
		/* 3*3 */
		int[][] matrix = {{1,2,3} , {4,5,6} , {7,8,9}};
		int rows = 3 , colums = 3;
		
		/* 1*3 
		int[][] matrix = {{1,2,3}};
		int rows = 1 , colums = 3;
		*/
		
		/* 3*1 
		int[][] matrix = {{1},{2},{3}};
		int rows = 3 , colums = 1;
		*/
		
		/* 1*1 
		int[][] matrix = {{1}};
		int rows = 1 , colums = 1;
		*/
		printMatrixClockwisely(matrix , rows , colums);
	}
}
