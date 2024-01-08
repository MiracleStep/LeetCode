package 链表;

import 链表.ListNode;

public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {//删除节点
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummyNode.next;
    }
}
