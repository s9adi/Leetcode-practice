package io.dsa.miscQ;

public class Queue<T> {
    private Object[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    private boolean isFull(){
        if (capacity == size){
            return true;
        }
        return false;
    }
    private boolean isEmpty(){
        return size == 0 ;
    }
    private T dequeue(){
        // check if empty
        if(isEmpty()){
            System.out.println("Nothing here");
            return null;
        }
        T element  = (T) arr[front];
        front = (front + 1)%capacity;
        return element;
    }

}
