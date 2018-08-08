package com.linked;

public class LinkedList<E> {

    private  class Node{
        public E e;
        public Node next;

        Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        Node(E e){
            this(e,null);
        }

        Node(){
            this(null,null);
        }
        // 链表节点的构造函数
        // 使用arr为参数，创建一个链表，当前的ListNode为链表头结点
        Node(E[] arr){

            if(arr == null || arr.length == 0)
                throw new IllegalArgumentException("arr can not be empty");

            this.e = arr[0];
            Node cur = this;
            for(int i = 1 ; i < arr.length ; i ++){
                cur.next = new Node(arr[i]);
                cur = cur.next;
            }
        }
        @Override
        public  String toString(){
            return e.toString();
        }
    }

    //    private  Node head;   1.0版本
    private  Node dummyHead; //虚拟的头结点 完善
    private  int size;

    public LinkedList(){
//        head = null;
        dummyHead = new Node(null,null);
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize(){
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty(){
        return  size == 0;
    }




    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
    public void add(int index,E e){
        if (index < 0 || index >size)
            throw  new IllegalArgumentException("slope over");
        //if (index == 0 ) {
        //      addFist(e);
        // }
        // else {

        // Node prev = head; //获取第一个节点  1.0
        Node prev = dummyHead; //获取第一个节点
        // for (int i = 0 ; i <index-1 ; i++){ //获取index节点位置前一个的节点位置1.0
        for (int i = 0 ; i < index ; i++){ //获取index节点位置前一个的节点位置  完善
            prev = prev.next; //获取下一个节点
        }
//            Node node = new Node(e); //新建一个节点
//            node.next = prev.next; //把index前一个节点的next信息存放在   新的节点的next
//            prev.next = node; //index前一个的节点的next信息 更新为新添加的节点

        prev.next = new Node(e,prev.next);
        size++;
        // }
    }

    // 在链表头添加新的元素e
    public void addFirst(E e){
//        Node node = new Node(e);  新建一个节点信息
//        node.next = head; 把链表的头节点指向  新节点的next
//        head=node;  把新添加的结点  更新为链表的头节点
//        head = new Node(e,head);

        add(0,e);
        size++;
    }

    // 在链表末尾添加新的元素e
    public void addlast(E e){
        add(size,e);
    }

    // 获得链表的第index(0-based)个位置的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E get(int index){

        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        Node cur = dummyHead.next;
        for(int i = 0 ; i < index ; i ++)
            cur = cur.next;
        return cur.e;
    }

    // 获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    // 修改链表的第index(0-based)个位置的元素为e
    // 在链表中不是一个常用的操作，练习用：）
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = dummyHead.next;
        for(int i = 0 ; i < index ; i ++)
            cur = cur.next;
        cur.e = e;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    // 从链表中删除index(0-based)位置的元素, 返回删除的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        Node prev = dummyHead;
        for(int i = 0 ; i < index ; i ++)
            prev = prev.next;

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;

        return retNode.e;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    // 从链表中删除元素e
    public void removeElement(E e){

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for(Node cur = dummyHead.next ; cur != null ; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");

        return res.toString();
    }
}

