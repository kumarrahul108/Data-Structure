
// Linked List in Java  

public class P1_Linked_List
{
    
    // creating Head Node for L.L 
    static Node head;

    // **** Creating Node Class **** 
    static class Node 
    {
        Node next;
        int data;

        Node(int data)
        {
            this.data = data;
            this.next = null;  
        }
    }



    // **** Insertation in L.L **** 
    public  void insert(int data) 
    {
        Node n = new Node(data);

        // Base
        if(head == null) 
        {
            head = n;
            n.next = null;        
        }
        else 
        {
            Node ptr = head;
            while(ptr.next != null)
            {
                ptr = ptr.next;
            }

            ptr.next = n;
            n.next = null;
        }
    }



    // **** Traversal in L.L ****
    public  void display()
    {
        // Base 
        if(head == null) 
        {
            System.out.println("Emty List !");
        }  

        Node ptr = head;
        while(ptr != null)
        {
            System.out.print(ptr.data + "  -> "); 
            ptr = ptr.next;
        }
        System.out.print("null"); 
    }



    // **** Insertation Cases ****

    // Add at the begginning 
    public void addFirst(int data)
    {
        Node n = new Node(data);

        n.next = head;
        head = n; 
    }


            
    // **** Add at the end ****
    public void addLast(int data) 
    {
        Node n = new Node(data);

        // Base
        if(head == null)
        {
            head = n;  
        }  

        Node ptr = head;

        while(ptr.next != null) 
        {
            ptr = ptr.next;
        }

        ptr.next = n;
        n.next = null;
    }


    // **** Add after a Node ****
    public void addAfterNode(int data,int node)
    {
       // Base
       if(node == 0)  
       {
            System.out.print("Not Possible ");
       } 

       Node n = new Node(data); 
       Node curr; 
       
       Node ptr = head;
       while(ptr != null)
       {
            if(ptr.data == node)
            {
                curr = ptr;
                n.next = curr.next;
                curr.next = n;
            }
            ptr = ptr.next;
       }
    }



    // **** Add after a Position ****
    public void addAfterPos(int data,int pos)
    {
        Node n = new Node(data);

        int c = 0;

        Node ptr = head;
        while(ptr != null) 
        {
            c++;
            if(c == pos)
            {
                n.next = ptr.next;
                ptr.next = n;
            }
            ptr = ptr.next;
        }
    }




    // **** Deletion ****

    // **** delete 1st node ****
    public void removeFirst()
    {
        // Base 
        if(head == null)
        {
            return;
        }

        if(head.next == null)
        {
            head = null;
        }
        else 
        {
            head = head.next;
        }  
    }   


    // **** delete last node ****
    public void removeLast()
    {
        // Base 
        if(head == null)
        {
            return;
        }
        else
        {
            Node ptr = head;
            while(ptr.next.next != null)
            {
                ptr = ptr.next;
            }
            ptr.next = null;
        }
    }



    // Main Function 
    public static void main(String[] args) 
    {
        P1_Linked_List l1 = new P1_Linked_List();

        l1.insert(3);
        l1.insert(4);
        l1.insert(5);
        l1.insert(6);

        System.out.print("\nLinked List          :   ");  
        l1.display();

        l1.addFirst(56); 
        l1.addLast(78);

        System.out.print("\n\nUpdated Linked List  :   ");  
        l1.display();

        System.out.print("\n\nUpdated Linked List  :   ");
        l1.addAfterNode(53, 5);
        l1.display();  

        System.out.print("\n\nUpdated Linked List  :   ");
        l1.addAfterPos(35, 3);  
        l1.display();

        System.out.print("\n\nUpdated Linked List  :   ");
        l1.removeFirst();
        l1.removeLast();
        l1.display(); 

    }
}