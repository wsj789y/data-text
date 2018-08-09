package com.trees.bst;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node{
        public  E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public  BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /*//向二分搜索树插入新的元素
    public void add(E e){
        if (root ==null) {
            root = new Node(e);
            size++;
        }else
            add(root,e);
    }*/
    // 向以node为根的二分搜索树中插入元素e，递归算法
    /*private void add(Node node, E e){
        if(e.equals(node.e))
            return;
        else if(e.compareTo(node.e) < 0 && node.left == null){
            node.left = new Node(e);
            size ++;
            return;
        }
        else if(e.compareTo(node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size ++;
            return;
        }

        if(e.compareTo(node.e) < 0)
            add(node.left, e);
        else //e.compareTo(node.e) > 0
            add(node.right, e);
    }*/

    //向二分搜索树插入新的元素
    public void add(E e){
        root = add(root,e);
    }
    // 向以node为根的二分搜索树中插入元素e，递归算法 简化版
    private Node add(Node node , E e){
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0 )
            node.left = add(node.left,e);
        else if (e.compareTo(node.e) >0)
            node.right = add(node.right,e);
        return node;
    }

    //查看二分搜索树中是否包含元素E
    public boolean contains(E e){
        return contains(root,e);
    }
    //看以node为根的节点是否包含元素E 递归
    private boolean contains(Node node,E e){
        if (node == null)
            return false;

        if (node.e.compareTo(e) == 0)
            return true;
        else if (node.e.compareTo(e) >0)
            return contains(node.left,e);
        else //if (node.e.compareTo(e)<0)
            return contains(node.right,e);
    }

    //二叉树的前序遍历 递归形式
    public void proOrder(){
        proOrder(root);
    }
    //前序便利以node为根的二叉搜索树 递归算法
    private void proOrder(Node node){
        if (node == null)
            return ;
        System.out.println(node.e);
        proOrder(node.left);
        proOrder(node.right);
    }

    //二叉树的中序遍历遍历 递归形式
    public void inOrder(){
        proOrder(root);
    }
    //中序便利以node为根的二叉搜索树 递归算法
    private void inOrder(Node node){
        if (node == null)
            return ;
        proOrder(node.left);
        System.out.println(node.e);
        proOrder(node.right);
    }

    //二叉树的后序遍历遍历 递归形式
    public void postOrder(){
        proOrder(root);
    }
    //后序便利以node为根的二叉搜索树 递归算法
    private void postOrder(Node node){
        if (node == null)
            return ;
        proOrder(node.left);
        proOrder(node.right);
        System.out.println(node.e);
    }

    //二分搜索树的前序非递归便利深度优先遍历  结合栈来进行非递归便利
    public void  proOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            //栈结构是先进后出
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    //二分搜索树的层序遍历  广度优先遍历 最短路径
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    // 寻找二分搜索树的最小元素
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");

        return minimum(root).e;
    }
    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    //寻找二分搜索树的最大值
    public E maximum(){
        if (size == 0)
            throw  new IllegalArgumentException("is empty");
        return maximum(root).e;
    }
    //返回以node为根节点的二分搜索树的最大值
    private Node maximum(Node node) {
        if (node.right==null)
            return node;

        return maximum(node.right);
    }

    // 从二分搜索树中删除最小值所在节点, 返回最小值
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    //从二分搜索树中删除最大值所在节点
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }
    //删除掉以node为根的热分搜索树中的最大节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {
        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    //在二分搜索树中删除任意元素的节点
    public void remove(E e){
        root = remove(root,e);
    }
    //删除掉以node为根的二分搜索树中元素为e的节点，递归算法
    //返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e) {
        if (node == null)
            return null;

        if (e.compareTo(node.e) <0){
            node.left = remove(node.left,e);
            return node;
        }else if (e.compareTo(node.e)>0){
            node.right = remove(node.right,e);
            return node;
        }else { // if(e.compareTo(node.e) == 0)
            //待删除节点左子树为空的情况
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //待删除节点左右字数都不为空的情况 可以使用前驱 或后继代替待删除节点
            // 【找到后继】 找到比待删除节点大的最小节点，既待删除节点右子树最小的节点
            //用这个节点的位置代替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e +"\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }

    // 打乱数组顺序
    private static void shuffle(Object[] arr){

        for(int i = arr.length - 1 ; i >= 0 ; i --){
            int pos = (int) (Math.random() * (i + 1));
            Object t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
    }

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 10000;

        for(int i = 0 ; i < n ; i ++)
            bst.add(random.nextInt(n));

        // 注意, 由于随机生成的数据有重复, 所以bst中的数据数量大概率是小于n的

        // order数组中存放[0...n)的所有元素
        Integer[] order = new Integer[n];
        for( int i = 0 ; i < n ; i ++ )
            order[i] = i;
        // 打乱order数组的顺序
        shuffle(order);

        // 乱序删除[0...n)范围里的所有元素
        for( int i = 0 ; i < n ; i ++ )
            if(bst.contains(order[i])){
                bst.remove(order[i]);
                System.out.println("After remove " + order[i] + ", size = " + bst.size() );
            }

        // 最终整个二分搜索树应该为空
        System.out.println(bst.size());
    }

}
