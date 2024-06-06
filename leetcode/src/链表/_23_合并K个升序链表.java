package 链表;

public class _23_合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeSort(lists, 0, lists.length);
    }

    //合并[left, right)范围内的ListNode并进行排序
    private ListNode mergeSort(ListNode[] lists, int left, int right) {
        if (left == right - 1) {
            return lists[left];
        }
        if (left == right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        ListNode leftLists = mergeSort(lists, left, mid);//左边的合并并排序成功
        ListNode rightLists = mergeSort(lists, mid, right);//右边的合并并排序成功
        return mergeTwoList(leftLists, rightLists);//合并左右两个链表
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
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
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return dummyNode.next;
    }
}
