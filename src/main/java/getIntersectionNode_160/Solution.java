package getIntersectionNode_160;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        if (headA == headB) {
            return headA;
        }

        int lenA = 1;
        int lenB = 1;
        ListNode temp = headA;
        while (temp.next != null) {
            temp = temp.next;
            lenA++;
        }

        ListNode tailA = temp;

        temp = headB;
        while (temp.next != null) {
            temp = temp.next;
            lenB++;
        }

        ListNode tailB = temp;
        if (tailB != tailA) {
            return null;
        }

        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB && headA != null; i++) {
                headA = headA.next;
            }

        } else if (lenA < lenB) {
            for (int i = 0; i < lenB - lenA && headB != null; i++) {
                headB = headB.next;
            }
        }

        while (!headA.equals(headB)) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
}
