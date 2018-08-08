package com.queue;

import com.array.Array;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;


    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }
    public ArrayQueue(){
        array = new Array<>();
    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    //入队
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    //出队 取出队首的元素
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    //查看队首元素
    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res= new StringBuilder();
        res.append("Queue:");
        res.append("front [");
        for (int i = 0 ; i < array.getSize() ; i++){
            res.append(array.get(i));
            if (i != array.getSize()-1)
                res.append(",");
        }
        res.append("] tail");
        return res.toString();
    }


    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue();
        for (int i = 0 ; i < 10 ; i++){
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue+"Variabe ："+i );
            if (i % 3 == 2 ){
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }
    }
}
