package oop.labor08.lab8_2;

import java.util.ArrayList;

public class StackInheritance extends ArrayList<Object>{
    private final int capacity;

    public StackInheritance(int capacity) {
        super();
        this.capacity = capacity;
    }

    public boolean isFull() {
        return size() == capacity;
    }

    public void push(Object obj) {
        if (!isFull()){
            add(obj);
        }
    }

    public void pop() {
        if (!isEmpty()){
            remove(size() - 1);
        }
    }

    public Object top() {
        if(isEmpty()){
            return null;
        }
        return get(size() - 1);
    }
}
