

// 38. Implement Queue using array

class Queue {
    int[] arr = new int[5];
    int front = 0;
    int rear = 0;

    void enqueue(int val) {
        if (rear == arr.length) {
            System.out.println("Queue is full");
            return;
        }
        arr[rear] = val;
        rear++;
    }

    void dequeue() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return;
        }
        front++;
    }

    int front() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    int size() {
        return rear - front;
    }

    void display() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = front; i < rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class QueueUsingArray{
    public static void main(String[] args) {
        Queue q = new Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();            // Queue: 10 20 30
        System.out.println(q.front());  // 10
        System.out.println(q.size());   // 3

        q.dequeue();
        q.display();            // Queue: 20 30
        System.out.println(q.size());   // 2
    }
}
