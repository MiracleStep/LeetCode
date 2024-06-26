package 链表;

public class _148_排序链表 {
    public ListNode sortList(ListNode head) {
        ListNode res = sortList(head, null);
        return res;
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        //递归基
        if (head == tail) return head;//为空
        if (head.next == tail) { //只有一个待排序节点
            head.next = null;//进行merge时候不会越界，导致超时。
            return head;
        }
        //找链表中间结点
        ListNode mid = head, fast = head;
        while (fast != tail && fast.next != tail) {
            mid = mid.next;
            fast = fast.next.next;
        }
        //排序
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);//合并排序好的链表1和2。
        return sorted;
    }

    //合并两个有序链表  参考LeetCode「21. 合并两个有序链表」
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        } else if (list2 != null) {
            cur.next = list2;
        }
        return dummyNode.next;
    }
}
