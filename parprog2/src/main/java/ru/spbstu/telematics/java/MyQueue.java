package ru.spbstu.telematics.java;

import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class MyQueue<T> implements Queue<T>{

    T[] queue;
    private int max_size;
    private int nElement;

    public MyQueue(int max_s) {
        max_size = max_s;
        queue = (T[]) new Object[max_size];
        nElement = 0;
    }
    public MyQueue() {
        max_size = 10;
        queue = (T[]) new Object[max_size];
        nElement = 0;
    }


    public T get(int i){
        if (i<0||i>=nElement)
            new IndexOutOfBoundsException();
        return queue[i];

    }

    @Override
    public int size() {
        return nElement;
    }

    @Override
    public boolean isEmpty() {
        return nElement==0;
    }

    @Override
    public boolean contains(Object o) {
        if (nElement == 0)
            return false;
        for (int i=0; i<nElement; i++){
            if (o.equals(queue[i]))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() { return new MyQueueIterator<T>();  }

    public class MyQueueIterator<T> implements Iterator<T>
    {
        private int index;

        MyQueueIterator()
        {
            index = -1;
        }



        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }


        @Override
        public boolean hasNext()
        {
            return index + 1 < nElement;
        }

        @Override
        public T next()
        {
            if (!hasNext())
                throw new NoSuchElementException();

            index++;
            return (T) queue[index];
        }

    }


    @Override
    public Object[] toArray() {
        Object [] array = new Object[nElement];
        for(int i=0; i<nElement; i++){
            array[i]=queue[i];
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a == null)
            return null;
        T1[] array;
        if (nElement < a.length)
            array =a;
        else array = (T1[])new Object[nElement];
        for (int i=0; i<nElement; i++)
            array[i] = (T1)queue[i];
        return array;
    }


    @Override
    public boolean add(T t) {
        return this.offer(t);
    }

    @Override
    public boolean remove(Object o) {
        int n=0;
        for(int i=0; i<nElement; i++){
            if (queue[i].equals(o)){
                n=i;
                break;
            }
        }
        if (n!=0){
            for (int i=n; i<nElement-1; i++){
                queue[i]=queue[i+1];
            }
            queue[nElement-1]=null;
            nElement--;
            return true;
        }
        return false;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null)
            return true;
        int i=0;
        for(Object item :c){
            if (!this.contains(item)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean f= false;
        if (c ==null)
            throw new NullPointerException();
        for(Object item :c)
            if (this.add((T) item))
                f=true;

        return f;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean f= false;
        for(Object item :c)
            f=this.remove(item);

        return f;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null)
            throw new NullPointerException();
        T [] array =(T[])new Object[max_size];
        int i=0;
        for (Object item: c){
            if (this.contains(item)){
                array[i++]=(T)item;
            }
        }
        queue=array;
        nElement =i;

        return true;
    }

    @Override
    public void clear() {
        while (nElement!=0)
            this.remove();
    }


    @Override
    public boolean offer(T t) {
        if (t ==null)
            return true;
        if (nElement < max_size) {
            queue[nElement++] = t;
        } else {
            max_size += nElement;
            T[] tmp = (T[]) new Object[max_size];
            for (int i = 0; i < queue.length; i++) {
                tmp[i] = queue[i];
            }
            queue = tmp;
            this.offer(t);
        }
        return queue[nElement]==t;
    }

    @Override
    public T remove() {
        if(nElement == 0)
            new NoSuchElementException();
        return this.poll();
    }

    @Override
    public T poll() {
        if(nElement == 0)
            return null;
        else {
            T el=queue[0];
            for (int i = 0; i < queue.length-1; i++) {
                queue[i] = queue[i + 1];
            }
            queue[nElement-1] = null;
            nElement--;
            return el;
        }
    }

    @Override
    public T element() {
        if (nElement==0){
            new NoSuchElementException();
        }
        return queue[0];
    }

    @Override
    public T peek() {
        if(nElement == 0)
            return null;
        else return queue[0];
    }
}
