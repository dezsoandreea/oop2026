package oop.labor09.lab9_1;

public interface IQueue {
    void enQueue(Object obj);
    Object deQueue();
    boolean isFull();
    boolean isEmpty();
    void printQueue(); //seged muvelet
}
