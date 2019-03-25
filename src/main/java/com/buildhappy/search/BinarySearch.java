package com.buildhappy.search;

import java.util.stream.Stream;

/**
 * 二分法查找
 * 折半查找的两个关键问题
 *  何时终止遍历
 *  如何移动low和high指针
 */
public class BinarySearch {
    /**
     * 基础的折半查找
     */
    public static int binarySearch(int[] num, int k) {
        if (null == num || num.length == 0) {
            return -1;
        }
        int low = 0, high = num.length - 1;
        while (low <= high) {
            int middle = (low + high) >> 1;
            if (num[middle] == k) {
                return middle;
            }

            if (num[middle] > k) {
                // 一定要有 -1
                high = middle - 1;
            } else {
                // 一定要有 +1
                low = middle + 1;
            }
        }
        return -1;
    }


    /**
     * JDK中对折半查找的实现
     * 等价于：Arrays.binarySearch(num, 0, num.length, key);
     */
    public static int binarySearchJDK(int[] num, int k) {
        if (null == num || num.length == 0) {
            return -1;
        }
        int low = 0, high = num.length - 1;
        while (low <= high) {
            int middle = (low + high) >> 1;
            if (num[middle] == k) {
                return middle;
            }

            if (num[middle] > k) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        // key not found.
        return -(low + 1);
    }

    /**
     * 查找元素的最后出现的位置
     */
    public static int binarySearchFindLast(int[] num, int k) {
        if (null == num || num.length == 0) {
            return -1;
        }
        int low = 0, high = num.length - 1;
        while (low <= high) {
            int middle = (low + high) >> 1;
            // 终止遍历的条件(关键步骤)
            if (num[middle] == k) {
               if (middle == num.length - 1 || num[middle + 1] > k) {
                   return middle;
               }else {
                   low = middle + 1;
               }
            }

            //在左侧
            if (num[middle] > k) {
                high = middle - 1;
            } else if (num[middle] < k) {
                //在右侧
                low = middle + 1;
            }
        }
        // key not found.
        return -(low + 1);
    }

    /**
     * 查找k第一次出现的位置
     * @param num
     * @param k
     * @return
     */
    public static int binarySearchFindFirst(int[] num, int k) {
        if (null == num || num.length == 0) {
            return -1;
        }
        int low = 0, high = num.length - 1;
        while (low <= high) {
            int middle = (low + high) >> 1;
            // 终止遍历的条件(关键步骤)
            if (num[middle] == k) {
                if (middle == 0 || num[middle - 1] < k) {
                    return middle;
                }else {
                    high = middle - 1;
                }
            }

            //在左侧
            if (num[middle] > k) {
                high = middle - 1;
            } else if (num[middle] < k) {
                //在右侧
                low = middle + 1;
            }
        }
        // key not found.
        return -(low + 1);
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 3, 4, 5, 6};
//        System.out.println(binarySearch(num, 7));
        System.out.println(binarySearchFindLast(num, 3));
        System.out.println(binarySearchFindFirst(num, 3));
    }

}
