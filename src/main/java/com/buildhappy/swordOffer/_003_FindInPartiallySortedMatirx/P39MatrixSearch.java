package com.buildhappy.swordOffer._003_FindInPartiallySortedMatirx;
/**
 * 在二维数组中查找某个元素是否存在
 * @author buildhappy
 *
 */
public class P39MatrixSearch {
	private static int rows = 4 , colums = 4;
	private static final int[][] matrix = {{1,2,8,9}, {2,4,9,12}, {4,7,10,13}, {6,8,11,15}};
	/**
	 * 
	 * @param matrix
	 * @param number 待查找的数字
	 * @return
	 */
	public static boolean find(int[][] matrix , int number){
		boolean found = false;
		if(matrix != null && rows > 0 && colums > 0){
			int row = 0;
			int colum = colums - 1;
			while(colum >= 0 && row < rows){
				if(matrix[row][colum] == number){
					found = true;
					break;
				}else if(matrix[row][colum] > number){
					colum--;
				}else{
					row++;
				}
			}
		}
		return found;
	}
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		System.out.println(find(matrix , 5));
		System.out.println("用时：" + (System.nanoTime() - startTime));//181089  198305
	}
}
