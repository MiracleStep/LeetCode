package 链表;

public class _430_扁平化多级双向链表 {
    private class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                Node post = cur.next;
                cur.next = flatten(cur.child);
                cur.child = null;
                cur.next.prev = cur;
                if (post != null) {
                    while (cur.next != null) {
                        cur = cur.next;
                    }
                    cur.next = post;
                    post.prev = cur;
                }
                cur = post;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
