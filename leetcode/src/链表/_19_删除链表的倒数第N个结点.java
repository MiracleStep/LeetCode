package 链表;

public class _19_删除链表的倒数第N个结点 {
    // 建立虚拟头结点：dummyNode 以及找到链表的长度。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head; //建立虚拟头结点方便对链表进行统一的操作。

        ListNode cur = head;
        int len = 0;
        while (cur != null){
            cur = cur.next;
            len++;
        }

        int tarLen = len - n;
        cur = dummyNode;
        for (int i = 0; i < tarLen; i++){
            cur = cur.next;
        }
        //遍历到被删除结点的前一个节点。
        cur.next = cur.next.next;
        return dummyNode.next; //返回是dummyNode的下一个节点，而不是head节点。
    }
    //双指针优化
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode post = pre;//双指针
        for (int i = 0; i < n; i++) {
            post = post.next;//post先移动n次。
        }
        while(post.next != null) {
            post = post.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummyNode.next;
    }
}
