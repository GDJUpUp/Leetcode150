package Hot100.linkedlist;

public class N19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {

    }

    public static class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = new ListNode();
        ans.next = head;
        removeNthFromEndRecursion( ans, n);
        return ans.next;
    }

    public int removeNthFromEndRecursion(ListNode head,int n) {
        if(head.next == null){
            return 1;
        }else {
            int res = removeNthFromEndRecursion(head.next,n);
            if (res == n){
                head.next = head.next.next;
            }
            return res+1;
        }
    }
}
