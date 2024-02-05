package 链表;

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


    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int len = 0;
        ListNode cur = head;
        while (cur != null && len < k) {
            //计算长度
            cur = cur.next;
            len++;
        }

        if (len == k) { //长度为k就翻转
            cur = reverseKGroup(cur, k);//翻转接下来的节点
            while (len > 0) {//翻转n个节点
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
                len--;
            }
            return cur;
        } else {
            //不翻转
            return head;
        }
    }
}
