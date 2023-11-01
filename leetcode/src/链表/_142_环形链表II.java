package 链表;

public class _142_环形链表II {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                ListNode tmp = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (slow != tmp){
                    slow = slow.next;
                    tmp = tmp.next;
                }
                return slow;
            }
        }
        return null;
    }
}
