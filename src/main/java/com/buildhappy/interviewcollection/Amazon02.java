package com.buildhappy.interviewcollection;

/**
 * 求二叉树的节点的最短路径
 * 比如：
 * 输入：
 *    10
 *  5    15
 * 输出：15(10+5)
 * @author caijianfu
 * @date
 */
public class Amazon02 {
    public static int minTreePath(TNode t){
        if(t == null){
            return 0;
        }else if(t.left == null){
            return t.value + minTreePath(t.right);
        }else if(t.right == null){
            return t.value + minTreePath(t.left);
        }else{
            int l = minTreePath(t.left);
            int r = minTreePath(t.right);
            return l > r ? t.value + r : t.value + l;
        }
    }

    private class TNode{
        public int value;
        public TNode left;
        public TNode right;
    }
}
