package com.buildhappy.eightQueen;

/**
 *  八皇后问题是一个古老而著名的问题，是回溯算法的典型例题。
 *  该问题是十九世纪著名的数学家高斯1850年提出：
 *  在8X8格的国际象棋上摆放八个皇后，使其不能互相攻击，
 *  即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
 *  
 *  高斯认为有76种方案。1854年在柏林的象棋杂志上不同的作者发表了40种不同的解，
 *  后来有人用图论的方法解出92种结果。现代教学中，把八皇后问题当成一个经典递归算法例题。
 * @author buildhappy
 *
 */
class Queen{
	static final int QUEEN_MAX = 8; //皇后的数量

	int[][] chess = new int[QUEEN_MAX][QUEEN_MAX];//分配8X8的数组，充当棋盘，存放皇后

	int resultCount = 0;//记录皇后的放置方法的总数

	int[] Queenplace = new int[QUEEN_MAX];//存放每行的皇后位置,
											//即第column行的皇后放置位置是Queenplace[column]
	/**
	 * Rows表示起始行
	 * @param Rows
	 */
	public void putQueen(int Rows){
		int row = Rows;//行标
		for (int column = 0; column < QUEEN_MAX; column++){//column表示列标
			if (chess[row][column] == 0){//row行、column列可以放皇后
				//for循环的作用是使其斜下方和正下方不为0
				for (int rowi = row + 1; rowi < QUEEN_MAX; rowi++){
					chess[rowi][column]++;
					if (column - rowi + row >= 0){
						chess[rowi][column - rowi + row]++;
					}
					if (column + rowi - row < QUEEN_MAX){
						chess[rowi][column + rowi - row]++;
					}
				}

				Queenplace[row] = column;//row行column列放了皇后
				if (row == QUEEN_MAX - 1){//皇后已放满，打印出皇后布局
					printQueen(++resultCount);
				}else {//否则继续排列下一行皇后
					putQueen(row + 1);
				}

				for (int rows = row + 1; rows < QUEEN_MAX; rows++){//回溯，在此行的皇后不放此列column
																	//，恢复该位置的正下面/斜下面的count
					chess[rows][column]--;
					if(column - rows + row >= 0){
						chess[rows][column - rows + row]--;
					}
					if (column + rows - row < QUEEN_MAX){
						chess[rows][column + rows - row]--;
					}
				}
			}
		}//end for
		
		if (row == 0){
			System.out.println(QUEEN_MAX + "皇后问题共有" + resultCount + "个解.");
		}
	}

	public void printQueen(int size){// 打印皇后布局
		System.out.println(QUEEN_MAX + "皇后的第" + size + "个解是:");
		System.out.println();
		for (int row = 0; row < QUEEN_MAX; row++){
			for (int column = 0; column < QUEEN_MAX; column++){
				System.out.print(Queenplace[row] == column ? " * " : " - ");
			}
			System.out.println();
		}
		System.out.println();

	}

	public static void main(String[] args){
		Queen Q = new Queen();
		Q.putQueen(0);

	}

}
