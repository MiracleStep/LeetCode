package 链表;

import java.util.List;
public class _24_两两交换链表中的节点 {
    //交换链表题和翻转链表题差不多。
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode pre = head;
        ListNode post;
        if (head.next != null){ //判断只有一个结点的情况。
            post = head.next;
        } else {
            return head;
        }
        ListNode resHead = head.next;
        while (true){
            pre.next = post.next;
            post.next = pre;
            if (pre.next != null && pre.next.next != null){
                ListNode tmpNode = pre;
                pre = pre.next;
                post = pre.next;
                tmpNode.next = post;
            } else {
                return resHead;
            }
        }
    }
    // 逻辑优化
    public ListNode swapPairs2(ListNode head) {
        ListNode dummyNode = new ListNode(); //建立虚拟头结点，以避免方法1种特殊情况的判断
        dummyNode.next = head;

        ListNode cur = dummyNode;
        while (cur.next != null && cur.next.next != null){
            ListNode pre = cur.next;
            ListNode post = cur.next.next;

            cur.next = post;
            pre.next = post.next;
            post.next = pre;

            cur = pre;
        }
        return dummyNode.next;
    }
}
