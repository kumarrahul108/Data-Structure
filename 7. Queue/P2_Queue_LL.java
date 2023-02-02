
// Queue Using Linked List 


public class P2_Queue_LL 
{   

    static Node front;
    static Node back;

    // *** Creating Node Class *** 
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
    


    // *** Empty Condition *** 
    public boolean isEmpty()
    {
        if(front == null)
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }

    
    // *** Enqueue Operation ***
    public void add(int data)
    {
        Node n = new Node(data);

        // Base
        if(isEmpty())
        {
            front = n;
            back = n;
        }

        back.next = n;
        back = n;
    }



    // *** Dequeue Opeartions ***
    public int remove()
    {
        // Base
        if(isEmpty())
        {
            System.out.println("Queue UnderFlow !!");
            return -1;
        }

        if(front.next == null)
        {
            front = back = null;
            return front.data;
        }

        else 
        {
            int x = front.data;
            front = front.next;
            return x;
        }  
    }



    // ***  Peek Operations ***
    public int peek()
    {
        // Base
        if(isEmpty())
        {
            System.out.println("Queue UnderFlow !");
            return -1;
        }

        return front.data;
    }   


    // *** Display *** 
    public void display()
    {
        // Base 
        if(isEmpty())
        {
            System.out.println("Empty Queue !!");
        }  

        Node ptr = front;
        while(ptr != null) 
        {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }


    public static void main(String[] args) 
    {
        P2_Queue_LL l2 = new P2_Queue_LL();

        l2.add(4);
        l2.add(7);
        l2.add(14);
        l2.add(19);
        l2.add(24);
        l2.add(34);
        l2.add(56);

        System.out.println("\nQueue Elements  :   \n");
        l2.display();  

       
        l2.remove();
        System.out.println("\nUpdated Queue Elements :   \n"); 
        l2.display();

        System.out.print("\nPeek Value of Queue  :  " + l2.peek());



    }    
}
