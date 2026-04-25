package oop.labor09.lab9_1;

import java.util.Arrays;
import java.util.Objects;

public class CircularQueue implements IQueue{
    private final int CAPACITY;
    private Object[] items;
    private int front;
    private int rear;

    public CircularQueue(int capacity){
        this.CAPACITY = capacity;
        this.items = new Object[capacity];
        this.front = -1;
        this.rear = -1;
    }

    @Override
    public void enQueue(Object obj) {
        if(isFull()){
            System.out.println("A sor tele van");
            return;
        }else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % CAPACITY;
            items[rear] = obj;
        }
    }

    @Override
    public Object deQueue() {
        Object element;
        if (isEmpty()) {
            System.out.println("A sor ures");
            return null;
        } else {
            element = items[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            }
            else {
                front = (front + 1) % CAPACITY;
            }
            return (element);
        }
    }

    @Override
    public boolean isFull() {
        return (front == 0 && rear == CAPACITY - 1) || front == rear + 1;
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public void printQueue() {
        System.out.print("SOR: ");
        for (int i = 0; i < CAPACITY; i++) {
            System.out.print(items[(front + i) % CAPACITY] + " ");
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        CircularQueue that = (CircularQueue) o;

        if (this.CAPACITY != that.CAPACITY){
            return false;
        }

        for (int i = 0; i < CAPACITY; i++) {
            Object a = this.items[(this.front + i) % CAPACITY];
            Object b = that.items[(that.front + i) % CAPACITY];

            if (!Objects.equals(a, b)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(CAPACITY, Arrays.hashCode(items), front, rear);
    }
}
