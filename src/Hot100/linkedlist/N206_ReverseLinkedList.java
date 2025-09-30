package Hot100.linkedlist;

import java.util.Stack;

public class N206_ReverseLinkedList {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // 创建链表
        N206_ReverseLinkedList.ListNode head = createLinkedList(arr);

        // 打印链表验证
        printLinkedList(head);
        ListNode listNode = reverseListHash(head);
        printLinkedList(listNode);
    }

    public static N206_ReverseLinkedList.ListNode createLinkedList(int[] arr) {
        // 处理空数组情况
        if (arr.length == 0) {
            return null;
        }

        // 创建外部类实例
        N206_ReverseLinkedList outer = new N206_ReverseLinkedList();

        // 创建头节点
        N206_ReverseLinkedList.ListNode head = outer.new ListNode(arr[0]);

        // 使用current指针跟踪当前处理的节点
        N206_ReverseLinkedList.ListNode current = head;

        // 从第二个元素开始，逐个创建节点并连接
        for (int i = 1; i < arr.length; i++) {
            // 创建新节点
            N206_ReverseLinkedList.ListNode newNode = outer.new ListNode(arr[i]);

            // 连接新节点到链表
            current.next = newNode;

            // 移动current指针到新节点
            current = newNode;
        }

        // 返回链表头节点
        return head;
    }

    // 辅助方法：打印链表
    public static void printLinkedList(N206_ReverseLinkedList.ListNode head) {
        N206_ReverseLinkedList.ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */



    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseListHash(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        ListNode ans = null;
        if (!stack.empty()) {
            ans = stack.pop();
        }
        current = ans;
        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
            current.next = null;
        }
        return ans;
    }


    public static ListNode reverseListRecursion(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        ListNode ans = null;
        if (!stack.empty()) {
            ans = stack.pop();
        }
        current = ans;
        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
            current.next = null;
        }
        return ans;
    }

}
