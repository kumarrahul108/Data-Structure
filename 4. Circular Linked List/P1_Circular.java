
// Circular LInked List in Java 


public class P1_Circular 
{
    // creating Head Node for L.L 
    static Node head;
    static Node tail;   

    // **** Creating Node Class **** 
    static class Node 
    {
        Node next;
        int data;

        Node(int data) 
        {
            this.next = null;
            this.data = data;
        }
    }


    // **** Traversal in Circular L.L ****
    public void display()
    {
        // Base
        if(head == null)
        {
            System.out.print("Empty !");
        }  

        Node ptr = head;
        do 
        {
            System.out.print(ptr.data + "  -> ");
            ptr = ptr.next; 
        }
        while(ptr != head);
        System.out.print("head");
    }



    // **** Insertation ****
    public void insert(int data)
    {
        Node n = new Node(data); 

        // Base
        if(head == null) 
        {
            head = n;
            tail = n;
            n.next = head;
        } 
        else 
        {
            tail.next = n;
            tail = n;
            tail.next = head;  
        }
    }




    // **** Insertation Cases *****


    // *** Add at the beginning ***
    public void addFirst(int data)
    {
        Node n = new Node(data);

        tail.next = n;
        n.next = head;
        head = n;
    }


    // *** Add at the End ***
    public void addEnd(int data)
    {
        Node n = new Node(data);

        // Base
        if(head == null)
        {
            head = n;
            tail = n;
            tail.next = head;
        }

        tail.next = n;
        tail = n;
        tail.next = head;
    }


    // *** Add after value ***
    public void addAfterVal(int data,int val) 
    {
        Node ptr = head;
        do 
        {
            if(ptr.data == val)
            {
                Node n = new Node(data);
                n.next = ptr.next;
                ptr.next = n;
            }
            ptr = ptr.next;
        }
        while(ptr != head);   
    } 



    // **** Deletion ****
    public void remove(int val) 
    {
        Node ptr = head;
        Node prev = null;

        while(ptr.data != val)
        {
            if(ptr.next == head)
            {
                System.out.print("Invalid value");
                break;
            }
            prev = ptr;
            ptr = ptr.next;
        }
        prev.next = ptr.next;

    }


        
    // **** Main Function ****
    public static void main(String[] args) 
    {
        P1_Circular l1 = new P1_Circular();

        l1.insert(4);
        l1.insert(7);
        l1.insert(9);

        System.out.print("\n\nCircular Linked List         :    ");
        l1.display();

        l1.addFirst(11);
        l1.addEnd(77);

        System.out.print("\n\nUpdated Circular Linked List  :    ");
        l1.display();

        l1.addAfterVal(33, 7);
        System.out.print("\n\nUpdated Circular Linked List  :    ");
        l1.display();


        l1.remove(7);
        System.out.print("\n\nUpdated Circular Linked List  :    ");
        l1.display();

        

    }
}