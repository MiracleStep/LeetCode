package 链表;

import java.util.Deque;
import java.util.LinkedList;

public class _143_重排链表 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, fast = head;
        //找到中心位置,slow就是
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null){//奇数，slow在中心点
            slow = slow.next;
        }
        ListNode cur = reverseListNode(slow);
        ListNode pre = head;
        while (cur != null) {
            ListNode post = pre.next;
            ListNode tmp = cur.next;
            pre.next = cur;
            cur.next = post;
            pre = post;
            cur = tmp;
        }
        pre.next = null;
    }
    //翻转链表
    private ListNode reverseListNode(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode post = head.next;
            head.next = pre;
            pre = head;
            head = post;
        }
        return pre;
    }

    public void reorderList2(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, fast = head;
        //找到中心位置,slow就是
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null){//奇数，slow在中心点
            slow = slow.next;
        }
        Deque<ListNode> stack = new LinkedList<>();
        //要处理的后半部分节点存入栈中
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        //开始处理节点
        ListNode pre = head;
        while (!stack.isEmpty()) {
            ListNode post = pre.next;
            ListNode cur = stack.pop();
            pre.next = cur;
            cur.next = post;
            pre = post;
        }
        pre.next = null;
    }
}
