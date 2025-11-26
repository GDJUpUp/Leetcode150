package Hot100.linkedlist;

public class N141_LinkedListCycle {
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

    /**
     * 判断链表中是否存在环
     * 使用快慢指针法检测链表环，快指针每次移动两步，慢指针每次移动一步
     * 如果链表中存在环，快指针最终会追上慢指针
     * @param head 链表的头节点
     * @return 如果链表中存在环则返回true，否则返回false
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 快慢指针遍历链表，快指针每次走两步，慢指针每次走一步
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 如果快慢指针相遇，说明链表中存在环
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
