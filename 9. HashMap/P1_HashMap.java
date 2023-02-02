
// Hash Map in Java 


import java.util.HashMap;
import java.util.Map;


public class P1_HashMap 
{
    public static void main(String[] args) 
    {
        HashMap<String,Integer> map = new HashMap<>();

        map.put("India", 120);
        map.put("USA", 300);
        map.put("China", 100);
        map.put("Japan",200);

        System.out.print("\nMapping Set :  " + map);

        if(map.containsKey("Japan"))
        {
            System.out.print("\nPresent");
        }
        else 
        {
            System.out.print("\nNot - Present ");
        }   

        System.out.println("\nGetting Values :   ");
        System.out.print("\nIndia ->  " + map.get("India"));
        System.out.print("\nChina  ->  " + map.get("China"));

        
        // Iteration Loop 
        System.out.println("\n");
        for(Map.Entry<String,Integer> e: map.entrySet())
        {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }   

        map.remove("China");  

    }
}