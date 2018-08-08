package com.array;

import javax.xml.ws.soap.Addressing;

public class Array<E> {

    private E[] data;
    private  int size;

    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getCapacity(){
        return data.length;
    }

    public int getSize(){
        return  size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int index , E e){
        if (index < 0 || index > size)
            throw  new IllegalArgumentException("数组越界");

        if (size == data.length)
            resize(data.length+(data.length << 1));

        for (int i = size - 1 ; i >= index ; i--)
            data[i +1] = data[i];

        data[index] = e;
        size++;
    }

    //数组扩容  动态数组的静态实现
    public void  resize(int newCapacity){
        E[] newData= (E[]) new Object[newCapacity];
        for (int i = 0 ; i < size ; i++)
            newData[i] = data[i];

        data = newData;
    }


    //数组删除元素防止复杂度震荡当capacity/4 == size
    public E remove(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("failed");

        E ret = data[index];
        for (int i = index + 1; i < size ; i++)
            data[i - 1] = data[i];

        size --;
        data[size-1] = null;
        if (size == data.length/4 && data.length/2 != 0)
            resize(data.length/2);
        return ret;
    }


}
