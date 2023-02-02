
// Queue Using Arrays 


public class P1_Queue_Array 
{
    static int f = -1;
    static int b = -1;
    static int size;
    static int arr[];  


    P1_Queue_Array(int size)
    {
        this.size = size;
        arr = new int[size];
    }


    // **** Empty Queue ****
    public boolean isEmpty()
    {
        if(f == b)  
        {
            return true;
        }
        else 
        {
            return false;
        }
    }


    // **** Full Queue ****
    public boolean isFull()
    {
        if(b == size-1)
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }


    // **** Enqueue Operation ****
    public void add(int data) 
    {
        // Base
        if(isFull())
        {
            System.out.print("Queue OverFlow !");
        }

        b++;
        arr[b] = data;
        f = 0;
    }


    // **** dequeue Operation ****
    public void remove()
    {
        // Base
        if(isEmpty())
        {
            System.out.print("Queue UnderFlow  !");
        } 

        for(int i=0;i<b;i++)
        {
            arr[i] = arr[i+1];
        }

        b--; 
    }


    // *** Peek Operation ****
    public void peek()
    {
        System.out.print("\nTop Element of Queue : " + arr[0]);

        System.out.print("\nLast Element of Queue  :  " + arr[b]);   
    }


    // *** Display *** 
    public void display()
    {
        // Base
        if(isEmpty())
        {
            System.out.println("Empty Queue !");
        }

        for(int i=f;i<=b;i++)
        {
            System.out.println(arr[i]);  
        }
    }


    public static void main(String[] args) 
    {
        P1_Queue_Array l1 = new P1_Queue_Array(10);

        l1.add(3);
        l1.add(6);
        l1.add(9);
        l1.add(15);
        l1.add(22);
        l1.add(32); 

        System.out.print("\nQueue Elements  :     \n");
        l1.display();  

        l1.remove();
        System.out.print("\n\nUpdated Queue Elements  :   \n");
        l1.display();

        System.out.println();  
        l1.peek();


    }
}