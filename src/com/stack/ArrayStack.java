package com.stack;

import com.array.Array;

public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    ArrayStack(){
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

    @Override
    public void push(E e) {
        array.add(0,e);
    }

    @Override
    public E pop() {
        return array.remove(array.getSize()-1);
    }

    @Override
    public E peek() {
        return null;
    }
}
