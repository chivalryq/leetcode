public class l25 {
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution25 {
    //分层
    public ListNode[] reverse(ListNode head, ListNode tail) {
        //return new head & tail
        if (head == tail) return new ListNode[]{head, tail};
        ListNode pre = head;
        ListNode now = head.next;
        do {
            ListNode tmp = now.next;
            now.next = pre;
            pre = now;
            now = tmp;
        } while (pre != tail);
        return new ListNode[]{tail, head};
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode img = new ListNode();
        img.next = head;
        ListNode tail = img;
        ListNode pre = img ;//pre,next of first
        while(head!=null){
            for (int i=0;i<k;i++) {
                tail = tail.next;
                if (tail == null) return img.next;
            }
            ListNode next=tail.next;
            ListNode[] cp = reverse(head, tail);
            pre.next = cp[0];
            tail=cp[1];
            tail.next = next;
            pre=tail;
            head=tail.next;
        }
    return img.next;
    }
}
