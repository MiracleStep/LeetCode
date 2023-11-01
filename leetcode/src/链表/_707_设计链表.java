package 链表;

public class _707_设计链表 {

    int len = 0;

    class Node{
        int val;
        Node next;
        public Node(int value){
            this.val = value;
        }
    }

    private Node dummyNode;

    public _707_设计链表() {
        dummyNode = new Node(0);
    }

    public int get(int index) {
        if (index < 0 || len <= index) return -1;
        Node cur = dummyNode;
        while (index-- >= 0){
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(len, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > len) return;
        Node addNode = new Node(val);
        Node cur = dummyNode;
        while (index-- > 0){
            cur = cur.next;
        }
        addNode.next = cur.next;
        cur.next = addNode;
        len++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || len <= index) return;
        int counter = index;
        Node cur = dummyNode;
        while (counter-- > 0){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        len--;
    }
}
