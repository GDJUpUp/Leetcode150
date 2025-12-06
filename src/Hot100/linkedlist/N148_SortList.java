package Hot100.linkedlist;

public class N148_SortList {
    public static void main(String[] args) {

        ListNode node0 = new ListNode(4);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;

        sortListRecursion(node0);



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


    public  ListNode sortList(ListNode head) {
        return sortListRecursion(head);
    }
    //TODO使用递归，自顶向下
    public static ListNode sortListRecursion(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode mid = getMid(dummy);
        ListNode firstHead = head;
        ListNode secondHead = mid.next;
        mid.next = null;
        firstHead = sortListRecursion(firstHead);
        secondHead = sortListRecursion(secondHead);
        return mergeList(firstHead,secondHead);
    }

    //获取链表中点的办法
    public static ListNode getMid(ListNode head){
        ListNode f = head;
        ListNode l = head;
        while (f!=null&&f.next!=null){
            f = f.next.next;
            l = l.next;
        }
        return l;
    }

    //合并链表
    public static ListNode mergeList(ListNode firstHead,ListNode secondHead){
        ListNode f = firstHead;
        ListNode s = secondHead;
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        while (f!=null && s!=null){
            if (f.val<= s.val){
                pre.next = f;
                f = f.next;
                pre = pre.next;
            }else {
                pre.next = s;
                s = s.next;
                pre = pre.next;
            }
        }
        if (f!=null){
            pre.next = f;
        }
        if (s!=null){
            pre.next = s;
        }
        return dummy.next;
    }

//    //TODO使用循环，自底向上
//
//    public static ListNode sortListLoop(ListNode head) {
//        int len = getLength(head);
//        int window = 1;
//        ListNode dummy = new ListNode();
//        dummy.next = head;
//        while (window<len){
//            int count = 1;
//            ListNode tempStart = dummy.next;
//
//            while (window*(count-1)+window<len){
//                ListNode first = tempStart;
//                ListNode second = first;
//                int step = 0;
//                while (step<window){
//                    step++;
//                    second = second.next;
//                }
//
//            }
//
//            window = window*2;
//        }
//        return dummy.next;
//    }
//
//    public static int getLength(ListNode head) {
//        int len = 0;
//
//        while (head!= null){
//            len ++;
//            head = head.next;
//        }
//        return len;
//    }
//
//    public static ListNode getLengthList(ListNode head,int len) {
//
//        return len;
//    }



}
