package Hot100.linkedlist;

import java.util.HashMap;

public class N138_CopyListWithRandomPointer {
    public static void main(String[] args) {

    }

    class Node {
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


}
