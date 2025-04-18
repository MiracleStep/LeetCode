package 链表;

public class _92_反转链表II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode cur = dummyNode;
        ListNode reHead = null;//记录要反转链表的前面的节点
        ListNode first = cur;//记录反转链表的第一个节点
        ListNode pre = null;//前序节点

        for (int i = 0; i <= right; i++) {
            if (i >= left) {
                //cur属于反转链表的范围，开始反转
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            } else {
                reHead = cur;
                cur = cur.next;
                first = cur;
            }
        }
        //操作补充头部和尾部
        reHead.next = pre;
        first.next = cur;

        return dummyNode.next;
    }
}
