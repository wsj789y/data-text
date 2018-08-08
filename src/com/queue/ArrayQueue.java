package com.queue;

import com.array.Array;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enqueue(E e) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFromt() {
        return null;
    }
}
