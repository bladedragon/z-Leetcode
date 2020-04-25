package swapPairs_24;

public class Solution {


    public ListNode swapPairs(ListNode head){
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode tail =head;
        head = newHead;
        int i =1;
        while(tail != null){
            if(i%2 ==0){
                newTail = newHead.next;
                reverse(newHead,tail);
                newHead =newTail;
                tail =newTail;
            }
            i++;
            tail = tail.next;
        }
        return head.next;
    }


    ListNode newTail = null;
    public void reverse(ListNode head,ListNode tail){
        ListNode cur =head.next.next;
        ListNode curNext = cur.next;
        while(cur!= null){
            cur.next =head.next;
            head.next =cur;
            if(cur ==tail){
                newTail.next =curNext;
                break;
            }
            cur =curNext;
            curNext = cur.next;
        }
    }



  //Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

}
