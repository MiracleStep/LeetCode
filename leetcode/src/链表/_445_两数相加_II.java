package 链表;

import java.util.Deque;
import java.util.LinkedList;

public class _445_两数相加_II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseListNode(l1);
        l2 = reverseListNode(l2);
        ListNode dummyNode = new ListNode();
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode cur = new ListNode(sum % 10);
            cur.next = dummyNode.next;
            dummyNode.next = cur;
            sum /= 10;
        }
        if (sum != 0) {
            ListNode cur = new ListNode(sum % 10);
            cur.next = dummyNode.next;
            dummyNode.next = cur;
        }
        return dummyNode.next;
    }

    private ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummyNode = new ListNode();
        int sum = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            ListNode cur = new ListNode(sum % 10);
            cur.next = dummyNode.next;
            dummyNode.next = cur;
            sum /= 10;
        }
        if (sum != 0) {
            ListNode cur = new ListNode(sum % 10);
            cur.next = dummyNode.next;
            dummyNode.next = cur;
        }
        return dummyNode.next;
    }
}
