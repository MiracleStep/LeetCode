package 链表;

import java.util.HashMap;
import java.util.Map;

public class _146_LRU缓存 {
    class DLinkedNode {
        int key;
        int val;
        DLinkedNode next;
        DLinkedNode prev;

        public DLinkedNode(){

        }

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private int size;
    private int capacity;
    private DLinkedNode head, tail;
    private Map<Integer, DLinkedNode> cache = new HashMap<>();

    public _146_LRU缓存(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //如果key存在就把当前节点移到头结点
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.val = value;
            moveToHead(node);
        } else {
            // 如果 key 不存在，创建一个新的节点
            node = new DLinkedNode(key, value);
            cache.put(key, node);
            addToHead(node); //新的节点添加到头部
            size++;
            if (size > capacity) {
                //超出容量，删除双向链表尾部
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
