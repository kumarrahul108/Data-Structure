
// Array List in Java 

import java.util.ArrayList;
import java.util.Collections;

public class P1_ArrayList 
{
    public static void main(String[] args) 
    {
        ArrayList<Integer> l1 = new ArrayList<>();

        l1.add(3);
        l1.add(6);
        l1.add(67);
        l1.add(78);
        l1.add(34);
        l1.add(56);

        l1.set(2, 11);
        l1.set(3, 44);

        l1.remove(4); 
        System.out.print("\n\nArray List :   " + l1);

        int size = l1.size();
        System.out.println("\nSize of Array List :   " + size);

        System.out.print("\n\nArray List :   -->  ");
        for(int i=0;i<size;i++)
        {
            System.out.print(l1.get(i) + "   ");  
        }

        Collections.sort(l1);
        System.out.print("\nSorted Array List : " + l1);

    }
}