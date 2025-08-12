package linkedlist;
class Qnode{
    int data;
    Qnode next;
    Qnode(int data){
        this.data=data;
        next = null;
    }
}
class Qmethods{
    static Qnode front, rear;
    static int len=-1;   
    public static void Enqueue(int data) {
        Qnode newNode = new Qnode(data);
        if (rear == null) {
            front = rear = newNode; 
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        len++;
    }
    public static void Dequeue() {
        if (front == null) {
            System.out.println("Its an Empty Queue Fool, what will u delete from this?");
            return;
        }
        Qnode temp = front;
        front = front.next;
        temp.next = null;
        len--;
    } 
    public static void Peak() {
        if (front != null) {
            System.out.println("\nFront element: " + front.data);
        } else {
            System.out.println("\nQueue is empty.");
        }

    }  
    public static void Traverse() {
        Qnode temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
public class Queue extends Qmethods{
    public static void main(String ar[]) {
        Enqueue(4);
        Enqueue(9);
        Enqueue(23);
        Dequeue();
        Traverse();
        Peak();
    }
}
