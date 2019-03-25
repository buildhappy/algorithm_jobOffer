package com.buildhappy.sort;

/**
 * 快速排序
 *
 * @author buildhappy
 */
public class QuickSort {

    public static void quickSort(int[] nums) {
        qSort(nums, 0, nums.length - 1);
    }

    public static void qSort(int[] nums, int low, int high) {
        if (low > high) {
            return;
        }
        int partionPoint = partition(nums, low, high);
        qSort(nums, 0, partionPoint - 1);
        qSort(nums, partionPoint + 1, high);
    }

    /**
     * 排序完后整个数组结构为：(nums<nums[low]),nums[low],(nums>nums[low])
     */
    public static int partition(int[] nums, int low, int high) {
        // 选取起始点为本次排序基准点
        int partitionPointVal = nums[low];
        while (low < high) {
            while (low < high && nums[high] > partitionPointVal) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] < partitionPointVal) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = partitionPointVal;
        return low;
    }

    public static void main(String[] args) {
        //int[] nums = {3,5,2,1,4};
        int[] nums = {1, 2, 3, 4, 5};
        quickSort(nums);
        for (int i : nums) {
            System.out.print(i + ",");
        }
    }
}
