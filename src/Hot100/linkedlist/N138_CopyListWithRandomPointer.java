package Hot100.linkedlist;

import java.util.HashMap;

public class N138_CopyListWithRandomPointer {
    public static void main(String[] args) {
        Node n0 = new Node(7);
        Node n1 = new Node(13);
        Node n2 = new Node(11);
        Node n3 = new Node(10);
        Node n4 = new Node(1);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        // 设置 random： [7,null],[13,0],[11,4],[10,2],[1,0]
        n0.random = null;
        n1.random = n0;
        n2.random = n4;
        n3.random = n2;
        n4.random = n0;

        copyRandomListNoMap(n0);

    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        //首先循环，放入map中。
        Node dummy = new Node(0);
        Node p = head;
        Node q = dummy;
        HashMap<Node,Node> nodeNodeHashMap = new HashMap<>();
        while (p!=null){
            Node temp = new Node(p.val);
            temp.random = p.random;
            q.next = temp;
            nodeNodeHashMap.put(p,temp);
            q = temp;
            p = p.next;
        }
        //第二次循环，寻找random
        q = dummy.next;
        while (q!=null){
            q.random = nodeNodeHashMap.get(q.random);
            q = q.next;
        }
        return dummy.next;
    }

    //    TODO不用hash表的做法
    public static Node copyRandomListNoMap(Node head) {
        //首先第一个循环是创建新的节点
        if(head == null){
            return null;
        }
        Node first = head;
        while (first!=null){
            Node temp = new Node(first.val);
            temp.next = first.next;
            first.next = temp;
            first = first.next.next;
        }

        //第二个循环链接random
        first = head;
        while (first!= null){
            first.next.random = first.random==null?first.random:first.random.next;
            first = first.next.next;
        }
        //第三个循环拆分两个链表
        first = head;

        Node ans = head.next;
        while (first!=null){

            Node second = first.next;
            first.next = first.next.next;
            if (first.next == null){
                break;
            }
            second.next = second.next.next;
            first = first.next;

        }
        return ans;
    }


}
