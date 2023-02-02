
// Stacks In Java  Using Linked List 


public class P1_Stack_LL
{
    static Node top; 

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



    // *** Check for Empty Stack ***
    public boolean isEmpty()
    {
        if(top == null)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }  


    // *** Display ***
    public void display()
    {
        // Base
        if(isEmpty())
        {
            System.out.println("Stack UnderFlow !!");
        }

        Node ptr = top;
        while(ptr != null)
        {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }

        System.out.print("null");     
    }



    // *** Push Opeartion ***
    public void push(int data)
    {
        Node n = new Node(data);
        n.next = top;
        top = n;
    }



    // *** Pop Opeartion ***
    public int pop()
    {
        // Base
        if(isEmpty())
        {
            System.out.println("Empty Stack !!");
            return 0;
        }

        int x = top.data;
        top = top.next;
        return x;
    }



    // *** Peak Operation ***
    public int peek()
    {
        // Base
        if(isEmpty())
        {
            System.out.println("Empty Stack !!");
            return 0;
        }

        return top.data;
    }



    // **** Main Function ****
    public static void main(String[] args) 
    {
        P1_Stack_LL l1 = new P1_Stack_LL();

        l1.push(3);
        l1.push(7);
        l1.push(12);
        l1.push(17);
        l1.push(21); 

        System.out.print("\nStack Elements :   \n");
        l1.display();  

        System.out.print("\n\nTop elemets in Stack :  " + l1.peek());

        l1.pop();

        System.out.print("\n\nUpdated Stack Elements :  \n");
        l1.display();

    }
}