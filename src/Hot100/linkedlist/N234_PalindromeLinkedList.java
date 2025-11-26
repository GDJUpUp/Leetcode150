package Hot100.linkedlist;

import java.util.List;
import java.util.Stack;

public class N234_PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(0);
        listNode1.next = listNode2;

        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;

        ListNode listNode5 = new ListNode(0);
        listNode4.next = listNode5;

        ListNode listNode6 = new ListNode(1);
        listNode5.next = listNode6;

        System.out.println(isPalindrome(listNode1));

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

    public static boolean isPalindrome(ListNode head) {
        boolean ans = true;
        ListNode midNode = getMidNode(head);
        ListNode head2 = reverseListNode(midNode);
        while (head2!= null && head!=null){
            if (head.val==head2.val){
                head2 = head2.next;
                head = head.next;
            }else {
                ans = false;
                break;
            }
        }
        return ans;
    }

    public static ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static ListNode reverseListNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null ){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

}
