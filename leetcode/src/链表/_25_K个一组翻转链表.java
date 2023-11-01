package 链表;

import java.util.List;

public class _25_K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        ListNode end = dummyNode;
        while (end.next != null){
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next; //保存带翻转节点组的下一个节点。
            end.next = null; //带翻转节点的最后一个节点为null方便reverse
            pre.next = reverseListNode(start); //前驱节点的下一个节点指向翻转好的节点
            start.next = next; // 翻转好的节点最后一个节点指向下一个节点。

            pre = start; //重新初始化调整pre和end的位置。
            end = pre;
        }
        return dummyNode.next;
    }

    public ListNode reverseListNode(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
