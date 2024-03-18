package 链表;

public class _23_合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        int mid = left + (right - left) / 2;
        if (left == right - 1) {
            return lists[left];
        }
        if (left == right) {
            return null;
        }
        ListNode leftLists = merge(lists, left, mid);
        ListNode rightLists = merge(lists, mid, right);
        return mergeTwoLists(leftLists, rightLists);
    }


    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        cur.next = a == null ? b : a;
        return dummyNode.next;
    }
}
