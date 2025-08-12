package linkedlist;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class Methods{
    static Node head = null;
    static int count=0;
    public static void InsertAtBegin(int data) {
        Node newNode = new Node(data);
        if(head==null) {
            head = newNode;
        } else {
            newNode.next=head;
            head = newNode;
        }
        count++;
    }

    public static void InsertAtEnd(int data) {
        Node newNode = new Node(data);
        if(head==null) {
            head = newNode;
        } else {
            Node temp = head;
            while(temp.next!=null) {
                temp=temp.next;
            }
            temp.next = newNode;
        }
        count++;
    }
    
    public static void InsertAtPos(int data, int pos) {
        if(pos==0) {
            InsertAtBegin(data);
            return;
        }else if(pos>count) {
            System.out.println("The length is only "+count+", so you cannot insert somewhere where the position doesnt exist!");
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int i=0;
        while(temp.next!=null && i<pos-1) {
            temp=temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next=newNode;
        count++;
    }
    
    public static void Traverse() {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}

public class Singly_Linked_List extends Methods{
    public static void main(String[] args) {
        InsertAtBegin(2);
        InsertAtBegin(1);
        InsertAtBegin(4);
        InsertAtEnd(5);
        InsertAtPos(7, 3);
        Traverse();
        System.out.println("\nLength: "+count+" nodes");
    }

}