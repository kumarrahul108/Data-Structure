
// Operations on Arrays In Java 

import java.util.Scanner; 

public class P1_Array 
{

    
    // **** Array --> Traversal ****
    public static void display(int a[]) 
    {
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i] + "   "); 
        }            
    }




    // **** linear search --> both sorted + unsorted array ****
    public static int linear(int a[],int val)
    {
        for(int i=0;i<a.length;i++)
        {
            if(a[i] == val)
            {
                return i;
            }
        }
        return -1; 
    } 




    // **** binary serach --> only for sorted array ****
    public static int binary(int a[],int val)
    {
        int n = a.length;
        int low = 0;
        int high = n-1;
        
        while(low<=high)
        {
            int mid = (low + high)/2;

            // Base 
            if(a[mid] == val)
            {
                return mid;
            }


            if(a[mid]<val)
            {
                low = mid + 1;
            }

            else 
            {
                high = mid -1;
            }
        }

        return -1;
    }  




    // **** Insertation of Elements in Array ****
    public static void insert(int a[],int pos,int val)
    {
        int n = a.length;  

        int new_arr[] = new int[n+1];

        for(int i=0;i<(n+1);i++)
        {
            if((pos -1) == i)
            {
                new_arr[i] = val;
            }

            else if((pos - 1) < i) 
            {
                new_arr[i] = a[i-1];
            } 

            else 
            {
                new_arr[i] = a[i];
            }
        }

        for(int i=0;i<new_arr.length;i++)
        {
            System.out.print(new_arr[i] + "    ");
        }

    }




    // **** Deletion of Elements in Array ****
    public static void remove(int a[],int pos)
    {
        // Base
        if(pos < 0 || pos > (a.length) || a == null)
        {
            System.out.print("This Position donot exists !!");
        }

        int n = a.length;
        int new_arr[] = new int[n-1];
        int j = 0;

        for(int i=0;i<a.length;i++)
        {
            if((pos) == i)  
            {
                continue;
            }

            new_arr[j] = a[i];
            j++;

        }

        // display(new_arr);

        for(int i=0;i<new_arr.length;i++)
        {
            System.out.print(new_arr[i] + "   ");
        }

    }

    


    // **** Main Function ****

    public static void main(String[] args) 
    {
        int arr1[] = {22,55,78,96,105,156};  // Sorted Array

        int arr2[] = {55,78,105,156,33,67};  // unsorted array

        System.out.print("Display Array 1 Elements :    "); 
        display(arr1); 

        System.out.print("\nDisplay Array 2 Elements :    "); 
        display(arr2); 

        /* 
        int arr3[] = new int[5];
        System.out.print("\n\nEnter Elemnts of Array 3 : \n"); 

        Scanner sc = new Scanner(System.in);

        for(int i=0;i<5;i++)
        {
            System.out.print("Enter elements for index : " + (i+1) + "  ->  ");
            arr3[i] = sc.nextInt();
        }

        System.out.print("\n\nDisplay Array 3 Elements :    "); 
        display(arr3); 

        */
        System.out.print("\nUsing Linear Serach :: \n");
        int l_idx = linear(arr1,96); 

        if(l_idx == -1)
        {
            System.out.print("\nElement is Not Present !!");
        } 
        else 
        {
            System.out.print("\nElement is Present at index :  " + l_idx);
        }

        int b_idx = binary(arr1, 96);

        if(b_idx == -1)
        {
            System.out.print("\nElement is Not Present !!");
        } 
        else 
        {
            System.out.print("\nElement is Present at position :  " + b_idx); 
        }


        System.out.print("\n\nDisplay Original Array  :     ");
        display(arr1); 
        System.out.print("\n\nUpdated Array           :    ");
        insert(arr1, 3, 11); 


        System.out.print("\n\nDisplay Original Array  :   ");
        display(arr1);
        System.out.print("\nUpdated Array             :   ");
        remove(arr1, 3);  
        
    
    }
}