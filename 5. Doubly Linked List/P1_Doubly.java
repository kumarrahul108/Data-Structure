
// Doubly Linked List in Java 

public class P1_Doubly 
{
    static Node head;
    static Node tail;


    // *** Creating Node Class ***
    static class Node 
    {
        Node next;
        Node prev;
        int data;

        Node(int data)
        {
            this.data = data;
            this.next = null;
            this.prev = null;  
        }
    }



    // **** Traversal ****
    public void display()
    {
        // Base
        if(head == null)
        {
            System.out.println("Empty List !");
        }

        Node ptr = head;
        while(ptr != null)
        {
            System.out.print(ptr.data + "   <-->  ");
            ptr = ptr.next;
        }
        System.out.print("null"); 
    } 



    // **** Insertation ****
    public void insert(int data)
    {
        Node n = new Node(data);
        Node ptr = head;

        if(head == null)
        {
            head = n;
            tail = n;
            n.next = null;
            n.prev = null;
        } 

        else 
        {
            while(ptr.next != null) 
            {
                ptr = ptr.next;
            }
            ptr.next = n;
            n.next = null;
            n.prev = ptr;
            tail = n;
        } 
    } 


    // *** Insertation Cases ***

    // Add at the beginning
    public void addFirst(int data)
    {
        Node n = new Node(data);
        // Base
        if(head == null)
        {
            head = n;
            tail = n;
        }

        n.next = head;
        n.prev = null;

        head = n;
    }


    // **** Add at the end ****
    public void addLast(int data)
    {
        Node n = new Node(data);
        Node ptr = head;

        while(ptr.next != null)
        {
            ptr = ptr.next;  
        }  
        ptr.next = n;
        n.prev = ptr;
        tail = n; 
    }


    // **** Add after Value ****
    public void addAfter(int data,int val)
    {
        Node n = new Node(data);
        Node ptr = head;

        while(ptr.data != val)
        {
            ptr = ptr.next;
        }

        n.next = ptr.next;
        ptr.next = n;
        n.prev = ptr;
    }  



    // **** Deletion ****
    public void remove(int key)
    {
        Node ptr = head;
        Node prev = null;

        while(ptr.data != key)
        {
            prev = ptr;
            ptr = ptr.next;
        }

        prev.next = ptr.next;
    }   



    // ****  Main Function ****

    public static void main(String[] args) 
    {
        P1_Doubly l1 = new P1_Doubly();

        l1.insert(5);
        l1.insert(8);
        l1.insert(11);
        l1.insert(17);

        System.out.print("\n\nDoubly Linked List  :    ");
        l1.display();

        l1.addFirst(33);
        l1.addLast(56);

        System.out.print("\n\nUpdated Doubly Linked List  :   ");
        l1.display();

        l1.addAfter(44, 11);
        System.out.print("\n\nUpdated Doubly Linked List  :   ");
        l1.display();  

        l1.remove(17);
        System.out.print("\n\nUpdated Doubly Linked List  :   ");
        l1.display();

    }
}