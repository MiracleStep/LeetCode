package 链表;

import java.util.HashSet;

public class _160_相交链表 {
    //哈希表 空间复杂度高
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> visitedNodes = new HashSet<>();
        while (headA != null) {
            visitedNodes.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (visitedNodes.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    //官方题解:双指针。空间复杂度o(1) 时间复杂度o(m+n)
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) { // 求链表A的长度
            lenA++;
            curA = curA.next;
        }
        while (curB != null) { // 求链表B的长度
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        //求长度差移动节点到相同的距离
        if (lenA > lenB){
            int moveValue = lenA - lenB;
            while (moveValue > 0){
                moveValue--;
                curA = curA.next;
            }
        } else if (lenB > lenA){
            int moveValue = lenB - lenA;
            while (moveValue > 0){
                moveValue--;
                curB = curB.next;
            }
        }

        while (curA != null && curB != null){
            if (curA == curB) return curA;

            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

}

