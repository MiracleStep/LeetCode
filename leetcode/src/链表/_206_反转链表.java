package 链表;
public class _206_反转链表 {
    // 递归求解
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //非递归求解
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
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
