package Hot100.linkedlist;

public class N21_MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(5);

        ListNode l2_1 = new ListNode(1);
        ListNode l2_2 = new ListNode(2);
        ListNode l2_3 = new ListNode(4);
//        ListNode l2_4 = new ListNode(1);
        l2_1.next = l2_2;
        l2_2.next = l2_3;

        mergeTwoLists(l1_1,l2_1);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1 = list1;
        ListNode l2 = list2;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode pre = l1.val <= l2.val ? l1 : l2;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val ) {
                ListNode temp = l1;
                l1 = l1.next;
                pre.next = temp;
                pre = pre.next;
            } else {
                ListNode temp = l2;
                l2 = l2.next;
                pre.next = temp;
                pre = pre.next;
            }
        }
        while (l1 != null){
            ListNode temp = l1;
            l1 = l1.next;
            pre.next = temp;
            pre = pre.next;
        }
        while (l2 != null){
            ListNode temp = l2;
            l2 = l2.next;
            pre.next = temp;
            pre = pre.next;
        }
        return list1.val <= list2.val ? list1 : list2;
    }

}
