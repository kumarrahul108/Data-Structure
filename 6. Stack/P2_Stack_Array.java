

// Stacks In Java  Using Arrays


public class P2_Stack_Array 
{

    static int size;
    static int top = -1;
    static int arr[];

    P2_Stack_Array(int size)
    {
        this.size = size;
        arr = new int[size];
    }

    
    // *** Check for Empty Stack ***
    public boolean isEmpty()
    {
        if(top < 0)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }



    // *** Check for Full Stack ***
    public boolean isFull()
    {
        if((size-1) == top)
        {
            return true;
        }
        else 
        {
            return false;
        }  
    }



    // *** Push Opeartion ***
    public void push(int data)
    {
        // Base 
        if(isFull()) 
        {
            System.out.println("Stack Overflow !!");
        }

        top++;
        arr[top] = data;
    } 



    // *** Pop Opeartion ***
    public int pop()
    {
        // Base
        if(isEmpty())
        {
            System.out.println("Stack UnderFlow !");
            return -1;
        }

        int x = arr[top];
        top--;
        return x;
    }


    // **** Peek Operation ****
    public int peek()
    {
        // Base
        if(isEmpty())
        {
            System.out.println("Stack UnderFlow !");
            return -1;
        }

        return arr[top];

    }


    // *** Display ***
    public void display()
    {
        // Base
        if(isEmpty())
        {
            System.out.print("Stack UnderFlow !!");
        }

        for(int i=top;i > -1;i--)
        {
            System.out.println(arr[i]);  
        }

    }

    

    // **** main function ****
    public static void main(String[] args) 
    {
        P2_Stack_Array l2 = new P2_Stack_Array(10);

        l2.push(5);
        l2.push(8);
        l2.push(11);
        l2.push(15);
        l2.push(19);
        l2.push(26);

        System.out.print("\nStack Elements :   \n");
        l2.display();

        System.out.print("\n\nTop elemets in Stack :  " + l2.peek()); 

        l2.pop();

        System.out.print("\n\nUpdated Stack Elements :  \n");  
        l2.display();
    }    
}
