package com.buildhappy.list;

import com.buildhappy.bean.ListNode;
import com.buildhappy.factory.ListFactory;

import static com.buildhappy.util.LogUtils.println;

/**
 * 检测链表中是否有环
 * 参考：https://blog.csdn.net/tyler_download/article/details/53691695
 */
public class FindListCycle {
    public static void main(String[] args) {
        ListNode head = ListFactory.getCycleList();
        println("Exist cycle: " + existCycle(head));
        println("Cycle length: " + cycleLength(head));
    }

    /**
     * 判断是否有环
     */
    public static boolean existCycle(ListNode head) {
        ListNode p = head, q = head;
        do {
            if (!canGoOneStep(p)) {
                return false;
            }
            p = p.next;
            if (!canGoTwoStep(q)) {
                return false;
            }
            q = q.next.next;
        } while (p != q);

        return true;
    }

    /**
     * 计算链表中环的长度
     */
    public static int cycleLength(ListNode head) {
        ListNode p = head, q = head;
        int meetCount = 0, nodeNum = 0;
        // 第一次相遇遍历的节点数，第二次相遇遍历的节点数
        int firstMeetScanNodeNum = 0, secondMeetScanNodeNum = 0;
        do {
            if (!canGoOneStep(p)) {
                return 0;
            }
            p = p.next;
            if (!canGoTwoStep(q)) {
                return 0;
            }
            q = q.next.next;
            nodeNum++;

            if (p == q) {
                meetCount++;
                println("Node num: " + nodeNum + ", meet count: " + meetCount + ", p:" + p);

                if (meetCount == 1) {
                    firstMeetScanNodeNum = nodeNum;
                }
                if (meetCount == 2) {
                    secondMeetScanNodeNum = nodeNum;
                }
            }

            //相遇两次,两次遍历的节点的差值,就是环中节点的数量
        } while (meetCount < 2);

        return secondMeetScanNodeNum - firstMeetScanNodeNum;
    }

    public static boolean canGoOneStep(ListNode node) {
        boolean canNotGo = (node == null || node.next == null);
        return !canNotGo;
    }

    public static boolean canGoTwoStep(ListNode node) {
        boolean canNotGo = (node == null || node.next == null || node.next.next == null);
        return !canNotGo;
    }
}
