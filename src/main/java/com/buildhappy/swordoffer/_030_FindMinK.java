package com.buildhappy.swordoffer;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 面试题30：最小的k个数
 * 题目大致为：
 * 输入n个整数，找出其中最小的k个数。
 * 思路：
 * 使用类似二叉查找树的形式实现，控制好树中的结点个数为k
 * 时间复杂度:O(n)
 *
 */
public class _030_FindMinK {
    public static void main(String args[]) {
        // 测试的例子
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        final int k = 4;
        TreeSet<Integer> set = getLeastNumbers(array, k);
        // 输出
        Iterator<Integer> it = set.iterator();
		/*
		System.out.println("最小的" + k + "个数为：");
		while (it.hasNext()) {
			System.out.print(it.next() + "、");
		}
		*/

        getLeastNumber_3(array, k);
        System.out.println();
        System.out.println(findKthLargest(array, k));

    }

    /**
     * 法一：利用红黑树，适合海量数据处理
     */
    public static TreeSet<Integer> getLeastNumbers(int array[], int k) {
        //对红黑树的实现
        TreeSet<Integer> set = new TreeSet();
        //判断k和array的合法性
        if (array == null || k <= 0) {
            return null;
        }

        for (int i = 0; i < array.length; i++) {
            //如果TreeSet中的元素小于K个，则直接插入
            if (set.size() < k) {
                set.add(array[i]);
            } else {//TreeSet中的元素大于K个
                //最大的元素大于array[i]
                if (set.last() > array[i]) {
                    //移除
                    set.pollLast();
                    //加入新的
                    set.add(array[i]);
                }
            }
        }
        return set;
    }


    /**
     * 法二: 使用优先级队列
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        });

        for(int val : nums) {
            pq.offer(val);
            if(pq.size() > k) {
//                pq.poll();
                pq.poll();
            }
        }
        System.out.println(pq);
        return pq.peek();
    }

    /** 法三：利用快排的Partition函数 **/
    public static void getLeastNumber_3(int[] nums, int k) {
        if (null == nums || nums.length <= 0 || k > nums.length) {
            return;
        }

        int low = 0, high = nums.length - 1;
        int index = partition(nums, low, high);
        //保证分割的位置在k处，这样就能保证前k-1个数字是最小的
        while (index != k - 1) {
            if (index < k - 1) {
                low = index + 1;
                index = partition(nums, low, high);
            } else {
                high = index - 1;
                index = partition(nums, low, high);
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }

    }

    public static int partition(int[] nums, int low, int high) {
        if (null == nums || nums.length == 0 || low > high) {
            return -1;
        }
        int mark = nums[low];
        while (low < high) {
            while (low < high && nums[high] > mark) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] < mark) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = mark;
        return low;
    }

}
