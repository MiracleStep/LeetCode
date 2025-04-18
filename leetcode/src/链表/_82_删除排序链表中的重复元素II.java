package 链表;

public class _82_删除排序链表中的重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode cur = dummyNode;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;
                ListNode right = cur.next.next;
                while (right != null && right.val == val) {
                    right = right.next;
                }
                cur.next = right;
            } else {
                cur = cur.next;
            }
        }

        return dummyNode.next;
    }
}
