package 链表;

import 链表.ListNode;

public class LCR_021_删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode slow = dummyNode, fast = dummyNode;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }
}
