package 链表;

public class LCR_022_环形链表II {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode tmp = head;
                while (slow != tmp) {
                    slow = slow.next;
                    tmp = tmp.next;
                }
                return tmp;
            }
        }
        return null;
    }
}
