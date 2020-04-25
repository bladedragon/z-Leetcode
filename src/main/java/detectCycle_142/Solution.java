package detectCycle_142;

public class Solution {
    public ListNode detectCycle(ListNode head){
        ListNode slow =  head;
        ListNode fast = head;
        ListNode meetNode = null;
        while(fast != null && fast.next!= null){
            if(fast == slow){
                meetNode = fast;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        if(meetNode == null){
            return meetNode;
        }
        while (head != meetNode) {
            head = head.next;
            if (head == meetNode) {
                break;
            }
            meetNode = meetNode.next;
        }
        return meetNode;
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
}
