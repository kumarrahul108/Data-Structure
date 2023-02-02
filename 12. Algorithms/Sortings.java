
// Sortings in Java 

public class Sortings 
{

    // ** Display Array Elements ***    
    public static void display(int a[])
    {
        for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i] + "    ");  
        }
    }



    // **** Bubble Sort ****
    public static void bubble(int a[])
    {
        int n = a.length;

        // loop for passes 
        for(int i=0;i<(n-1);i++)
        {
            // loop for comparison 
            for(int j=0;j<(n-1-i);j++) 
            {
                // Comaprison 
                if(a[j] > a[j+1])
                {
                    // swaping
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    } 



    // **** Selection Sort ****
    public static void selection(int a[])
    {
        int n = a.length;

        // loop for no of passes
        for(int i=0;i<(n-1);i++)
        {
            int min = i;
            // loop for comparison 
            for(int j = i+1;j<(n-1);j++)
            {
                // Compare
                if(a[min] > a[j])
                {
                    min = j;
                }
            } 

            // swapping 
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }  



    // **** Insertation Sort ****
    public static void insertation(int a[])
    {
        int n = a.length;  

        // loop for no of passes  
        for(int i=1;i<n;i++)
        {
            int curr = a[i];  
            int j = (i-1); 

            // for comparison 
            while(j>=0 && curr < a[j])
            {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = curr; 
        }
    }   



    // **** Counting Sort ****
    public static void count(int a[]) 
    {
        int n = a.length;
        int maximum = max(a);

        int count[] = new int[maximum + 1];

        // making each element of count = 0 
        for(int i=0;i<count.length;i++)
        {
            count[i] = 0;    
        } 

        for(int i=0;i<n;i++)
        {
            count[a[i]] = count[a[i]] + 1;
        }  

        int i = 0;
        int j = 0;   

        while(i <= maximum) 
        {
            if(count[i] > 0)
            {
                a[j] = i;
                count[i] = count[i] - 1;
                j++;
            }
            else 
            {
                i++;
            }
        }
    }



    // *** Maximum value of Array ***
    public static int max(int a[])
    {
        int m = a[0];
        int n = a.length;

        for(int i=1;i<n;i++)
        {
            if(m < a[i])
            {
                m = a[i];
            }
        }

        return m;
    } 




    public static void main(String[] args) 
    {
        int arr[] = {7,8,3,1,2};  
        System.out.print("\nArray Elements    :   ");
        display(arr);

        System.out.print("\n\nUsing Bubble Sort       :   ");
        bubble(arr);
        display(arr); 

        System.out.print("\n\nUsing Selection Sort    :   ");
        selection(arr);
        display(arr); 

        System.out.print("\n\nUsing Insertation Sort  :   ");
        insertation(arr);  
        display(arr); 

        System.out.print("\n\nUsing Counting Sort     :   "); 
        count(arr);      
        display(arr); 

        


          
    }
}