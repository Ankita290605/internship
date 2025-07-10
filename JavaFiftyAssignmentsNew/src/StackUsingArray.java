

// 37. Implement Stack using array

class Stack {
    int[] arr = new int[5];
    int indx;

    Stack() {
        indx = -1;
    }

    void push(int val) {
        if (indx == arr.length - 1) {
            System.out.println("Stack is full");
            return;
        }
        indx++;
        arr[indx] = val;
    }

    void pop() {
        if (indx == -1) {
            System.out.println("Stack is empty");
            return;
        }
        indx--;
    }

    int top() {
        if (indx == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[indx];
    }

    int size() {
        return indx + 1;
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        System.out.println(st.top());   // 40
        System.out.println(st.size());  // 4
        st.pop();
        System.out.println(st.size());  // 3
    }
}
