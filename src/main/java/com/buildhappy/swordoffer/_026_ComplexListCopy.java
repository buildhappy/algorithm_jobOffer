package com.buildhappy.swordoffer;
/**
 * 复杂链表的复制
 * 有一个复杂链表，其结点除了有一个m_pNext指针指向下一个结点外，还有一个m_pSibling指向链表中的任一结点或者NULL，
 * 要求实现对该链表的复制。
 * 参考：http://blog.csdn.net/u012289407/article/details/46609731
 * @author buildhappy
 *
 */
public class _026_ComplexListCopy {

    static class Node{
        int value;
        Node next;
        Node sbiling;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("val = " + value);
            sb.append(", next = " + (next == null ? "null" : next.value));
            sb.append(", sbiling = " + (sbiling == null ? "null" : sbiling.value));
            return sb.toString();
        }
    }

    //第一步遍历一遍原始链表，复制结点N对应的N'，将N'插入到N的后面
    public static void cloneNodes(Node head){
        Node node = head;
        while(node != null){
            Node copyNode = new Node();
            copyNode.value = node.value;
            copyNode.next = node.next;
            copyNode.sbiling = null;
            node.next = copyNode;
            node = copyNode.next;
        }
    }
    //第二步是设置我们复制出来的链表上的结点的m_pSibling。
    //假设原始链表上的N的m_pSibling指向结点S，那么其对应复制出来的N->m_pNext是N’,同样S’也是S->m_pNext。
    //有了这样的链接方式，我们就能在O(1)中就能找到每个结点的m_pSibling了
    public static void setSbiling(Node head){
        Node node = head;
        while(node != null){
            Node copyNode = node.next;
            if(node.sbiling != null){
                copyNode.sbiling = node.sbiling.next;
            }
            node = copyNode.next;
        }
    }
    //再次遍历一遍，将原始链表和复制链表分开，奇数为原始链表，偶数为复制链表
    public static Node disConnectList(Node head){
        Node node = head;
        Node copyHead = null;
        Node copyNode = null;

        if(node != null){
            copyHead = node.next;
            copyNode = node.next;
            node.next = copyNode.next;
            node = node.next;
        }

        while(node != null){
            copyNode.next = node.next;
            copyNode = copyNode.next;
            node.next = copyNode.next;
            node = node.next;
        }

        return copyHead;
    }

    public static Node copy(Node head){
        cloneNodes(head);
        setSbiling(head);
        return disConnectList(head);
    }

    public static void main(String[] args) {

        Node head = new Node();
        head.value = 1;

        Node node2 = new Node();
        node2.value = 2;

        Node node3 = new Node();
        node3.value = 3;

        Node node4 = new Node();
        node4.value = 4;

        Node node5 = new Node();
        node5.value = 5;

        head.next = node2;
        head.sbiling = node3;

        node2.next = node3;
        node2.sbiling = node5;

        node3.next = node4;

        node4.next = node5;
        node4.sbiling = node2;

        Node copyHead = copy(head);

        Node node = copyHead;
        while(node != null){
            System.out.println(node);
            node = node.next;
        }

    }

}