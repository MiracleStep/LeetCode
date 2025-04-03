package 链表;

public class _25_K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode cur = head;
        int count = 0;
        while (cur != null){
            cur = cur.next;
            count++;
            if (count == k) {
                break;
            }
        }
        if (count < k) {
            return head;//长度不为k就直接返回
        }
        ListNode pre = reverseKGroup(cur, k);//翻转接下来的节点
        while (k-- > 0) {//翻转k个节点
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}
