package 链表;

public class _2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return new ListNode(0);
        }
        ListNode cur = new ListNode(0);
        ListNode head = cur; //固定头结点
        int sum = 0; //保存加和和进位
        while (l1 != null && l2 != null) {
            sum += l1.val + l2.val;
            cur.next = new ListNode(sum % 10);
            sum /= 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        while (l1 != null) {
            sum += l1.val;
            l1.val = sum % 10;
            cur.next = l1;
            sum /= 10;
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum += l2.val;
            l2.val = sum % 10;
            cur.next = l2;
            sum /= 10;
            cur = cur.next;
            l2 = l2.next;
        }
        if (sum != 0) { //最后可能还有进位
            cur.next = new ListNode(sum);
        }
        return head.next;
    }
}
