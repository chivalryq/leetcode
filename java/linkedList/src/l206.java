public class l206 {
}


class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return head;
        ListNode pre,next;
        pre=head;
        ListNode now=head.next;
        head.next=null;
        do{
            next=now.next;
            now.next=pre;
            pre=now;
            now=next;

        }while(now!=null);
        return pre;
    }
}