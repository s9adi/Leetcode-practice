package io.dsa.miscQ;

public class QueueImpl<K> {

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl();
        queue.enqueue(10);
        queue.enqueue(12);

        queue.display();
    }

    private int SIZE = 10;
    private K[] data = (K[]) new Object[SIZE];
    private int front; // front is the place from where the element will be removed
    private int rear;

    QueueImpl() {
        this.front = -1;
        this.rear = -1;

    }

    public boolean isEmpty() {
        if (front == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (front == 0 && rear == SIZE - 1) { // element to be removed is first and the element to insert is last
            return true;
        }
        return false;
    }

    public void enqueue(K value) {
        if (isFull()) {
            System.out.println("The Queue is Full");
        } else {
            if (front == -1) {
                front = 0;
            }

            rear = rear + 1;

            data[rear] = value;
            System.out.println("Inserted at Position " + rear);
        }
    }

    public K dequeue() {
        // it can be empty
        if (isEmpty()) {
            System.out.println("Nothing here ");
        }
        K val = data[front];
        // check if there is only one element in the queue
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }

        System.out.println("Deleted " + val);
        return val;
    }

    public void display() {
        // we have to display from the front to the end of the array
        // then we have to display from the start to the front
        if (isEmpty()) {
            System.out.println("Notin here ");
            return;
        }

        if (front >= rear) {
            for (int i = front; i < SIZE - 1; i++) {
                System.out.println(data[i]);
            }

            for (int i = 0; i <= front; i++) {
                System.out.println(data[i]);
            }
        } else {
           for (int i = front ; i <= rear ; i++){
               System.out.println(data[i]);
           }
        }
    }
}
