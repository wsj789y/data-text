package com.leetCode;

import com.array.Array;
import com.linked.LinkedList;

public class SolutionDelERecurve {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    /*public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pro = dummyHead;
        while(pro.next != null){
            if(pro.next.val == val){
                ListNode delNode = pro.next;
                pro.next = delNode.next;
                delNode.next = null;
            }
            else{
                pro = pro.next;
            }
        }
        return dummyHead.next;
    }*/


    /**
     * 递归计算数组的和
     * 递归宏观语意：将原始的问题转化为更小的同一问题
     * 递归调用的微观解读 ：
     *      递归函数的调用，本质就是函数调用
     *      只不过调用的函数就是他自己本身
     */
    public int sum(int[] arr , int l){
        if (l == arr.length)
            return 0;
        return arr[l]+sum(arr,l+1);
    }

    /**
     * 递归删除链表固定的元素
     */
    public ListNode removeElements(ListNode head , int val){
        if (head == null)
            return head;
        head.next =removeElements(head.next,val);
        return head.val == val ? head.next : head;
    }



}
