package Hot100.linkedlist;

public class N24_SwapNodesInPairs {
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


    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode();
        ListNode first = head;
        pre.next = first;
        ListNode ans = pre;
        while (first != null && first.next!=null){
            ListNode second = first.next;
            pre.next = second;
            first.next = second.next;
            second.next = first;
            pre = first;
            first = first.next;
        }
        return ans.next;
    }
}
