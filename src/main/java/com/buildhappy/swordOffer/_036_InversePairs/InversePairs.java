package com.buildhappy.swordOffer._036_InversePairs;
/**
 * 逆序对定义：a[i]>a[j]，其中i<j
 * 思路：利用归并排序的思想，先求前面一半数组的逆序数，再求后面一半数组的逆序数，
 * 然后求前面一半数组比后面一半数组中大的数的个数（也就是逆序数），这三个过程加起来就是整体的逆序数目了。
 * 
 * 易错点：第二个方法在归并时，需要array的左右子数组是已排好序的数组，归并的结果是得到排好序的数组copy。
 * 因此在递归调用iPairs时，方法的前2个参数是颠倒的，这样得到的array才是排好序的。
 * 比如第一次时用copy当辅助数组对array排序，第二次就正好反过来。
 * @author buildhappy
 *
 */
public class InversePairs {

    public static int iPairs(int[] array) {
        if (array == null)
            throw new IllegalArgumentException();
        // 创建辅助数组
        int length = array.length;
        int[] copy = new int[length];
        System.arraycopy(array, 0, copy, 0, length);
        int numberOfInversePairs = iPairs(array, copy, 0, length - 1);
        return numberOfInversePairs;
    }

    /**
     * @param array 未归并数组 
     * @param copy 用于存储归并后数据的数组
     * @param begin 起始位置
     * @param end 结束位置
     * @return 逆序数
     */
    public static int iPairs(int[] array, int[] copy, int begin, int end) {
        if(begin == end)
            return 0;
        int mid = (begin + end) >> 1;
        // 递归调用
        int left = iPairs(copy, array, begin, mid);//???为什么要将copy和array的位置颠倒
        int right = iPairs(copy, array, mid + 1, end);
        // 归并
        int firstArrayEnd = mid, secondArrayEnd = end, copyPos = end;
        int count = 0; // 记录相邻子数组间逆序数
        
        while(firstArrayEnd >= begin && secondArrayEnd >= mid + 1){
        	//合并前后两个子数组并统计逆序对，并且该子数组有序
            if(array[firstArrayEnd] > array[secondArrayEnd]) {
                copy[copyPos--] = array[firstArrayEnd--];
                count += secondArrayEnd - mid;
            } else
                copy[copyPos--] = array[secondArrayEnd--];
        }
        
        while(firstArrayEnd >= begin)
            copy[copyPos--] = array[firstArrayEnd--];
        while(secondArrayEnd >= mid + 1)
            copy[copyPos--] = array[secondArrayEnd--];
        System.out.println("array:");
        for(int i : array)
        	System.out.print(i+" ");
        System.out.println();
        System.out.println("copy:");
        for(int i : copy)
        	System.out.print(i+" ");
        System.out.println();
        return left + right + count;
    }
    
    public static void main(String... args) {
        int test[] = { 7, 5, 6, 4};
        int count = iPairs(test);
        System.out.println(count + " ");
    }

}