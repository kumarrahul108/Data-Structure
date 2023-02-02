
// Circular Quueu Using Arrays 


public class P3_Queue_Circular 
{   

    static int arr[];
    static int size ;
    static int f = -1;            
    static int b = -1;         

    P3_Queue_Circular(int size)
    {
        this.size = size;
        arr = new int[size]; 
    }   


    // *** Empty Check ***
    public boolean isEmpty()
    {
        if(f == -1 && b == -1)   // --> both index at same position 
        {
            return true;
        }
        else 
        {
            return false; 
        }
    }



    // *** Full Check ***
    public boolean isFull()
    {
        if((b + 1) % size == f)   // --> full condition 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }  



    // *** Enqueue Opeartions ***
    public void add(int data)
    {
        // Base
        if(isFull())
        {
            System.out.println("Queue OverFlow  !");
        }  

        if(isEmpty())
        {
            f = 0;
            b = 0;
            arr[b] = data;
        }

        else 
        {
            b = (b + 1) % size;  // circular Increment of back (b) -> index 
            arr[b] = data;
        }

    }



    // *** Dequeue Opeartions ***
    public void remove()
    {
        // Base   --> no element present 
        if(isEmpty())
        {
            System.out.println("Queue UnderFlow !");
        }  

        if(f == b)   // if only 1 element is present 
        {
            System.out.println(arr[f]); 
            f = -1;
            b = -1;  
        } 
        else 
        {
            System.out.println(arr[f]); 
            f = (f + 1) % size;   // --> circular Increment of front (f) -> index 
        }
    }  


    // *** Display ***
    public void display()
    {
        // Base
        if(isEmpty())
        {
            System.out.println("Empty Queue");
        }

        int i = f;

        while(i <= b)
        {
            System.out.println(arr[i]);
            i = (i + 1) % size;   // --> Circular Increment in loop 
        }
    }


    // *** Main Function *** 
    public static void main(String[] args) 
    {
        P3_Queue_Circular l3 = new P3_Queue_Circular(10);

        l3.add(56);
        l3.add(13);
        l3.add(89);
        l3.add(13);
        l3.add(38);
        l3.add(76);

        System.out.print("\n\nCirular Queue Elements :    \n");
        l3.display();  

        l3.remove();
        l3.remove();

        l3.add(67);
        l3.add(34);
        l3.remove();
        l3.remove();

        System.out.print("\nUpdated Queue Elements :  \n");
        l3.display();
    }    
}
