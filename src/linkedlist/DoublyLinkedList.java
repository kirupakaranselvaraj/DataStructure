package linkedlist;

class DNode{
    int data;
    DNode next, prev;
    DNode(int data){
        this.data = data;
        next=prev=null;
    }
}

class DMethods{
    static DNode head = null;
    static DNode tail = null;
    static int count = 0;
    
    public static void InsertAtBegin(int data) {
        DNode newNode = new DNode(data);
        if(head==null) {
            head = tail = newNode;
        } else {
            newNode.next=head;
            head.prev=newNode;
            head = newNode;
        }
        count++;
    }
    
    public static void InsertAtEnd(int data) {
        DNode newNode = new DNode(data);
        if(head==null) {
            head=tail=newNode;
        } else {
            tail.next=newNode;
            newNode.prev=tail;
            tail = newNode;
        }
        count++;
    }
    
    public static void InsertAtPos(int data, int pos) {
        if(pos==0) {
            InsertAtBegin(data);
            return;
        }else if(pos>=count || pos<0) {
            System.out.println("Position does not exist");
            return;
        } else {
            DNode temp, newNode = new DNode(data);
            if(pos>count-pos) {
                temp=tail;
                for(int i=0; i<count-pos-1; i++) {
                    temp = temp.prev;
                }
                temp.prev.next=newNode;
                newNode.prev=temp.prev;
                newNode.next = temp;
                temp.prev=newNode;
            }else {
                temp = head;
                for(int i=0; i<pos-1; i++) {
                    temp = temp.next;
                }
                temp.next.prev=newNode;
                newNode.next=temp.next;
                newNode.prev=temp;
                temp.next=newNode;
            }
            count++;
        }
    }
    
    public static void Traverse() {
        DNode temp = head;
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}

public class DoublyLinkedList extends DMethods{
    public static void main(String args[]) {
        InsertAtBegin(2);
        InsertAtBegin(7);
        InsertAtBegin(5);    
        InsertAtEnd(45);
        InsertAtEnd(945);
        InsertAtEnd(8);
        InsertAtEnd(1);
        InsertAtEnd(75);
        InsertAtPos(10, 5);
        Traverse();
        System.out.println("\nLength: " + count + " nodes");
    }
}
