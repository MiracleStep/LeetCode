package 链表;

public class _234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        ListNode pre = null;
        //快慢指针 + 反转链表的迭代写法
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode tmp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tmp;
        }
        //当fast = null，表示链表为奇数个，此时slow在中间，需要把slow往后移动一个到后半对称的开始
        if (fast != null) {
            slow = slow.next;
        }
        //此时，slow为后半链条的头，pre为前半链条的头，开始循环比较即可
        while (slow != null && pre != null) {
            if (slow.val != pre.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
}
