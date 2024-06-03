package 链表;

public class _25_K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int len = 0;
        ListNode cur = head;
        while (cur != null && len < k) {//统计节点数
            cur = cur. next;
            len++;
        }

        if (len == k) { //长度为k就翻转
            cur = reverseKGroup(cur, k); //翻转接下来的节点
            while (len > 0) { //翻转n个节点
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
                len--;
            }
        } else {
            //不翻转
            return head;
        }
        return cur;
    }
}
