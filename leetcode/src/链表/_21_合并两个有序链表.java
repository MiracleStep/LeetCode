package 链表;

public class _21_合并两个有序链表 {
    //1
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode();
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

    //递归法
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
