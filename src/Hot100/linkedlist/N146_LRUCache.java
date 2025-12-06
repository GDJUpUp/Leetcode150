package Hot100.linkedlist;

import java.util.HashMap;

public class N146_LRUCache {
    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(1,1);
//        lruCache.put(2,2);
//        lruCache.get(1);
//        lruCache.put(3,3);
//        lruCache.get(2);
//        lruCache.put(4,4);
//        lruCache.get(1);
//        lruCache.get(3);
//        lruCache.get(4);

        lruCache.get(2);
        lruCache.put(2,6);
        lruCache.get(1);
        lruCache.put(1,5);




    }

    public static class ListNode{
        int key;
        int val;
        ListNode next;
        ListNode pre;

        ListNode(){

        }

        ListNode(int key,int val){
            this.key = key;
            this.val = val;
        }

        ListNode(int val,ListNode next,ListNode pre){
            this.key = val;
            this.next = next;
            this.pre = pre;
        }
    }

    static class LRUCache {
        int capacity;
        ListNode cacheValue;
        HashMap<Integer,ListNode> hashMap;


        public LRUCache(int capacity) {
            this.cacheValue = new ListNode();
            this.capacity = capacity;
            this.hashMap = new HashMap<>();
        }

        public int get(int key) {


            ListNode listNode = hashMap.get(key);
            if (listNode!=null){

                moveNodeFirst(listNode);
                return listNode.val;
            }
            return -1;

        }

        public void moveNodeFirst(ListNode listNode){
            ListNode preNode = listNode.pre;
            ListNode nextNode = listNode.next;
            preNode.next = nextNode;
            nextNode.pre = preNode;
            listNode.next = this.cacheValue.next;
            listNode.pre = this.cacheValue;
            this.cacheValue.next.pre = listNode;
            this.cacheValue.next = listNode;
        }

        public void put(int key, int value) {
            ListNode temp = new ListNode(key,value);
            if (hashMap.get(key)!=null){
                ListNode listNode = hashMap.get(key);
                moveNodeFirst(listNode);
                listNode.val = value;
                hashMap.put(key,listNode);
                return;
            }

            if (hashMap.size()<this.capacity){
                temp.next = this.cacheValue.next;
                temp.pre = this.cacheValue;
                this.cacheValue.next = temp;

                if (this.cacheValue.pre == null){
                    this.cacheValue.pre = temp;
                    temp.next = this.cacheValue;

                }
                temp.next.pre = temp;
            }else {
                ListNode x = this.cacheValue.pre;
                this.cacheValue.pre = this.cacheValue.pre.pre;
                x.pre.next = this.cacheValue;
                if (hashMap.get(x.key)!=null){
                    hashMap.remove(x.key);
                }
                x = null;
                temp.next = this.cacheValue.next;
                temp.pre = this.cacheValue;
                this.cacheValue.next = temp;
                temp.next.pre = temp;
            }
            hashMap.put(key,temp);
        }
    }

}

