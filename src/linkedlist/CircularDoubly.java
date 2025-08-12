package linkedlist;

class CDnode {
    int data;
    CDnode next, prev;

    CDnode(int data) {
        this.data = data;
        next = prev = null;
    }
}
class CDmethods {
    static CDnode head = null, tail = null;
    static int len = 0;
    public static void InsertAtBegin(int data) {
        CDnode newNode = new CDnode(data);
        if (head == null || tail == null) {
            head = tail = newNode;
            head.next = head.prev = head;
        } else {
            newNode.next = head;
            head.prev = newNode;
            newNode.prev = tail;
            tail.next = newNode;
            head = newNode;
        }
        len++;
    }
    public static void InsertAtEnd(int data) {
        CDnode newNode = new CDnode(data);
        if (head == null || tail == null) {
            head = tail = newNode;
            tail.next = tail.prev = head;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            newNode.next = head;
            head.prev = newNode;
            tail = newNode;
        }
        len++;
    }
    public static void InsertAtPos(int data, int pos) {
        if (pos == 0) {
            InsertAtBegin(data);
            return;
        } else if (pos >= len || pos < 0) {
            System.out.println("Position does not exist");
            return;
        } else {
            CDnode newNode = new CDnode(data);
            CDnode temp;
            if (pos > len / 2) {
                temp = tail;
                for (int i = len - 1; i > pos; i--) {
                    temp = temp.prev;
                }
            } else {
                temp = head;
                for (int i = 0; i < pos; i++) {
                    temp = temp.next;
                }
            }
            newNode.prev = temp.prev;
            temp.prev.next = newNode;
            temp.prev = newNode;
            newNode.next = temp;
        }
        len++;
    }
    public static void DeleteAtBegin() {
        if (head == null || tail == null) {
            System.out.println("Nothing to Delete");
        } else if (head.next == head) {
            head = tail = null;
            return;
        } else {
            head.next.prev = tail;
            tail.next = head.next;
            head = head.next;
        }
        len--;
    }
    public static void DeleteAtEnd() {
        if (head == null || tail == null) {
            System.out.println("Nothing to Delete");
        } else if (head.next == head) {
            head = tail = null;
            return;
        } else {
            tail.prev.next = head;
            head.prev = tail.prev;
            tail = tail.prev;
        }
        len--;
    }
    public static void DeleteAtPos(int pos) {
        if (pos == 0) {
            DeleteAtBegin();
            return;
        } else if (pos >= len || pos < 0) {
            System.out.println("Position does not exist");
            return;
        } else {
            CDnode temp;
            if (pos > len / 2) {
                temp = tail;
                for (int i = len - 1; i > pos; i--) {
                    temp = temp.prev;
                }
            } else {
                temp = head;
                for (int i = 0; i < pos; i++) {
                    temp = temp.next;
                }
            }
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
        }
        len--;
    }
    public static void Reverse() {
        if (head == null) {
            System.out.println("Nothind to reverse!");
            return;
        }
        CDnode temp = tail;
        do {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        } while (temp.next != head);
    }
    public static void display() {
        if (head == null) {
            System.out.println("Nothing to display!");
            return;
        }
        CDnode temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
    }
}
public class CircularDoubly extends CDmethods {
    public static void main(String[] args) {
        InsertAtBegin(5);
        InsertAtBegin(55);
        InsertAtBegin(80);
        InsertAtEnd(6);
        InsertAtEnd(72);
        InsertAtPos(3, 2);
        DeleteAtBegin();
        DeleteAtEnd();
        DeleteAtPos(2);
        display();
        System.out.println("\nLength: " + len + " nodes");
        Reverse();
    }
}
