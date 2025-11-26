package Hot100.linkedlist;

public class N2_AddTwoNumbers {
    public static void main(String[] args) {

    }

    public class ListNode {
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


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0,null);
        ListNode p = new ListNode();
        p = ans;
        int count = 0;
        while (l1!=null || l2!=null){
            ListNode p1 = new ListNode(count,null);
            p.next = p1;
            p = p.next;
            int temp = p.val + (l1==null?0: l1.val) + (l2==null?0: l2.val);
            if (temp>=10){
                p.val = temp%10;
                count = 1;
            }else {
                p.val = temp%10;
                count = 0;
            }
            l1 = l1==null?null: l1.next;
            l2 = l2==null?null: l2.next;
        }
        if(count == 1){
            ListNode p1 = new ListNode(count,null);
            p.next = p1;
        }
        return ans.next;
    }
}
