package com.buildhappy.leedcode.hard;

import com.buildhappy.leedcode.Task;

import java.util.concurrent.ConcurrentHashMap;

/**
 * https://leetcode.com/problems/lru-cache/
 * 参考：https://www.programcreek.com/2013/03/leetcode-lru-cache-java/
 */
public class _146_LRUCache extends Task {
    @Override
    public void run() {

    }

    class LRUCache {
        private int capacity;
        private Node head, tail;
        private ConcurrentHashMap<Integer, Node> cache;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new ConcurrentHashMap<>(capacity);
        }

        public int get(int key) {
            Node v = cache.get(key);
            if (v == null) {
                return -1;
            }
            remove(v);
            setHead(v);
            return v.value;
        }

        public void put(int key, int value) {
            Node v = cache.get(key);
            if (v != null) {
                v.value = value;
                remove(v);
                setHead(v);
            } else {
                if (cache.size() > capacity) {
                    cache.remove(tail.key);
                    remove(tail);
                }
                cache.put(key, v);
                setHead(v);
            }
        }

        private void remove(Node node) {
            // 第一个节点
            if (node.prev == null) {
                head = node.next;
            } else {
                node.prev.next = node.next;
            }

            // 最后一个节点
            if (node.next == null) {
                tail = node.prev;
            } else {
                node.next.prev = node.prev;
            }
        }

        private void setHead(Node node) {
            if (head != null) {
                head.prev = node;
            }
            node.next = head;
            node.prev = null;

            if (tail == null) {
                tail = head;
            }

        }
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
}
