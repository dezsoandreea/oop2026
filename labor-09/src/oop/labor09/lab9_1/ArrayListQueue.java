package oop.labor09.lab9_1;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListQueue implements IQueue {
    private ArrayList<Object> items;
    private final int CAPACITY;

    public ArrayListQueue(int capacity){
        this.CAPACITY = capacity;
        this.items = new ArrayList<>(capacity);
    }

    @Override
    public void enQueue(Object obj) {
        if(isFull()){
            System.out.println("A sor tele van");
            return;
        }
        items.add(obj);
    }

    @Override
    public Object deQueue() {
        if(isEmpty()){
            System.out.println("A sor ures");
            return null;
        }
        return items.remove(0);
    }

    @Override
    public boolean isFull() {
        return items.size() == CAPACITY;
    }

    @Override
    public boolean isEmpty() {
        return items.size() == 0;
    }

    @Override
    public void printQueue() {
        System.out.println(items);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        ArrayListQueue that = (ArrayListQueue) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, CAPACITY);
    }
}
