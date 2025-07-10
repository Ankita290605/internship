

// 40. Detect a cycle in linked list (Floyd's algorithm)

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    void insert(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void makeCycle() {
        if (head == null) return;

        Node temp = head;
        Node joinNode = null;
        int count = 1;

        while (temp.next != null) {
            if (count == 2) {
                joinNode = temp;
            }
            temp = temp.next;
            count++;
        }
        temp.next = joinNode;
    }

    boolean hasCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           
            fast = fast.next.next;     

            if (slow == fast) {
                return true; 
            }
        }

        return false;
    }
}

public class HaveCycle{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        list.makeCycle();

        if (list.hasCycle()) {
            System.out.println("Cycle detected in the linked list");
        } else {
            System.out.println("No cycle in the linked list");
        }
    }
}