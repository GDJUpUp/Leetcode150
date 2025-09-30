package Hot100.linkedlist;

import java.util.HashMap;

public class N160_IntersectingLinkedList {
    public static void main(String[] args) {

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNodeHash(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> map = new HashMap<>();

        for  (ListNode q = headA; q != null; q = q.next) {
            map.put(q, map.getOrDefault(q, 0) + 1);
        }
        ListNode ans = null;
        for  (ListNode q = headB; q != null; q = q.next) {
            if(map.containsKey(q)) {
                ans = q;
                break;
            }
        }
        return ans;
    }


    public ListNode getIntersectionNodeTwoPointers(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        if (p1 == null || p2 == null) {
            return null;
        }
        while (p1 != p2 ) {
            if (p1 == null) {
                p1 = headB;
            }else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            }else  {
                p2 = p2.next;
            }
        }
        return p2;

    }

}
