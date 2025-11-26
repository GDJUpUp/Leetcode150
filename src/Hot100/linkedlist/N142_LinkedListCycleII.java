package Hot100.linkedlist;

public class N142_LinkedListCycleII {
    public static void main(String[] args) {

    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 快慢指针遍历链表，快指针每次走两步，慢指针每次走一步
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 如果快慢指针相遇，说明链表中存在环
            if (fast == slow) {
                ListNode temp = head;
                while (temp!=slow){
                    temp = temp.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

}
