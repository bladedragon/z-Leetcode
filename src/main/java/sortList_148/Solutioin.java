package sortList_148;

public class Solutioin {
    public ListNode sortList(ListNode head){
        if(head == null  || head.next ==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);
        
        return merge(l1,l2);

    }



    private ListNode merge(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);
        ListNode res = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                head.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                head.next = l1;
                l1 = l1.next;
            } else {
                if (l1.val > l2.val) {
                    head.next = l2;
                    l2 = l2.next;
                } else {
                    head.next = l1;
                    l1 = l1.next;
                }
            }
            head = head.next;
        }
        return res.next;
    }



    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
}
